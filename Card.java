/*This is a test */
/**
 * Write a description of class Card here.
 * 
 * @author Nikhil Srinivasan
 * @version 09/14/2016
 * TESTING, this is a test of a change in the card class
 */
public class Card
{
    // instance variables - replace the example below with your own
    public String face;
    public String suit;
    public int faceValue;

    /**
     * Constructor for objects of class Card
     */
    public Card(String pFace, String pSuit, int pFaceValue)
    {
        face = pFace;
        suit = pSuit;
        faceValue = pFaceValue;
        
    }

    public String getFace()
    {
        return face;
    }

    public String getSuit()
    {
        return suit;
    }
    
    public int getFaceValue()
    {
        return faceValue;
    }
    
    public void setFaceValue11()
    {
        faceValue = 11;
    }
    
    public void print()
    {
        System.out.println("You got dealt a " + face + " of " + suit + " .");
        
    }
    
    public boolean aceCheck()
    {
        String aceFaceCheck = getFace();
        if (aceFaceCheck.equals("Ace"))
        {
            return true;
        }
        return false;
    }
    
}
