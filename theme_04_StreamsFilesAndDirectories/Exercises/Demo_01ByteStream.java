package theme_04_StreamsFilesAndDirectories.Exercises;

import java.io.FileInputStream;
import java.io.IOException;

public class Demo_01ByteStream {
    public static void main(String[] args) throws IOException {

        //1. Stream?
        //2. Try, Catch, Finally? Exception Handling
        //3. Read and write?
        //4. Path Paths, File  Files

        FileInputStream fis = new FileInputStream("Resources/theme_04_Exercises_Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt");
        int oneByte = fis.read(); // чете информацията като 0 и 1, т.е. по байтове
        while (oneByte >= 0) {
            System.out.print((char) oneByte);
            oneByte = fis.read();
        }
        fis.close();

    }
}
