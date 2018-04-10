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
    private String id;
    private String itemDescription;
    private double itemWeight;
    private boolean canBePickedUp;

    /**
     * constructor for an Item of the class Item.
     */
    public Item(String id, String itemDescription, double itemWeight, boolean canBePickedUp)
    {
        this.id = id;
        this.itemDescription = itemDescription;
        this.itemWeight = itemWeight;    
        this.canBePickedUp = canBePickedUp;
    }

    /**
     * Get id from an item
     * 
     * @return the id of an item
     */
    public String getId()
    {
        return id;
    }

    /**
     * Return the item´s weight.
     * 
     * @return the item´s weight like a double.
     */
    public double getItemWeight()
    {
        return itemWeight;
    }
    
    /**
     * Return true if the current item can be taken,
     * or false if it can´t be taken
     * 
     * @return a boolean, true or false
     */
    public boolean canBePickedUp()
    {
        return canBePickedUp;
    }

    /**
     * Return the description and weight of an Item.
     * 
     * @return a String eith the description of the items
     */
    public String getItemInfo()
    {
        return itemDescription + ", " 
        + itemWeight + " kg.";
    }
}
