package theme_04_StreamsFilesAndDirectories.Exercises;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class P07_MergeTwoFiles {
    public static void main(String[] args) {
        //В1 четем със Scanner и пишем с PrintWriter (with append!)
        //PrintWriter pw = new PrintWriter(new FileWriter(path,true))

        Path input1 = Paths.get("Resources/theme_04_Exercises_Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputOne.txt");
        Path input2 = Paths.get("Resources/theme_04_Exercises_Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputTwo.txt");
        Path output = Paths.get("Resources/theme_04_Exercises_Resources/merge-two-files-out.txt");

        try {
            List<String> firstFile = Files.readAllLines(input1);
            List<String> secondFile = Files.readAllLines(input2);

            Files.write(output, firstFile, StandardOpenOption.CREATE);
            Files.write(output, secondFile, StandardOpenOption.APPEND);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}


