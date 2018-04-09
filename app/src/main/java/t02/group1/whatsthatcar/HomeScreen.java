package t02.group1.whatsthatcar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.InputStream;

import br.com.bloder.magic.view.MagicButton;

public class HomeScreen extends AppCompatActivity {

    MagicButton btnSearch, btnHistory, btnHelp;

    static UserInterfaceController ui;
    static ExpertModerator em;
    static SearchEngine se;
    static File filesDir;
    SearchHistory history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        ExpertController1 ec1 = new ExpertController1();
        ExpertController2 ec2 = new ExpertController2();
        ExpertController3 ec3 = new ExpertController3();

        filesDir = getFilesDir();
        history = new SearchHistory();

        em = new ExpertModerator();

        em.addExpert(ec1);
        em.addExpert(ec2);
        em.addExpert(ec3);

        se = new SearchEngine(em);
        ui = new UserInterfaceController(se);

        btnSearch = (MagicButton) findViewById(R.id.searchButton);
        btnHelp = (MagicButton) findViewById(R.id.helpButton);
        btnHistory = (MagicButton) findViewById((R.id.historyButton));

        btnSearch.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Search", Toast.LENGTH_SHORT).show();
                Intent toy = new Intent(HomeScreen.this, SearchView.class);
                startActivity(toy);
            }
        });

        btnHistory.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "History", Toast.LENGTH_SHORT).show();
                Intent toy = new Intent(HomeScreen.this, HistoryView.class);
                startActivity(toy);
            }
        });

        btnHelp.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Help", Toast.LENGTH_SHORT).show();
                Intent toy = new Intent(HomeScreen.this, HelpView.class);
                startActivity(toy);
            }
        });
    }

//    public void beginSearch(View v){
//        Intent toy = new Intent(HomeScreen.this, SearchView.class);
//        startActivity(toy);
//    }
//
//    public void getHelp(View v){
//        Intent toy = new Intent(HomeScreen.this, HelpView.class);
//        startActivity(toy);
//    }
//
//    public void viewHistory(View v){
//        Intent toy = new Intent(HomeScreen.this, HistoryView.class);
//        startActivity(toy);
//    }
}
