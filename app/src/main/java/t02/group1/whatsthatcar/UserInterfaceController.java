package t02.group1.whatsthatcar;

import java.util.HashMap;

/**
 * Created by Patrick on 2018-04-02.
 */

import java.util.*;

public class UserInterfaceController {

    HashMap<String, String> problem = new HashMap<>();

    public UserInterfaceController(SearchEngine searchEngine) {
    }

    public void loadData(){
        problem.put("make", SearchView.ans1);
        problem.put("type", SearchViewQ2.ans2);
        problem.put("doors_size", SearchViewQ3.ans3 + "," + SearchViewQ3.ans3pt2);
    }

//    private List<HashMap> getDataRequest(){
//
//    }

    private void sendUserInput(HashMap in){

    }

    private void sendHistory(List<HashMap> in){

    }

    private void confirmResult(){

    }

    private void displayHomeView(){

    }

    private void displaySearchView(){

    }

    private void displayHelpView(Object state){

    }

    private void displayHistoryView(){

    }

    private void exit(Object state){

    }
}
