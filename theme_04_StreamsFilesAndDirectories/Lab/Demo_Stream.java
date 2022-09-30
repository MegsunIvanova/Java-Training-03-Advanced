package theme_04_StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Demo_Stream {
    public static void main(String[] args) throws IOException {

        // Read
        String path = "D:\\Miglena\\Miglena\\09 My Documents\\SoftUni\\Java3_Advanced\\" +
                "theme_04_StreamsFilesAndDirectories\\" +
                "04.Java-Advanced-Streams-Files-and-Directories-Resources\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream fileStream = new FileInputStream(path);

        Scanner scanner = new Scanner(fileStream);
        String line = scanner.nextLine();

        while (scanner.hasNextLine()) {
            System.out.println(line);
            line = scanner.nextLine();
        }


        //   System.out.println("Hello World!");

        //Write


    }
}
