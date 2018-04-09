package t02.group1.whatsthatcar;

import android.support.annotation.NonNull;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Patrick on 2018-04-02.
 */

public class SearchHistory extends HistoryView{
    Queue<Map<String, String>> guessHistory = new PriorityQueue<>(10);
    String filename = "history.txt";
    File file;

    FileReader reader;
    BufferedReader buffer;
    Map<String, String> temp;
    String[] tempStr;

    /**
     * TODO: This method should check the history file for the data and then parse for the queue
     *
     */
    public SearchHistory(){
        file = new File(filesDir, filename);
        Log.d("file path", filesDir.toString());
        try {
            reader = new FileReader(file);
            buffer = new BufferedReader(reader);
            while (!buffer.readLine().equals("")) {
                Log.d("Buffer Line:", " " + buffer.readLine());
                tempStr = buffer.readLine().split(",");
                temp = new HashMap<>();
                temp.put("make",tempStr[0]);
                temp.put("type",tempStr[1]);
                temp.put("doors",tempStr[2]);
                temp.put("size",tempStr[3]);
                Log.d("History -> ", "entry read from file");
            }
            reader.close();
            buffer.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     *
     * @param userIn
     */
    public void updateHistory(Map<String, String> userIn) {
        guessHistory.add(userIn);
        try{
            PrintWriter writer = new PrintWriter(file);
            for(Map<String, String> entry: guessHistory){
                writer.println(entry.get("make") + "," + entry.get("type") + "," + entry.get("doors") + "," + entry.get("size"));
            }
            writer.close();
            Log.d("History", "Entry written properly");
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     *
     * @return search history as ArrayList for HistoryView display
     */
    public List<Map<String, String>> getHistory() {
        List<Map<String, String>> history = new ArrayList<>();
        for(Map<String, String> entry: guessHistory){
            history.add(entry);
        }
        return history;
    }
}


