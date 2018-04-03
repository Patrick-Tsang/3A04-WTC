package t02.group1.whatsthatcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class handles the interaction from the UI controller and the Expert Moderator
 * It acts as a blackboard for the experts to display their guesses and read other guesses from
 * @Author Liam Macpherson
 * @date  02/04/2018
 */

public class SearchEngine {

    Map<String, String> problemSpec = new HashMap<>();
    Map<Integer, Double>  guessList = new HashMap<>();

    /**
     * @param problem This problem as defined by the user
     */
    public void setProblem(HashMap problem) {
       problemSpec = problem;
    }

    /**
     * @return  This is the problem as defined by the user
     */
    public Map getProblem() {
        return problemSpec;
    }

    /**
     *
     * @param guesses This is the map of all the vehicles IDs and the weights associated with that
     *                guess
     */
    public void setGuesses(Map<Integer, Double> guesses) {
            guessList = guesses;
    }

    /**
     *
     * @return This is the list of guesses with their weights attached
     */
    public Map<Integer, Double> getGuesses() {
        return guessList;
    }

    /**
     * Pass new information to the moderator to pass to the expert controllers.
     */
    private void updateModerator() {

    }


}
