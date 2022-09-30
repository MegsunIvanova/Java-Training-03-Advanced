package theme_03_SetsAndMapsAdvanced.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class P08_AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, double[]> studentsMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String student = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble).toArray();
            studentsMap.put(student, grades);
        }

        studentsMap.entrySet().forEach(entry -> {
            String student = entry.getKey();
            double[] grades = entry.getValue();

            double avgGrade = 0;
            for (double grade : grades) {
                avgGrade += grade;
            }
            if (grades.length > 0) {
                avgGrade /= grades.length;
            }

            System.out.println(student+" is graduated with "+avgGrade);

        });
    }
}
