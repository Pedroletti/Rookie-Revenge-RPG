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
import static resources.ascii.PhaseFour.*;
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
            initICA();
            initStipendiegränd();
            initTheEastPavilion();
            initIKSU();
            initOrigo();

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
        addAttackMove("GOD KICK", 200);

        /* STARTER */
        addAttackMove("PUNCH", 45);
        addEffectMove("LUCKY BAIT", Move.MoveType.POWERUP, Move.TargetStat.ATTACK, 1.2);
        addEffectMove("TROPIC THUNDER", Move.MoveType.POWERUP, Move.TargetStat.SPEED, 1.2);
        addEffectMove("ARTON56", Move.MoveType.POWERUP, Move.TargetStat.ATTACK, 1.25);
        addEffectMove("GUINNESS", Move.MoveType.POWERUP, Move.TargetStat.DEFENSE, 1.2);
        addEffectMove("TAUNT", Move.MoveType.WEAKEN, Move.TargetStat.SPEED, 0.8);
        addEffectMove("MEAN WORDS", Move.MoveType.WEAKEN, Move.TargetStat.ATTACK, 0.8);
        addEffectMove("STARE", Move.MoveType.WEAKEN, Move.TargetStat.DEFENSE, 0.8);

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
        addAttackMove("TACKLE", 35);
        addEffectMove("WHITE MONSTER", Move.MoveType.POWERUP, Move.TargetStat.SPEED, 1.2);
        addEffectMove("DEFAULT DANCE", Move.MoveType.WEAKEN, Move.TargetStat.DEFENSE, 0.8);

        /* MIT-CAFE */
        addAttackMove("THROW KEBAB", 40);
        addEffectMove("NTK MEMBER?", Move.MoveType.WEAKEN, Move.TargetStat.SPEED, 0.8);

        /* DATAGYM */
        addEffectMove("COFFEE", Move.MoveType.POWERUP, Move.TargetStat.SPEED, 1.2);
        addAttackMove("BAD FEEDBACK", 45);
        addAttackMove("DENIED ENTRY", 50);
        addEffectMove("ENCOURAGEMENT", Move.MoveType.WEAKEN, Move.TargetStat.DEFENSE, 1.2);

        /* NATURVETARHUSET */
        addAttackMove("VECTOR THRUST", 50);
        addEffectMove("HIGH GRAVITY", Move.MoveType.POWERUP, Move.TargetStat.SPEED, 1.2);
        addEffectMove("ZERO FRICTION", Move.MoveType.WEAKEN, Move.TargetStat.SPEED, 0.8);
        addAttackMove("OVERDRIVE", 50);
        addEffectMove("PLATING", Move.MoveType.POWERUP, Move.TargetStat.DEFENSE, 1.2);
        addEffectMove("RESOURCE DRAIN", Move.MoveType.WEAKEN, Move.TargetStat.ATTACK, 0.8);
        addAttackMove("ACID SPLASH", 50);
        addEffectMove("ADRENALIN", Move.MoveType.POWERUP, Move.TargetStat.ATTACK, 1.2);
        addEffectMove("CELL DECAY", Move.MoveType.WEAKEN, Move.TargetStat.DEFENSE, 0.8);

        /* TVISTE */
        addAttackMove("DEPT TRAP", 50);
        addEffectMove("FATHERS CREDITCARD", Move.MoveType.POWERUP, Move.TargetStat.DEFENSE, 1.2);
        addEffectMove("NET WORTH JUDGE", Move.MoveType.WEAKEN, Move.TargetStat.ATTACK, 0.8);
        addAttackMove("CARB OVERLOAD", 55);
        addEffectMove("DOUBLE SKAGEN", Move.MoveType.POWERUP, Move.TargetStat.ATTACK, 1.2);
        addEffectMove("FORCED POTATO", Move.MoveType.WEAKEN, Move.TargetStat.SPEED, 0.8);
        addAttackMove("PROSTATE POKE", 50);
        addEffectMove("PLACEBO EFFECT", Move.MoveType.POWERUP, Move.TargetStat.DEFENSE, 1.2);
        addEffectMove("BURNOUT", Move.MoveType.WEAKEN, Move.TargetStat.DEFENSE, 0.8);
        addAttackMove("CRITICAL FEEDBACK", 50);
        addEffectMove("GOLDEN RATIO", Move.MoveType.POWERUP, Move.TargetStat.SPEED, 1.2);
        addEffectMove("UNORDERED GRID", Move.MoveType.WEAKEN, Move.TargetStat.DEFENSE, 0.8);

        /* ROUGE */
        addAttackMove("BATON HIT", 55);
        addEffectMove("FLEX MUSCLE", Move.MoveType.POWERUP, Move.TargetStat.ATTACK, 1.2);
        addEffectMove("DRUNK SUSPICION", Move.MoveType.WEAKEN, Move.TargetStat.SPEED, 0.8);
        addAttackMove("DEAL BAD CARDS", 55);
        addEffectMove("HOUSE BLACKJACK", Move.MoveType.POWERUP, Move.TargetStat.DEFENSE, 1.25);
        addEffectMove("BUY-IN", Move.MoveType.WEAKEN, Move.TargetStat.DEFENSE, 0.75);
        addAttackMove("PENIS SWING", 60);
        addEffectMove("ASS-BEER", Move.MoveType.POWERUP, Move.TargetStat.ATTACK, 1.25);
        addEffectMove("PARTY IN HOLMA", Move.MoveType.WEAKEN, Move.TargetStat.ATTACK, 0.75);
        addAttackMove("EXPENSIVE BEER", 65);
        addEffectMove("BRIBE", Move.MoveType.POWERUP, Move.TargetStat.SPEED, 1.3);
        addEffectMove("MANIPULATE", Move.MoveType.WEAKEN, Move.TargetStat.SPEED, 0.7);

        /* STIPENDIEGRÄND */
        addAttackMove("GOGO GAGA", 60);
        addEffectMove("TITTY TOUCH", Move.MoveType.POWERUP, Move.TargetStat.ATTACK, 1.25);
        addEffectMove("CRY", Move.MoveType.WEAKEN, Move.TargetStat.DEFENSE, 0.75);
        addAttackMove("SPIT", 60);
        addEffectMove("ROBUX SHOWER", Move.MoveType.POWERUP, Move.TargetStat.DEFENSE, 1.25);
        addEffectMove("SPOILED BRAT", Move.MoveType.WEAKEN, Move.TargetStat.SPEED, 0.75);
        addEffectMove("zzZzzZz..", Move.MoveType.POWERUP, Move.TargetStat.ATTACK, 0.9);
        addAttackMove("TURING ATTACK", 60);
        addAttackMove("SPEEDRUN", 60);
        addEffectMove("DV-ASSEMBLE", Move.MoveType.POWERUP, Move.TargetStat.ATTACK, 1.25);

        /* THE EAST PAVILION */
        addAttackMove("INDUCTION", 60);
        addEffectMove("TRUTH TABLE", Move.MoveType.POWERUP, Move.TargetStat.DEFENSE, 1.3);
        addEffectMove("DISCONNECTION", Move.MoveType.WEAKEN, Move.TargetStat.ATTACK, 0.7);
        addAttackMove("SEGMENTATION FAULT", 60);
        addEffectMove("MALLOC", Move.MoveType.POWERUP, Move.TargetStat.DEFENSE, 1.3);
        addEffectMove("MEMORY LEAK", Move.MoveType.WEAKEN, Move.TargetStat.DEFENSE, 0.7);
        addAttackMove("SWING", 65);
        addEffectMove("MVC", Move.MoveType.POWERUP, Move.TargetStat.ATTACK, 1.3);
        addEffectMove("NULL-POINTER", Move.MoveType.WEAKEN, Move.TargetStat.ATTACK, 0.7);
        addAttackMove("DERIVATION", 65);
        addEffectMove("EXPONENTIAL GROWTH", Move.MoveType.POWERUP, Move.TargetStat.SPEED, 1.3);
        addEffectMove("LIMIT TOWARDS ZERO", Move.MoveType.WEAKEN, Move.TargetStat.SPEED, 0.7);

        /* IKSU */
        addAttackMove("SKULL CRUSHER", 60);
        addEffectMove("JUICE", Move.MoveType.POWERUP, Move.TargetStat.ATTACK, 1.3);
        addEffectMove("SCARY FLEX", Move.MoveType.WEAKEN, Move.TargetStat.DEFENSE, 0.7);
        addEffectMove("CELSIUS", Move.MoveType.POWERUP, Move.TargetStat.SPEED, 1.3);
        addEffectMove("BANNED4LIFE", Move.MoveType.WEAKEN, Move.TargetStat.ATTACK, 0.7);
        addAttackMove("TREADMILL RUN", 60);
        addEffectMove("PACING PRESSURE", Move.MoveType.WEAKEN, Move.TargetStat.SPEED, 0.7);

        /* ORIGO */
        addAttackMove("LOSE YOUR PANTS", 70);
        addAttackMove("BOTTLE-SLAM", 70);
        addAttackMove("CATHETER CONSTRICTION", 70);
        addAttackMove("BROKEN SPELL", 70);
        addAttackMove("RUNESCAPE", 70);
        addAttackMove("BULLY-DL", 70);
        addAttackMove("TACTICAL PUKE", 70);
        addAttackMove("BING COLLECT", 75);
        addAttackMove("VOMIT", 80);
        addAttackMove("ULTRA-VOMIT", 90);


        addEffectMove("BREZNAK", Move.MoveType.POWERUP, Move.TargetStat.ATTACK, 1.35);
        addEffectMove("STEEZY BREEZY", Move.MoveType.POWERUP, Move.TargetStat.DEFENSE, 1.35);
        addEffectMove("DUNK-CHAMPION", Move.MoveType.POWERUP, Move.TargetStat.ATTACK, 1.35);
        addEffectMove("BLACKOUT", Move.MoveType.POWERUP, Move.TargetStat.ATTACK, 1.35);
        addEffectMove("FERNET FOUNTAIN", Move.MoveType.POWERUP, Move.TargetStat.SPEED, 1.35);
        addEffectMove("SHOTGUN", Move.MoveType.POWERUP, Move.TargetStat.SPEED, 1.35);
        addEffectMove("MARRIAGE", Move.MoveType.POWERUP, Move.TargetStat.DEFENSE, 1.35);
        addEffectMove("LEFT RAGE", Move.MoveType.POWERUP, Move.TargetStat.ATTACK, 1.35);
        addEffectMove("DRESS FANCY", Move.MoveType.POWERUP, Move.TargetStat.DEFENSE, 1.38);
        addEffectMove("WHISKY ENJOYER", Move.MoveType.POWERUP, Move.TargetStat.SPEED, 1.4);

        addEffectMove("ROOKIESKÅL", Move.MoveType.WEAKEN, Move.TargetStat.DEFENSE, 0.6);
    }

    private void addAttackMove(String name, int baseDamage) {
        moveCatalog.put(name, new AttackMove(name, baseDamage));
    }

    private void addEffectMove(String name, Move.MoveType moveType, Move.TargetStat targetStat, double multiplier) {
        moveCatalog.put(name, new EffectMove(name, moveType, targetStat, multiplier));
    }

    private void initMITPlace() {
        Rookie r1 = createEnemy("Data Grunt", getDataGruntArt(), "TACKLE", "WHITE MONSTER", "STARE", 2);
        Rookie r2 = createEnemy("Data Grunt", getDataGruntArt(), "TACKLE", "WHITE MONSTER", "STARE", 3);
        Rookie r3 = createEnemy("Gamer", getGamerArt(), "TACKLE", "WHITE MONSTER", "DEFAULT DANCE", 3);
        Rookie r4 = createEnemy("Gamer", getGamerArt(), "TACKLE", "WHITE MONSTER", "DEFAULT DANCE", 4);
        List<Rookie> rookies = List.of(r1, r2, r3, r4);
        battlegrounds.add(new Battleground("MIT-Place", rookies, false, false, false));
    }

    private void initMITCafe() {
        Rookie r1 = createEnemy("Female Worker", getFemaleMITArt(), "THROW KEBAB", "COFFEE", "NTK MEMBER?", 8);
        Rookie r2 = createEnemy("Female Worker", getFemaleMITArt(), "THROW KEBAB", "COFFEE", "NTK MEMBER?", 7);
        Rookie r3 = createEnemy("Male Worker", getMaleMITArt(), "THROW KEBAB", "COFFEE", "NTK MEMBER?", 7);
        Rookie r4 = createEnemy("Male Worker", getMaleMITArt(), "THROW KEBAB", "COFFEE", "NTK MEMBER?", 6);
        Rookie r5 = createEnemy("Female Worker", getFemaleMITArt(), "THROW KEBAB", "COFFEE", "NTK MEMBER?", 7);

        List<Rookie> rookies = List.of(r1, r2, r3, r4, r5);
        battlegrounds.add(new Battleground("MIT-CAFE", rookies, true, false, false));
    }

    private void initDataGym() {
        Rookie r1 = createEnemy("Tutor", getTutorArt(), "BAD FEEDBACK", "WHITE MONSTER", "MEAN WORDS", 9);
        Rookie r2 = createEnemy("Study Counselor", getCounselorArt(), "BAD FEEDBACK", "COFFEE", "ENCOURAGEMENT", 10);
        Rookie r3 = createEnemy("Principal", getPrincipalArt(), "DENIED ENTRY", "COFFEE", "MEAN WORDS", 12);
        List<Rookie> rookies = List.of(r1, r2, r3);
        battlegrounds.add(new Battleground("Data Gym", rookies, true, true, false));
    }

    private void initNaturvetarhuset() {
        Rookie r1 = createEnemy("Physics Theorist", getPhysicsArt(), "VECTOR THRUST", "HIGH GRAVITY", "ZERO FRICTION", 11);
        Rookie r2 = createEnemy("Physics Theorist", getPhysicsArt(), "VECTOR THRUST", "HIGH GRAVITY", "ZERO FRICTION", 12);
        Rookie r3 = createEnemy("Machine Engineer", getMachineArt(), "OVERDRIVE", "PLATING", "RESOURCE DRAIN", 11);
        Rookie r4 = createEnemy("Machine Engineer", getMachineArt(), "OVERDRIVE", "PLATING", "RESOURCE DRAIN", 12);
        Rookie r5 = createEnemy("Life-Science Agent", getLifeScienceArt(), "ACID SPLASH", "ADRENALIN", "CELL DECAY", 12);
        Rookie r6 = createEnemy("Life-Science Agent", getLifeScienceArt(), "ACID SPLASH", "ADRENALIN", "CELL DECAY", 13);
        Rookie r7 = createEnemy("Physics Theorist", getPhysicsArt(), "VECTOR THRUST", "HIGH GRAVITY", "ZERO FRICTION", 14);
        Rookie r8 = createEnemy("Machine Engineer", getMachineArt(), "OVERDRIVE", "PLATING", "RESOURCE DRAIN", 13);
        List<Rookie> rookies = List.of(r1, r2, r3, r4, r5, r6, r7, r8);
        battlegrounds.add(new Battleground("Naturvetarhuset", rookies, true, false, false));
    }

    private void initSkötet() {
        Rookie r1 = createEnemy("5 Year Old Rookie", get5YearOldRookie(), "ROOKIE KICK", "FLASH TUX", "BENDER", 16);
        r1.setMessage(get5YearText());
        List<Rookie> rookies = List.of(r1);
        Battleground bg = new Battleground("Skötet", rookies, true, true, false);
        bg.setTraining(true);
        battlegrounds.add(bg);
    }

    private void initTviste() {
        Rookie r1 = createEnemy("Economy Elite", getMaleTvisteArt(), "DEPT TRAP", "FATHERS CREDITCARD", "NET WORTH JUDGE", 15);
        Rookie r2 = createEnemy("Economy Elite", getMaleTvisteArt(), "DEPT TRAP", "FATHERS CREDITCARD", "NET WORTH JUDGE", 16);
        Rookie r4 = createEnemy("Economy Elite", getFemaleTvisteArt(), "DEPT TRAP", "FATHERS CREDITCARD", "NET WORTH JUDGE", 17);

        Rookie r5 = createEnemy("Fire Potato Guy", getPotatoArt(), "CARB OVERLOAD", "DOUBLE SKAGEN", "FORCE EAT", 18);
        Rookie r6 = createEnemy("Banger Potato Guy", getPotatoArt(), "CARB OVERLOAD", "DOUBLE SKAGEN", "FORCED POTATO", 19);

        Rookie r7 = createEnemy("Medical Scholar", getMedicalArt(), "PROSTATE POKE", "PLACEBO EFFECT", "BURNOUT", 15);
        Rookie r8 = createEnemy("Medical Scholar", getMedicalArt(), "PROSTATE POKE", "PLACEBO EFFECT", "BURNOUT", 16);
        Rookie r9 = createEnemy("Medical Scholar", getMedicalArt(), "PROSTATE POKE", "PLACEBO EFFECT", "BURNOUT", 17);

        Rookie r10 = createEnemy("Architect", getArchitectArt(), "CRITICAL FEEDBACK", "GOLDEN RATIO", "UNORDERED GRID", 15);
        Rookie r11 = createEnemy("Architect", getArchitectArt(), "CRITICAL FEEDBACK", "GOLDEN RATIO", "UNORDERED GRID", 16);
        Rookie r12 = createEnemy("Architect", getArchitectArt(), "CRITICAL FEEDBACK", "GOLDEN RATIO", "UNORDERED GRID", 17);

        List<Rookie> rookies = List.of(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12);
        battlegrounds.add(new Battleground("Tviste", rookies, true, false, false));
    }

    private void initRouge() {
        Rookie r1 = createEnemy("Entrance Guard", getDefaultArt(), "BATON HIT", "FLEX MUSCLE", "DRUNK SUSPICION", 18);
        Rookie r2 = createEnemy("BlackJack Dealer", getBlackJackArt(), "DEAL BAD CARDS", "HOUSE BLACKJACK", "BUY-IN", 19);
        r2.setMessage(new String[]{"Hej", "DU FÅR INTE GÅ IN"});
        Rookie r3 = createEnemy("Homer President", getHomerArt(), "PENIS SWING", "ASS-BEER", "PARTY IN HOLMA", 21);
        Rookie r4 = createEnemy("Saba", getSabaArt(), "EXPENSIVE BEER", "BRIBE", "MANIPULATE", 22);
        List<Rookie> rookies = List.of(r1, r2, r3, r4);
        battlegrounds.add(new Battleground("Rouge", rookies, true, true, false));
    }

    private void initICA() {
        Rookie r1 = createEnemy("ICA Cashier", getDefaultArt(), "BATON HIT", "FLEX MUSCLE", "DRUNK SUSPICION", 1);
        List<Rookie> rookies = List.of(r1);
        Battleground bg = new Battleground("ICA", rookies, true, true, false);
        bg.setDefeated();
        bg.setStore(true);
        battlegrounds.add(bg);
    }

    private void initStipendiegränd() {
        Rookie r1 = createEnemy("Screaming Infant", getScreamingInfantArt(), "GOGO GAGA", "TITTY TOUCH", "CRY", 21);
        Rookie r2 = createEnemy("Screaming Infant", getScreamingInfantArt(), "GOGO GAGA", "TITTY TOUCH", "CRY", 22);
        Rookie r3 = createEnemy("Playing Child", getPlayingChildArt(), "SPIT", "ROBUX SHOWER", "SPOILED BRAT", 21);
        Rookie r4 = createEnemy("Playing Child", getPlayingChildArt(), "SPIT", "ROBUX SHOWER", "SPOILED BRAT", 22);
        Rookie r5 = createEnemy("Playing Child", getPlayingChildArt(), "SPIT", "ROBUX SHOWER", "SPOILED BRAT", 23);
        Rookie r6 = createEnemy("Passed-out Student", getPassedOutStudentArt(), "zzZzzZz..", "zzZzzZz..", "zzZzzZz..", 24);
        Rookie r7 = createEnemy("Julia", getFemaleMITArt(), "TURING ATTACK", "DV-ASSEMBLE", "MEAN WORDS", 25);
        Rookie r8 = createEnemy("Maximilian", getMaleMITArt(), "SPEEDRUN", "EYBRO", "TAUNT", 25);
        List<Rookie> rookies = List.of(r1, r2, r3, r4, r5, r6, r7, r8);
        battlegrounds.add(new Battleground("Stipendiegränd", rookies, true, false, false));
    }

    private void initTheEastPavilion() {
        Rookie r1 = createEnemy("Discrete Math Exam", getDiscreteExamArt(), "INDUCTION", "TRUTH TABLE", "DISCONNECTION", 26);
        Rookie r2 = createEnemy("C-Prog Exam", getCProgExamArt(), "SEGMENTATION FAULT", "MALLOC", "MEMORY LEAK", 27);
        Rookie r3 = createEnemy("Java Exam", getJavaExamArt(), "SWING", "MVC", "NULL-POINTER", 28);
        Rookie r4 = createEnemy("Calculus Exam", getCalculusExamArt(), "DERIVATION", "EXPONENTIAL GROWTH", "LIMIT TOWARDS ZERO", 30);
        List<Rookie> rookies = List.of(r1, r2, r3, r4);
        battlegrounds.add(new Battleground("The East Pavilion", rookies, true, true, false));
    }

    private void initIKSU() {
        Rookie r1 = createEnemy("Roided-Roy", getDefaultArt(), "SKULL CRUSHER", "JUICE", "SCARY FLEX", 29);
        Rookie r2 = createEnemy("Roided-Rick", getDefaultArt(), "SKULL CRUSHER", "JUICE", "SCARY FLEX", 30);
        Rookie r3 = createEnemy("IKSU Cashier", getDefaultArt(), "DENIED ENTRY", "CELSIUS", "BANNED4LIFE", 29);
        Rookie r4 = createEnemy("IKSU Cashier", getDefaultArt(), "DENIED ENTRY", "CELSIUS", "BANNED4LIFE", 30);
        Rookie r5 = createEnemy("Cardio-Carl", getDefaultArt(), "TREADMILL RUN", "CELSIUS", "PACING PRESSURE", 29);
        Rookie r6 = createEnemy("Cardio-Carl", getDefaultArt(), "TREADMILL RUN", "CELSIUS", "PACING PRESSURE", 29);
        List<Rookie> rookies = List.of(r1, r2, r3, r4, r5, r6);
        battlegrounds.add(new Battleground("IKSU", rookies, true, false, false));
    }

    private void initOrigo() {
        Rookie r1 = createEnemy("Nilf", getDefaultArt(), "LOSE YOUR PANTS", "BREZNAK", "ROOKIESKÅL", 30);
        Rookie r2 = createEnemy("J-Breezy", getDefaultArt(), "BOTTLE-SLAM", "STEEZY BREEZY", "ROOKIESKÅL", 31);
        Rookie r3 = createEnemy("VB", getDefaultArt(), "CATHETER CONSTRICTION", "DUNK-CHAMPION", "ROOKIESKÅL", 32);
        Rookie r4 = createEnemy("Trasan", getDefaultArt(), "BROKEN SPELL", "BLACKOUT", "ROOKIESKÅL", 33);
        Rookie r5 = createEnemy("Åsa", getDefaultArt(), "RUNESCAPE", "FERNET FOUNTAIN", "ROOKIESKÅL", 34);
        Rookie r6 = createEnemy("DL", getDefaultArt(), "BULLY-DL", "SHOTGUN", "ROOKIESKÅL", 35);
        Rookie r7 = createEnemy("Ezkill", getDefaultArt(), "TACTICAL PUKE", "MARRIAGE", "ROOKIESKÅL", 36);
        Rookie r8 = createEnemy("BJ", getDefaultArt(), "BING COLLECT", "LEFT RAGE", "ROOKIESKÅL", 37);
        Rookie r9 = createEnemy("Grämmel", getDefaultArt(), "VOMIT", "DRESS FANCY", "ROOKIESKÅL", 38);
        Rookie r10 = createEnemy("Ascended Grämmel", getDefaultArt(), "ULTRA-VOMIT", "WHISKY ENJOYER", "ROOKIESKÅL", 42);
        r1.setMessage(getIntroLeagueText());
        r5.setMessage(getLeagueText());
        r9.setMessage(getJoarText());
        r10.setMessage(getJoarEvolveText());
        List<Rookie> rookies = List.of(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        battlegrounds.add(new Battleground("ORIGO", rookies, true, true, true));
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