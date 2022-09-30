package theme_03_SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P06_FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> map = new LinkedHashMap<>();
        String regex = "\\b[\\w]+@[\\w]+.(com|us|uk)\\b";
        Pattern pattern = Pattern.compile(regex);

        String name = scanner.nextLine();
        while (!name.equals("stop")) {
            String email = scanner.nextLine();
            Matcher matcher = pattern.matcher(email);
            if (!matcher.find()) {
                map.put(name, email);
            }

            name = scanner.nextLine();
        }

        map.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        });
    }
}
