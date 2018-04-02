package t02.group1.whatsthatcar;

import java.util.HashMap;
import java.util.List;


/**
 * Author: Liam Macpherson
 * Date: 02/04/2018
 * Description: This interface formalises interaction between Expert Controllers and the Moderator,
 * and between the Expert Controller and the Expert Datas
 */

public interface ExpertControllerInterface {
    void startSearch();
    List<Integer> getResults();
    void updateSpec(String newInfo);
}
