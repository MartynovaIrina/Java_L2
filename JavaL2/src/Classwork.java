import java.util.Scanner;

public class Classwork {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of starts you'd like to print");
        int lineLength= scanner.nextInt();
        printNStarsLine(lineLength);
        System.out.println();

        System.out.println("Please enter size of square");
        int squareSize = scanner.nextInt();
        printNxNSquare(squareSize);

        System.out.println("Please enter the length of rectangular");
        int length = scanner.nextInt();
        System.out.println("Please enter the height of rectangular");
        int height = scanner.nextInt();
        printStarsRectangular(length, height);

        System.out.println("To check if two numbers can be divided without a mode, please enter the first number:");
        int number1 = scanner.nextInt();
        System.out.println("Please enter a second number:");
        int number2 = scanner.nextInt();
        System.out.println(twoNumbersDividedWithoutMode(number1, number2));

        System.out.println("To calculate factorial of a number, please enter a number");
        int n = scanner.nextInt();
        System.out.println("Loop solution");
        System.out.println(factorialCustomV1(n));

        System.out.println("To calculate factorial of a number, please enter a number");
        int number = scanner.nextInt();
        System.out.println("Recursive solution");
        System.out.println(factorialCustomV2(number));
    }

    public static void printNStarsLine(int lineLength) {
        System.out.println("*".repeat(lineLength));
        /*for (int i = 0; i < n; i++){
            System.out.print("*");}*/
    }

    public static void printNxNSquare(int squareSize){
        for (int i = 0; i < squareSize; i++){
            System.out.println("*".repeat(squareSize));
        }
    }

    public static void printStarsRectangular(int length, int height) {
        for (int i = 0; i < height; i++){
            System.out.println("*".repeat(length));
        }
        /* for (int i = 0; i < height; i++){
            for (int j = 0; j < length; j++){
                System.out.print("*");
            }
            System.out.println();
        }*/
    }

    public static boolean twoNumbersDividedWithoutMode(int number1, int number2){
        return number1 % number2 == 0;
    }

    public static int factorialCustomV1(int n){
        int result = 1;
        for (int i = 2; i <= n; i++){
            result *= i;
        }
        return result;
    }

    public static int factorialCustomV2(int n){
        if (n == 0){
            return 1;
        }
        return factorialCustomV2(n - 1) * n;

    }

}