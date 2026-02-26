package resources;

import core.GameManager;

public class OverworldStrings {
    public static String getOverworldString(GameManager gameManager) {
        if(gameManager.player.isDev()) return getOverworldState5String();
        //if(gameManager.data.battlegrounds.get(9).isDefeated()) return getOverworldState5String(); // If East Pavilion is defeated
        if(gameManager.data.battlegrounds.get(6).isDefeated()) return getOverworldState4String(); // If Rouge is defeated
        else if(gameManager.data.battlegrounds.get(4).isDefeated()) return getOverworldState3String(); // If skötet is defeated
        else if(gameManager.data.battlegrounds.get(2).isDefeated()) return getOverworldState2String(); // If datagym is defeated
        else return getOverworldState1String();
    }

    private static String getOverworldState1String() {
        return "+------------------------------------+\n" +
                "+              OVERWORLD             +\n" +
                "+------------------------------------+\n" +
                "       Choose your battleground.     \n" +
                " 1.  MIT-PLACE\n" +
                " 2.  MIT-CAFE\n" +
                " 3.  DATA INSTITUTIONEN    [GYM]\n" +
                " 4.  ***************\n" +
                " 5.  ******                [********]\n" +
                " 6.  ******\n" +
                " 7.  *****                 [***]\n" +
                " 8.  ***                   [*****]\n" +
                " 9.  *******\n" +
                " 10. ****************      [***]\n" +
                " 11. ****\n" +
                " 12. *****                 [******]\n" +
                " 13. RETURN\n" +
                "+------------------------------------+";
    }

    private static String getOverworldState2String() {
        return "+------------------------------------+\n" +
                "+              OVERWORLD             +\n" +
                "+------------------------------------+\n" +
                "       Choose your battleground.     \n" +
                " 1.  MIT-PLACE\n" +
                " 2.  MIT-CAFE\n" +
                " 3.  DATA INSTITUTIONEN    [GYM]\n" +
                " 4.  NATURVETARHUSET\n" +
                " 5.  SKÖTET                [TRAINING]\n" +
                " 6.  ******\n" +
                " 7.  *****                 [***]\n" +
                " 8.  ***                   [*****]\n" +
                " 9.  *******\n" +
                " 10. ****************      [***]\n" +
                " 11. ****\n" +
                " 12. *****                 [******]\n" +
                " 13. RETURN\n" +
                "+------------------------------------+";
    }

    private static String getOverworldState3String() {
        return "+------------------------------------+\n" +
                "+              OVERWORLD             +\n" +
                "+------------------------------------+\n" +
                "       Choose your battleground.     \n" +
                " 1.  MIT-PLACE\n" +
                " 2.  MIT-CAFE\n" +
                " 3.  DATA INSTITUTIONEN    [GYM]\n" +
                " 4.  NATURVETARHUSET\n" +
                " 5.  SKÖTET                [TRAINING]\n" +
                " 6.  TVISTE\n" +
                " 7.  ROUGE                 [GYM]\n" +
                " 8.  ***                   [*****]\n" +
                " 9.  *******\n" +
                " 10. ****************      [***]\n" +
                " 11. ****\n" +
                " 12. *****                 [******]\n" +
                " 13. RETURN\n" +
                "+------------------------------------+";
    }

    private static String getOverworldState4String() {
        return "+------------------------------------+\n" +
                "+              OVERWORLD             +\n" +
                "+------------------------------------+\n" +
                "       Choose your battleground.     \n" +
                " 1.  MIT-PLACE\n" +
                " 2.  MIT-CAFE\n" +
                " 3.  DATA INSTITUTIONEN    [GYM]\n" +
                " 4.  NATURVETARHUSET\n" +
                " 5.  SKÖTET                [TRAINING]\n" +
                " 6.  TVISTE\n" +
                " 7.  ROUGE                 [GYM]\n" +
                " 8.  ICA                   [STORE]\n" +
                " 9.  STIPENDIEGRÄND\n" +
                " 10. THE EAST PAVILION     [GYM]\n" +
                " 11. ****\n" +
                " 12. *****                 [******]\n" +
                " 13. RETURN\n" +
                "+------------------------------------+";
    }

    private static String getOverworldState5String() {
        return "+------------------------------------+\n" +
                "+              OVERWORLD             +\n" +
                "+------------------------------------+\n" +
                "       Choose your battleground.     \n" +
                " 1.  MIT-PLACE\n" +
                " 2.  MIT-CAFE\n" +
                " 3.  DATA INSTITUTIONEN    [GYM]\n" +
                " 4.  NATURVETARHUSET\n" +
                " 5.  SKÖTET                [TRAINING]\n" +
                " 6.  TVISTE\n" +
                " 7.  ROUGE                 [GYM]\n" +
                " 8.  ICA                   [STORE]\n" +
                " 9.  ÅLIDHEM\n" +
                " 10. THE EAST PAVILION     [GYM]\n" +
                " 11. IKSU\n" +
                " 12. ORIGO                 [LEAGUE]\n" +
                " 13. RETURN\n" +
                "+------------------------------------+";
    }

}
