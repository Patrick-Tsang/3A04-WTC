package t02.group1.whatsthatcar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.InputStream;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }

    public void beginSearch(View v){
        Intent toy = new Intent(HomeScreen.this, SearchView.class);
        startActivity(toy);
    }

    public void getHelp(View v){
        Intent toy = new Intent(HomeScreen.this, HelpView.class);
        startActivity(toy);
    }

    public void viewHistory(View v){
        Intent toy = new Intent(HomeScreen.this, HistoryView.class);
        startActivity(toy);
    }
}
