package theme_04_StreamsFilesAndDirectories.Exercises;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Demo_05FilesAndPaths {
    public static void main(String[] args) throws IOException {

        File file = new File("asdasd"); //използва се за обработка на файл

        BufferedReader reader = new BufferedReader(new FileReader("asdasd"));
        BufferedReader reader1 = Files.newBufferedReader(Path.of("asdasd"));

        Path path = Paths.get("asdasd");

    }
}
