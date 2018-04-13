import java.util.Stack;
import java.util.ArrayList;

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
    private ArrayList<Item> inventory;
    private double maxWeight;
    private double inventoryWeight;

    /**
     * Constructor for objects of class Player
     */
    public Player(Room currentRoom)
    {
        // initialise instance variables
        this.currentRoom = currentRoom;
        moveRooms = new Stack<>();
        inventory = new ArrayList<>();
        maxWeight = 5;
        inventoryWeight = 0;
    }

    /**
     * Return the current room
     * 
     * @return currentoRoom
     */
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
            System.out.println("There is no door!\n");
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

    /**
     * Take an Item from the current room
     */
    public void take(String secondWord) //Item second word of the command)
    {
        // if there is no second word, we don't know what to take...
        if(secondWord == null){
            System.out.println("Take what?");
        }
        else{
            //if there are items in the rooms
            if(currentRoom.emptyRoom() == false){
                Item itemTaken = currentRoom.getItemRoom(secondWord);
                if(itemTaken != null){
                    if(itemTaken.canBePickedUp() == true){
                        if((inventoryWeight + itemTaken.getItemWeight()) <= maxWeight){
                            //take current item
                            inventory.add(itemTaken);
                            inventoryWeight += itemTaken.getItemWeight();
                            currentRoom.removeItem(itemTaken.getId());
                            System.out.println("You have taken the item: " + itemTaken.getId() + ".");
                        }
                        else{
                            System.out.println("You can´t get over the max weight.");
                        }
                    }
                    else{
                        System.out.println("This item can´t be taken.");
                    }
                }
                else{
                    System.out.println("This item don´t exist.");
                }
            }
            else{
                System.out.println("There are no items to take in this room.");
            }
        }
    }

    /**
     * Use the wheelchair to take patients.
     */
    public void useWheelChair(String secondWord)
    {
        if(secondWord == null){
            System.out.println("Take who?");
        }
        else{
            //if there are items in the rooms
            if(currentRoom.emptyRoom() == false){
                Item chairWheel = null;
                for(Item chairWheelItem : inventory){
                    if(chairWheelItem.getId().equals("wheelchair")){
                        chairWheel = chairWheelItem;
                    }
                }
                if(chairWheel != null){
                    maxWeight = 100;
                    Item patient = currentRoom.getItemRoom(secondWord);
                    if(patient != null){
                        patient.changePickUpItem(true);
                        if(patient.canBePickedUp() == true){
                            if((inventoryWeight + patient.getItemWeight()) <= maxWeight){
                                //take current item
                                inventory.add(patient);
                                inventoryWeight += patient.getItemWeight();
                                currentRoom.removeItem(patient.getId());
                                System.out.println("You are moving the patient: " + patient.getId() + ".");
                            }
                            else{
                                System.out.println("You can´t get over the max weight.");
                            }
                        }
                        else{
                            System.out.println("This patient can´t be moved.");
                        }
                    }
                    else{
                        System.out.println("This patient don´t exist.");
                    }
                }
                else{
                    System.out.println("You haven´t the wheelchair in your inventory.");
                }
            }
            else{
                System.out.println("There are no items to take in this room.");
            }
        }
    }

    /**
     * Drop an item in the current room.
     */
    public void dropItem(String secondWord)
    {
        if(secondWord == null){
            System.out.println("Drop what?");
        }
        else{
            if(!inventory.isEmpty()){
                boolean found = false;
                for(int i = 0; i < inventory.size() && !found; i++){
                    Item itemToDrop = inventory.get(i);
                    if(itemToDrop.getId().equals(secondWord)){
                        if(itemToDrop.getId().equals("wheelchair")){
                            maxWeight = 5;
                            for(Item patient : inventory){
                                if(patient.getId().equals("patient")){
                                    patient.changePickUpItem(false);
                                }
                            }
                        }
                        if(itemToDrop.getId().equals("patient")){
                            itemToDrop.changePickUpItem(false);
                        }                   
                        currentRoom.addItem(itemToDrop);
                        inventoryWeight -= itemToDrop.getItemWeight();
                        inventory.remove(itemToDrop);
                        found = true;
                        System.out.println("You have droped the item: " + itemToDrop.getId() + ".");
                    }
                }
            }
            else{
                System.out.println("Your inventory is empty.");
            }
        }
    }

    /**
     * Show the items of the player´s inventory.
     */
    public void showItems()
    {
        if(inventory.size() != 0){
            System.out.println("You have:");
            for(Item item : inventory){
                System.out.println(item.getItemInfo());
            }
            System.out.println("\nInventoryWeight: " + inventoryWeight + " kg.");
        }
        else{
            System.out.println("There are no items in your inventory.");
        }
    }
}
