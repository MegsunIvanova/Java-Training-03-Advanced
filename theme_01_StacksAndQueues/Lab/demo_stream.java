package theme_01_StacksAndQueues.Lab;

import java.util.stream.IntStream;

public class demo_stream {
    public static void main(String[] args) {


        //С цикъл:
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }

        //Със стриим:
        IntStream
                .rangeClosed(1, 10)
                .forEach(System.out::println);
    }
}
