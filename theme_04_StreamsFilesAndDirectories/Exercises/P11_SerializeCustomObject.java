package theme_04_StreamsFilesAndDirectories.Exercises;

import java.io.*;

public class P11_SerializeCustomObject {

    public static class Course implements Serializable {
        String name;
        int numberOfStudents;
    }

    public static void main(String[] args) {
        Course course = new Course();
        course.name = "Java Advanced";
        course.numberOfStudents = 250;

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Resources/theme_04_Exercises_Resources/course.ser"));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Resources/theme_04_Exercises_Resources/course.ser"))) {
            oos.writeObject(course);
            Course courseFromFile = (Course) ois.readObject();
            System.out.println(courseFromFile.name);
            System.out.println(courseFromFile.numberOfStudents);

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

    }

}
