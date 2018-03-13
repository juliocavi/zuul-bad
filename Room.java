import java.util.HashMap;

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
 * @author  Michael KÃ¶lling and David J. Barnes
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
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    public void setExits(Room north, Room east, Room south, Room west, Room southEast, Room northWest) 
    {
        if(north != null)
            exitsMap.put("north", north);
        if(east != null)
            exitsMap.put("east", east);
        if(south != null)
            exitsMap.put("south", south);
        if(west != null)
            exitsMap.put("west", west);
        if(southEast != null)
            exitsMap.put("southEast", southEast);
        if(northWest != null)
            exitsMap.put("northWest", northWest);
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Return an exit
     * 
     * @param direction set the direction 
     * @return an exit
     */
    public Room getExit(String direction)
    {
        Room exit = null;
        if(direction.equals("north"))
            exit = exitsMap.get("north");
        if(direction.equals("east"))
            exit = exitsMap.get("east");
        if(direction.equals("south"))
            exit = exitsMap.get("south");
        if(direction.equals("west"))
            exit = exitsMap.get("west");
        if(direction.equals("southEast"))
            exit = exitsMap.get("southEast");
        if(direction.equals("northWest"))
            exit = exitsMap.get("northWest");   
        return exit;
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

        if(exitsMap.get("north") != null) {
            exitsDescription += "north ";
        }
        if(exitsMap.get("east") != null) {
            exitsDescription += "east ";
        }
        if(exitsMap.get("south") != null) {
            exitsDescription += "south ";
        }
        if(exitsMap.get("west") != null) {
            exitsDescription += "west ";
        }
        if(exitsMap.get("southEast") != null) {
            exitsDescription += "southEast ";
        }
        if(exitsMap.get("northWest") != null) {
            exitsDescription += "northWest ";
        }
        
        return exitsDescription;
    }
}
