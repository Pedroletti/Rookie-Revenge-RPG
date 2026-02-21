package core;

import model.Battleground;
import model.Player;
import model.Rookie;
import model.moves.AttackMove;
import model.moves.EffectMove;
import model.moves.Move;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static resources.ascii.PhaseOne.*;
import static resources.ascii.PhaseTwo.*;
import static resources.ascii.PhaseThree.*;
import static resources.RookieStrings.*;

public class GameData implements Serializable {
    private static final long serialVersionUID = 1L;

    /* DATA */
    private Player player;
    public List<Battleground> battlegrounds;
    public Map<String, Move> moveCatalog;


    public GameData() {
        battlegrounds = new ArrayList<>();
        moveCatalog = new HashMap<>();
        initMoves();
    }

    public void buildWorld() {
        new Thread(() -> {
            battlegrounds = new ArrayList<>();
            moveCatalog = new HashMap<>();

            /* Init all data */
            initMoves();
            initMITPlace();
            initMITCafe();
            initDataGym();
            initNaturvetarhuset();
            initSkötet();
            initTviste();
            initRouge();

            System.out.println("World is built.");
        }).start();
    }

    public void updatePlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    private void initMoves() {
        /* GOD */
        moveCatalog.put("GOD KICK", new AttackMove("GOD KICK", 200));

        /* STARTER */
        moveCatalog.put("PUNCH", new AttackMove("PUNCH", 40));
        moveCatalog.put("LUCKY BAIT", new EffectMove("LUCKY BAIT", Move.MoveType.POWERUP, Move.TargetStat.ATTACK, 1.2));
        moveCatalog.put("TROPIC THUNDER", new EffectMove("TROPIC THUNDER", Move.MoveType.POWERUP, Move.TargetStat.SPEED, 1.2));
        moveCatalog.put("ARTON56", new EffectMove("ARTON56", Move.MoveType.POWERUP, Move.TargetStat.ATTACK, 1.25));
        moveCatalog.put("GUINNESS", new EffectMove("GUINNESS", Move.MoveType.POWERUP, Move.TargetStat.DEFENSE, 1.2));
        moveCatalog.put("TAUNT", new EffectMove("TAUNT", Move.MoveType.WEAKEN, Move.TargetStat.SPEED, 0.8));
        moveCatalog.put("MEAN WORDS", new EffectMove("MEAN WORDS", Move.MoveType.WEAKEN, Move.TargetStat.ATTACK, 0.8));
        moveCatalog.put("STARE", new EffectMove("STARE", Move.MoveType.WEAKEN, Move.TargetStat.DEFENSE, 0.8));

        /* STORE */
        moveCatalog.put("ROOKIE KICK", new AttackMove("ROOKIE KICK", 55, 1000));
        moveCatalog.put("PUKE ATTACK", new AttackMove("PUKE ATTACK", 70, 4000));
        moveCatalog.put("F-SIDEFLIP", new AttackMove("F-SIDEFLIP", 85, 8000));
        moveCatalog.put("ROOKIE RAGE", new AttackMove("ROOKIE RAGE", 100, 15000));

        moveCatalog.put("FLASH TUX", new EffectMove("FLASH TUX", Move.MoveType.POWERUP, Move.TargetStat.ATTACK, 1.3, 1000));
        moveCatalog.put("SELL PATCHES", new EffectMove("SELL PATCHES", Move.MoveType.POWERUP, Move.TargetStat.DEFENSE, 1.3, 1000));
        moveCatalog.put("EYBRO", new EffectMove("EYBRO", Move.MoveType.POWERUP, Move.TargetStat.SPEED, 1.3, 1000));
        moveCatalog.put("PEA SOUP", new EffectMove("PEA SOUP", Move.MoveType.POWERUP, Move.TargetStat.ATTACK, 1.44, 4000));
        moveCatalog.put("SANTA'S LAP", new EffectMove("SANTA'S LAP", Move.MoveType.POWERUP, Move.TargetStat.DEFENSE, 1.47, 5000));
        moveCatalog.put("PUNSCH", new EffectMove("PUNSCH", Move.MoveType.POWERUP, Move.TargetStat.SPEED, 1.5, 6000));

        moveCatalog.put("CALCULUS", new EffectMove("CALCULUS", Move.MoveType.WEAKEN, Move.TargetStat.ATTACK, 0.7, 1000));
        moveCatalog.put("HUNGOVER", new EffectMove("HUNGOVER", Move.MoveType.WEAKEN, Move.TargetStat.DEFENSE, 0.7, 1000));
        moveCatalog.put("BENDER", new EffectMove("BENDER", Move.MoveType.WEAKEN, Move.TargetStat.SPEED, 0.7, 1000));
        moveCatalog.put("TENGIL SITTING", new EffectMove("TENGIL SITTING", Move.MoveType.WEAKEN, Move.TargetStat.DEFENSE, 0.56, 4000));
        moveCatalog.put("FERNET", new EffectMove("FERNET", Move.MoveType.WEAKEN, Move.TargetStat.SPEED, 0.53, 5000));
        moveCatalog.put("DUNKED", new EffectMove("DUNKED", Move.MoveType.WEAKEN, Move.TargetStat.ATTACK, 0.5, 6000));

        /* MIT-PLACE */
        moveCatalog.put("TACKLE", new AttackMove("TACKLE", 35));
        moveCatalog.put("WHITE MONSTER", new EffectMove("WHITE MONSTER", Move.MoveType.POWERUP, Move.TargetStat.SPEED, 1.2));
        moveCatalog.put("DEFAULT DANCE", new EffectMove("DEFAULT DANCE", Move.MoveType.WEAKEN, Move.TargetStat.DEFENSE, 0.8));

        /* MIT-CAFE */
        moveCatalog.put("THROW KEBAB", new AttackMove("THROW KEBAB", 40));
        moveCatalog.put("NTK MEMBER?", new EffectMove("NTK MEMBER?", Move.MoveType.WEAKEN, Move.TargetStat.SPEED, 0.8));

        /* DATAGYM */
        moveCatalog.put("COFFEE", new EffectMove("COFFEE", Move.MoveType.POWERUP, Move.TargetStat.SPEED, 1.2));
        moveCatalog.put("BAD FEEDBACK", new AttackMove("BAD FEEDBACK", 45));
        moveCatalog.put("DENIED ENTRY", new AttackMove("DENIED ENTRY", 50));
        moveCatalog.put("DISCOURAGEMENT", new EffectMove("DISCOURAGEMENT", Move.MoveType.WEAKEN, Move.TargetStat.DEFENSE, 0.8));

        /* NATURVETARHUSET */
        moveCatalog.put("VECTOR THRUST", new AttackMove("VECTOR THRUST", 50));
        moveCatalog.put("HIGH GRAVITY", new EffectMove("HIGH GRAVITY", Move.MoveType.POWERUP, Move.TargetStat.SPEED, 1.2));
        moveCatalog.put("ZERO FRICTION", new EffectMove("ZERO FRICTION", Move.MoveType.WEAKEN, Move.TargetStat.SPEED, 0.8));
        moveCatalog.put("OVERDRIVE", new AttackMove("OVERDRIVE", 50));
        moveCatalog.put("PLATING", new EffectMove("PLATING", Move.MoveType.POWERUP, Move.TargetStat.DEFENSE, 1.2));
        moveCatalog.put("RESOURCE DRAIN", new EffectMove("RESOURCE DRAIN", Move.MoveType.WEAKEN, Move.TargetStat.ATTACK, 0.8));
        moveCatalog.put("ACID SPLASH", new AttackMove("ACID SPLASH", 50));
        moveCatalog.put("ADRENALIN", new EffectMove("ADRENALIN", Move.MoveType.POWERUP, Move.TargetStat.ATTACK, 1.2));
        moveCatalog.put("CELL DECAY", new EffectMove("CELL DECAY", Move.MoveType.WEAKEN, Move.TargetStat.DEFENSE, 0.8));

        /* TVISTE */
        moveCatalog.put("DEPT TRAP", new AttackMove("DEPT TRAP", 50));
        moveCatalog.put("FATHERS CREDITCARD", new EffectMove("FATHERS CREDITCARD", Move.MoveType.POWERUP, Move.TargetStat.DEFENSE, 1.2));
        moveCatalog.put("NET WORTH JUDGE", new EffectMove("NET WORTH JUDGE", Move.MoveType.WEAKEN, Move.TargetStat.ATTACK, 0.8));
        moveCatalog.put("CARB OVERLOAD", new AttackMove("CARB OVERLOAD", 55));
        moveCatalog.put("DOUBLE SKAGEN", new EffectMove("DOUBLE SKAGEN", Move.MoveType.POWERUP, Move.TargetStat.ATTACK, 1.2));
        moveCatalog.put("FORCED POTATO", new EffectMove("FORCED POTATO", Move.MoveType.WEAKEN, Move.TargetStat.SPEED, 0.8));
        moveCatalog.put("PROSTATE POKE", new AttackMove("PROSTATE POKE", 50));
        moveCatalog.put("PLACEBO EFFECT", new EffectMove("PLACEBO EFFECT", Move.MoveType.POWERUP, Move.TargetStat.DEFENSE, 1.2));
        moveCatalog.put("BURNOUT", new EffectMove("BURNOUT", Move.MoveType.WEAKEN, Move.TargetStat.DEFENSE, 0.8));
        moveCatalog.put("CRITICAL FEEDBACK", new AttackMove("CRITICAL FEEDBACK", 50));
        moveCatalog.put("GOLDEN RATIO", new EffectMove("GOLDEN RATIO", Move.MoveType.POWERUP, Move.TargetStat.SPEED, 1.2));
        moveCatalog.put("UNORDERED GRID", new EffectMove("UNORDERED GRID", Move.MoveType.WEAKEN, Move.TargetStat.DEFENSE, 0.8));

        /* ROUGE */
        moveCatalog.put("BATON HIT", new AttackMove("BATON HIT", 55));
        moveCatalog.put("FLEX MUSCLE", new EffectMove("FLEX MUSCLE", Move.MoveType.POWERUP, Move.TargetStat.ATTACK, 1.2));
        moveCatalog.put("DRUNK SUSPICION", new EffectMove("DRUNK SUSPICION", Move.MoveType.WEAKEN, Move.TargetStat.SPEED, 0.8));

        moveCatalog.put("DEAL BAD CARDS", new AttackMove("DEAL BAD CARDS", 55));
        moveCatalog.put("HOUSE BLACKJACK", new EffectMove("HOUSE BLACKJACK", Move.MoveType.POWERUP, Move.TargetStat.DEFENSE, 1.25));
        moveCatalog.put("BUY-IN", new EffectMove("BUY-IN", Move.MoveType.WEAKEN, Move.TargetStat.DEFENSE, 0.75));

        moveCatalog.put("PENIS SWING", new AttackMove("PENIS SWING", 60));
        moveCatalog.put("ASS-BEER", new EffectMove("ASS-BEER", Move.MoveType.POWERUP, Move.TargetStat.ATTACK, 1.25));
        moveCatalog.put("PARTY IN HOLMA", new EffectMove("PARTY IN HOLMA", Move.MoveType.WEAKEN, Move.TargetStat.ATTACK, 0.75));

        moveCatalog.put("EXPENSIVE BEER", new AttackMove("EXPENSIVE BEER", 65));
        moveCatalog.put("SABOTAGE ORIGO", new EffectMove("SABOTAGE ORIGO", Move.MoveType.POWERUP, Move.TargetStat.SPEED, 1.3));
        moveCatalog.put("MANIPULATE", new EffectMove("MANIPULATE", Move.MoveType.WEAKEN, Move.TargetStat.SPEED, 0.7));
    }

    private void initMITPlace() {
        Rookie r1 = createEnemy("Data Grunt", getDataGruntArt(), "TACKLE", "WHITE MONSTER", "STARE", 2);
        Rookie r2 = createEnemy("Data Grunt", getDataGruntArt(), "TACKLE", "WHITE MONSTER", "STARE", 3);
        Rookie r3 = createEnemy("Gamer", getGamerArt(), "TACKLE", "WHITE MONSTER", "DEFAULT DANCE", 3);
        Rookie r4 = createEnemy("Gamer", getGamerArt(), "TACKLE", "WHITE MONSTER", "DEFAULT DANCE", 4);
        List<Rookie> rookies = List.of(r1, r2, r3, r4);
        battlegrounds.add(new Battleground("MIT-Place", rookies, false, false));
    }

    private void initMITCafe() {
        Rookie r1 = createEnemy("Female Worker", getFemaleMITArt(), "THROW KEBAB", "COFFEE", "NTK MEMBER?", 8);
        Rookie r2 = createEnemy("Female Worker", getFemaleMITArt(), "THROW KEBAB", "COFFEE", "NTK MEMBER?", 7);
        Rookie r3 = createEnemy("Male Worker", getMaleMITArt(), "THROW KEBAB", "COFFEE", "NTK MEMBER?", 7);
        Rookie r4 = createEnemy("Male Worker", getMaleMITArt(), "THROW KEBAB", "COFFEE", "NTK MEMBER?", 6);
        Rookie r5 = createEnemy("Female Worker", getFemaleMITArt(), "THROW KEBAB", "COFFEE", "NTK MEMBER?", 7);

        List<Rookie> rookies = List.of(r1, r2, r3, r4, r5);
        battlegrounds.add(new Battleground("MIT-CAFE", rookies, false, false));
    }

    private void initDataGym() {
        Rookie r1 = createEnemy("Tutor", getTutorArt(), "BAD FEEDBACK", "WHITE MONSTER", "MEAN WORDS", 11);
        Rookie r2 = createEnemy("Study Counselor", getCounselorArt(), "BAD FEEDBACK", "COFFEE", "DISCOURAGEMENT", 12);
        Rookie r3 = createEnemy("Principal", getPrincipalArt(), "DENIED ENTRY", "COFFEE", "MEAN WORDS", 13);
        List<Rookie> rookies = List.of(r1, r2, r3);
        battlegrounds.add(new Battleground("Data Gym", rookies, false, true));
    }

    private void initNaturvetarhuset() {
        Rookie r1 = createEnemy("Physics Theorist", getPhysicsArt(), "VECTOR THRUST", "HIGH GRAVITY", "ZERO FRICTION", 12);
        Rookie r2 = createEnemy("Physics Theorist", getPhysicsArt(), "VECTOR THRUST", "HIGH GRAVITY", "ZERO FRICTION", 13);
        Rookie r3 = createEnemy("Machine Engineer", getMachineArt(), "OVERDRIVE", "PLATING", "RESOURCE DRAIN", 12);
        Rookie r4 = createEnemy("Machine Engineer", getMachineArt(), "OVERDRIVE", "PLATING", "RESOURCE DRAIN", 13);
        Rookie r5 = createEnemy("Life-Science Agent", getLifeScienceArt(), "ACID SPLASH", "ADRENALIN", "CELL DECAY", 13);
        Rookie r6 = createEnemy("Life-Science Agent", getLifeScienceArt(), "ACID SPLASH", "ADRENALIN", "CELL DECAY", 14);
        Rookie r7 = createEnemy("Physics Theorist", getPhysicsArt(), "VECTOR THRUST", "HIGH GRAVITY", "ZERO FRICTION", 15);
        Rookie r8 = createEnemy("Machine Engineer", getMachineArt(), "OVERDRIVE", "PLATING", "RESOURCE DRAIN", 14);
        List<Rookie> rookies = List.of(r1, r2, r3, r4, r5, r6, r7, r8);
        battlegrounds.add(new Battleground("Naturvetarhuset", rookies, true, false));
    }

    private void initSkötet() {
        Rookie r1 = createEnemy("5 Year Old Rookie", get5YearOldRookie(), "ROOKIE KICK", "FLASH TUX", "BENDER", 18);
        r1.setMessage(get5YearText());
        List<Rookie> rookies = List.of(r1);
        Battleground bg = new Battleground("Skötet", rookies, true, true);
        bg.setTraining(true);
        battlegrounds.add(bg);
    }

    private void initTviste() {
        Rookie r1 = createEnemy("Economy Elite", getMaleTvisteArt(), "DEPT TRAP", "FATHERS CREDITCARD", "NET WORTH JUDGEMENT", 17);
        Rookie r2 = createEnemy("Economy Elite", getMaleTvisteArt(), "DEPT TRAP", "FATHERS CREDITCARD", "NET WORTH JUDGEMENT", 18);
        Rookie r4 = createEnemy("Economy Elite", getFemaleTvisteArt(), "DEPT TRAP", "FATHERS CREDITCARD", "NET WORTH JUDGEMENT", 19);

        Rookie r5 = createEnemy("Fire Potato Guy", getDefaultArt(), "CARB OVERLOAD", "DOUBLE SKAGEN", "FORCE EAT", 20);
        Rookie r6 = createEnemy("Banger Potato Guy", getDefaultArt(), "CARB OVERLOAD", "DOUBLE SKAGEN", "FORCED POTATO", 21);

        Rookie r7 = createEnemy("Medical Scholar", getDefaultArt(), "PROSTATE POKE", "PLACEBO EFFECT", "BURNOUT", 17);
        Rookie r8 = createEnemy("Medical Scholar", getDefaultArt(), "PROSTATE POKE", "PLACEBO EFFECT", "BURNOUT", 18);
        Rookie r9 = createEnemy("Medical Scholar", getDefaultArt(), "PROSTATE POKE", "PLACEBO EFFECT", "BURNOUT", 19);

        Rookie r10 = createEnemy("Architect", getDefaultArt(), "CRITICAL FEEDBACK", "GOLDEN RATIO", "UNORDERED GRID", 17);
        Rookie r11 = createEnemy("Architect", getDefaultArt(), "CRITICAL FEEDBACK", "GOLDEN RATIO", "UNORDERED GRID", 18);
        Rookie r12 = createEnemy("Architect", getDefaultArt(), "CRITICAL FEEDBACK", "GOLDEN RATIO", "UNORDERED GRID", 19);

        List<Rookie> rookies = List.of(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12);
        battlegrounds.add(new Battleground("Tviste", rookies, true, false));
    }

    private void initRouge() {
        Rookie r1 = createEnemy("Entrance Guard", getDefaultArt(), "BATON HIT", "FLEX MUSCLE", "DRUNK SUSPICION", 23);
        Rookie r2 = createEnemy("BlackJack Worker", getBlackJackArt(), "DEAL BAD CARDS", "DEALER BLACKJACK", "BUY-IN", 23);
        Rookie r3 = createEnemy("Homer President", getHomerArt(), "PENIS SWING", "ASS-BEER", "PARTY IN HOLMA", 24);
        Rookie r4 = createEnemy("Saba", getDefaultArt(), "EXPENSIVE BEER", "SABOTAGE ORIGO", "MANIPULATE", 26);
        List<Rookie> rookies = List.of(r1, r2, r3, r4);
        battlegrounds.add(new Battleground("Rouge", rookies, true, true));
    }

    private Rookie createEnemy(String name, String art, String attackMove, String powerupMove, String weakenMove, int level) {
        Rookie rookie = new Rookie(name);
        rookie.setArt(art);
        rookie.addMove(moveCatalog.get(attackMove));
        rookie.addMove(moveCatalog.get(powerupMove));
        rookie.addMove(moveCatalog.get(weakenMove));
        rookie.levelUp(level - 1);
        return rookie;
    }

}