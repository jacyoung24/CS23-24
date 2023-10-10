/**
 * MadLibRunner class
 *
 * @author (Jim Greenlee)
 * @version (Oct 1, 2021)
 */
public class MadLibRunner
{
  public static void main(String[] args)
  {
    // Create a MadLib
    MadLib m1 = new MadLib("I went to the animal <noun>, the <plural noun> and the <number> beasts were there.");
    System.out.println(m1);
    
    // Create another MadLib
    MadLib m2 = new MadLib("Once upon a time in a <adjective> land, a <noun> <adverb> grew.");
    System.out.println(m2);
    
    // Change the riddle of m1
    m1.setRiddle("The <noun> in <country> stays <adverb> in the <noun>.");
    System.out.println(m1);
    
    // Create a new story for m2
    m2.setRiddle("Do you <verb> your <adjective> <noun> <adverb>? That's hilarious!");
    System.out.println(m2);
  }
}
