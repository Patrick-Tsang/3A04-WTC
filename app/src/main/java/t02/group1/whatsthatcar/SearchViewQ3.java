package t02.group1.whatsthatcar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class SearchViewQ3 extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private String doors;
    private String size;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view_q3);

        findViewById(R.id.helpButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showHelp("Search Help Q3", "Select the number of doors (excluding the trunk) and then the size of the vehicle (compact, midsize, large).");
            }
        });
    }

    public void showMenu(View v){
        PopupMenu menu = new PopupMenu(this, v);
        menu.setOnMenuItemClickListener(this);
        menu.inflate(R.menu.popup_menu_3);
        menu.show();
    }

    public void showMenu2(View v){
        PopupMenu menu = new PopupMenu(this, v);
        menu.setOnMenuItemClickListener(this);
        menu.inflate(R.menu.popup_menu_4);
        menu.show();
    }

    private void showHelp(String title,String help)
    {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(SearchViewQ3.this);
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
    public boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(this, item.getTitle() + " clicked",Toast.LENGTH_SHORT).show();
        Button b = (Button)findViewById(R.id.doorsButton);
        b.setVisibility(View.INVISIBLE);
        Button a = (Button)findViewById(R.id.typeButton);
        a.setVisibility(View.VISIBLE);


        String check = item.getTitle().toString();

        //check if the result is from the doors selection - show the search button if it is NOT
        if (!(check.equals("0") || check.equals("2") || check.equals("3") || check.equals("4"))){
            Button c = (Button)findViewById(R.id.typeButton);
            c.setVisibility(View.INVISIBLE);
            Button d = (Button)findViewById(R.id.searchButton);
            d.setVisibility(View.VISIBLE);
            doors = item.getTitle().toString();
        }else{
            size = item.getTitle().toString();
        }
        return true;
    }

    public void searchPress(View v){
        Intent toy = new Intent(SearchViewQ3.this, SearchViewResult.class);
        Intent getIntent = getIntent();
        String make = getIntent.getStringExtra("make");
        String type = getIntent.getStringExtra("type");
        toy.putExtra("make", make);
        toy.putExtra("type", type);
        toy.putExtra("doors", doors);
        toy.putExtra("size", size);
        startActivity(toy);
    }

    private void displayHelp(View v)
    {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(SearchViewQ3.this);
        localBuilder.setTitle("Search Help");
        localBuilder.setIcon(R.mipmap.ic_launcher);
        localBuilder.setMessage(HelpData.getSearchHelp());
        localBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {

            }
        });

        localBuilder.setCancelable(false).create();

        localBuilder.show();
    }
}
