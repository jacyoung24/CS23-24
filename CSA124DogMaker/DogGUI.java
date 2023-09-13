/*
* Activity 1.2.4
* DogGUI
*
* V1.0
* 6/1/2019
* Copyright(c) 2019 PLTW to present. All rights reserved
*/
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage; 
import java.awt.GraphicsEnvironment;
import java.awt.DisplayMode;

import javax.imageio.ImageIO;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.util.ArrayList;

/**
 * This program contains many elements that are outside the scope of CSA, including
 * graphics libraries, inner classes, image IO, Exception, and NumberFormatException
 * Students may take a look "under the hood" of this class and can expect to see
 * much familiar code but should not expect to understand all of it.
 */
public class DogGUI
{
  private static Image kitchenImage, dogImage, dogEatImage, dogSpeakImage, dogSitImage, dogWalkImage;
  public static boolean READY_TO_EXECUTE = false;
  private static CodeCompiler cc = new CodeCompiler();
  private static ArrayList<DogObject> dogs = new ArrayList<DogObject>();

  // GUI environment for screen size scaling
  private static GraphicsEnvironment ge;
  private static DisplayMode mode;

  public DogGUI()
  {
    ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    mode = ge.getDefaultScreenDevice().getDisplayMode();
    int screenH = (int)mode.getHeight();
    int screenW = (int)mode.getWidth(); 
    // System.out.println("screenSize w:" + screenW + " h:" + screenH);

    loadFiles(screenW, screenH);

    JFrame f = new JFrame("Object Creator");
    
    f.setSize(screenW, screenH); 
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel()
    {
      static final long serialVersionUID = 124L;
      @Override
      public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // draw background
        g.drawImage(kitchenImage, 0, 0, null);

        if (DogGUI.READY_TO_EXECUTE)
        {
          // note: only 1 dog allowed in this version
          for (DogObject dog : dogs)
          {
            System.out.println("Dog object: " + dog); 
            if (dog.isEating())
            {
              g.drawImage(dogEatImage, dog.getX(), dog.getY(), dog.getWidth(), dog.getHeight(), null);
            }
            else if (dog.isSitting())
            {
              g.drawImage(dogSitImage, dog.getX(), dog.getY(), dog.getWidth(), dog.getHeight(), null);
            }
            else if (dog.isSpeaking()) 
            {
              g.drawImage(dogSpeakImage, dog.getX(), dog.getY(), dog.getWidth(), dog.getHeight(), null);
            }
            else if (dog.isWalking())
            {
              g.drawImage(dogWalkImage, dog.getX(), dog.getY(), dog.getWidth(), dog.getHeight(), null);
            }
            else
            {
              g.drawImage(dogImage, dog.getX(), dog.getY(), dog.getWidth(), dog.getHeight(), null);
            }
          }
          System.out.println("Done processing dog\n");

        } 
        DogGUI.READY_TO_EXECUTE = false;
      } 
    };
    
    panel.setLayout(new BorderLayout());
    f.setContentPane(panel);

    int textW = (int)(.06 * screenW);
    final JTextField textInput = new JTextField(textW); 
    JScrollPane textPanel = new JScrollPane(textInput);

    final JButton button = new JButton("Execute");
    button.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        String content = textInput.getText();
        System.out.println("Command to execute: " + content);
        if (!content.contains(";"))
        {
          System.out.println("Error: Missing semi-colon in statement");
        }
        else
        {
          DogAction dogAct = cc.compile(content);

          if (dogAct != null)
          {
            applyDogAction(dogAct);
            DogGUI.READY_TO_EXECUTE = true;
            panel.repaint();
            textInput.setText("");   
          }
          else
          {
           System.out.println("Error: Could not compile command: " + content + "\n");
          }
        }
      }

      private void applyDogAction(DogAction dogAction)
      {
        boolean dogExists = false;
        for (DogObject dog : dogs)
        {
          if (dog.getIdentifier().equals(dogAction.getIdentifier()))
          {
            dogExists = true;
          }
        }
        if (!dogExists) // This should be a constructor
        {
          System.out.println("New dog identifier " + dogAction.getIdentifier());
          applyDogConstructor(dogAction);
        }
        else // The dog exists! This should be a method call.
        {
          System.out.println("Dog exists, identifier is " + dogAction.getIdentifier());
          applyDogMethod(dogAction);
        }
      }

      private void applyDogConstructor(DogAction dogAction)
      {
        if (dogAction.getAction().equals("Constructor 1"))
        {
          dogs.add(new DogObject(dogAction.getIdentifier()));
        }
        else 
        {
          System.err.println("Error: Could not execute dog action " + dogAction.getAction());
        }
      }

      private void applyDogMethod(DogAction dogAct)
      {
        String methodIdentifier = dogAct.getAction();
        System.out.println("Dog method should be: " + methodIdentifier);
      
        if (methodIdentifier.equals("setX") ||
          methodIdentifier.equals("setY") ||
          methodIdentifier.equals("setColor") ||
          methodIdentifier.equals("eat") ||
          methodIdentifier.equals("sit") ||
          methodIdentifier.equals("speak") ||
          methodIdentifier.equals("walk") )
        {
          System.out.println("Recognized method " + methodIdentifier);
          for (DogObject dog : dogs)
          {
            if (dog.getIdentifier().equals(dogAct.getIdentifier()))
            {
              String[] methodArgs = dogAct.getArgs();
              if (methodArgs != null)  // null args means illegal or undefined method call, ignore it
              {
                if (methodArgs[0].equals(""))
                {
                  // implememnt methods with empty param list
                  System.out.println("dogAction.getArgs() " + dogAct.getArgs());                
                  // methods with no params
                  if (methodIdentifier.equals("eat"))
                  {
                    dog.eat();
                  }
                  else if (methodIdentifier.equals("sit"))
                  {
                    dog.sit();
                  }
                  else if (methodIdentifier.equals("speak"))
                  {
                    dog.speak();
                  }
                  else if (methodIdentifier.equals("walk"))
                  {
                    dog.walk();
                  }
                }// methods with params (none in this version)
              } 
            }
          }
        }
        else
        {
          System.err.println("Error: Could not process " + methodIdentifier);
        }
      }
    });

    JPanel subPanel = new JPanel();
    subPanel.add(BorderLayout.NORTH, textPanel);
    subPanel.add(BorderLayout.SOUTH, button);
    subPanel.setSize(screenW-500,50);
    panel.add(BorderLayout.SOUTH, subPanel);
    panel.setVisible(true);

    f.getRootPane().setDefaultButton(button);
    f.setVisible(true);
  }

  private void loadFiles(int w, int h)
  {

    // a try is like an if statement, "throwing" an error if the body of the try fails
    try {     
      BufferedImage bufferedImage = ImageIO.read(new File("kitchenPorch.png"));
      kitchenImage = bufferedImage.getScaledInstance(w, h, Image.SCALE_DEFAULT);
    } catch (Exception e) { System.err.println("Warning: Could not open file kitchenPorch.png"); } 
    try {
      BufferedImage bufferedImage = ImageIO.read(new File("dog.png"));
      dogImage = bufferedImage.getScaledInstance(w, h, Image.SCALE_DEFAULT);    
    } catch (Exception e) { System.err.println("Warning: Could not open file dog.png"); } 
    try {
      BufferedImage bufferedImage = ImageIO.read(new File("dogEat.png"));
      dogEatImage = bufferedImage.getScaledInstance(w, h, Image.SCALE_DEFAULT);       
    } catch (Exception e) { System.err.println("Warning: Could not open file dogEat.png"); } 
    try {
      BufferedImage bufferedImage = ImageIO.read(new File("dogSpeak.png"));
      dogSpeakImage = bufferedImage.getScaledInstance(w, h, Image.SCALE_DEFAULT);     
    } catch (Exception e) {  System.err.println("Warning: Could not open file dogSpeak.png"); } 
    try {
      BufferedImage bufferedImage = ImageIO.read(new File("dogSit.png"));
      dogSitImage = bufferedImage.getScaledInstance(w, h, Image.SCALE_DEFAULT);       
    } catch (Exception e) { System.err.println("Warning: Could not open file dogSit.png"); } 
    try {
      BufferedImage bufferedImage = ImageIO.read(new File("dogWalk.png"));
      dogWalkImage = bufferedImage.getScaledInstance(w, h, Image.SCALE_DEFAULT); 
    } catch (Exception e) { System.err.println("Warning: Could not open file dogWalk.png"); } 
  }
}