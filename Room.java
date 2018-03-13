import java.util.HashMap;
import java.util.Set;

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
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class Room 
{
    private String description;
    private HashMap<String, Room> exitsMap;

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
     * Return a description of the room�s exits.
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
}
