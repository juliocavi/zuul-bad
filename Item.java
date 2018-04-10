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
    
    /**
     * constructor for an Item of the class Item.
     */
    public Item(String id, String itemDescription, double itemWeight)
    {
        this.id = id;
        this.itemDescription = itemDescription;
        this.itemWeight = itemWeight;        
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
     * Return the description and weight of an Item.
     * 
     * @return a String eith the description of the items
     */
    public String getItemInfo()
    {
        return "There is " + itemDescription + ", " 
        + itemWeight + "kg";
    }
}
