
package t02.group1.whatsthatcar;

/**
 * Created by Patrick on 2018-04-02.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;


import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class SearchView extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    static InputStream file1;
    static InputStream file2;
    static InputStream file3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        file1 = getResources().openRawResource(R.raw.data1);
        file2 = getResources().openRawResource(R.raw.data2);
        file3 = getResources().openRawResource(R.raw.data3);
    }

    public void showMenu(View v){
        PopupMenu menu = new PopupMenu(this, v);
        menu.setOnMenuItemClickListener(this);
        menu.inflate(R.menu.popup_menu_1);
        menu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item){
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "Item 1 clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Toast.makeText(this, "Item 2 clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item3:
                Toast.makeText(this, "Item 3 clicked",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item4:
                Toast.makeText(this, "Item 4 clicked",Toast.LENGTH_SHORT).show();
                break;
            default :
                return false;
        }
        TextView prompt = (TextView)findViewById(R.id.question1);
        prompt.setVisibility(View.INVISIBLE);

        Button answers = (Button)findViewById(R.id.answers1);
        answers.setVisibility(View.INVISIBLE);

        try {
            System.out.println(ExpertData1.search("BMW"));
            Log.d("Search Results:", "Search Completed");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    Scanner input =  new Scanner(System.in);

    public View goToActivity(String act){
        return null;
    }

    public void getInput(String in){

    }

    public void saveInput(String in){

    }
}

