/* 
 * Activity 1.1.3
 */
public class GalaxyWeight
{
  public static void main(String[] args)
  {
    int earth = 125;
    double jupiter = earth * (24.79/9.8);
    double uranus = earth * (10.67/9.8);
    double avg = (earth + jupiter + uranus) / 3;
    
    System.out.printf("Earth weight: %d\n", earth);
    System.out.printf("Jupiter weight: %.2f\n", jupiter);
    System.out.printf("Uranus weight: %.2f\n", uranus);
    System.out.printf("Average weight: %.2f\n", avg);
  }
}