import java.util.Scanner;  // added to allow keyboard input

class Magic8Ball {
  public static void main(String[] args) 
  {
    
    // Tell the user to enter a question
    Scanner scan = new Scanner(System.in);
    System.out.println("Welcome to the Magic 8 Ball!");
    System.out.print("Enter your question and I will answer it: ");
    String question = scan.nextLine();
     
    // Get a random number from 1 to 8
    int num = (int)(Math.random() * 8 + 1);
    System.out.println(num);
    // Use if statements to print out 1 of 8 responses
    if (num == 1)
    System.out.println("It is certain");
    else if (num == 2)
    System.out.println("It is decidedly so");
    else if (num == 3)
    System.out.println("Outlook good");
    else if (num == 4)
    System.out.println("Don’t count on it");
    else if (num == 5)
    System.out.println("My sources say no");
    else if (num == 6)
    System.out.println("Outlook not so good");
    else if (num == 7)
    System.out.println("Reply hazy, try again");
    else if (num == 8)
    System.out.println("Ask again later");
    else
    System.out.println("Error");
   }
}