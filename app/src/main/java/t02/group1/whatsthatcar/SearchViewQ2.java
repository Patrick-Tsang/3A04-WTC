package t02.group1.whatsthatcar;

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
    }

    public void showMenu(View v){
        PopupMenu menu = new PopupMenu(this, v);
        menu.setOnMenuItemClickListener(this);
        menu.inflate(R.menu.popup_menu_2);
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
//        TextView prompt = (TextView)findViewById(R.id.question2);
//        prompt.setVisibility(View.INVISIBLE);
//
//        Button answers = (Button)findViewById(R.id.answers2);
//        answers.setVisibility(View.INVISIBLE);
        Intent toy = new Intent(SearchViewQ2.this, SearchViewQ3.class);
        startActivity(toy);
        return true;
    }
}
