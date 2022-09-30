package theme_03_SetsAndMapsAdvanced.Exercises;

import java.util.*;

public class P08_UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        TreeMap<String, LinkedHashMap<String, Integer>> usersMap = new TreeMap<>();
        //Attacker                      IP     Counter


        while (!input.equals("end")) {
            String[] inputParts = input.split(" ");

            String ipParts = inputParts[0];
            String userNameParts = inputParts[2];
            String ipAddress = ipParts.substring(3);
            String userName = userNameParts.substring(5);

            usersMap.putIfAbsent(userName, new LinkedHashMap<>());
            usersMap.get(userName).putIfAbsent(ipAddress, 0);
            int counter = usersMap.get(userName).get(ipAddress) + 1;
            usersMap.get(userName).put(ipAddress, counter);

            input = scanner.nextLine();
        }

        for (var attacker : usersMap.entrySet()) {
            System.out.printf("%s: \n", attacker.getKey());
            LinkedHashMap<String, Integer> attacks = attacker.getValue();
            StringBuilder sb = new StringBuilder();

            for (var singleIPAttack : attacks.entrySet()) {
                String formattedAttack = String.format("%s => %d, ", singleIPAttack.getKey(), singleIPAttack.getValue());
                sb.append(formattedAttack);
            }
            String finalOutput = sb.substring(0, sb.length() - 2) + ".";

            System.out.println(finalOutput);


        }
    }
}
