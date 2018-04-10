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

public class SearchHistory extends HomeScreen{
    ArrayList<Map<String, String>> guessHistory = new ArrayList();
    String filename = "history.txt";
    File file;

    FileReader reader;
    BufferedReader buffer;
    Map<String, String> temp;
    String[] tempStr;

    /**
     * Constructor for the Search History object
     *
     */
    public SearchHistory(File filesDir){
        file = new File(filesDir, filename);
        Log.d("file path", filesDir.toString());

        try {
            reader = new FileReader(file);
            buffer = new BufferedReader(reader);
            String line;
            while ((line = buffer.readLine()) != null) {
                Log.d("Buffer Line:", " " + line);
                tempStr = line.split(",");
                temp = new HashMap<>();
                temp.put("make",tempStr[0]);
                temp.put("type",tempStr[1]);
                temp.put("doors_size",tempStr[2] + "," + tempStr[3]);
                guessHistory.add(temp);
            }
            reader.close();
            buffer.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @param userIn
     */
    public void updateHistory(Map<String, String> userIn) {
        guessHistory.add(0, userIn);
        while (guessHistory.size() > 10){
            guessHistory.remove(10);
        }
        try{
            PrintWriter writer = new PrintWriter(file);
            for(Map<String, String> entry: guessHistory){
                writer.println(entry.get("make") + "," + entry.get("type") + "," + entry.get("doors_size"));
            }
            writer.close();
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


