package t02.group1.whatsthatcar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistoryView extends AppCompatActivity {
    HashMap searchHistory = new HashMap();
    SearchHistory sh;

    Button returnHome;
    private ListView listResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_view);

//        try {
//            Map<String, String> temp = new HashMap<>();
//            temp.put("make", "a");
//            temp.put("type", "b");
//            temp.put("doors_size","c, d");
//            for(int i = 0; i < 10; i++){
//                sh.updateHistory(temp);
//            }
//            //Log.d("", "");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        sh = new SearchHistory();
        returnHome = findViewById(R.id.returnHome);
        returnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy = new Intent(HistoryView.this, HomeScreen.class);
                startActivity(toy);
            }
        });

        displayHistory();
    }

    public void displayHistory(){
        final List<Map<String, String>> listems  = sh.getHistory();
        SimpleAdapter simplead = new SimpleAdapter(this, listems,
                R.layout.history_item, new String[] {"make", "type", "doors_size" },
                new int[] {R.id.txtMake,R.id.txtType, R.id.txtDoors});

        listResult=findViewById(R.id.listResult);
        listResult.setAdapter(simplead);
        listResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String, String> item = listems.get(position);
                AlertDialog.Builder localBuilder = new AlertDialog.Builder(HistoryView.this);
                localBuilder.setTitle( "Search Result #" + Integer.toString(position + 1) );
                localBuilder.setIcon(R.mipmap.ic_launcher);
                String[] ds = item.get("doors_size").split(",");
                String s =  "Make: " + item.get("make") + "\n" + "Type: " + item.get("type") + "\n";
                s +=  "Doors: " + ds[0] + "\n" + "Size: " + ds[1];
                localBuilder.setMessage(s);
                localBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                    {

                    }
                });

                localBuilder.setCancelable(false).create();

                localBuilder.show();

            }
        });
    }
}
