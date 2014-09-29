package chatbot.model;

public class Chatbot
{
	private String name;
	private int numberOfChats;
	
	/**
	 * Creates a Chatbot Object with a specified name. Initializes the total chats to 0.
	 * @param name The name of the chatbot.
	 */
	public Chatbot(String name)
	{
		this.name = name;
		numberOfChats = 0;
		//this. means talk to the current class
	}
	
	/**
	 * Returns the name of the chatbot
	 * @return returns the name of the chatbot
	 */
	public String getName()
	{
		return name;
		//can be return this.name there is no difference
	}
	
	/**
	 * Returns the number of chats for this chatbot.
	 * @return the current number of chats
	 */
	public int getNumbeOfChats()
	{
		return numberOfChats;
	}
	
	/**
	 * This allows anyone to change the chatbot name.
	 * @param name the new name for the chatbot
	 */
	public void setName(String name)
	{
		this.name = name;
		//allows anyone to change the Chatbot name if they call setName
	}
	
	/**
	 * This adds one to the number of chats.
	 */
	public void incrementChats()
	{
		numberOfChats++;
		//++ is a shortcut to add 1 to a variable
	}
	
	
	/**
	 * Check's to see if you want to quit
	 * @param input determines what you put into the box
	 * @return returns whether or not it is okay to quit
	 */
	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;
		
		if(input != null && input.equals("quit"))
		{
			okToQuit = true;
		}
		
		return okToQuit;
	}
}
