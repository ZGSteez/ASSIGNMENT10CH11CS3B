/*
 * CSVReader
 * Assignment 10 - P11.04
 * Chapter 11
 *
 * @author Zhuo Guan
 * Implementing CSVReader class
 */
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSVReader {
    private ArrayList<ArrayList<String>> data = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private File fileName = new File("src/CSVFile");

    /**
     * Returns number of rows
     * @return - amount of rows
     */
    public int numberOfRows(){

      return 0;
  }

    /**
     * Returns the amount of characters in selected row
     * @param row - row from csv file
     * @return - length of a row
     */
    public int numberOfFields(int row){
      return 0;
    }

    /**
     * Returns value at row,column
     * @param row - row value
     * @param column - column value
     * @return - value at specified row,column
     */
    public String field(int row, int column){
      return "a";
    }

    public void readFile() throws FileNotFoundException {

        while (!fileName.exists()) {
            try {
                if (!fileName.exists()) {
                    throw new FileNotFoundException("Error: file not found");
                }
            } catch (FileNotFoundException e) {
                System.out.print("Error: file not found. Enter alternative filename: ");
                String newFilename = scanner.nextLine();
                fileName = new File(newFilename);
            }
        }
        Scanner input = new Scanner(fileName);

        while (input.hasNextLine()) {
            String line = input.nextLine();
            //String[] values = line.split("\",\"");
            String[] values = line.split(",");

            while (values.length < 0) {
                try {
                    throw new FileNotFoundException("Error: incorrect format");
                } catch (FileNotFoundException e) {

                        System.out.print("Error: incorrect format. Enter alternative filename: ");
                        String newFilename = scanner.nextLine();
                        fileName = new File(newFilename);

                }
            }

            for (String a : values){
                System.out.println(a);
            }
            fillArray(values);

        }
        input.close();


    }

    public void show(){
        System.out.println(data);

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.print(data.size());

    }

    private ArrayList<String> removeDuplicates(ArrayList<String> temporaryList){
        String a = "";

        System.out.println("Before" + temporaryList.size());
        for (int i = 0; i < temporaryList.size();i++){
            a = temporaryList.get(i);

            for (int j = temporaryList.size() - 1; j >= 0;j--){
                if (temporaryList.get(j).contains(a) && !a.equals(temporaryList.get(j))){
                    temporaryList.remove(a);
                    System.out.println(a);
                    System.out.println(temporaryList.get(j));
                }
            }
        }

        System.out.println("After" + temporaryList.size());

        return temporaryList;
    }


    public void fillArray(String[] lineValues) {

        ArrayList<String> temporaryList = new ArrayList<>();
        ArrayList<String> List = new ArrayList<>();
        int b = 0;
        int counter = lineValues.length;
        int i = 0;

        System.out.println(lineValues.length);

        if (lineValues.length % 2 == 0) {
            while (i < counter) {
                //iPlus = i + 1;

                if (!lineValues[i].contains("\"")) {
                    temporaryList.add(lineValues[i]);
                    i++;
                } else if (lineValues[i].contains("\"\"") && lineValues[i + 1].contains("\"\"")) {
                    temporaryList.add(lineValues[i] + "," + lineValues[i + 1]);
                    i++;
                } else if (lineValues[i].contains("\"") && lineValues[i + 1].contains("\"")) {
                    temporaryList.add(lineValues[i] + "," + lineValues[i + 1]);
                    i++;


                }
                i++;

            }
        }


        else if (lineValues.length % 2 == 1) {
            while (i < counter - 1) {
                b = i;
                if (!lineValues[i].contains("\"")) {
                    temporaryList.add(lineValues[i]);
                } else if (lineValues[i].contains("\"\"") && lineValues[i + 1].contains("\"\"")) {
                    temporaryList.add(lineValues[i] + "," + lineValues[i + 1]);
                } else if ((lineValues[i].contains("\"") && lineValues[i + 1].contains("\"")) && (!lineValues[b].contains("\"\"") && !lineValues[b+1].contains("\"\""))){
                    temporaryList.add(lineValues[i] + "," + lineValues[i + 1]);
                }
                else if (lineValues[i+1].contains("\"\"\"")){
                    temporaryList.add(lineValues[i]);
                }

                i++;

            }



        }

        data.add(temporaryList);

    }

    public void ok(){
        if (data.get(0).get(2).contains(data.get(0).get(3))){
            System.out.print("GOOD");
        }

//        System.out.println(data.get(0).get(2));
//        System.out.println(data.get(0).get(3));

    }

    public static void main(String[] args) throws FileNotFoundException {

//            String c = ("\"John Jacob \"\"Jakey\"\" Astor VI\",1912,1992");
//            String split[] = c.split(",");
//            for (String a : split){
//                System.out.println(a);
//            }
        CSVReader newReader = new CSVReader();

        newReader.readFile();
        newReader.show();
    }
}
