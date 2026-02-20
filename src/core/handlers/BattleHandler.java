package core.handlers;

import core.GameManager;
import model.Player;
import model.Rookie;
import model.moves.*;
import utils.StringReader;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static resources.BattleStrings.*;
import static resources.GameMenuStrings.*;

public class BattleHandler {
    private final JTextArea display;
    private final GameManager gameManager;
    private StringReader sr;
    private Player player;
    private OverworldHandler overviewHandler;
    private Rookie rookie, enemy;
    private boolean win;
    private boolean exit;


    public BattleHandler(GameManager gameManager, Player player, Rookie enemy, StringReader sr, JTextArea display) {
        this.display = display;
        this.gameManager = gameManager;
        this.sr = sr;
        this.player = player;
        this.enemy = new Rookie(enemy);
        rookie = new Rookie(player.getRookie());
        win = false;
        exit = false;
    }

    public void handleSelection(String choice) {
        if(exit) {
            exitGame(choice);
            return;
        }
        switch (choice) {
            case "1":
                processing(rookie.getMoves().get(0));
                break;
            case "2":
                processing(rookie.getMoves().get(1));
                break;
            case "3":
                processing(rookie.getMoves().get(2));
                break;
            case "4": // run
                endGame();
                break;
            default:
                display.append(getErrorText());
        }
    }

    public void endGame() {
        if(win) {
            player.getRookie().addExperience(enemy.getGiveExperience(), display);
            player.addGold(enemy.getGold());
            if(gameManager.battleground.isGym()) gameManager.battleground.registerGymVictory();
        }
        gameManager.updatePlayer(player);
        display.append("\n > Press enter to continue.\n");
        exit = true;
    }

    public void exitGame(String choice) {
        switch (choice) {
            case "0":
                gameManager.loadScene(getGameMenuString());
                gameManager.gameState = GameManager.GameState.GAME_MENU;
                gameManager.battleHandler = null;
                break;
            default:
                display.append(getErrorText());
                break;
        }
    }

    /**
     * Processes a full combat turn.
     * This method calculates the enemy's move, determines turn order based on speed,
     * applies damage/effects, and animates the results step-by-step using a Timer.
     * * @param playerMove The move selected by the player from the game.
     */
    public void processing(Move playerMove) {
        // 1. Enemy AI Decision: Randomly select a move from the enemy's move set
        Move enemyMove = enemy.getMoves().get((int) (Math.random() * enemy.getMoves().size()));

        // 2. St ate Management: Prevent further input while the animation is running
        gameManager.isProcessing = true;

        // 3. Initiative Check: Compare speed stats to see who acts first
        // If speeds are equal, the player currently gets the advantage
        boolean player_first = (enemy.getSpeed() <= rookie.getSpeed());

        // Tell user battle is processing
        display.setText(getProcessingString(rookie, enemy));

        // 4. Animation Sequence: Execute battle events in a timed sequence
        // A delay of 1200ms provides a good pace for reading the text
        Timer timer = new Timer(1200, new ActionListener() {
            int count = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                // Identify active players for the current phase (Turn 1: 0-2, Turn 2: 3-5)
                boolean isFirstTurn = (count < 3);
                Move currentMove = isFirstTurn
                        ? (player_first ? playerMove : enemyMove)
                        : (player_first ? enemyMove : playerMove);

                Rookie user = isFirstTurn
                        ? (player_first ? rookie : enemy)
                        : (player_first ? enemy : rookie);

                Rookie target = isFirstTurn
                        ? (player_first ? enemy : rookie)
                        : (player_first ? rookie : enemy);

                switch (count) {
                    case 0:
                    case 3:
                        if (user.getHp() <= 0) {
                            count = 6;
                            actionPerformed(e);
                            return;
                        }
                        display.append("\n " + user.getName() + " uses " + currentMove.getName() + "!");
                        count++;
                        break;

                    case 1:
                    case 4:
                        handleMoveEffect(currentMove, user, target);
                        count++;
                        break;

                    case 2:
                    case 5:
                        display.append("\n ...");
                        count++;
                        if (target.getHp() <= 0) count = 6;
                        break;
                    case 6:
                        // Win/Loss Condition: Check if anyone fainted
                        if (enemy.getHp() <= 0) {
                            display.append("\n " + enemy.getName() + " fainted!");
                            count = 8;
                        } else if (rookie.getHp() <= 0) {
                            display.append("\n " + rookie.getName() + " fainted...");
                            count = 13;
                        } else {
                            display.append("\n The battle continues!");
                            count++;
                        }
                        break;
                    case 8:
                        display.append("\n ...");
                        count++;
                        break;
                    case 9:
                        display.setText("" +
                                        "+               VICTORY              +\n");
                        count++;
                        break;
                    case 10:
                        display.append("\n Experience gained: " + enemy.getGiveExperience());
                        count++;
                        break;
                    case 11:
                        display.append("\n Gold earned: " + enemy.getGold());
                        win = true;
                        count = 20;
                        break;
                    case 13:
                        display.append("\n ...");
                        count++;
                        break;
                    case 14:
                        display.setText("" +
                                        "+               DEFEAT               +\n");
                        count++;
                        break;
                    case 15:
                        Random rand = new Random();
                        int randomIndex = rand.nextInt(getInsults().length);
                        display.append("\n " + rookie.getName() + getInsults()[randomIndex]);
                        count++;
                        break;
                    case 16:
                        display.append("\n You lost " + player.getGold()/2 + " gold!");
                        count = 20;
                        break;
                    case 20:
                        endGame();
                        gameManager.isProcessing = false;
                        ((Timer)e.getSource()).stop();
                        break;

                    default:
                        gameManager.isProcessing = false;
                        display.setText(getBattleString(rookie, enemy));
                        ((Timer)e.getSource()).stop();
                        break;
                }
            }
        });
        timer.start();
    }

    /**
     * Resolves the logic for different move types.
     * Calculates damage for AttackMoves using the A/D ratio and handles
     * stat modifications for EffectMoves.
     */
    private void handleMoveEffect(Move move, Rookie user, Rookie target) {
        if (move instanceof AttackMove) {
            int power = ((AttackMove) move).getBaseDamage();
            int a = user.getAttack();
            int d = target.getDefense();
            double divisor = 12 + ((double) player.getRookie().getLevel() / 1.5);
            double damageCalc = ((( (2.0 * user.getLevel() / 5.0) + 2.0 ) * power * ( (double)a / d) ) / (divisor) + 2.0);
            int dmg = (int) damageCalc;

            double baseAccuracy = 0.85;
            double speedBonus = (user.getSpeed() - target.getSpeed()) / 100.0;
            double finalHitChance = baseAccuracy + speedBonus;

            if (Math.random() > finalHitChance) {
                display.append("\n " + target.getName() + " dodged the attack!");
            } else {
                boolean isCritical = Math.random() < 0.10;
                if (isCritical) {
                    dmg *= 2;
                    display.append("\n CRITICAL HIT!");
                }

                target.takeDamage(dmg);
                display.append("\n It dealt " + dmg + " damage!");
            }

        }
        else if (move instanceof EffectMove) {
            EffectMove effect = (EffectMove) move;
            Move.TargetStat statToChange = effect.getStat();
            double multiplier = effect.getMultiplier();

            Rookie subject = (move.getType() == Move.MoveType.POWERUP) ? user : target;
            String changeType = (multiplier > 1.0) ? "rose" : "fell";
            switch (statToChange) {
                case ATTACK:
                    int newAttack = (int)(subject.getAttack() * multiplier);
                    subject.setAttack(Math.max(1, newAttack));
                    display.append("\n " + subject.getName() + "'s Attack " + changeType + "!");
                    break;
                case DEFENSE:
                    int newDefense = (int)(subject.getDefense() * multiplier);
                    subject.setDefense(Math.max(1, newDefense));
                    display.append("\n " + subject.getName() + "'s Defense " + changeType + "!");
                    break;
                case SPEED:
                    int newSpeed = (int)(subject.getSpeed() * multiplier);
                    subject.setSpeed(Math.max(1, newSpeed));
                    display.append("\n " + subject.getName() + "'s Speed " + changeType + "!");
                    break;
            }
        }
    }
}
