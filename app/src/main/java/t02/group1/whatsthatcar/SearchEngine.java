package t02.group1.whatsthatcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

/**
 * This class handles the interaction from the UI controller and the Expert Moderator
 * It acts as a blackboard for the experts to display their guesses and read other guesses from
 * @Author Liam Macpherson
 * @date  02/04/2018
 */

public class SearchEngine{

    Map<String, String> problemSpec = new HashMap<>();
    Map<Integer, Double>  guessList = new HashMap<>();

    ExpertModerator em;
    public SearchEngine(ExpertModerator expertMod){

        em = expertMod;

    }

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

    public void search(){
        Map<Integer, Double> mappedGuesses = em.getGuesses();
        //maybe sort here???

        guessList = sortMapByKey(mappedGuesses);
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
    public void updateModerator() {
        em.splitProblemSpec(problemSpec);
    }
    
    private Map<Integer,Double> sortMapByKey(Map<Integer,Double> map)
    {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<Integer,Double> sortMap = new TreeMap<>();
        sortMap.putAll(map);
        return sortMap;
    }

}
