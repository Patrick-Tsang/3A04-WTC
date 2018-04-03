package t02.group1.whatsthatcar;

/**
 * Created by Patrick on 2018-04-02.
 */

public class HelpData {

    public String getSearchHelp(){
        String toReturn = "By selecting the make, the type, the number of doors and the size of a vehicle, the application" +
                "displays a list of matching result, user can see detailed information of a vehicle by clicking on it.";

        return toReturn;
    }

    public String getHistoryHelp(){
        String toReturn = "The application stores your most recent 10 search history, when you click on \"Search History\" button," +
                "you can see the list of search history, by clicking on one of it, the application displays the search result" +
                "corresponding to that search.";

        return toReturn;
    }

    public String getGeneralHelp(){
        String toReturn = "This is an Android mobile application that will allow users to determine a specific car, " +
                "by answering questions concerning identifiable traits and generalistic knowledge of the vehicle. " +
                "It is designed to allow users with limited knowledge of cars to identify different car models.  ";

        return toReturn;
    }
}
