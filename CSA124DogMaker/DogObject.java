/*
* Activity 1.2.4
* DogObject
*
* V1.0
* 6/1/2019
* Copyright(c) 2019 PLTW to present. All rights reserved
*/
import java.awt.Dimension; 
import java.awt.Toolkit;

/** 
* Represents a simple Dog class in the GUI
*/
public class DogObject
{    
  private static final int DOG_W = 144, DOG_H = 137;
  private static final double ORIG_SCREEN_W = 500.0, ORIG_SCREEN_H = 580.0;
  private static final double ORIG_X = .55, ORIG_Y = .4;
  
  private static int numDogs = 0;
  
  private int x, y, width, height;
  private String identifier;
  private String color;

  private boolean eat, sit, speak, walk;

  public DogObject(String identifier)
  {       
    this.identifier = identifier;  
    numDogs++;
    color = "Red";

    // location based on screen size and number of dogs
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double currH = screenSize.getHeight(); 
    double currW = screenSize.getWidth();  
    x = (int)(ORIG_X * currW + numDogs * .07 * currW);  
    y = (int)(ORIG_Y * currH + numDogs * .07 * currW);
    
    double scaleY = 1.0;
    double scaleX = 1.0;
    // adjust size of dog for smaller screen size only
    if  (currW < ORIG_SCREEN_W || currH < ORIG_SCREEN_H)  
    {
      scaleX = currW/ORIG_SCREEN_W * .7;
      scaleY = currH/ORIG_SCREEN_H * .7;
      // adjust for extra wide
      if(currW/currH > ORIG_SCREEN_W/ORIG_SCREEN_H)
      {
        scaleX *= ORIG_SCREEN_W/currW;
      }
      // adjust for extra narrow
      if(currW/currH < ORIG_SCREEN_W/ORIG_SCREEN_H)
      {
        scaleY *= ORIG_SCREEN_H/currH;
      }

    }
    width = (int)(scaleX * DOG_W);
    height = (int)(scaleY * DOG_H);
  }

  public String toString()
  {
    return "<<<DogObject: " + identifier + " at (" + x + ", " + y + ") - Size: " + width + " x " + height + ">>>";
  }

  /**
   * @return the identifier
   */
  public String getIdentifier()
  {
    return identifier;
  }

  /**
   * @param identifier the identifier to set
   */
  public void setIdentifier(String identifier)
  {
    this.identifier = identifier;
  }

  /**
   * @return the numDogs
   */
  public static int getNumDogs()
  {
    return numDogs;
  }

  /**
   * Increment nubmer of dogs 
   */
  private static void incrementNumDogs()
  {
    numDogs += 1;
  }

  /**
   * @return the x
   */
  public int getX()
  {
    return x;
  }

  /**
   * @param x the x to set
   */
  public void setX(int x)
  {
    this.x = x;
  }

  /**
   * @return the y
   */
  public int getY()
  {
    return y;
  }

  /**
   * @param y the y to set
   */
  public void setY(int y)
  {
    this.y = y;
  }

  /**
   * @return the height
   */
  public int getHeight()
  {
    return height;
  }

  /**
   * @param height the height to set
   */
  public void setHeight(int height)
  {
    this.height = height;
  }

  /**
   * @return the width
   */
  public int getWidth() 
  {
    return width;
  }

  /**
   * @param width the width to set
   */
  public void setWidth(int width)
  {
    this.width = width;
  }

  /**
   * @return the color
   */
  public String getColor()
  {
    return color;
  }

  /**
   * @param color the color to set
   */
  public void setColor(String color)
  {
    this.color = color;
  }
  
  /**
   * Set the dog state to eat
   */
  public void eat() 
  {
    eat = true;
    sit = false;
    speak = false;
    walk = false;
  }
  /**
   * Set the dog state to sit
   */
  public void sit() 
  {
    eat = false;
    sit = true;
    speak = false;
    walk = false;
  }

  /**
   * Set the dog state to speak
   */
  public void speak()
  {
    eat = false;
    sit = false;
    speak = true;
    walk = false;
  }

  /**
   * Set the dog state to walk
   */
  public void walk()
  {
    eat = false;
    sit = false;
    speak = false;
    walk = true;
  }

  /**
   * Determine if the dog is eating
   * 
   * @return true if dog is in eat state, false otherwise
   */
  public boolean isEating() 
  {
    return eat;
  }
 
  /**
   * Determine if the dog is sitting
   * 
   * @return true if dog is in sit state, false otherwise
   */
  public boolean isSitting() 
  {
    return sit;
  }
  
  /**
   * Determine if the dog is speaking
   * 
   * @return true if dog is in speak state, false otherwise
   */
  public boolean isSpeaking()
  {
    return speak;
  }
  
  /**
   * Determine if the dog is walking
   * 
   * @return true if dog is in walk state, false otherwise
   */
  public boolean isWalking()
  {
    return walk;
  }

}