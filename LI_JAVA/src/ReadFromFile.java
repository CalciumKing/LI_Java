// Name: Landen Ingerslev
// Assignment: Read From File
/*Description: Code sorts all the names in the file, then asks for
names from the user, sorts those names and adds them to the file.
Then the program prints out the sorted lotr names and all the
inputted names separately*/

import java.io.*;
import java.util.*;

public class ReadFromFile {
    private static final String FILENAME = "lotr_races.txt";
    public static void main(String[] args) throws IOException {
        File myFile = new File(FILENAME);
        if(!myFile.exists()) {
            System.out.println("File Not Found");
            System.exit(0);
        }

        Scanner inputFile = new Scanner(myFile);
        String delimeter = ":";
        ArrayList<String> lines = new ArrayList<>();
        while(inputFile.hasNextLine()) {
            String currentLine = inputFile.nextLine();
            if(currentLine.contains(delimeter)) {
                String[] splitLine = currentLine.split(delimeter);
                lines.add(splitLine[0]);
            } else
                lines.add(currentLine);
        }
        lines.sort(String.CASE_INSENSITIVE_ORDER);
        inputFile.close();

        Scanner input = new Scanner(System.in);
        String text = "";
        ArrayList<String> newNames = new ArrayList<>();
        do {
            System.out.println("Enter a name or type 'CLOSE' to exit");
            text = input.nextLine();
            if(!text.equalsIgnoreCase("CLOSE"))
                newNames.add(text);
        } while(!text.equalsIgnoreCase("CLOSE"));
        newNames.sort(String.CASE_INSENSITIVE_ORDER);

        FileWriter fileWriter = new FileWriter(myFile, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        printWriter.println("");

        for(String name : newNames) {
            printWriter.println(name);
        }
        printWriter.close();
        fileWriter.close();

        System.out.println();

        for(String name : lines)
            System.out.println(name);
        System.out.println();
        for(String name : newNames)
            System.out.println(name);
    }
}