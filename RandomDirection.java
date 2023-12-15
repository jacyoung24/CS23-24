/*
* Activity 1.2.9
*/

public class RandomDirection
{
  public static void main(String[] args)
  {
    // set double direction to a random number from 0 to 8
    double direction = Math.random() * 8;
    if (direction < 1)
    {
      System.out.println("NORTH");
    }
    else if (direction < 2)
    {
      System.out.println("NORTH_EAST");
    }
    else if (direction < 3)
    {
      System.out.println("EAST");
    }
    else if (direction < 4)
    {
      System.out.println("SOUTH_EAST");
    }
    else if (direction < 5)
    {
      System.out.println("SOUTH");
    }
    else if (direction < 6)
    {
      System.out.println("SOUTH_WEST");
    }
    else if (direction < 7)
    {
      System.out.println("WEST");
    }
    else if (direction < 8)
    {
      System.out.println("NORTH_WEST");
    }
  }
}