package theme_04_StreamsFilesAndDirectories.Exercises;

import java.io.*;

public class P02_SumBytes {
    public static void main(String[] args) throws IOException {

        String path = "Resources/theme_04_Exercises_Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {

            String readLine = bufferedReader.readLine();
            long result = 0;
            while (readLine != null) {
                for (char symbol : readLine.toCharArray()) {
                    result += symbol;
                }
                readLine = bufferedReader.readLine();
            }

            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
