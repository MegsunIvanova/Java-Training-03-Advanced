package theme_04_StreamsFilesAndDirectories.Exercises;

import java.io.*;
import java.util.Locale;

public class P03_AllCapitals {
    public static void main(String[] args) {

        String path = "Resources/theme_04_Exercises_Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
             PrintWriter writer = new PrintWriter(new FileWriter("Resources/theme_04_Exercises_Resources/all-capitals-out.txt"))) {
            bufferedReader.lines().forEach(line -> writer.println(line.toUpperCase()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
