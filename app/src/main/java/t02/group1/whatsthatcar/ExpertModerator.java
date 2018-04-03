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

    public List<List<Integer>> expertsGuesslists = new ArrayList<>();
    private List<ExpertControllerInterface> expertContList = new ArrayList<>();

    /**
     * Add all the experts given to a list
     * @param expert1 Expert 1
     * @param expert2 Expert 2
     * @param expert3 Expert 3
     */
    public ExpertModerator(ExpertControllerInterface expert1,
                           ExpertControllerInterface expert2, ExpertControllerInterface expert3){
        expertContList.add(expert1);
        expertContList.add(expert2);
        expertContList.add(expert3);
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
    private void splitProblemSpec (HashMap<String, String> problemSpec){
      for(String keyValue : problemSpec.keySet()){
          switch (keyValue){
              case  "make":
                  updateExpert(problemSpec.get(keyValue), 1);
              case "type":
                  updateExpert(problemSpec.get(keyValue), 2);
              case "doors_size":
                  updateExpert(problemSpec.get(keyValue), 3);
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
           expertsGuesslists.add(expertContList.get(i).getResults());
        }

        //Loop through all the guess lists from each controller
        for(int i = 0; i< expertsGuesslists.size(); i++) {
            //get individual list
            List<Integer> guessList = expertsGuesslists.get(i);

            //loop through individual list
            for (int j = 0; j < guessList.size(); j++) {
                //get indiviudal guess
                int guessID = guessList.get(j);

                //if item has not been checked before
                if (!checkedItems.contains(guessList.get(j))) {
                    //add to checked item list
                    checkedItems.add(guessList.get(j));
                    int agreements = 1;

                    //loop through remaining expert lists and see if they contain the same guess
                    for (int k = i + 1; k < expertsGuesslists.size(); k++) {
                        if (expertsGuesslists.get(k).contains(guessID)) {
                            agreements++;
                        }
                    }
                    double weight = agreements / expertsGuesslists.size();
                    guessesWithWeights.put(guessID, weight);
                }
            }
        }

        /** Messier uncommited getter of experts agreement
         *  Just in case the above doesn't work. 02/04/2018
         *         List<Integer> commonGuesses = new ArrayList<>();
         List<Integer> bestGuesses = new ArrayList<>();
        // Set the common guess to the first list of guess and then loop through the experts and only keep the common results.
        // Quality of experts is based on the order in which they are added
        commonGuesses.addAll(expertsGuesses.get(i));
        for(int i=1; i<expertsGuesses.size()-1; i++){
                //experts do not agree on any guesses
                if(commonGuesses.isEmpty()){
                    num_of_disagrees++;
                    //set the common guesses to the expert
                    commonGuesses = expertsGuesses.get(i-1);
                }
            commonGuesses.retainAll((expertsGuesses.get(i)));
        }

        if(num_of_disagrees == 0){
            bestGuesses = commonGuesses;
        }
        **/
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
