package Exam_Paractice;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P01_FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Character> vowelsQueue = Arrays.stream(scanner.nextLine()
                        .split("\\s+")).map(s -> s.charAt(0))
                .collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Character> consonantsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(s -> s.charAt(0))
                .forEach(consonantsStack::push);

        Map<String, boolean[]> wordsMap = new LinkedHashMap<>();
        wordsMap.put("pear", new boolean["pear".length()]);
        wordsMap.put("flour", new boolean["flour".length()]);
        wordsMap.put("pork", new boolean["pork".length()]);
        wordsMap.put("olive", new boolean["olive".length()]);


        //process until there are no more consonant letters left
        while (!consonantsStack.isEmpty()) {
            //taking the first character of the vowels collection and
            // the last character from the consonants collection
            char vowel = vowelsQueue.poll();
            char consonant = consonantsStack.pop();

            //check if these letters are present in one or more of the given words
            for (var entry : wordsMap.entrySet()) {
                String word = entry.getKey();
                if (word.contains(String.valueOf(vowel))) {
                    int index = word.indexOf(vowel);
                    entry.getValue()[index] = true;
                }
                if (word.contains(String.valueOf(consonant))) {
                    int index = word.indexOf(consonant);
                    entry.getValue()[index] = true;
                }
            }
            //vowel letter is always returned to the collection, whether used or not
            //consonant letter is always removed from the collection, whether used or not
            vowelsQueue.offer(vowel);

        }

        List<String> foundedWords = new ArrayList<>();
        wordsMap.entrySet().stream()
                .filter(entry -> entry.getKey().length() == lettersFound(entry.getValue()))
                .forEach(entry -> foundedWords.add(entry.getKey()));

        System.out.println("Words found: " + foundedWords.size());
        System.out.println(String.join(System.lineSeparator(), foundedWords));


    }

    private static int lettersFound(boolean[] array) {
        int lettersFound = 0;
        for (boolean result : array) {
            if (result) {
                lettersFound++;
            }
        }
        return lettersFound;
    }
}
