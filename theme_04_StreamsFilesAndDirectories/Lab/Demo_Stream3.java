package theme_04_StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Demo_Stream3 {
    public static void main(String[] args) {

        // Read
        String path = "D:\\Miglena\\Miglena\\09 My Documents\\SoftUni\\Java3_Advanced\\" +
                "theme_04_StreamsFilesAndDirectories\\" +
                "04.Java-Advanced-Streams-Files-and-Directories-Resources\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        InputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(path);
            System.out.println("File was found it's ok");

            int oneByte = fileInputStream.read(); //чете един байт (един символ)

            while (oneByte != -1) {
                System.out.print((char) oneByte);
                oneByte = fileInputStream.read();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Cannot read from file");
            //exception-ните се подреждат от по-конкретен към по-общ, защото
            //иначе по-общия ще хване грешката и няма да стигнем до по-конкретния
        } finally {
            //код, който се изпълнява винаги независимо в кой от предните блокове сме влезнали
            //тук може да освободим ресурса
//            if (fileInputStream != null) {
//                fileInputStream.close();
//            }
        }


    }
}
