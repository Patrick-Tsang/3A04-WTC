package t02.group1.whatsthatcar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;
import java.util.List;

public class HistoryView extends AppCompatActivity {
    HashMap searchHistory = new HashMap();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_view);
    }

    public List<HashMap> displayHistory(){

        return null;
    }
}
