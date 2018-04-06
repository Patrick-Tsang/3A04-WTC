package t02.group1.whatsthatcar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class SearchViewQ3 extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view_q3);
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
        }
        return true;
    }

    public void searchPress(View v){
        Intent toy = new Intent(SearchViewQ3.this, SearchViewResult.class);
        startActivity(toy);
    }
}
