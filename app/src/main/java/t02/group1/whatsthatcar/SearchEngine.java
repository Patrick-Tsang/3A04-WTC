package t02.group1.whatsthatcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: Liam Macpherson
 * Date: 02/04/2018
 * Description: This class handles the interaction from the UI controller and the Expert Moderator
 * It acts as a blackboard for the experts to display their guesses and read other guesses from
 */

public class SearchEngine {

    Map<String, String> problemSpec = new HashMap<>();
    Map<Integer, Double>  guessList = new HashMap<>();

    public void setProblem(HashMap problem){
        problemSpec = problem;
    }

    public Map getProblem() {
        return problemSpec;
    }

    public void setGuesses(Map<Integer, Double> guesses) {
        guesses = guesses;
    }


    public Map<Integer, Double> getGuesses(List<String> list) {
        return guessList;
    }
    private void updateModerator() {

    }


}
