package theme_04_StreamsFilesAndDirectories.Exercises;

import java.io.*;
import java.util.Set;

public class P04_CountCharacterTypes {
    public static void main(String[] args) {

        String path = "Resources/theme_04_Exercises_Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        //•	a, e, i, o, u are vowels, only lower case.

        Set<Character> punctuationMarks = Set.of('!', ',', '.', '?');
        //•	Punctuation marks are (! , . ?).

        //•	All others are consonants.
        //•	Do not count whitespace.

        int countVowels = 0;
        int countPunctuationMarks = 0;
        int countConsonants = 0;

        try (FileReader fr = new FileReader(path);
             PrintWriter pw = new PrintWriter(new FileWriter("Resources/theme_04_Exercises_Resources/count-chars-out.txt"))) {

            int oneSymbol = fr.read();

            while (oneSymbol != -1) {
                char symbolAsChar = (char) oneSymbol;
                if (vowels.contains(symbolAsChar)) {
                    countVowels++;

                } else if (punctuationMarks.contains(symbolAsChar)) {
                    countPunctuationMarks++;

                } else if (!Character.isWhitespace(symbolAsChar)) {
                    countConsonants++;
                }

                oneSymbol = fr.read();
            }

            pw.println("Vowels: "+countVowels);
            pw.println("Consonants: "+countConsonants);
            pw.println("Punctuation: "+countPunctuationMarks);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }



        //   ;
        //pw.write(String.format("Vowels: %d%nConsonants: %d%nPunctuation: %d%n", countVowels, countConsonants, countPunctuationMarks));

        //Vowels: 41
        //Consonants: 72
        //Punctuation: 6


    }
}
