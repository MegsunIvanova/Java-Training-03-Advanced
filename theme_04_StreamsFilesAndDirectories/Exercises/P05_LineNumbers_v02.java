package theme_04_StreamsFilesAndDirectories.Exercises;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class P05_LineNumbers_v02 {
    public static void main(String[] args) {

        try (PrintWriter pw = new PrintWriter(new FileWriter("Resources/theme_04_Exercises_Resources/line-numbers-out.txt"))) {
            Path inputFile = Paths.get("Resources/theme_04_Exercises_Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt");
            List<String> lines = Files.readAllLines(inputFile);
            for (int i = 0; i < lines.size(); i++) {
                pw.println((i + 1) + ". " + lines.get(i));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
