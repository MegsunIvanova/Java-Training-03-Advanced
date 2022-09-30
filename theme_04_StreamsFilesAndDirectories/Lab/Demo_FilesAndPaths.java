package theme_04_StreamsFilesAndDirectories.Lab;

import java.io.File;
import java.io.IOException;

public class Demo_FilesAndPaths {
    public static void main(String[] args) throws IOException {

        String programDir = System.getProperty("user-dir");
        String path = programDir + "\\Resources\\theme_04_Lab_Resources\\input.txt";

        File myFile = new File("my-file.txt");


        if (!myFile.exists()) {
            myFile.createNewFile();
        }

        System.out.println();
    }
}
