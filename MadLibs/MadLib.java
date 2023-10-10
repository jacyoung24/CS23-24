/**
 * MadLib class
 *
 * @author (Jim Greenlee)
 * @version (Oct 1, 2021)
 */
import java.util.Scanner;

public class MadLib
{
  private String riddle;
  private String story;
  
  /**
   * Constructor for the <code>MadLib</code> class.
   * Accepts a phrase that can be parsed as a MadLib riddle.
   * Labels and parts of speech that will be substituted are assumed to be enclosed in < ... > tags.
   * <p>
   * Post-conditions:
   *    <blockquote>
   *    The <code>story</code> variable contains a tag-substituted version of the <code>riddle</code> variable
   *    </blockquote>
   * </p>
   * 
   * @param phrase  The tagged text of the riddle
   */
  public MadLib(String phrase)
  {
    setRiddle(phrase);
  }
  
  /**
   * Accessor method for the <code>riddle</code> instance variable.
   * 
   * @return  The current value of the <code>riddle</code> variable
   */
  public String getRiddle(String ml)
  {
    return riddle;
  }
  
  /**
   * Mutator method for the <code>riddle</code> instance variable.
   * Sets the value of the <code>riddle</code> variable.
   * Calls the <code>generateStory</code> method to convert the riddle to a story
   * <p>
   * Post-conditions:
   *    <blockquote>
   *    The <code>story</code> variable contains a tag-substituted version of the <code>riddle</code> variable
   *    </blockquote>
   * </p>
   * 
   * @param phrase  The tagged text of the riddle
   */
  public void setRiddle(String phrase)
  {
    riddle = phrase;
    generateStory();
  }
  
  /**
   * Accessor method for the <code>story</code> instance variable.
   * 
   * @return  The current value of the <code>story</code> variable.
   */
  public String getStory()
  {
    return story;
  }
  
  /**
   * Converts a MadLib riddle to a story.
   * Copies the <code>riddle</code> variable to the story variable.
   * Parses the <code>story</code> variable for parts of speech enclosed in < ... > tags
   * Prompts the user to enter a label or part of speech as indicated and replaces the tag with the user input.
   * Loops through the <code>story</code> variable until all all tags have been replaced.
   * <p>
   * Pre-conditions:
   *    <blockquote>
   *    Each opening &lt; is matched by a closing &gt;
   *    <br>
   *    Labels and parts of speech enclosed in &lt; ... &gt; are valid
   *    </blockquote>
   * </p>
   */
  public void generateStory()
  {
    Scanner sc = new Scanner(System.in);
    story = riddle;

    while (story.indexOf("<") >= 0)
    {
      int start = story.indexOf("<");
      int end = story.indexOf(">");
      String tag = story.substring(start + 1, end);
      System.out.println("Enter a " + tag + ": ");
      String word = sc.nextLine();
      story = story.substring(0, start) + word + story.substring(end + 1);
    }
    sc.close();
  }
  
  /**
   * <code>toString</code> method for the <code>Madlib</code> class.
   * 
   * @return  The current value of the <code>story</code> variable.
   */
  public String toString()
  {
    return story;
  }
}
