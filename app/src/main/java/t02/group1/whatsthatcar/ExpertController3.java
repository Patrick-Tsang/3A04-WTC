package t02.group1.whatsthatcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Patrick on 2018-04-02.
 */

///This is the expert for vehicle size of car + number of doors
public class ExpertController3 implements ExpertControllerInterface{

    List<HashMap<String, String>> searchResults;

    public ExpertController3(){
        searchResults = new ArrayList<>();
    }

    public void startSearch(){


    }

    public List<HashMap<String, String>> getResults(){
        return searchResults;

    }
}
