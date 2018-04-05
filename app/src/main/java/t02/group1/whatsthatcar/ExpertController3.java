package t02.group1.whatsthatcar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class implements the expert controller in charge of
 * the information for the car + number of doors.
 *
 * @author Patrick Tsang
 * @date 02/04/2018
 */
public class ExpertController3 implements ExpertControllerInterface{

    // Defining class variables for searching and receiving data
    List<Integer> searchResults;
    ExpertData3 expert = new ExpertData3();
    String doors;
    String size;

    /**
     * Instantiator of the EC2 class
     */
    public ExpertController3(){
        searchResults = new ArrayList<>();
    }

    /**
     * Starts the search in the data class for the parameters.
     */
    public void startSearch(){
        try {
            searchResults = expert.search(doors,size);
        } catch(IOException e) {
            System.err.println("Exception: " + e.getMessage());
        }

    }

    /**
     * @return results of search function
     */
    public List<Integer> getResults(){
        return searchResults;
    }

    /**
     * Updates search parameters based on user input information.
     * @param newInfo
     */
    public void updateSpec(String newInfo) {
        if(!newInfo.equals("") && newInfo.length() > 2){
            List<String> searchparams= Arrays.asList(newInfo.split(","));
           doors = searchparams.get(0);
           size =  searchparams.get(1);
        }
        else {doors=""; size = "";}
    }
}
