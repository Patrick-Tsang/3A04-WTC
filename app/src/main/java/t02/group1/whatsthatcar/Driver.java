package t02.group1.whatsthatcar;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Runs the program.
 */
public class Driver {

    public static void main(String[] args){
        UserInterfaceController ui;
        ExpertModerator em;
        SearchEngine se;

        //need to do views/history

        ExpertController1 ec1 = new ExpertController1();
        ExpertController2 ec2 = new ExpertController2();
        ExpertController3 ec3 = new ExpertController3();

        em = new ExpertModerator();

        em.addExpert(ec1);
        em.addExpert(ec2);
        em.addExpert(ec3);

        se = new SearchEngine(em);
        ui = new UserInterfaceController(se);

        HashMap<String, String> problem = new HashMap<>();
        problem.put("make", "BMW");
        problem.put("type", "Coupe");
        problem.put("doors_size", "");
        se.setProblem(problem);
        se.updateModerator();

       Map<Integer, Double> guesses = em.getGuesses();

        for (Map.Entry<Integer, Double> entry : guesses.entrySet())
        {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }


    }

}
