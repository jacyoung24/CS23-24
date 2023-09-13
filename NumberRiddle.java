import java.util.Scanner;   // Scanners must be imported

public class NumberRiddle
{
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);   // create the Scanner
    System.out.print("Enter a number: ");  // prompt the user
    int yourNumber = in.nextInt();         // read and store the number
    int original = yourNumber;             // store the original number

    // do whatever processing needs to be done on the number
    System.out.println("You entered " + yourNumber);

    // the program should output its double, output six added to it, output that number divided in half, and, finally, output that number subtracted by the original number. In this way, the program displays each calculation, and of course, the final result of three.
    yourNumber *= 2;
    System.out.println("Double: " + yourNumber);
    yourNumber += 6;
    System.out.println("Six added: " + (yourNumber));
    yourNumber /= 2;
    System.out.println("Divided in half: " + yourNumber);
    yourNumber -= original;
    System.out.println("Subtracted by the original number: " + (yourNumber));

    in.close(); // close the Scanner
  }
}
