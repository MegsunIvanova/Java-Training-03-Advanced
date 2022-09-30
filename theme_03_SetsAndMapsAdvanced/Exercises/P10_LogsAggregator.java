package theme_03_SetsAndMapsAdvanced.Exercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class P10_LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLogs = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> usersDurationMap = new TreeMap<>();
        Map<String, TreeSet<String>> usersIPAddresses = new TreeMap<>();

        for (int i = 0; i < numberOfLogs; i++) {
            //"{IP} {user} {duration}".
            String[] input = scanner.nextLine().split(" ");
            String ipAddress = input[0];
            String userName = input[1];
            int duration = Integer.parseInt(input[2]);

            usersDurationMap.putIfAbsent(userName, 0);
            int updatedDuration = usersDurationMap.get(userName) + duration;
            usersDurationMap.put(userName, updatedDuration);

            usersIPAddresses.putIfAbsent(userName, new TreeSet<>());
            usersIPAddresses.get(userName).add(ipAddress);

        }

        for (var durationEntry : usersDurationMap.entrySet()) {
            String userName = durationEntry.getKey();
            int duration = durationEntry.getValue();
            String ipAddresses = String.join(", ", usersIPAddresses.get(userName));
            System.out.printf("%s: %d [%s]\n", userName, duration, ipAddresses);
        }

    }
}
