package theme_04_StreamsFilesAndDirectories.Exercises;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class P10_SerializeArrayList {
    public static void main(String[] args) {


        List<Double> list = new ArrayList<>();
        list.add(1.1);
        list.add(2.2);
        list.add(3.3);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Resources/theme_04_Exercises_Resources/list.ser"));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Resources/theme_04_Exercises_Resources/list.ser"))) {

            oos.writeObject(list);

            List<Double> listFromFile = (List<Double>) ois.readObject();

            listFromFile.forEach(element -> System.out.print(element+ " "));


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
