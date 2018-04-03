package t02.group1.whatsthatcar;

import java.io.IOException;
import java.util.ArrayList;
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
    ExpertData1 expert = new ExpertData1();
    String searchParams;

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
            searchResults = expert.search(searchParams);
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
     * Updates search parameters based on user inputted information.
     * @param newInfo
     */
    public void updateSpec(String newInfo) {
        searchParams = newInfo;
    }
}
