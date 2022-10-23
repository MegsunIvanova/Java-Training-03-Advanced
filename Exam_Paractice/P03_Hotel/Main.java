package Exam_Paractice.P03_Hotel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Initialize the repository (hotel)
        Hotel hotel = new Hotel("Hilton", 30);

        //Initialize entity
        Person person = new Person("Mark", 11111, 41, "Sofia");

        //Print person
        System.out.println(person);
        //Person Mark: 11111, Age: 41, Hometown: Sofia
        System.out.println("---");

        //Add person
        hotel.add(person);
        //count
        System.out.println(hotel.getCount()); //1
        System.out.println("---");
        //remove
        System.out.println(hotel.remove("Anna")); //false
        System.out.println("---");

        Person firstPerson = new Person("Alice", 22121, 18, "London");
        Person secondPerson = new Person("Lizzy", 31311, 24, "Varna");
        Person thirdPerson = new Person("Lucy", 54122, 31, "Birmingham");
        Person fourthPerson = new Person("Maria", 66611, 41, "Sofia");
        //Add people
        hotel.add(firstPerson);
        hotel.add(secondPerson);
        hotel.add(thirdPerson);
        hotel.add(fourthPerson);

        // Get person
        Person personForGet = hotel.getPerson("Lucy", "Birmingham");
        Person personForGet1 = hotel.getPerson("Anna", "Burgas");
        System.out.println(personForGet); // Person Lucy: 54122, Age: 31, Hometown: Birmingham
        System.out.println(personForGet1); // null
        System.out.println("---");

        //Count
        System.out.println(hotel.getCount()); // 5
        System.out.println("---");

        //Remove Person
        System.out.println(hotel.remove("Alice")); //true
        System.out.println("---");

        // Get Statistics
        System.out.println(hotel.getStatistics());
        // The people in the hotel Hilton are:
        // Person Mark: 11111, Age: 41, Hometown: Sofia
        // Person Lizzy: 31311, Age: 24, Hometown: Varna
        // Person Lucy: 54122, Age: 31, Hometown: Birmingham
        // Person Maria: 66611, Age: 41, Hometown: Sofia


    }
}
