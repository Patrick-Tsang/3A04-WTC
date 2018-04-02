package t02.group1.whatsthatcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Patrick on 2018-04-02.
 */

public class SearchEngine {

    HashMap<Integer, String> problemSpec = new HashMap<Integer, String>();
    List<String> guessList = new ArrayList<>();

    public getProblem(HashMap hashmap) {

        return UserInterfaceController.sendUserInput();

    }

    public void setProblem(HashMap hashmap) {

    }

    public getGuesses(List<String> list) {

        return UserInterfaceController.sendHistory();

    }


    public void setGuesses(List<String> list) {

    }

    private void updateModerator() {

    }


}
