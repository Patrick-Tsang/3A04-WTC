package t02.group1.whatsthatcar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HelpView extends AppCompatActivity {
    public String displayHelp(){
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_view);
    }

    public void closeHelp(){

    }
}
