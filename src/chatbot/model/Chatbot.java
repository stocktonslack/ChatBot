package chatbot.model;

import java.util.ArrayList;
import chatbot.model.user;

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
	private int chatCount;

	/**
	 * This creates an ArrayList called memeList, for the memes to be put into.
	 */
	private ArrayList<String> memeList;
	
	/**
	 * Takes what the user say's and stores it
	 */
	private ArrayList<String> userInputList;

	/**
	 * The real life person outside the Chatbot
	 */
	private user myUser;

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
		chatCount = 0;
		contentArea = "";
		stringArea = "";
		memeList = new ArrayList<String>();
		fillTheMemeList();
		myUser = new user(name, chatCount, false, name);
		userInputList = new ArrayList<String>();
		
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
		return chatCount;
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
		chatCount++;
		// ++ is a shortcut to add 1 to a variable
	}
	

	/**
	 * processed the supplied text from the user to provide a message from the
	 * Chatbot.
	 * 
	 * @param userText The user supplied text.
	 * @return What the Chatbot says because of the supplied input.
	 */
	public String processText(String userText)
	{
		String processedText = "";
		
		if (userText != null && userText.length( > 0))
		{
			if(chatCount <5)
				processedText = "";
		}
		
		else
		{
			numberOfChats--;
			processedText = "answer the dang question...";
		}
		incrementChats();

		//int randomChoice = (int) (Math.random() * 6);
		//if (userText != null)
		return processedText;
		{
			if (chatCount < 10)
			{
				if(chatCount == 1)
				{
					processedText = "Welcome to the Bruce Wayne Chatbot, what is your name?";
				}
					
				else if (chatCount == 2)
				{
					processedText = "";
				}

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
					if (memeChecker(userText))
					{
						processedText = "The secret involves" + userText;
					}
					else
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

				else if (randomChoice == 3)
				{
					if (chatCount < 5)
					{
						if(chatCount == 0)
						{
							
						}
						if (chatCount == 1)
						{
							
						}
					}
				}
				
				else if (randomChoice == 4)
				{
					//userInputList add
					userInputList.add(0, userText);
				}
				
				else if (randomChoice == 5)
				{
					if (UserInputChecker(userText))
					{
						randomTopic = chatbotNameConversation(userText);
					}
					else
					{
						randomTopic = noNameConversation(userText);
					}
				}
				else
				{
					randomTopic
				}
			}
			
		}
		incrementChats();
		return processedText;
	}
	
	/**
	 * Tests user input for a String match
	 * @param input The String input from the user
	 * @return will notify that it matches the input
	 */
	private boolean UserInputChecker(String input)
	{
		boolean matchesInput = false;
		
		if(userInputList.size() > 0)
		{
			for (int loopCount = 0; loopCount < userInputList.size(); loopCount++)
			{
				if(input.equalsIgnoreCase(userInputList.get(loopCount)))
				{
					matchesInput = true;
					userInputList.remove(loopCount);
					loopCount--;
				}
			}
		}
		
		return matchesInput;
	}

	/**
	 * Fills the contents of the memeList with Internet memes.
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
	 * Checks to see if it is a meme
	 * @param currentText Checks the users input text
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
	 * Check's the input from the user to see if it talks about a certain subject
	 * @param input If what the user put's in is in the contentArea, then it will return true.
	 * @return if it talks about the content, then it will trigger the Content prompt
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
	 * Checks the length of the string
	 * @param input The input of the user
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
	
	
	/**
	 * Checks to see if the name of the Chatbot is contrained within the String supplied by the user.
	 * @param currentInput The user supplied String.
	 * @return Whether the name is inside or not.
	 */
	private boolean chatbotNameChecker(String currentInput)
	{
		boolean hasNameInString = false;
		
		if(currentInput.indexOf(this.getName()) > -1)
		{
			hasNameInString = true;
		}
		
		return hasNameInString;
	}
	
	private String chatbotNameConversation(String currentInput)
	{
		String nameConversation = "This is what you typed after my name: ";
		
		nameConversation += currentInput.substring(currentInput.indexOf(this.getName()) + this.getName().length(), currentInput.length()-1);
		
		return nameConversation;
	}
	
	private String noNameConversation (String currentInput)
	{
		String notNamed = "";
		
		int smallRandom = (int) (Math.random() * currentInput.length() / 2);
		int largerRandom = (int) ((Math.random() * smallRandom) + (Math.random() * (currentInput.length() / 2) + 1));
		
		notNamed = "You didn't say my name so here is a specia phrase: " + currentInput.substring(smallRandom, largerRandom);
		return notNamed;
	}
	
	
	
	
}

