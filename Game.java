import java.util.Stack;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Julio Cach�n Villadangos
 * @version 2018.03.13
 */

public class Game 
{
    private Parser parser;
    private Player player;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        parser = new Parser();
        player = new Player(createRooms());
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private Room createRooms()
    {
        Room hall, habitaciones, cafeteria, consulta, escaner, preoperatorio, quirofano;
        Item wheelchair, coat, receptionTable, patient, potty, television, bed, coffee, chair, notebook, safeboard, antibiotic, bandages, scalpel;

        // create the rooms
        hall = new Room("in the hall");
        habitaciones = new Room("in the bedrooms");
        cafeteria = new Room("in the buffet");
        consulta = new Room("in the consulting room");
        escaner = new Room("in the scaner room");
        preoperatorio = new Room("in the preoperative room");
        quirofano = new Room("in the operating theater");

        //create the items of the rooms
        wheelchair = new Item("wheelchair", "a wheelchair", 3, true);
        coat = new Item("coat", "a coat", 0.5, true);
        receptionTable = new Item("table", "a reception table", 15, false);
        patient = new Item("patient", "a patient", 80, false);
        potty = new Item("potty", "a potty", 0.3, true);
        television = new Item("television", "a television", 6, false);
        bed = new Item("bed", "a bed", 25, false);
        coffee = new Item("coffee", "a coffee", 0.2, true);
        chair = new Item("chair", "a chair", 1, false);
        notebook = new Item("notebook", "a notebook", 0.1, true);
        safeboard = new Item("safeboard", "a safeboard", 5, true);
        antibiotic = new Item("antibiotic", "an antibiotic", 0.2, true);
        bandages = new Item("bandage", "bandage", 0.2, true);
        scalpel = new Item("scalpel", "a scalpel",0.1, true);

        //add the item to the rooms
        hall.addItem(wheelchair);
        hall.addItem(coat);
        hall.addItem(receptionTable);
        habitaciones.addItem(patient);
        habitaciones.addItem(potty);
        habitaciones.addItem(television);
        habitaciones.addItem(bed);
        cafeteria.addItem(coffee);
        cafeteria.addItem(chair);
        //consulta.addItem(notebook);
        escaner.addItem(safeboard);
        preoperatorio.addItem(antibiotic);
        preoperatorio.addItem(bandages);
        quirofano.addItem(scalpel);

        // initialise room exits
        hall.setExit("east", consulta);
        hall.setExit("west", habitaciones);
        hall.setExit("southEast", cafeteria);
        habitaciones.setExit("east", hall);
        cafeteria.setExit("north", consulta);
        cafeteria.setExit("east", preoperatorio);
        cafeteria.setExit("northWest", hall);
        consulta.setExit("north", escaner);
        consulta.setExit("south", cafeteria);
        consulta.setExit("west", hall);
        consulta.setExit("southEast", preoperatorio);
        escaner.setExit("east", quirofano);
        escaner.setExit("south", consulta);
        preoperatorio.setExit("west", cafeteria);
        preoperatorio.setExit("northWest", consulta);
        quirofano.setExit("west", escaner);
        quirofano.setExit("southEast", preoperatorio);

        // start game in the hall
        return hall;
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        player.look();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            player.goRoom(command);
        }
        else if(commandWord.equals("look")) {
            player.look();
        }
        else if (commandWord.equals("eat")) {
            player.eat();
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        else if (commandWord.equals("back")) {
            player.back();
        }
        else if (commandWord.equals("take")) {
            player.take(command.getSecondWord());
        }
        else if (commandWord.equals("items")) {
            player.showItems();
        }
        else if (commandWord.equals("drop")) {
            player.dropItem(command.getSecondWord());
        }
        else if (commandWord.equals("useChair")) {
            player.useWheelChair(command.getSecondWord());
        }

        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println(parser.showCommands());
    }
    
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
