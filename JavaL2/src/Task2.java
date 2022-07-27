//На вход программы подаётся строка, в результате должно быть выведено является ли входная строка палиндромом.

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String stringToCheck = sc.nextLine().toLowerCase().replaceAll("\\W","");
        isStringPalindrome(stringToCheck);
        sc.close();
    }
    public static void isStringPalindrome(String stringToCheck){
        /* possible options but not the most suitable
        String reverseStringToCheck = "";
        for (int i = stringToCheck.length() - 1; i >= 0; i--) {
            reverseStringToCheck += stringToCheck.charAt(i));
        } or
        new StringBuilder(str).reverse().toString();*/
        boolean palindromeState = true;
        int indexForReverseOrder = stringToCheck.length() - 1;

        for (int indexForStraightOrder  = 0; indexForStraightOrder < stringToCheck.length()/2; indexForStraightOrder++){
            //the cycle goes until the middle of the string since we are going from both ends
                if (stringToCheck.charAt(indexForStraightOrder) != stringToCheck.charAt(indexForReverseOrder)){
                    System.out.println("The string isn't palindrome.");
                    palindromeState = false;
                    break;
                }
                else{
                    indexForReverseOrder--;
                }
        }
        if (palindromeState){
            System.out.println("The string is palindrome.");
        }
    }
}
