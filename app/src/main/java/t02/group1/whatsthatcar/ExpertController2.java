package t02.group1.whatsthatcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Patrick on 2018-04-02.
 */

public class ExpertController2 {

    List<Map<String, String>> searchResults;

    public ExpertController2(){
        searchResults = new ArrayList<>();
    }

    public void startSearch(){


    }

    public List<Map<String, String>> getResult(){
        return searchResults;

    }
}
