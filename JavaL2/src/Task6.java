//https://acmp.ru/index.asp?main=task&id_task=231

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task6 {
    private static String stringInput = "";
    private static int lengthOfline = 40;

    private static StringBuilder finalString = new StringBuilder();

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("INPUT.TXT"));
            stringInput = scanner.nextLine();
            scanner.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        char currChar;
        String currNumberString = "";
        int currDigits = 1;
        for (int i = 0; i < stringInput.length(); i++){
            currChar = stringInput.charAt(i);
            if ( currChar>= 48 && currChar <= 57){
                currNumberString += currChar;
            }
            else{
                if (!currNumberString.isEmpty()){
                    currDigits = Integer.parseInt(currNumberString);
                }
                else {currDigits = 1;}
                finalString.append(Character.toString(currChar).repeat(currDigits));
                currNumberString = "";
            }
        }

        for (int i = 0; i < finalString.length(); i++){
            if (i != 0 && i % lengthOfline == 0 ){
                System.out.println();
                System.out.print(finalString.charAt(i));
            }
            else {
                System.out.print(finalString.charAt(i));
            }
        }
    }
}
