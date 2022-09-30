package theme_03_SetsAndMapsAdvanced.Lab;

import java.util.Scanner;

public class Demo_Hash {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String first = "Hello from Java";
        String second = "The quick brown fox";
        String third = "jump over the lazy dog";

        int firstHash = first.hashCode();
        int secondHash = second.hashCode();
        int thirdHash = third.hashCode();

        System.out.println(firstHash);
        System.out.println(secondHash);
        System.out.println(thirdHash);

        System.out.println(scanner.nextLine().hashCode());

    }
}
