import java.util.Stack;

/**
 * Write a description of class Player here.
 *
 * @author Julio Cachón Villadangos
 * @version 2018.03.23
 */
public class Player
{
    private Room currentRoom;
    private Stack<Room> moveRooms;
    
    /**
     * Constructor for objects of class Player
     */
    public Player(Room currentRoom)
    {
        // initialise instance variables
        this.currentRoom = currentRoom;
        moveRooms = new Stack<>();
    }

    public Room getRoom()
    {
        return currentRoom;
    }
    
    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    public void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            moveRooms.push(currentRoom);
            currentRoom = nextRoom;
            look();
        }
    }
    
    /**
     * Return to the previous room
     */
    public void back()
    {
        if(!moveRooms.empty()){
            currentRoom = moveRooms.pop();
            look();
        }        
    }
    
    /**
     * Take a look of the exits for the current room
     */
    public void look()
    {
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Eat some food
     */
    public void eat()
    {
        System.out.println("You have eaten now and you are not hungry any more");
    }
}
