
import lpsolve.LpSolve;
import lpsolve.LpSolveException;

/**
 * Created by Vincent on 2/06/2016.
 */
public class Main {

    public static void main(String[] args) {
        String json = Util.readFileToString(args[0]);
        Game game = Game.createGameFromJSON(json);
        printGameDetails(game);

        for (int i = 0; i < args.length; i++) {
            System.out.println("Args " + args[i]);
        }

        try {
            LpSolve lpSolve = LpSolve.makeLp(0, game.getActions()[0].length);
            //lpSolve.strAddConstraint();
        } catch (LpSolveException e){
            e.printStackTrace();
        }
    }

    public static void printGameDetails(Game game) {
        for (int i = 0; i < game.getAgents().size(); i++) {
            System.out.printf("Agent %d: %s%n", i + 1, game.getAgents().get(i));
        }
    }

}
