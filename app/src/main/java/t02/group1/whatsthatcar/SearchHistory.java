package t02.group1.whatsthatcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Patrick on 2018-04-02.
 */

public class SearchHistory {
    List<Map<String, String>> guessHistory;
    public SearchHistory(){
        guessHistory = new ArrayList<>();
    }



    public void updateHistory(Map userIn, Map res) {

    }

    public List<Map<String, String>> getHistory() {
        return guessHistory;
    }
}