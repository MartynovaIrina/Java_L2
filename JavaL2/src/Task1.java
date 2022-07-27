
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

//Сделать игру быки и коровы (*) по аналогии с
//https://metaschool.ru/pub/games/bulls-and-cows/bulls.php.
public class Task1 {
    private static ArrayList<Integer> combinationToGuess = new ArrayList<>();

    private static ArrayList<Integer> combinationCurrentGuess = new ArrayList<>();
    private static final int sizeOfCombination = 4;

    private static ArrayList<Integer> currBulls = new ArrayList<>();
    private static int totalBulls = 0;
    private static int totalCows = 0;
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        generateCombinationToGuess();
        System.out.printf("Let's find all the bulls! Enter your %d-digit guess!\n", sizeOfCombination);

        while (totalBulls != sizeOfCombination){

            getCombinationCurrentGuess();

            while (combinationCurrentGuess.size() != sizeOfCombination){
                System.out.printf("Combination should contain %d unique digits.\n", sizeOfCombination);
                getCombinationCurrentGuess();
            }
            checkCombos();
        }
        System.out.println("Congratulations! You've guessed all bulls!");
        sc.close();
    }
    public static void generateCombinationToGuess(){
        int startRndNumber = 0;
        int endRndNumber = 10;
        int currNumber;
        Random random = new Random();

        while (combinationToGuess.size() != sizeOfCombination){
            currNumber = random.nextInt(startRndNumber, endRndNumber);
            if (!combinationToGuess.contains(currNumber)){
                combinationToGuess.add(currNumber);
            }
        }
        //System.out.println(combinationToGuess);
    }
    public static void getCombinationCurrentGuess(){
        combinationCurrentGuess.clear();
        String currentGuessString = sc.next();
        char currChar;
        int currDigit;

        for (int i = 0; i < currentGuessString.length(); i++){
            currChar = currentGuessString.charAt(i);
            currDigit = Character.getNumericValue(currChar);
            if (!combinationCurrentGuess.contains(currDigit)) {
                combinationCurrentGuess.add(currDigit);
            } else {
                System.out.println("Digits should be unique!");
                break;
            }
        }
    }

    public static void checkCombos(){

        currBulls.clear();
        totalBulls = 0;
        totalCows = 0;

        int currDigitInitCombo;
        int currentDigitGuessCombo;

        for (int i = 0; i < sizeOfCombination; i++){
            currDigitInitCombo = combinationToGuess.get(i);
            for (int j = 0; j < sizeOfCombination; j++){
                currentDigitGuessCombo = combinationCurrentGuess.get(j);
                if (i == j && currDigitInitCombo == currentDigitGuessCombo){
                    totalBulls++;
                    currBulls.add(currDigitInitCombo);
                } else if (currDigitInitCombo == currentDigitGuessCombo && !currBulls.contains(currDigitInitCombo)) {
                    totalCows++;
                }
            }
        }
        String currentComboString = combinationCurrentGuess.stream().map(Object::toString)
                .collect(Collectors.joining(""));
        System.out.print(currentComboString + ": ");
        System.out.println("number of bulls: " + totalBulls + ",   " + "number of cows: " + totalCows + "\n");
    }
}


