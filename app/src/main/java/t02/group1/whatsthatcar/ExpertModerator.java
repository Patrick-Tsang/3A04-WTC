package t02.group1.whatsthatcar;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * This class performs the main logic of the system, formalising searches and
 * combining the answers of the various experts. It is built so that experts could be easily added
 * with only new keys requiring addition.
 * @author Liam Macpherson
 * @date 02/04/2018
 */

public class ExpertModerator {

    static final private double CUTOFF_WEIGHT =0.5;
    private List<List<Integer>> expertsGuesslists = new ArrayList<>();
    private List<ExpertControllerInterface> expertContList = new ArrayList<>();

    /**
     *
     */
    public ExpertModerator(){

    }

    /**
     * Add a new expert to the list of experts
     * @param newExpert Expert to be added
     */
    public void addExpert(ExpertControllerInterface newExpert){
        expertContList.add(newExpert);
    }

    /**
     * This divides the problem up based on the key values
     * @param problemSpec Problem spec mapping type of input to user input's value
     */
    public void splitProblemSpec (Map<String, String> problemSpec){
      for(String keyValue : problemSpec.keySet()){
          switch (keyValue){
              case  "make":
                  updateExpert(problemSpec.get(keyValue), 0);
                  break;
              case "type":
                  updateExpert(problemSpec.get(keyValue), 1);
                  break;
              case "doors_size":
                  updateExpert(problemSpec.get(keyValue), 2);
                  break;
              default:
          }
      }
    }

    /**
     * This combines all the guesses from the Expert controllers and assigns weights to them based
     * on how many other experts agree with a particular expert controller's guess.
     * @return The list of guesses (as IDs) with weights mapped to each
     */
    private Map<Integer, Double> generateGuesses(){
        List<Integer> checkedItems= new ArrayList<>();
        Map<Integer, Double> guessesWithWeights= new HashMap<>();

        //get all the guesses from each Expert Controller
        for (int i=0; i<expertContList.size(); i++){
            expertContList.get(i).startSearch();
           expertsGuesslists.add(expertContList.get(i).getResults());

        }

        //Loop through all the guess lists from each controller
        for(int i = 0; i< expertsGuesslists.size(); i++) {
            //get individual list
            List<Integer> guessList = expertsGuesslists.get(i);

            //loop through individual list
            for (int j = 0; j < guessList.size(); j++) {
                //get individual guess
                int guessID = guessList.get(j);

                //if item has not been checked before
                if (!checkedItems.contains(guessList.get(j))) {
                    //add to checked item list
                    checkedItems.add(guessList.get(j));
                    double agreements = 1;

                    //loop through remaining expert lists and see if they contain the same guess
                    for (int k = i + 1; k < expertsGuesslists.size(); k++) {
                        if (expertsGuesslists.get(k).contains(guessID)) {
                            agreements++;
                        }
                    }

                    double weight = agreements / expertContList.size();
                    if(weight>CUTOFF_WEIGHT) {
                        guessesWithWeights.put(guessID, weight);
                    }
                }
            }
        }
        return guessesWithWeights;
    }

    /**
     *
     * @return Map of guesses to the weights
     */
    public Map<Integer, Double> getGuesses(){
        return generateGuesses();
    }


    /**
     *
     * @param newData The new data to be passed in
     * @param expertNumber The expert controller's identification number specific to a particular
     *                     domain
     */
    private void updateExpert(String newData, int expertNumber){
        expertContList.get(expertNumber).updateSpec(newData);
    }
}
