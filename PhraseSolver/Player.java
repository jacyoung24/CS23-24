/*
 * Activity 2.5.2
 * 
 * A Player class the PhraseSolverGame
 */
import java.util.Scanner;

public class Player
{
  /* your code here - attributes */

  /* your code here - constructor(s) */ 
  public Player()
  {
    System.out.println("Enter Player Name:");
    Scanner sc = new Scanner(System.in);
    String newName = sc.nextLine();

    String name = newName;
    System.out.println("Hello and welcome to the game, " + name);
  }

  public Player(String inputName)
  {
    String name = inputName;
    int points = 0;
    System.out.println("Hello and welcome to the game, " + name);
  }

  /* your code here - accessor(s) */ 
  public String getName()
  {
    
  }

  public int getPoints()
  {
  
  }

  /* your code here - mutator(s) */ 
  public void setName(String inputName)
  {
  
  }

  public void addToPoints(int value)
  {
  
  }
}