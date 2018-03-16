import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Julio Cachón Villadangos
 * @version 2018.03.13
 */
public class Room 
{
    private String description;
    private HashMap<String, Room> exitsMap;
    private ArrayList<Item> itemsRoom;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exitsMap = new HashMap<>();
        itemsRoom = new ArrayList<>();
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor The room in the given direction.
     */
    public void setExit(String direction, Room neighbor)
    {
        exitsMap.put(direction, neighbor);
    }

    /**
     * Return an exit
     * 
     * @param direction set the direction 
     * @return an exit
     */
    public Room getExit(String direction)
    {
        return exitsMap.get(direction);
    }

    /**
     * Return a description of the room´s exits.
     * For example: "Exits: north east west"
     * 
     * @return A description of the available exits.
     */
    public String getExitsString()
    {
        String exitsDescription = "Exits: ";
        Set<String> setMap = exitsMap.keySet();

        for(String direction : setMap){
            exitsDescription += direction + " ";
        }

        return exitsDescription;
    }
        
    /**
     * Return a description of the items.
     * 
     * @return A description of the available items.
     */
    public String getItemsString()
    {
        String itemDescription = "";
        for(Item item : itemsRoom){
            itemDescription += item.getItemInfo() + ".\n";
        }
        return itemDescription;
    }
    
    /**
     * Add an item to the current room
     */
    public void addItem(Item currentItem)
    {
        itemsRoom.add(currentItem);
    }
    
    /**
     * Return a long description of this room, of the form:
     *     You are in the 'name of room'
     *     Exits: north west southwest
     * @return A description of the room, including exits.
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitsString() + ".\n" + getItemsString();
    }
}
