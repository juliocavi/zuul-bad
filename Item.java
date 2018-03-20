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
    private String itemName;
    private String itemDescription;
    private double itemWeight;
    private boolean canBeTaken;
    
    /**
     * Constructor for an Item of the class Item.
     */
    public Item(String itemName, String itemDescription, double itemWeight, boolean canBeTaken)
    {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemWeight = itemWeight;    
        this.canBeTaken = canBeTaken;
    }
        
    /**
     * Return the description and weight of an Item.
     * 
     * @return a String with the complete details of the items
     */
    public String getItemInfo()
    {
        return "There is " + itemDescription + ", " 
        + itemWeight + "kg";
    }
    
    /**
     * Return the item´s name
     * 
     * @return the item´s name like a String
     */
    public String getItemName(){
        return itemName;
    }
    
    /**
     * Return the item´s description
     * 
     * @return the item´s description like a String
     */
    public String getItemDescription()
    {
        return itemDescription;
    }
    
    /**
     * Return the item´s weight
     * 
     * @return the item´s weight like a double
     */
    public double getItemWeight(){
        return itemWeight;
    }
    
    /**
     * Return true if the item to take can be taken, and false if it can´t be taken
     * 
     * @return a boolen for situations like, if the item can be taken, or if it can´t be taken
     */
    public boolean itemCanBeTaken(){
        return canBeTaken;
    }
}
