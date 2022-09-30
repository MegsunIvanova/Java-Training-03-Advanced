package theme_02_MultidimensionalArrays.Lab;

public class DemoMultidimensionalArr {
    public static void main(String[] args) {

//        int[] arr1 = {};
//        int[] arr2 = {13, 42, 69};
//        int[] arr3 = new int[3];
//        //code to insert the elements

        //деклариране и създаване на multidimensional array
        int[][] matrix1 = new int[4][];//трябва да се окаже размера поне на едно от измеренията
        int[][] matrix2 = {
                {13, 42, 69},
                {13, 42, 69},
                {13, 42, 69}
        };

        int[][] matrix = new int[3][4];

        int start = 1;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 4; row++) {
                matrix[row][col] = start;
                start++;
            }
        }

//        matrix = new int[][] {
//                arr0,
//                arr1,
//                arr2
//        };


        //достъпване на елементи на multidimensional array

    }
}
