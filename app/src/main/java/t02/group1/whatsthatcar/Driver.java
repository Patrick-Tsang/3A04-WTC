package t02.group1.whatsthatcar;

/**
 * Runs the program.
 */
public class Driver {

    public static void Driver(String[] args){
        UserInterfaceController ui;
        ExpertModerator em;
        SearchEngine se;

        //need to do views/history

        ExpertController1 ec1 = new ExpertController1();
        ExpertController2 ec2 = new ExpertController2();
        ExpertController3 ec3 = new ExpertController3();


        em = new ExpertModerator(ec1, ec2, ec3);
        se = new SearchEngine(em);
        ui = new UserInterfaceController(se);

    }

}
