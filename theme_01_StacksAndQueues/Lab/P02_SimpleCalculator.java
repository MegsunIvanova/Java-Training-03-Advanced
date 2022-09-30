package theme_01_StacksAndQueues.Lab;

import java.util.*;

public class P02_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] expression = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = expression.length - 1; i >= 0; i--) {
            stack.push(expression[i]);
        }

        while (stack.size() > 1) {
            int firstNum = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int secondNum = Integer.parseInt(stack.pop());

            switch (operator) {
                case "+":
                    stack.push(String.valueOf(firstNum + secondNum));
                    break;
                case "-":
                    stack.push(String.valueOf(firstNum - secondNum));
                    break;
            }
        }


        System.out.println(stack.pop());
    }
}
