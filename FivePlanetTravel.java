/* 
 * Activity 1.1.5
 */
public class FivePlanetTravel
{
  public static void main(String[] args)
  {
    // theplanets.org average distance from earth to the planets
    int mercury = 56974146;
    int venus = 25724767;
    int mars = 48678219;
    int jupiter = 390674710;
    int saturn = 792248270;

    // speed of light and our speed
    int lightSpeed =  670616629;
    lightSpeed /= 10;

    /* your code here */
    System.out.println("Mercury: " + mercury / lightSpeed + " seconds");
    System.out.println("Venus: " + venus / lightSpeed + " seconds");
    System.out.println("Mars: " + mars / lightSpeed + " seconds");
    System.out.println("Jupiter: " + jupiter / lightSpeed + " seconds");
    System.out.println("Saturn: " + saturn / lightSpeed + " seconds");

    // What is arithmetic overflow and what is its cause?
    // Arithmetic overflow is when the result of an arithmetic operation is too large to be represented by the data type used to store it.

    // What is meant by a widening conversion? Why might it be preferred over a narrowing conversion?
    // A widening conversion is when a value of one data type is converted to a value of another data type that is larger than the first.
  }
}
