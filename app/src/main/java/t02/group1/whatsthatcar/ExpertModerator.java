package t02.group1.whatsthatcar;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * Created by Patrick on 2018-04-02.
 */

public class ExpertModerator {

    public List<List<Integer>> expertsGuesslists = new ArrayList<>();
    private List<ExpertControllerInterface> expertContList = new ArrayList<>();

    //Take in the expers and aadd them to a list of type interface
    public ExpertModerator(ExpertControllerInterface expert1, ExpertControllerInterface expert2, ExpertControllerInterface expert3){
        expertContList.add(expert1);
        expertContList.add(expert2);
        expertContList.add(expert3);
    }

    //pass new information to the experts
    private void updateExpert(int a, HashMap map){
        for (ExpertControllerInterface expertCont : expertContList){

        }
    }

    //
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

    public Map<Integer, Double> getGuesses(){
        return generateGuesses();
    }


    private HashMap splitProblemSet(int expertNumber){
        HashMap toReturn = new HashMap();

        return toReturn;
    }
}
