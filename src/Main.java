
import lpsolve.LpSolve;
import lpsolve.LpSolveException;

import java.util.Iterator;

/**
 * Created by Vincent on 2/06/2016.
 */
public class Main {

    public static void main(String[] args) {
        String json = Util.readFileToString(args[0]);
        Game game = Game.createGameFromJSON(json);
        printGameDetails(game);

//        for (int i = 0; i < args.length; i++) {
//            System.out.println("Args " + args[i]);
//        }

        if (args.length == 1)
            printSupportSets(game);

        try {
            LpSolve lpSolve = LpSolve.makeLp(game.getActions().length, game.getActions()[0].length);

            //lpSolve.strAddConstraint();
        } catch (LpSolveException e) {
            e.printStackTrace();
        }
    }

    public static void printGameDetails(Game game) {
        for (int i = 0; i < game.getAgents().size(); i++) {
            System.out.printf("Agent %d: %s%n", i + 1, game.getAgents().get(i));
        }
    }

    public static String[][] generateSupportSets(Game game, int player) {
        String[] actions = game.getActions()[player];
        String[][] supportSets = Util.generateCombinationsProper(actions);
        return supportSets;
    }

    public static void printSupportSets(Game game) {
        String[][] supportSetsPlayer1 = generateSupportSets(game, 0);
        String[][] supportSetsPlayer2 = generateSupportSets(game, 1);
        for (int i = 0; i < supportSetsPlayer1.length; i++) {
            System.out.printf("Player 1 support set (%d): [", i + 1);
            for (int j = 0; j < 2; j++) {
                System.out.print(supportSetsPlayer1[i][j]);
                if (j == 0) System.out.print(", ");
            }
            System.out.println("]");
        }

        for (int i = 0; i < supportSetsPlayer2.length; i++) {
            System.out.printf("Player 2 support set (%d): [", i + 1);
            for (int j = 0; j < 2; j++) {
                System.out.print(supportSetsPlayer2[i][j]);
                if (j == 0) System.out.print(", ");
            }
            System.out.println("]");
        }
    }

}
