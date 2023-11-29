/*
 * Activity 2.4.1
 */
import java.util.Scanner;

public class GetDigits
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter an integer to see its digits: ");
    int number = sc.nextInt();

    /* Your code here */
    
    while (number > 0) {
        int digit = number % 10;
        System.out.println(digit);
        number = number / 10;
    }
  }
}