package t02.group1.whatsthatcar;

import java.util.List;

/**
 * This interface formalises interaction between Expert Controllers and the Moderator,
 * and between the Expert Controller and the Expert Datas
 * @author Liam Macpherson
 * @date 02/04/2018
 */

public interface ExpertControllerInterface {
    /**
     * Begin the search for results - perhaps redundant.
     */
    void startSearch();

    /**
     * Search a specific data expert to return guesses
     * @return List of identification number for each guess
     */
    List<Integer> getResults();

    /**
     * Pass new information to a specific expert to ensure that it has the most up-to-date
     * requirements
     * @param newInfo new data specific to the expert.
     */
    void updateSpec(String newInfo);
}
