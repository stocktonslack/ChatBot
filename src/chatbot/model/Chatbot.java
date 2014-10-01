package chatbot.model;

import java.util.ArrayList;

public class Chatbot
{
	private String name;
	private int numberOfChats;
	private ArrayList<String> memeList;
	private ArrayList<String> contentList;
	
	/**
	 * Sets the name of the Chatbot and creates the array for the memeList, the contentList.
	 * @param name The name of the Chatbot
	 */
	public Chatbot(String name)
	{
		this.name = name;
		numberOfChats = 0;
		
		//this. means talk to the current class
		
		memeList = new ArrayList<String>();
		fillTheMemeList();
		
		contentList = new ArrayList<String>();
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
	 * Fills the contents of the memeList with internet memes.
	 */
	private void fillTheMemeList()	
	{
		memeList.add("y u mad bro");
		memeList.add("I'm always watching you... alway's watching you...");
		memeList.add("so I guess you could say things are gettin' pretty serious");
		memeList.add("Why so serious?");
		memeList.add("one does not simply");
		memeList.add("Mormon Memes");
		memeList.add("You Shall Not PASS)");
		
	}
	
	/**
	 * processed the supplied text from the user to provide a message from the Chatbot.
	 * @param userText The user supplied text.
	 * @return What the Chatbot says because of the supplied input.
	 */
	public String processText(String userText)
	{
		String processedText = "";
		incrementChats();
		
		if(memeChecker(userText))
		{
			processedText = "Guess What! You found a meme: " + userText;
			processedText += " Isn't that sweet!";
		}
		
		else if(contentChecker(userText))
		{
			
		}
		
		else
		{
			processedText = "I'm sad, that wasn't a meme.";
		}
		
		return processedText;
	}
	
	/**
	 * Checks to see if it is a meme
	 * @param currentText  Checks the users input text
	 * @return returns true or false if the meme is in the list or not.
	 */
	private boolean memeChecker(String currentText)
	{
		boolean isAMeme =  false;
		
		for(String currentMeme : memeList)
		{
			if(currentMeme.equalsIgnoreCase(currentText))
			{
				isAMeme = true;
			}
		}
		
		for(int loopCount = 0; loopCount < memeList.size(); loopCount++)
		{
			if(memeList.get(loopCount).equalsIgnoreCase(currentText))
			{
				isAMeme = true;
			}
		}
		
		return isAMeme;
	}
	
	private void fillTheContentList()
	{
		contentList.add("Batman");
		contentList.add("Stud");
		contentList.add("Stockton");
		contentList.add("Yoyo");
		contentList.add("Homework");
		contentList.add("Chairman");
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
