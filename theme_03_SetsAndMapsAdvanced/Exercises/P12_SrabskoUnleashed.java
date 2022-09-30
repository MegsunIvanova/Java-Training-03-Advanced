package theme_03_SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P12_SrabskoUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Integer>> dataMap = new LinkedHashMap<>();
        //            venue                 singer    money

        String regex = "(?<singer>\\w+( \\w+)*)\\s@(?<venue>\\w+( \\w+)*)\\s(?<ticketsPrice>[0-9]+)\\s(?<ticketsCount>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            //"{singer} @{venue} {ticketsPrice} {ticketsCount}"
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String singer = matcher.group("singer");
                String venue = matcher.group("venue");
                int ticketsPrice = Integer.parseInt(matcher.group("ticketsPrice"));
                int ticketsCount = Integer.parseInt(matcher.group("ticketsCount"));
                int money = ticketsPrice * ticketsCount;
                dataMap.putIfAbsent(venue, new LinkedHashMap<>());
                dataMap.get(venue).putIfAbsent(singer, 0);
                int totalMoney = dataMap.get(venue).get(singer) + money;
                dataMap.get(venue).put(singer, totalMoney);
            }
            input = scanner.nextLine();
        }

        if (!dataMap.isEmpty()) {
            for (var venueEntry : dataMap.entrySet()) {
                String venue = venueEntry.getKey();
                System.out.println(venue);
                venueEntry.getValue().entrySet().stream().sorted((e1, e2) ->
                                e2.getValue().compareTo(e1.getValue()))
                        .forEach(singerEntry -> {
                            String singer = singerEntry.getKey();
                            int totalMoney = singerEntry.getValue();
                            System.out.printf("#  %s -> %d\n", singer, totalMoney);
                        });
            }
        }

    }
}

