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

#3.Parser

import java.util.Scanner;

public class Parser 
{
    private CommandWords commands;  
    private Scanner reader;        

    public Parser() 
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    public Command getCommand() 
    {
        String inputLine;   
        String word1 = null;
        String word2 = null;
        System.out.print("> ");    
        inputLine = reader.nextLine();
        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();      
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();     
                
            }
        }

        if(commands.isCommand(word1)) {
            return new Command(word1, word2);
        }
        else {
            return new Command(null, word2); 
        }
    }
}

#4.Room
public class Room 
{
    public String description;
    public Room northExit;
    public Room southExit;
    public Room eastExit;
    public Room westExit;
    
    public Room(String description) 
    {
        this.description = description;
    }

    public void setExits(Room north, Room east, Room south, Room west) 
    {
        if(north != null)
            northExit = north;
        if(east != null)
            eastExit = east;
        if(south != null)
            southExit = south;
        if(west != null)
            westExit = west;
    }

    public String getDescription()
    {
        return description;
    }

}

#5.Game
class Game 
{
   private Parser parser;
   private Room currentRoom;
    
    Game() 
    {
        createRooms();
        parser = new Parser();
    }

    private void createRooms()
    {
        Room lobby,f1g1,f1g2,f1g3,f1g4, f1g5,f1g6,f2g1,f2g2,f2g3,f2g4, f2g5,f2g6, qd,m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,m13,m14,m15,m16,m17,m18;
      
        lobby = new Room("\nYou have entered the lobby.\nHere, your game starts!");
        f1g1 = new Room("");
        f1g2 = new Room("Keep digging, silver key is near you. \nType 'silverkey' for digging more...");
        f1g3 = new Room("");
        f1g4 = new Room("");
        f1g5 = new Room("You have entered Silver Stone Farm.\nYou have a shovel with you for finding the silver key.\nStart digging now!!!");
        f1g6 = new Room("");
        f2g1 = new Room("You have entered Golden Daisy Farm.\nYou have a shovel with you for finding the golden key.\nStart digging now!!!");
        f2g2 = new Room("");
        f2g3 = new Room("");
        f2g4 = new Room("");
        f2g5 = new Room("Keep digging, golden key is near you. \nType 'goldenkey' for digging more...");
        f2g6 = new Room("");
        qd = new Room("Mystery door has appeared!!! \nAnswer one question for knowing which key is the correct key to unlock the 'Mystery door'. For knowing the question, Type'question'. ");
        m1= new Room("You have entered the Haunted Mansion.\nBeware of the monster!! \nA gun is given to you for killng the monster. \nType 'shoot' for firing the gun!!\nSave yourself, if you can!");
        m2= new Room("");
        m3= new Room("");
        m4= new Room("");
        m5= new Room("");
        m6= new Room("");
        m7= new Room("");
        m8= new Room(" ");
        m9= new Room("");
        m10= new Room("");
        m11= new Room("Monster is here!!! Type 'shoot' for killing the monster and save your life!!");
        m12= new Room("");
        m13= new Room("");
        m14= new Room("");
        m15= new Room("");
        m16= new Room("");
        m17= new Room("");
        m18= new Room("");
        //(N,E,S,W)
       lobby.setExits(f1g5,null,null, null);
       f1g1.setExits(null, f1g2, f1g4,null);
       f1g2.setExits(null, f1g3, f1g5,f1g1);
       f1g3.setExits(null,f2g1,f1g6,f1g2);
       f1g4.setExits(f1g1, f1g5, null,null);
       f1g5.setExits(f1g2, f1g6, null,f1g4);
       f1g6.setExits(f1g3,null,null,f1g5);
      
       f2g1.setExits(null, f2g2, f2g4,f1g3);
       f2g2.setExits(null, f2g3, f2g5,f2g1);
       f2g3.setExits(null, qd, null,f2g2);
       f2g4.setExits(f2g1, f2g5, null,null);
       f2g5.setExits(f2g2,f2g6,null ,f2g4);
       f2g6.setExits(f2g3,null,null,f2g5);
       qd.setExits( null, m1,null, null);
       m1.setExits(null,m2,m4,null);
       m2.setExits(null,m3,m5,m1);
       m3.setExits(null,null,m6,m2);
       m4.setExits(m1,m5,m7,null);
       m5.setExits(m2,m6,m8,m4);
       m6.setExits(m3,null,m9,m5);
       m7.setExits(m4,m8,m10,null);
       m8.setExits(m5,m9,m11,m7);
       m9.setExits(m6,null,m12,m8);
       m10.setExits(m7,m11,m13,null);
       m11.setExits(m8,m12,m14,m10);
       m12.setExits(m9,null,m15,m11);
       m13.setExits(m10,m14,m16,null);
       m14.setExits(m11,m15,m17,m13);
       m15.setExits(m12,null,m18,m14);
       m16.setExits(m13,m17,null,null);
       m17.setExits(m14,m18,null,m16);
       m18.setExits(m15,null,null,m17);
       //start
       currentRoom = lobby;  
      
       
    }

    void play() 
    {            
        printWelcome();
        boolean finished = false;
        while (! finished) 
        {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
    }

    private void printWelcome()
    {
       
        System.out.println("\t\t\t\t\t\t\t\t\tWelcome to 'You Only Live Once' game!!!!");
        System.out.println();
        System.out.println("\t\t\t\t  Game Description:\n \t\t\t\t ->At the start of the game you are in the lobby.You have been provided with a shovel when you enter the game.From the lobby you end up in the Silver Stone Farm.");
        System.out.println("\t\t\t\t -> You have one silver key buried in this farm which you have to find by digging the farm.");
        System.out.println("\t\t\t\t -> After you find the silver key from the Silver Stone Farm, you head in the eastern direction and you end up in the Golden Daisy Farm.");
        System.out.println("\t\t\t\t ->You have one golden key buried in this farm which you have to find by digging the farm.");
        System.out.println("\t\t\t\t ->After you find the golden key from the Golden Daisy Farm, you end up in Mystery Door.");
        System.out.println("\t\t\t\t ->For deciding which key is the correct key to the Mystery Door,answer one question for unlocking the Mystery Door.");
        System.out.println("\t\t\t\t ->Behind the Mystery Door, Haunted Mansion is there which has one monster.A gun is provided to you for killing that monster.\n\t\t\t\t ->Kill that monster and you win the game!!!!!");
        System.out.println("\t\t\t\t ->Type 'dig'  before the direction name when you are digging in the farms and 'go' before the direction name when you are not digging in the game.");
         System.out.println("\t\t\t\t ->Type 'help' for any help and type 'quit' for quiting the game.");
        System.out.println(currentRoom.getDescription());
        System.out.print("Exits: ");
        if(currentRoom.northExit != null) 
        {
            System.out.print("north ");
        }
        if(currentRoom.eastExit != null)
        {
            System.out.print("east ");
        }
        if(currentRoom.southExit != null) 
        {
            System.out.print("south ");
        }
        if(currentRoom.westExit != null)
        {
            System.out.print("west ");
        }
        System.out.println();
    
    }
    
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
            goRoom(command);
        }
        else if (commandWord.equals("dig")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        else if (commandWord.equals("silverkey")) {
            System.out.println("Hurray!! \nSilver key is found!!");
        }
        else if (commandWord.equals("goldenkey")) {
            System.out.println("Hurray!! \nGolden key is found!!");
        }
        else if (commandWord.equals("Rome")) {
            Answer();
            System.out.println("Exits: east");
        }
        else if (commandWord.equals("rome")) {
             Answer();
             System.out.println("Exits: east");
        }
        else if (commandWord.equals("ROME")) {
             Answer();
             System.out.println("Exits: east");
        }
        else if (commandWord.equals("question")) {
            System.out.println("Question: What is the capital of Italy?");
            
        }
        else if (commandWord.equals("shoot")) {
            System.out.println("You have killed the monster and you are safe. \n Congratulations!!!You have won the game!! \n Thank you for playing.Good bye!!");
            wantToQuit = quit(command);
        }
        return wantToQuit;
    }

    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander.Type 'quit' for quiting the game.");
        System.out.println("Your command words are:");
        System.out.println("'go', 'quit' and 'help'");
    }

    private void Answer() 
    {
        System.out.println("Your answer is correct!!!This door is unlocked for you.You may keep playing now.You are now entering the Haunted Mansion !!"); 
    }
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) 
        {
            System.out.println("Go where?");
            return;
        }
           //go north or go south
        String direction = command.getSecondWord();

        Room nextRoom = null;
        if(direction.equals("north")) {
            nextRoom = currentRoom.northExit;
        }
        if(direction.equals("east")) {
            nextRoom = currentRoom.eastExit;
        }
        if(direction.equals("south")) {
            nextRoom = currentRoom.southExit;
        }
        if(direction.equals("west")) {
            nextRoom = currentRoom.westExit;
        }

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getDescription());
            System.out.print("Exits: ");
            if(currentRoom.northExit != null) {
                System.out.print("north ");
            }
            if(currentRoom.eastExit != null) {
                System.out.print("east ");
            }
            if(currentRoom.southExit != null) {
                System.out.print("south ");
            }
            if(currentRoom.westExit != null) {
                System.out.print("west ");
            }
            System.out.println();
        }
    }

    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  
        }
    }
}


