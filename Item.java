/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds create objets Item.
 *
 * @author  Julio Cachón Villadangos
 * @version 2018.03.14
 */

public class Item
{
    // a constant array that holds all valid command words
    private String itemDescription;
    private double itemWeight;
    
    /**
     * constructor for an Item of the class Item.
     */
    public Item(String itemDescription, double itemWeight)
    {
        this.itemDescription = itemDescription;
        this.itemWeight = itemWeight;        
    }
    
    /**
     * Return the description and weight of an Item.
     */
    public String getItemInfo()
    {
        return "There is " + itemDescription + ", " 
        + itemWeight + "kg.";
    }
}
