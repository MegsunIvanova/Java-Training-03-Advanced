package theme_04_StreamsFilesAndDirectories.Exercises;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class P12_CreateZipArchive {
    public static void main(String[] args) {

        //https://examples.javacodegeeks.com/core-java/util/zip/create-zip-file-from-multiple-files-with-zipoutputstream/

        String zipFile = "Resources/theme_04_Exercises_Resources/files.zip";

        String[] srcFiles = {"Resources/theme_04_Exercises_Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt",
                "Resources/theme_04_Exercises_Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt",
                "Resources/theme_04_Exercises_Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/words.txt"};

        try (FileOutputStream fos = new FileOutputStream(zipFile);
             ZipOutputStream zos = new ZipOutputStream(fos)) {

            // create byte buffer
            byte[] buffer = new byte[1024];
            for (int i = 0; i < srcFiles.length; i++) {
                File scrFile = new File(srcFiles[i]);
                FileInputStream fis = new FileInputStream(scrFile);

                // begin writing a new ZIP entry, positions the stream to the start of the entry data
                zos.putNextEntry(new ZipEntry(scrFile.getName()));

                int length = fis.read(buffer);
                while (length > 0) {
                    zos.write(buffer, 0, length);
                    length = fis.read(buffer);
                }
                zos.closeEntry();

                //close the InputStream
                fis.close();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
