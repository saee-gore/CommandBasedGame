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
