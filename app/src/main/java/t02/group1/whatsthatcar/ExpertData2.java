package t02.group1.whatsthatcar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the ExpertData class for "make"
 * @author  Stanley Liu
 * @date    03/04/2018
 */

public class ExpertData2 {

    /**
     * The search method read through the data file and find the make that equals to the input
     * @param search
     * @return return a list of integers that corresponds to the index of the row
     * @throws IOException
     */
    public static List<Integer> search(String search) throws IOException {

        List<Integer> results2 = new ArrayList<>();
        String file = "C:\\Users\\Liam\\Desktop\\Uni Stuff or work\\Uni\\International Study\\Fourth year\\Sem2\\3A04 - Large System Design\\Project\\WhatsThatCar\\3A04-WTC\\app\\src\\main\\res\\raw\\data2.csv"; // file that contains only info of "type"
        String line = "";
        List<String> data = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));

        while ((line = br.readLine()) != null) {
            data.add(line);
        }

        br.close();

        for (int i = 1; i < data.size(); i++) { // i start with 1 here to skip the headings
            if (data.get(i).equals(search)) {
                results2.add(i+1); // the index of the row, +1 because in the file there is no row 0
            }
        }

        return results2;
    }


//    public static void main(String args[]) throws IOException {
//        List<Integer> list = search("Sedan");
//        for (int i=0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//    }

}
