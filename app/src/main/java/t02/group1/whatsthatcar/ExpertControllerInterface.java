package t02.group1.whatsthatcar;

import java.util.HashMap;
import java.util.List;

public interface ExpertControllerInterface {
    void startSearch();
    List<Integer> getResults();
    void updateSpec(String newInfo);
}
