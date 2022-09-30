package theme_04_StreamsFilesAndDirectories.Exercises;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class P09_CopyAPicture {
    public static void main(String[] args) {

        byte [] buffer = new byte [1024];
        try(FileInputStream fis = new FileInputStream("Resources/theme_04_Exercises_Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Cat03.jpg");
            FileOutputStream fos = new FileOutputStream("Resources/theme_04_Exercises_Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/CopyCat03.jpg")) {

            while (fis.read(buffer) != -1) {
                fos.write(buffer);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
