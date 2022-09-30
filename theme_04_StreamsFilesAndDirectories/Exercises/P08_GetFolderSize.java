package theme_04_StreamsFilesAndDirectories.Exercises;

import java.io.File;
import java.util.ArrayDeque;

public class P08_GetFolderSize {
    public static void main(String[] args) {

        File folder = new File("D:\\Miglena\\Miglena\\09 My Documents\\SoftUni\\Java3_Advanced\\PAdvan_Sept\\Resources\\theme_04_Exercises_Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");
        File[] arr = folder.listFiles();

        int folderSize = 0;
        ArrayDeque<File> files = new ArrayDeque<>();
        files.offer(folder);

        while (!files.isEmpty()) {
            File currentFile = files.poll();
            File[] nestedFiles = currentFile.listFiles();
            for (File nestedFile : nestedFiles) {
                if (nestedFile.isDirectory()) {
                    files.offer(nestedFile);
                } else {
                    folderSize += nestedFile.length();
                }
            }
        }

        System.out.println("Folder size: "+folderSize);


    }
}
