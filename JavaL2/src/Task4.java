import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        System.out.println("Please enter a string.");
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        sc.close();
        int maxZeros = 0;
        int currZeros = 0;
        for(int i = 0; i < inputString.length(); i++){
            if (inputString.charAt(i) == '0'){
                currZeros++;
                if (currZeros > maxZeros) {
                    maxZeros = currZeros;
                }
            }
            else {currZeros = 0;}
        }

        System.out.println("Maximum consecutive zeros: " + maxZeros);
    }
}
