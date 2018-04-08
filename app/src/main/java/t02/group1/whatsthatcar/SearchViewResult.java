package t02.group1.whatsthatcar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;

public class SearchViewResult extends AppCompatActivity {

    static UserInterfaceController ui = HomeScreen.ui;
    static ExpertModerator em = HomeScreen.em;
    static SearchEngine se = HomeScreen.se;

    Button returnHome;
    public void init(){
        returnHome = (Button) findViewById(R.id.returnHome);
        returnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy = new Intent(SearchViewResult.this, HomeScreen.class);
                startActivity(toy);
            }
        });

        //testing
        printData();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_result);
        init();

    }

    //JUST using to see if the inputs passed to ui show up.
    public void printData(){
        HashMap prob = ui.problem;
        System.out.print(prob.toString());

        Toast.makeText(this, prob.toString(),Toast.LENGTH_SHORT).show();
    }
}
