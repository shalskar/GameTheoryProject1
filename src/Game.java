import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vincent on 2/06/2016.
 */
public class Game {

    private static final String KEY_AGENTS = "Agents";
    private static final String KEY_ACTIONS = "Actions";
    private static final String KEY_VALUES = "Values";

    private List<String> agents;
    private String[][] actions;
    private int[][][] values;

    public Game(List<String> agents, String[][] actions, int[][][] values) {
        this.agents = agents;
        this.actions = actions;
        this.values = values;
    }

    public List<String> getAgents() {
        return agents;
    }

    public void setAgents(List<String> agents) {
        this.agents = agents;
    }

    public String[][] getActions() {
        return actions;
    }

    public void setActions(String[][] actions) {
        this.actions = actions;
    }

    public int[][][] getValues() {
        return values;
    }

    public void setValues(int[][][] values) {
        this.values = values;
    }

    /**
     * Parse String with JSON format into a Game object
     *
     * @param json String with JSON format
     * @return A game object
     */
    public static Game createGameFromJSON(String json) {
        JSONObject gameJSONObject = new JSONObject(json);
        List<String> agents = parseAgents(gameJSONObject);
        String[][] actions = parseActions(gameJSONObject);
        int[][][] values = parseValues(gameJSONObject);

        return new Game(agents, actions, values);
    }

    /** Static parsing methods. **/

    private static List<String> parseAgents(JSONObject jsonObject){
        List<String> agents = new ArrayList<>();
        JSONArray agentsJSONArray = jsonObject.getJSONArray(KEY_AGENTS);
        for (int i = 0; i < agentsJSONArray.length(); i++) {
            agents.add(agentsJSONArray.getString(i));
        }
        return agents;
    }

    private static String[][] parseActions(JSONObject jsonObject){
        JSONArray actionsOuterJSONArray = jsonObject.getJSONArray(KEY_ACTIONS);
        String[][] actions = new String[actionsOuterJSONArray.length()][actionsOuterJSONArray.getJSONArray(0).length()];

        for (int i = 0; i < actionsOuterJSONArray.length(); i++) {
            JSONArray actionsInnerJSONArray = actionsOuterJSONArray.getJSONArray(i);
            String[] inner = new String[actionsInnerJSONArray.length()];
            for (int j = 0; j < actionsInnerJSONArray.length(); j++) {
                inner[j] = actionsInnerJSONArray.getString(j);
            }
            actions[i] = inner;
        }
        return actions;
    }

    private static int[][][] parseValues(JSONObject jsonObject){
        int agentCount = jsonObject.getJSONArray(KEY_AGENTS).length();
        JSONArray valuesOuterJSONArray = jsonObject.getJSONArray(KEY_VALUES);
        int[][][] values = new int[valuesOuterJSONArray.length()][valuesOuterJSONArray.getJSONArray(0).length()][agentCount];

        for (int i = 0; i < valuesOuterJSONArray.length(); i++) {
            JSONArray valuesMiddleJSONArray = valuesOuterJSONArray.getJSONArray(i);
            int[][] middle = new int[valuesMiddleJSONArray.length()][agentCount];
            for (int j = 0; j < valuesMiddleJSONArray.length(); j++) {
                JSONArray valuesInnerJSONArray = valuesMiddleJSONArray.getJSONArray(j);
                int[] inner = new int[agentCount];
                for (int h = 0; h < valuesInnerJSONArray.length(); h++) {
                    inner[h] = valuesInnerJSONArray.getInt(h);
                }
                middle[j] = inner;
            }
            values[i] = middle;
        }
        return values;
    }

}
