package t02.group1.whatsthatcar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the ExpertData class for "number of doors" and "vehicle size"
 * @author  Stanley Liu
 * @date    03/04/2018
 */

public class ExpertData3 extends SearchView{

    /**
     * The search method read through the data file and find the make that equals to the input
     * @param doors
     * @param size
     * @return return a list of integers that corresponds to the index of the row
     * @throws IOException
     */
    public static List<Integer> search(String doors, String size) throws IOException {

        List<Integer> results3 = new ArrayList<>();
        String line = "";
        List<String> data = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(file3));


        // if no input(empty string), add something to it so my for loop later on works
        if (doors == null || doors.equals("")) {
            doors = doors + "a";
        }

        if (size == null || size.equals("")) {
            size = size + "a";
        }

        while ((line = br.readLine()) != null) {
            data.add(line);
        }

        br.close();

        for (int i = 1; i < data.size(); i++) { // i start with 1 here to skip the headings
            if (data.get(i).split(",")[0].equals(doors) || data.get(i).split(",")[1].equals(size)) {
                results3.add(i+1); // the index of the row, +1 because in the file there is no row 0
            }
        }

        return results3;
    }

}
