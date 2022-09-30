package theme_04_StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Demo_Stream2 {
    public static void main(String[] args) throws IOException {

        // Read
        String path = "D:\\Miglena\\Miglena\\09 My Documents\\SoftUni\\Java3_Advanced\\" +
                "theme_04_StreamsFilesAndDirectories\\" +
                "04.Java-Advanced-Streams-Files-and-Directories-Resources\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream fileInputStream = new FileInputStream(path);

        int oneByte = fileInputStream.read(); //чете един байт (един символ)

        while (oneByte != -1) {
            System.out.print((char) oneByte);
            oneByte = fileInputStream.read();
        }

    }
}
