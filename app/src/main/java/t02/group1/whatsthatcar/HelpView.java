package t02.group1.whatsthatcar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HelpView extends AppCompatActivity {
    public String displayHelp(){
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_view);

        findViewById(R.id.btnSearch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showHelp("Search Help", HelpData.getSearchHelp());
            }
        });

        findViewById(R.id.btnHistory).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showHelp("History Help", HelpData.getHistoryHelp());
            }
        });
        findViewById(R.id.btnGeneral).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showHelp("General Help", HelpData.getGeneralHelp());
            }
        });
    }

    private void showHelp(String title,String help)
    {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(HelpView.this);
        localBuilder.setTitle(title);
        localBuilder.setIcon(R.mipmap.ic_launcher);
        localBuilder.setMessage(help);
        localBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {

            }
        });

        localBuilder.setCancelable(false).create();

        localBuilder.show();
    }

    public void closeHelp(){

    }
}
