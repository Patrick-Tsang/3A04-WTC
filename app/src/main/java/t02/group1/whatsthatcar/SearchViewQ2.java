package t02.group1.whatsthatcar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class SearchViewQ2 extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    String ans2 = "";
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
        Toast.makeText(this, item.getTitle() + " clicked",Toast.LENGTH_SHORT).show();
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
