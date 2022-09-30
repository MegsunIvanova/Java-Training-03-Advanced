package theme_04_StreamsFilesAndDirectories.Exercises;

import java.io.FileReader;
import java.io.IOException;

public class Demo_02CharacterStream {
    public static void main(String[] args) throws IOException {

        //1. Stream?
        //2. Try, Catch, Finally? Exception Handling
        //3. Read and write?
        //4. Path Paths, File  Files

        FileReader reader = new FileReader("Resources/theme_04_Exercises_Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt");
        int oneChar = reader.read(); // чете информацията като по char-ове
        while (oneChar >= 0) {
            System.out.print((char) oneChar);
            oneChar = reader.read();
        }
        reader.close();

    }
}
