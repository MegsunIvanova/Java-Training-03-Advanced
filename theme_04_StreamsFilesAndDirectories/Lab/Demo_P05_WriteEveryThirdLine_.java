package theme_04_StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Demo_P05_WriteEveryThirdLine_ {
    public static void main(String[] args) throws IOException {

        String programDir = System.getProperty("user.dir");
        String path = programDir + "\\Resources\\theme_04_Lab_Resources\\input.txt";

        //само за малки файлове
        List<String> strings = Files.readAllLines(Paths.get(path));

        for (int i = 2; i < strings.size(); i += 3) {
            System.out.println(strings.get(i));
        }

        Files.write(Path.of("my-demo.txt"),strings, StandardOpenOption.CREATE_NEW);

    }
}
