package theme_04_StreamsFilesAndDirectories.Exercises;

import java.io.*;

public class P05_LineNumbers {
    public static void main(String[] args) {

        String path = "Resources/theme_04_Exercises_Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path));
             PrintWriter pw = new PrintWriter(new FileWriter("Resources/theme_04_Exercises_Resources/line-numbers-out.txt"))) {
            String line = br.readLine();
            int counter = 0;
            while (line != null) {
                counter++;
                String numberedLine = counter + ". " + line;
                pw.println(numberedLine);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
