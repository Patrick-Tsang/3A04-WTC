package t02.group1.whatsthatcar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchViewResult extends AppCompatActivity {

    Button returnHome;

    private ListView listResult;

    public void init(){
        returnHome = (Button) findViewById(R.id.returnHome);
        returnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy = new Intent(SearchViewResult.this, HomeScreen.class);
                startActivity(toy);
            }
        });


        Intent getIntent = getIntent();
        String make = getIntent.getStringExtra("make");
        String type = getIntent.getStringExtra("type");
        String doors = getIntent.getStringExtra("doors");
        String size = getIntent.getStringExtra("size");


        UserInterfaceController ui;
        ExpertModerator em;
        SearchEngine se;

        //need to do views/history

        ExpertController1 ec1 = new ExpertController1();
        ExpertController2 ec2 = new ExpertController2();
        ExpertController3 ec3 = new ExpertController3();

        em = new ExpertModerator();

        em.addExpert(ec1);
        em.addExpert(ec2);
        em.addExpert(ec3);

        se = new SearchEngine(em);
        ui = new UserInterfaceController(se);

        HashMap<String, String> problem = new HashMap<>();
        problem.put("make", make);
        problem.put("type", type);
        problem.put("doors_size", doors+","+size);
        se.setProblem(problem);
        se.updateModerator();

        se.search();

        Map<Integer, Double> guesses = se.getGuesses();
        //TODO: Create text box that is only visible for null set
//        if (guesses.entrySet() == null){
//
//        } else {
            for (Map.Entry<Integer, Double> entry : guesses.entrySet()) {
                System.out.println(entry.getKey() + "-" + entry.getValue());
            }



        List<String> data = new ArrayList<>();


        InputStream file = getResources().openRawResource(R.raw.data);
        BufferedReader br = new BufferedReader(new InputStreamReader(file));
        String line = "";

        final List<Car> cars = new ArrayList<>();
        int i = 0;
        try {
            for (Integer key: guesses.keySet()) {
                //guesses.get(key);
                while ((line = br.readLine()) != null) {
                    if (key == i) {
                        cars.add(new Car(line.split(",")));
                        break;
                    }
                    i++;
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        List<Map<String, Object>> listems = new ArrayList<>();
        for (Car car:cars) {
            Map<String, Object> listem = new HashMap<>();
            listem.put("make", car.getMake());
            listem.put("model", car.getModel());
            listems.add(listem);
        }
        SimpleAdapter simplead = new SimpleAdapter(this, listems,
                R.layout.item, new String[] { "make", "model" },
                new int[] {R.id.txtMake,R.id.txtModel});

        listResult=findViewById(R.id.listResult);
        listResult.setAdapter(simplead);
        listResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Car c = cars.get(position);

                AlertDialog.Builder localBuilder = new AlertDialog.Builder(SearchViewResult.this);
                localBuilder.setTitle( c.getMake() +" "+ c.getModel());
                localBuilder.setIcon(R.mipmap.ic_launcher);
                localBuilder.setMessage(c.toString());
                localBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                    {

                    }
                });

                localBuilder.setCancelable(false).create();

                localBuilder.show();

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_result);
        init();
    }
}
