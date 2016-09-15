import java.util.ArrayList;
import java.util.Random;

/**
 * Write a description of class Table here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Table
{
    // instance variables - replace the example below with your own
    public Deck thisDeck;
    private InputReader reader;
    private Random randomGenerator;
    public Card thisCard;
    public int points;

    /**
     * Constructor for objects of class Table
     */
    public Table()
    {
        reader = new InputReader();
        randomGenerator = new Random();
        welcome();
        startGame();

    }

    public void welcome()
    {
        System.out.println("Welcome to the Srinivasan Gambling Den.");
        System.out.println("Please stay and have a good time.");
        System.out.println("Cheating is not permitted in this game.");
        System.out.println();

    }

    public Card generateCard()
    {
        // Pick a random number for the index in the deck. 
        // The number will be between 0 (inclusive) and the size
        // of the list (exclusive).
        int index = randomGenerator.nextInt(thisDeck.size());
        thisCard = thisDeck.returnCard(index);
        thisCard.print();
        thisDeck.removeCard(index);
        return thisCard;
    }

    public boolean checkBust(int pValue)
    {
        if(pValue > 21)
        {
            return true;
        }
        return false;
    }

    public void startGame()
    {
        int round = 1;
        boolean gFinished = false; //a boolean check to see if the individual wants to step away from the table

        while(!gFinished)
        {

            if(round == 1)
            {
                System.out.println("Would you like to begin playing the game? Please use \"yes\" or \"no\" to respond.");

            }

            if(round > 1)
            {
                System.out.println("Would you like to keep playing the game? Please use \"yes\" or \"no\" to respond.");
            }

            String gInput = reader.getInput().trim().toLowerCase();

            if(!gInput.startsWith("yes") && !gInput.startsWith("no"))
            {
                System.out.println();
                System.out.println("You have entered an invalid input. Exiting the game now.");
                return;                
            }

            System.out.println();

            if(gInput.startsWith("no"))
            {
                gFinished = true;
                System.out.println("Thank you for visiting the Srinivasan Gambling Den. Come again soon.");
                return;
            }

            if(gInput.startsWith("yes"))
            {
                thisDeck = new Deck();
                System.out.println("This is Round " + round + " of the blackjack game.");
                System.out.println();
                boolean rFinished = false; //a boolean check to see if the individual wants to play a new hand
                points = 0; //maintains a running total of the points the player has in this round
                System.out.println("Please use \"hit\" or \"hold\" to indicate if you would like a card or to stop.");
                while(!rFinished)
                {
                    System.out.println();
                    String input = reader.getInput().trim().toLowerCase();

                    if(input.startsWith("hit"))
                    {
                        System.out.println("You have asked for a card.");
                        generateCard();
                        if (thisCard.aceCheck())
                        {
                            System.out.println("Would you like this Ace to be set to 1 or 11?");
                            String aceValInput = reader.getInput();
                            
                            if (aceValInput.equals("11"))
                            {
                                thisCard.setFaceValue11();
                            }
                            
                        }
                        points = points + thisCard.getFaceValue();
                        System.out.println("Your cards total " + points + " points.");

                        if(points == 21)
                        {
                            System.out.println();
                            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                            System.out.println("$$$$$$$$$$$$$ BLACKJACK $$$$$$$$$$$$$$$");
                            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                            System.out.println();
                            rFinished = true;
                        }

                        if(checkBust(points))
                        {
                            System.out.println();
                            System.out.println("***************************************");
                            System.out.println("***************************************");
                            System.out.println("************* BUSTED ******************");
                            System.out.println("***************************************");
                            System.out.println("***************************************");

                            System.out.println("You have busted. You have " + points + " points.");
                            System.out.println();
                            rFinished = true;

                        }

                    }
                    
                    if(input.startsWith("hold"))
                    {
                        System.out.println();
                        System.out.println("#######################################");
                        System.out.println("#######################################");
                        System.out.println("############## HOLD ###################");
                        System.out.println("#######################################");
                        System.out.println("#######################################");
                        System.out.println("You have a total of " + points + " points.");
                        rFinished = true;
                    }

                }
            }
            round++;
        }
    }

}
