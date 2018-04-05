package t02.group1.whatsthatcar;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the ExpertData class for "make"
 * @author  Stanley Liu
 * @date    03/04/2018
 */

public class ExpertData1 extends SearchView{

    /**
     * The search method read through the data file and find the make that equals to the input
     * @param search
     * @return return a list of integers that corresponds to the index of the row
     * @throws IOException
     */
    public static List<Integer> search(String search) throws IOException {

        List<Integer> results1 = new ArrayList<>();
        String line = "";
        List<String> data = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(file1));

        while ((line = br.readLine()) != null) {
            data.add(line);
        }

        br.close();

        for (int i = 1; i < data.size(); i++) { // i start with 1 here to skip the headings
            if (data.get(i).equals(search)) {
                results1.add(i + 1); // the index of the row, +1 because in the file there is no row 0
            }
        }

        return results1;
    }

}
