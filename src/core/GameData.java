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
        battlegrounds = new ArrayList<>();
        initMITHuset();
        initDataGym();
    }

    public void updatePlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    private void initMoves() {
        /* ATTACK MOVES */
        moveCatalog.put("PUNCH", new AttackMove("PUNCH", 40));
        moveCatalog.put("SCREAM", new AttackMove("SCREAM", 55));
        moveCatalog.put("BAD FEEDBACK", new AttackMove("BAD FEEDBACK", 55));
        moveCatalog.put("DENIED ENTRY", new AttackMove("DENIED ENTRY", 60));

        /* POWERUPS */
        moveCatalog.put("EYBRO", new EffectMove("EYBRO", Move.MoveType.POWERUP, Move.TargetStat.ATTACK, 7));
        moveCatalog.put("TROPIC THUNDER", new EffectMove("TROPIC THUNDER", Move.MoveType.POWERUP, Move.TargetStat.SPEED, 9));
        moveCatalog.put("ARTON56", new EffectMove("ARTON56", Move.MoveType.POWERUP, Move.TargetStat.ATTACK, 8));
        moveCatalog.put("GUINNESS", new EffectMove("GUINNESS", Move.MoveType.POWERUP, Move.TargetStat.DEFENSE, 7));
        moveCatalog.put("WHITE MONSTER", new EffectMove("WHITE MONSTER", Move.MoveType.POWERUP, Move.TargetStat.SPEED, 5));
        moveCatalog.put("COFFEE", new EffectMove("COFFEE", Move.MoveType.POWERUP, Move.TargetStat.SPEED, 12));
        moveCatalog.put("ENCOURAGEMENT", new EffectMove("ENCOURAGEMENT", Move.MoveType.POWERUP, Move.TargetStat.ATTACK, 5));

        /* WEAKENS */
        moveCatalog.put("TAUNT", new EffectMove("TAUNT", Move.MoveType.WEAKEN, Move.TargetStat.SPEED, 7));
        moveCatalog.put("MEAN WORDS", new EffectMove("MEAN WORDS", Move.MoveType.WEAKEN, Move.TargetStat.ATTACK, 9));
        moveCatalog.put("STARE", new EffectMove("STARE", Move.MoveType.WEAKEN, Move.TargetStat.DEFENSE, 7));
        moveCatalog.put("DEFAULT DANCE", new EffectMove("DEFAULT DANCE", Move.MoveType.WEAKEN, Move.TargetStat.DEFENSE, 8));

    }

    private void initMITHuset() {
        List<Rookie> rookies = new ArrayList<>();

        Rookie r1 = new Rookie("Data Grunt");
        r1.setArt(getDataGruntArt());
        r1.addMove(moveCatalog.get("PUNCH"));
        r1.addMove(moveCatalog.get("WHITE MONSTER"));
        r1.addMove(moveCatalog.get("STARE"));
        r1.levelUp(2);
        Rookie r2 = new Rookie("Gamer");
        r2.setArt(getGamerArt());
        r2.addMove(moveCatalog.get("PUNCH"));
        r2.addMove(moveCatalog.get("WHITE MONSTER"));
        r2.addMove(moveCatalog.get("DEFAULT DANCE"));
        r2.levelUp(1);
        Rookie r3 = new Rookie("Gamer");
        r3.setArt(getGamerArt());
        r3.addMove(moveCatalog.get("PUNCH"));
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
        r1.setArt(getTutorArt());
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
        battlegrounds.add(new Battleground("Tutor", rookies, false, true));
    }

}