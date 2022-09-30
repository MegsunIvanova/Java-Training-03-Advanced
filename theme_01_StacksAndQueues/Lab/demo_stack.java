package theme_01_StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class demo_stack {
    public static void main(String[] args) {

        //Създаване на stack
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        //Добавяне на елементи на върха на stack-a
        stack.push(13);
        stack.push(42);
        stack.push(69);
        stack.push(73);

//        for (Integer integer : stack) {
//            System.out.println(integer);
//        }

        while (stack.isEmpty()) {
            //Премахване на елемент от върха на стека
            int topElement = stack.pop();

            System.out.println(topElement);
        }

    }
}