import java.util.HashMap;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Julio Cachón Villadangos
 * @version 2018.03.14
 */

public class CommandWords
{
    // a constant array that holds all valid command words
    private HashMap<String, CommandWord> validCommands;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        validCommands = new HashMap<>();
        validCommands.put("go", CommandWord.GO);
        validCommands.put("help", CommandWord.HELP);
        validCommands.put("quit", CommandWord.QUIT);
        validCommands.put("help", CommandWord.HELP);
        validCommands.put("look", CommandWord.LOOK);
        validCommands.put("eat", CommandWord.EAT);
        validCommands.put("back", CommandWord.BACK);
        validCommands.put("take", CommandWord.TAKE);
        validCommands.put("drop", CommandWord.DROP);
        validCommands.put("items", CommandWord.ITEMS);
        validCommands.put("unknown", CommandWord.UNKNOWN);
        validCommands.put("usechair", CommandWord.USECHAIR);
    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        if(validCommands.containsKey(aString)){
            return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }

    /**
     * Return all the valid commands.
     */
    public String getCommandList()
    {
        String commands = "";
        commands += validCommands.keySet();
        return commands;
    }
}
