import java.util.HashMap;
import java.util.Scanner;

/*
На вход подаётся текст, слова отделяются пробелами, для каждого слова необходимо вывести количество его повторений.
*/
public class Task7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString;
        String[] wordsInLine;
        HashMap<String, Integer> wordRepeats = new HashMap<>();
        while (sc.hasNext()){
            inputString = sc.nextLine();
            wordsInLine = inputString.split("\\s+");
            for (String word : wordsInLine) {
                word = word.toLowerCase();
                if (!wordRepeats.containsKey(word)){
                    wordRepeats.put(word, 1);
                }
                else {
                    wordRepeats.put(word, wordRepeats.get(word) + 1);
                }
            }
            for (String word : wordRepeats.keySet()){
                System.out.println("The text contain word: "+ word + " and it repeats " + wordRepeats.get(word) + " time(s)");
            }
        }
    }
}
