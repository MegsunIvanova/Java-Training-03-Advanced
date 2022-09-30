package theme_04_StreamsFilesAndDirectories.Exercises;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Demo_04StreamScanner {
    public static void main(String[] args) throws IOException {

        //1. Stream?
        //2. Try, Catch, Finally? Exception Handling
        //3. Read and write?
        //4. Path Paths, File  Files

        FileReader reader = new FileReader("Resources/theme_04_Exercises_Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt");
        Scanner scan = new Scanner(reader);


        String line = scan.nextLine(); // чете информацията като кажем по int, String, Double
        while (scan.hasNextLine()) {
            System.out.print(line);
            line = scan.nextLine();
        }

        reader.close();
    }
}

