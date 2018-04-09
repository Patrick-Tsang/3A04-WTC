package t02.group1.whatsthatcar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class SearchViewQ2 extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

   

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view_q2);

        findViewById(R.id.helpButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showHelp("Search Help Q2", "Select the type from coupe to SUV!");
            }
        });
    }

    public void showMenu(View v){
        PopupMenu menu = new PopupMenu(this, v);
        menu.setOnMenuItemClickListener(this);
        menu.inflate(R.menu.popup_menu_2);
        menu.show();
    }

    private void showHelp(String title,String help)
    {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(SearchViewQ2.this);
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

    @Override
    public boolean onMenuItemClick(MenuItem item){
        Toast.makeText(this, item.getTitle() + " clicked",Toast.LENGTH_SHORT).show();
//        TextView prompt = (TextView)findViewById(R.id.question2);
//        prompt.setVisibility(View.INVISIBLE);
//
//        Button answers = (Button)findViewById(R.id.answers2);
//        answers.setVisibility(View.INVISIBLE);
        Intent toy = new Intent(SearchViewQ2.this, SearchViewQ3.class);
        Intent getIntent = getIntent();
        String make = getIntent.getStringExtra("make");
        toy.putExtra("make", make);
        toy.putExtra("type", item.getTitle());
        startActivity(toy);
        return true;
    }
}
