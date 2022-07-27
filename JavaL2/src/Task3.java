import java.util.Scanner;

/*На вход подаётся номер билета, необходимо проверить является ли он счастливым.
Билет является счастливым если сумма первой половины чисел равна сумме второй половины чисел.
 */
public class Task3 {
    private  static int ticketLength;
    private static int ticketNumberInt = 0;
    private static int leftSideTicketSum = 0;
    private static int rightSideTicketSum = 0;
    private static Scanner scanner = new Scanner(System.in);
    private static int counter = 0;

    private static boolean luckyTicket = true;
    private static int numberOfRightTicketConditions = 2; //ticket should contain only numbers and has even numbers

    public static void main(String[] args) {
        getTicketNumber();
        if (luckyTicket){
            checkTicket();
        }
        scanner.close();
    }

    public static void getTicketNumber(){
        String ticketNumberString;

        System.out.println("Please enter a ticket number.");

        while (counter != numberOfRightTicketConditions) {

            ticketNumberString = scanner.next();
            counter = 0;

            if (ticketNumberString.length() % 2 != 0) {
                System.out.println("Ticket has odd digits. Therefore you have a regular ticket. Ride more and good luck!");
                luckyTicket = false;
                break;
            } else {
                counter++;
            }
            try {
                ticketNumberInt = Integer.parseInt(ticketNumberString);
                counter++;
            } catch (NumberFormatException e) {
                System.out.println("The ticket should contain only numbers. Please type the number again.");
            }
            if (counter == numberOfRightTicketConditions) {
                ticketLength = ticketNumberString.length();
            }
        }
    }
    public static void checkTicket(){
            for (int i = 0; i <= ticketLength; i++){
                if (i < ticketLength / 2){ //calculating the right side sum of the ticket
                    rightSideTicketSum += ticketNumberInt % 10; //mod 10 for getting the last digit
                }
                else { //calculating the left side sum of the ticket
                    leftSideTicketSum += ticketNumberInt % 10; //mod 10 for getting the last digit
                }
                ticketNumberInt /= 10; //dividing by 10 for getting rid of last digit
            }
            if (leftSideTicketSum == rightSideTicketSum && luckyTicket){
                System.out.println("Lucky ticket! Congrats! Now you can eat it!");
            }
            else {
                System.out.println("Regular ticket. Ride more and good luck!");
            }
        }
    }

