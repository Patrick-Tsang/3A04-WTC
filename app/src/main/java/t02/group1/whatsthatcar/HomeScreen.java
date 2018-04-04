package t02.group1.whatsthatcar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.InputStream;

public class HomeScreen extends AppCompatActivity {

    public Button searchButton;
    public Button historyButton;
    public Button helpButton;

    public void init(){
        searchButton = (Button)findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent toy = new Intent(HomeScreen.this, SearchView.class);
                startActivity(toy);
            }
        });

        historyButton = (Button)findViewById(R.id.historyButton);
        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent toy = new Intent(HomeScreen.this, HistoryView.class);
                startActivity(toy);
            }
        });

        helpButton = (Button)findViewById(R.id.helpButton);
        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent toy = new Intent(HomeScreen.this, HelpView.class);
                startActivity(toy);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        init();
    }

    public void beginSearch(){

    }

    public void getHelp(){

    }

    public void viewHistory(){

    }
}
