package t02.group1.whatsthatcar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistoryView extends AppCompatActivity {
    HashMap searchHistory = new HashMap();
    static File filesDir;
    SearchHistory history;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_view);
        filesDir = getFilesDir();
        history = new SearchHistory();
        displayHistory();

        try {
            Map<String, String> temp = new HashMap<>();
            temp.put("make ", "a");
            temp.put("type", "b");
            temp.put("doors","c");
            temp.put("size","d");
            for(int i = 0; i < 10; i++){
                history.updateHistory(temp);
            }
            //Log.d("", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<HashMap> displayHistory(){
        history.getHistory();
        return null;
    }
}
