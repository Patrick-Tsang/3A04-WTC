package t02.group1.whatsthatcar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
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

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(this, item.getTitle() + " clicked",Toast.LENGTH_SHORT).show();
//        TextView prompt = (TextView)findViewById(R.id.question3);
//        prompt.setVisibility(View.INVISIBLE);
//
//        Button answers = (Button)findViewById(R.id.answers3);
//        answers.setVisibility(View.INVISIBLE);
        Intent toy = new Intent(SearchViewQ3.this, SearchViewResult.class);
        startActivity(toy);
        return true;
    }
}
