package chatbot.model;

import java.util.ArrayList;

public class Chatbot
{
	/**
	 * The content that is input from the user, for checking
	 */
	private String contentArea;

	/**
	 * The name of the chatBot
	 */
	private String name;

	/**
	 * Sets the number of Chats and increases it by one each time.
	 */
	private int numberOfChats;

	/**
	 * This creates an ArrayList called memeList, for the memes to be put into.
	 */
	private ArrayList<String> memeList;

	private String stringArea;

	/**
	 * Sets the name of the Chatbot and creates the array for the memeList, the
	 * contentList.
	 * 
	 * @param name
	 *            The name of the Chatbot
	 */
	public Chatbot(String name)
	{
		this.name = name;
		numberOfChats = 0;
		contentArea = "";
		stringArea = "";
		memeList = new ArrayList<String>();
		fillTheMemeList();
		// this. means talk to the current class
	}

	/**
	 * Returns the name of the chatbot
	 * 
	 * @return returns the name of the chatbot
	 */
	public String getName()
	{
		return name;
		// can be return this.name there is no difference
	}

	/**
	 * Returns the number of chats for this chatbot.
	 * 
	 * @return the current number of chats
	 */
	public int getNumbeOfChats()
	{
		return numberOfChats;
	}

	/**
	 * This allows anyone to change the chatbot name.
	 * 
	 * @param name
	 *            the new name for the chatbot
	 */
	public void setName(String name)
	{
		this.name = name;
		// allows anyone to change the Chatbot name if they call setName
	}

	/**
	 * This adds one to the number of chats.
	 */
	public void incrementChats()
	{
		numberOfChats++;
		// ++ is a shortcut to add 1 to a variable
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
	 * processed the supplied text from the user to provide a message from the
	 * Chatbot.
	 * 
	 * @param userText
	 *            The user supplied text.
	 * @return What the Chatbot says because of the supplied input.
	 */
	public String processText(String userText)
	{
		String processedText = "";
		incrementChats();

		int randomChoice = (int) (Math.random() * 3);
		if (userText != null)
		{

		}

		/**
		 * if a random number is 0 then it will use the string checker
		 */
		if (randomChoice == 0)
		{
			if (stringChecker(userText))
			{
				processedText = "that was to long, sorry!";
			}
			else
			{
				processedText = "Short is goodish";
			}
		}

		/**
		 * if a random number is 1 then it will use the memeChecker
		 */
		else if (randomChoice == 1)
		{
			// if (memeChecker(userText))
			// {
			// processedText = "The secret involves" + userText;
			// }
			// else
			{
				if (memeChecker(userText))
				{
					processedText = "Guess What! You found a meme: " + userText;
					processedText += " Isn't that sweet!";
				}
				else
				{
					processedText = "I'm sad, that wasn't a meme.";
				}
			}
		}
		else if (randomChoice == 2)
		{
			if (contentChecker(userText))
			{
				processedText = "";
			}
			else
			{
				processedText = "let's talk about yoyo's!!";
			}
		}
		return processedText;
	}

	/**
	 * Checks to see if it is a meme
	 * 
	 * @param currentText
	 *            Checks the users input text
	 * @return returns true or false if the meme is in the list or not.
	 */
	private boolean memeChecker(String currentText)
	{
		boolean isAMeme = false;

		for (String currentMeme : memeList)
		{
			if (currentMeme.equalsIgnoreCase(currentText))
			{
				isAMeme = true;
			}
		}

		return isAMeme;
	}

	/**
	 * Check's the content from the user to see if it talks about any certain
	 * subjects
	 * 
	 * @param input
	 *            If what the user put's in is in the contentArea, then it will
	 *            return true.
	 * @return returns the isContent, after it is true.
	 */
	private boolean contentChecker(String input)
	{
		boolean isContent = false;

		if (input.contains(contentArea))
		{
			isContent = true;
		}

		return isContent;
	}

	/**
	 * Checks the length of the strings
	 * 
	 * @param input
	 *            The input of the user
	 * @return returns whether or not the string that the user inputs is to long
	 */
	private boolean stringChecker(String input)
	{
		boolean isTooLong = false;

		if (input.contains(stringArea))
		{
			isTooLong = true;
		}

		return isTooLong;
	}

	/**
	 * Check's to see if you want to quit
	 * 
	 * @param input
	 *            determines what you put into the box
	 * @return returns whether or not it is okay to quit
	 */
	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;

		if (input != null && input.equals("quit"))
		{
			okToQuit = true;
		}

		return okToQuit;
	}
}
