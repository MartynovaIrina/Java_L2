// https://acmp.ru/index.asp?main=task&id_task=70
//Степень строки

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task5 {
    private static String stringInput = "";
    private static int pow = 0;
    private static StringBuilder pattern = new StringBuilder();
    private static int maxLength = 1023;

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("INPUT.TXT"));
            stringInput = scanner.nextLine();
            pow = scanner.nextInt();
            scanner.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
            try (FileWriter writer = new FileWriter("OUTPUT.TXT", false)) {
                if (pow > 0){
                StringBuilder stringPow = new StringBuilder();
                for (int i = 0; i < pow; i++){
                    stringPow.append(stringInput);
                    if (stringPow.length() > maxLength)
                    {   writer.write(stringPow.substring(0, maxLength));
                        break;
                    }
                }
                if (stringPow.length() <= maxLength){
                writer.write(stringPow.toString());}}
                else {
                    pow *= -1;
                    String patternString;
                    int slicePattern = stringInput.length() / pow;
                    for (int i = 0; i < slicePattern; i++) {
                        pattern.append(stringInput.charAt(i));
                    }
                    patternString = pattern.toString();
                    if (patternString.repeat(pow).equals(stringInput)){
                        if (patternString.length() <= maxLength) {
                            writer.write(patternString);
                        }
                        else {
                            writer.write(patternString.substring(0, maxLength));
                        }}
                    else {
                        writer.write("NO SOLUTION");
                    }
                }
                writer.flush();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }


