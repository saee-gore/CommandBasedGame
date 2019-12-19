# TextBasedGame
#It is a text-based game which is coded in Java using BlueJ( integrated development environment).
#Game Description:
->At the start of the game you are in the lobby.You have been provided with a shovel when you enter the game.From the lobby you end up     in the Silver Stone Farm.
->You have one silver key buried in this farm which you have to find by digging the farm.
->After you find the silver key from the Silver Stone Farm, you head in the eastern direction and you end up in the Golden Daisy Farm.
->You have one golden key buried in this farm which you have to find by digging the farm.
->After you find the golden key from the Golden Daisy Farm, you end up in Mystery Door.
->For deciding which key is the correct key to the Mystery Door,answer one question for unlocking the Mystery Door.
->Behind the Mystery Door, Haunted Mansion is there which has one monster.A gun is provided to you for killing that monster.
->Kill that monster and you win the game!!!!!");
->Type 'dig'  before the direction name when you are digging in the farms and 'go' before the direction name when you are not digging in   the game.
->Type 'help' for any help and type 'quit' for quiting the game.

#There are 5 classes namely:-
#1)Command: It specifies how many arguments should be taken from user. In this game, user can give one or two argumnets only. 
#2)CommandWords: It specifies the keywords of the game.
#3)Parser:It scans the user's input and matches with the keyword and accordinggly runs the code.
#4)Room: It is used for navigation in 4 directions: N,E,S,W.
#5)Game: The main code for the actual game is written here.

#1. Command
public class Command
{
    private String commandWord;
    private String secondWord;

    public Command(String firstWord, String secondWord)
    {
        commandWord = firstWord;
        this.secondWord = secondWord;
    }

    public String getCommandWord()
    {
        return commandWord;
    }

    public String getSecondWord()
    {
        return secondWord;
    }

    public boolean isUnknown()
    {
        return (commandWord == null);
    }

    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}
#2.CommandWords
public class CommandWords
{
    private static final String[] validCommands = { "go","quit", "help","rome","Rome","ROME","shoot","dig","goldenkey","silverkey","question"};

    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) 
        {
            if(validCommands[i].equals(aString))
                return true;
        }
        
        return false;
    }
}


