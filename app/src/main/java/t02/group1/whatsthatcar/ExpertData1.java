package t02.group1.whatsthatcar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Patrick on 2018-04-02.
 */

// This is the expert data for the vehicle manufacturer
public class ExpertData1 {

    HashMap<Integer, String> dataset = new HashMap<>(); // not sure when to use this yet

    // do we need the information for the whole row to be returned, or just a list of row number
    public List<Integer> search(String search) throws IOException {

        List<Integer> results = new ArrayList<>();
        String file = "data.csv";
        String line = "";
        List<String> data = new ArrayList<>();
        List<String> filteredData = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));

        while ((line = br.readLine()) != null) {
            data.add(line);
        }

        br.close();

        for (int i = 1; i < data.size(); i++) { // i start with 1 here to skip the headings
            if (data.get(i).split(",")[0].equals(search)) {
                results.add(i); // the index of the row
            }
        }

        return results;
    }


}
