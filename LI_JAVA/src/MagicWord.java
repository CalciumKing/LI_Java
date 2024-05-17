/*
Name: Landen Ingerslev
Assignment: Magic Word
Description: Code adds all the names with their passwords into an arraylist
 it then gets a random line and splits it into a username and password
 the user is then queried to enter a password to the username and are
 stuck in a while loop until they guess correctly, if they do get it correct
 the program prints "correct" and ends
 */

import java.io.*;
import java.util.*;
public class MagicWord {
    private static final String FILENAME = "lotr_names_passwords.txt";
    private static final String delimiter = ":";
    public static void main(String[] args) throws FileNotFoundException {
        File myFile = new File(FILENAME);
        if(!myFile.exists()) {
            System.out.println("File Not Found");
            System.exit(0);
        }

        Scanner inputFile = new Scanner(myFile);
        ArrayList<String> lines = new ArrayList<>();
        while(inputFile.hasNextLine())
            lines.add(inputFile.nextLine());
        inputFile.close();


        int random = (int)(Math.random() * lines.size() + 1);
        String[] splitWord = lines.get(random).split(delimiter);
        String username = splitWord[0];
        String password = splitWord[1];

        Scanner input = new Scanner(System.in);
        String guess;
        System.out.println("Guess the password to " + username);
        do {
            guess = input.nextLine();
            if(!guess.equals(password))
                System.out.println("Wrong, guess again");
        } while(!guess.equals(password));

        System.out.println("That's correct");
    }
}