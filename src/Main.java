import com.sun.javafx.beans.annotations.NonNull;

/**
 * Created by Vincent on 2/06/2016.
 */
public class Main {

    private static final String DIRECTORY_MATCHING_PENNIES = "games/matching-pennies.JSON";

    public static void main(String[] args){
        String json = Util.readFileToString(DIRECTORY_MATCHING_PENNIES);
        Game game = Game.createGameFromJSON(json);
        printGameDetails(game);
    }

    public static void printGameDetails(@NonNull Game game){
        for(int i = 0; i < game.getAgents().size(); i ++){
            System.out.printf("Agent %d: %s%n", i + 1, game.getAgents().get(i));
        }
    }

}
