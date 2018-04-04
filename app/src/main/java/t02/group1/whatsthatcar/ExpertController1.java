package t02.group1.whatsthatcar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the expert controller in charge of
 * the information for the vehicle manufacturer.
 *
 * @author Patrick Tsang
 * @date 02/04/2018
 */
public class ExpertController1 implements ExpertControllerInterface{

    // Defining class variables for searching and receiving data
    List<Integer> searchResults;
    ExpertData1 expert = new ExpertData1();
    String searchParams;

    /**
     * Instantiator of the EC1 class
     */
    public ExpertController1(){
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
     * @return results of the search function
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

    public static void main(String args[]){
        ExpertController1 ec1 = new ExpertController1();
        ec1.updateSpec("BMW");
        ec1.startSearch();
        System.out.print(ec1.getResults().size());
    }
}

