package t02.group1.whatsthatcar;

/**
 * Created by Patrick on 2018-04-02.
 */

public class HelpData {

    static public String getSearchHelp(){
        String helpData = "First select the make from a variety of options! Then proceed to select the type from coupe to SUV, " +
                "the number of doors (excluding the trunk) and the size of a vehicle can also be selected (compact, midsize, large). " +
                "The application displays a list of matching results, users can view more detailed information about a specific vehicle " +
                "by selecting it on this results screen ";

        return helpData;
    }

    static public String getHistoryHelp(){
        String helpData = "The application stores the 10 most recent searches, when a user selects  \"Search History\" button," +
                "The user's previous inputs will be and by selection one of them, the application will display the search results that match those inputs";

        return helpData;
    }

    static public String getGeneralHelp(){
        String helpData= "This is an Android mobile application that will allow users to determine a specific car, " +
                "by answering questions concerning identifiable traits and little knowledge of the vehicle. " +
                "More specific help can be found in both of the tasks. Select \"Search History\" to view previous searches"+
                "Select \"Search\" to begin a new saearch";

        return helpData;
    }
}
