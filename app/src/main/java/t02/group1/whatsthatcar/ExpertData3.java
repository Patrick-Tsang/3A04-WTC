package t02.group1.whatsthatcar;

import java.io.BufferedReader;
import java.io.FileReader;
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

//      //COMMENTED VERSION FOR LIAM TO TEST WITH RATHER THAN USE SHITEY PHONE EMULATOR
//    public class ExpertData3 {
//
//        /**
//         * The search method read through the data file and find the make that equals to the input
//         * @param doors
//         * @param size
//         * @return return a list of integers that corresponds to the index of the row
//         * @throws IOException
//         */
//        public static List<Integer> search(String doors, String size) throws IOException {
//
//            List<Integer> results3 = new ArrayList<>();
//            String file = "C:\\Users\\Liam\\Desktop\\Uni Stuff or work\\Uni\\International Study\\Fourth year\\Sem2\\3A04 - Large System Design\\Project\\WhatsThatCar\\3A04-WTC\\app\\src\\main\\res\\raw\\data3.csv"; // file that contains only info of "number of doors" and "size"
//            String line = "";
//            List<String> data = new ArrayList<>();
//            BufferedReader br = new BufferedReader(new FileReader(file));
//
//
//            // if no input(empty string), add something to it so my for loop later on works
//            if (doors == null || doors.equals("")) {
//                doors = doors + "a";
//            }
//
//            if (size == null || size.equals("")) {
//                size = size + "a";
//            }
//
//            while ((line = br.readLine()) != null) {
//                data.add(line);
//            }
//
//            br.close();
//
//            for (int i = 1; i < data.size(); i++) { // i start with 1 here to skip the headings
//                if (data.get(i).split(",")[0].equals(doors) || data.get(i).split(",")[1].equals(size)) {
//                    results3.add(i+1); // the index of the row, +1 because in the file there is no row 0
//                }
//            }
//
//            return results3;
//        }
//
//
////    public static void main(String args[]) throws IOException {
////        List<Integer> list = search("2", "");
////        for (int i = 0; i < list.size(); i++) {
////            System.out.println(list.get(i));
////        }
////    }
//
//    }