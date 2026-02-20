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

import static resources.ascii.Characters.*;
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
            initMITHuset();
            initDataGym();
            initNaturvetarhuset();
            initSkötet();

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
        /* STARTER */
        moveCatalog.put("PUNCH", new AttackMove("PUNCH", 40));
        moveCatalog.put("LUCKY BAIT", new EffectMove("LUCKY BAIT", Move.MoveType.POWERUP, Move.TargetStat.ATTACK, 1.2));
        moveCatalog.put("TROPIC THUNDER", new EffectMove("TROPIC THUNDER", Move.MoveType.POWERUP, Move.TargetStat.SPEED, 1.2));
        moveCatalog.put("ARTON56", new EffectMove("ARTON56", Move.MoveType.POWERUP, Move.TargetStat.ATTACK, 1.25));
        moveCatalog.put("GUINNESS", new EffectMove("GUINNESS", Move.MoveType.POWERUP, Move.TargetStat.DEFENSE, 1.2));
        moveCatalog.put("TAUNT", new EffectMove("TAUNT", Move.MoveType.WEAKEN, Move.TargetStat.SPEED, 0.8));
        moveCatalog.put("MEAN WORDS", new EffectMove("MEAN WORDS", Move.MoveType.WEAKEN, Move.TargetStat.ATTACK, 0.8));
        moveCatalog.put("STARE", new EffectMove("STARE", Move.MoveType.WEAKEN, Move.TargetStat.DEFENSE, 0.8));

        /* MIT-HUSET */
        moveCatalog.put("TACKLE", new AttackMove("TACKLE", 35));
        moveCatalog.put("WHITE MONSTER", new EffectMove("WHITE MONSTER", Move.MoveType.POWERUP, Move.TargetStat.SPEED, 1.2));
        moveCatalog.put("DEFAULT DANCE", new EffectMove("DEFAULT DANCE", Move.MoveType.WEAKEN, Move.TargetStat.DEFENSE, 0.8));

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

        /* SKÖTET */
        moveCatalog.put("ROOKIE KICK", new AttackMove("ROOKIE KICK", 50, 500));
        moveCatalog.put("PUKE ATTACK", new AttackMove("PUKE ATTACK", 70, 2000));
        moveCatalog.put("FEJDEN SIDEFLIP", new AttackMove("FEJDEN SIDEFLIP", 85, 5000));
        moveCatalog.put("ROOKIE RAGE", new AttackMove("ROOKIE RAGE", 100, 10000));

        moveCatalog.put("FLASH TUX", new EffectMove("FLASH TUX", Move.MoveType.POWERUP, Move.TargetStat.ATTACK, 1.3, 1000));
        moveCatalog.put("SELL PATCHES", new EffectMove("SELL PATCHES", Move.MoveType.POWERUP, Move.TargetStat.DEFENSE, 1.3, 1000));
        moveCatalog.put("EYBRO", new EffectMove("EYBRO", Move.MoveType.POWERUP, Move.TargetStat.SPEED, 1.3, 1000));
        moveCatalog.put("PEA SOUP", new EffectMove("PEA SOUP", Move.MoveType.POWERUP, Move.TargetStat.ATTACK, 1.44, 3000));
        moveCatalog.put("SANTA'S LAP", new EffectMove("SANTA'S LAP", Move.MoveType.POWERUP, Move.TargetStat.DEFENSE, 1.47, 3500));
        moveCatalog.put("PUNSCH", new EffectMove("PUNSCH", Move.MoveType.POWERUP, Move.TargetStat.SPEED, 1.5, 4000));

        moveCatalog.put("CALCULUS", new EffectMove("CALCULUS", Move.MoveType.WEAKEN, Move.TargetStat.ATTACK, 0.7, 1000));
        moveCatalog.put("HUNGOVER", new EffectMove("HUNGOVER", Move.MoveType.WEAKEN, Move.TargetStat.DEFENSE, 0.7, 1000));
        moveCatalog.put("BENDER", new EffectMove("BENDER", Move.MoveType.WEAKEN, Move.TargetStat.SPEED, 0.7, 1000));
        moveCatalog.put("DUNKED", new EffectMove("DUNKED", Move.MoveType.WEAKEN, Move.TargetStat.ATTACK, 0.5, 4000));
        moveCatalog.put("TENGIL SITTING", new EffectMove("TENGIL SITTING", Move.MoveType.WEAKEN, Move.TargetStat.DEFENSE, 0.56, 3000));
        moveCatalog.put("FERNET", new EffectMove("FERNET", Move.MoveType.WEAKEN, Move.TargetStat.SPEED, 0.53, 3500));

    }

    private void initMITHuset() {
        List<Rookie> rookies = new ArrayList<>();

        Rookie r1 = new Rookie("Data Grunt");
        r1.setArt(getTutorArt());
        r1.addMove(moveCatalog.get("TACKLE"));
        r1.addMove(moveCatalog.get("WHITE MONSTER"));
        r1.addMove(moveCatalog.get("STARE"));
        r1.levelUp(2);
        Rookie r2 = new Rookie("Gamer");
        r2.setArt(getGamerArt());
        r2.addMove(moveCatalog.get("TACKLE"));
        r2.addMove(moveCatalog.get("WHITE MONSTER"));
        r2.addMove(moveCatalog.get("DEFAULT DANCE"));
        r2.levelUp(1);
        Rookie r3 = new Rookie("Gamer");
        r3.setArt(getGamerArt());
        r3.addMove(moveCatalog.get("TACKLE"));
        r3.addMove(moveCatalog.get("WHITE MONSTER"));
        r3.addMove(moveCatalog.get("DEFAULT DANCE"));
        r3.levelUp(2);

        rookies.add(r1);
        rookies.add(r2);
        rookies.add(r3);
        battlegrounds.add(new Battleground("MIT-Huset", rookies, false, false));
    }

    private void initDataGym() {
        List<Rookie> rookies = new ArrayList<>();
        Rookie r1 = new Rookie("Tutor");
        r1.setArt(getDataGruntArt());
        r1.addMove(moveCatalog.get("BAD FEEDBACK"));
        r1.addMove(moveCatalog.get("WHITE MONSTER"));
        r1.addMove(moveCatalog.get("MEAN WORDS"));
        r1.levelUp(9);

        Rookie r2 = new Rookie("Study Counselor");
        r2.setArt(getCounselorArt());
        r2.addMove(moveCatalog.get("BAD FEEDBACK"));
        r2.addMove(moveCatalog.get("COFFEE"));
        r2.addMove(moveCatalog.get("ENCOURAGEMENT"));
        r2.levelUp(10);

        Rookie r3 = new Rookie("Principal");
        r3.setArt(getPrincipalArt());
        r3.addMove(moveCatalog.get("DENIED ENTRY"));
        r3.addMove(moveCatalog.get("COFFEE"));
        r3.addMove(moveCatalog.get("MEAN WORDS"));
        r3.levelUp(12);

        rookies.add(r1);
        rookies.add(r2);
        rookies.add(r3);
        battlegrounds.add(new Battleground("Data Gym", rookies, false, true));
    }

    private void initNaturvetarhuset() {
        List<Rookie> rookies = new ArrayList<>();
        Rookie r1 = new Rookie("Physics Theorist");
        r1.setArt(getPhysicsArt());
        r1.addMove(moveCatalog.get("VECTOR THRUST"));
        r1.addMove(moveCatalog.get("HIGH GRAVITY"));
        r1.addMove(moveCatalog.get("ZERO FRICTION"));
        r1.levelUp(11);
        Rookie r2 = new Rookie("Physics Theorist");
        r2.setArt(getPhysicsArt());
        r2.addMove(moveCatalog.get("VECTOR THRUST"));
        r2.addMove(moveCatalog.get("HIGH GRAVITY"));
        r2.addMove(moveCatalog.get("ZERO FRICTION"));
        r2.levelUp(12);

        Rookie r3 = new Rookie("Machine Engineer");
        r3.setArt(getMachineArt());
        r3.addMove(moveCatalog.get("OVERDRIVE"));
        r3.addMove(moveCatalog.get("PLATING"));
        r3.addMove(moveCatalog.get("RESOURCE DRAIN"));
        r3.levelUp(11);
        Rookie r4 = new Rookie("Machine Engineer");
        r4.setArt(getMachineArt());
        r4.addMove(moveCatalog.get("OVERDRIVE"));
        r4.addMove(moveCatalog.get("PLATING"));
        r4.addMove(moveCatalog.get("RESOURCE DRAIN"));
        r4.levelUp(12);

        Rookie r5 = new Rookie("Life-Science Agent");
        r5.setArt(getLifeScienceArt());
        r5.addMove(moveCatalog.get("ACID SPLASH"));
        r5.addMove(moveCatalog.get("ADRENALIN"));
        r5.addMove(moveCatalog.get("CELL DECAY"));
        r5.levelUp(11);
        Rookie r6 = new Rookie("Life-Science Agent");
        r6.setArt(getLifeScienceArt());
        r6.addMove(moveCatalog.get("ACID SPLASH"));
        r6.addMove(moveCatalog.get("ADRENALIN"));
        r6.addMove(moveCatalog.get("CELL DECAY"));
        r6.levelUp(12);

        rookies.add(r1);
        rookies.add(r2);
        rookies.add(r3);
        rookies.add(r4);
        rookies.add(r5);
        rookies.add(r6);
        battlegrounds.add(new Battleground("Naturvetarhuset", rookies, true, false));
    }

    private void initSkötet() {
        List<Rookie> rookies = new ArrayList<>();
        Rookie r1 = new Rookie("5 Year Old Rookie");
        r1.setArt(get5YearOldRookie());
        r1.setMessage(get5YearText());
        r1.addMove(moveCatalog.get("ROOKIE KICK"));
        r1.addMove(moveCatalog.get("FLASH TUX"));
        r1.addMove(moveCatalog.get("BENDER"));
        r1.levelUp(17);
        rookies.add(r1);
        Battleground bg = new Battleground("Skötet", rookies, true, true);
        bg.setTraining(true);
        battlegrounds.add(bg);
    }

}