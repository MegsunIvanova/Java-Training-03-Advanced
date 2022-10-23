package theme_10_Workshop_BasicAlgorithms;

public class Demo_01_Recursion {
    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }

        System.out.println();

        print(1);

    }

    private static void print(int i) {
        if (i > 10) {
            return;
        }
        System.out.println("PRE recursive call " + i);
        //Pre call

        print(i + 1);//call
        //BACKTRACKING
        System.out.println("POST recursive call " + i);
    }
}
