package chatbot.model;

import java.util.ArrayList;
import chatbot.model.user;

public class Chatbot {
	/**
	 * The content that is input from the user, for checking
	 */
	private String contentArea;

	/**
	 * The name of the chatBot
	 */
	private String name;

	/**
	 * Sets the number of Chats that the chatbot has participated in.
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
	 * The real life person outside the Chatbot, this is where we store
	 * information about them.
	 */
	private user myUser;

	/**
	 * Determines the maximum length, for the string checker.
	 */
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
		userInputList = new ArrayList<String>();
		memeList = new ArrayList<String>();
		myUser = new user();
		fillTheMemeList();
		

		// this. means talk to the current class
	}

	/**
	 * Returns the name of the chatbot
	 * 
	 * @return returns the name of the chatbot
	 */
	public String getName() {
		return name;
		// can be return this.name there is no difference
	}

	/**
	 * Returns the number of chats for this chatbot.
	 * 
	 * @return the current number of chats
	 */
	public int getNumbeOfChats() {
		return chatCount;
	}

	/**
	 * This allows anyone to change the chatbot name.
	 * 
	 * @param name
	 *            the new name for the chatbot
	 */
	public void setName(String name) {
		this.name = name;
		// allows anyone to change the Chatbot name if they call setName
	}

	public void setMyUser(user myUser)
	{
		this.myUser = myUser;
	}
	
	/**
	 * This adds one to the number of chats that the chatbot has participated
	 * in, tracking the activity of the chatbot.
	 */
	public void incrementChats() {
		chatCount++;
		// ++ is a shortcut to add 1 to a variable
	}

	/**
	 * condensing the processedText method, so that we can save space and have
	 * cleaner code.
	 * 
	 * @param userText
	 *            the input from the user.
	 * @return What the Chatbot says based on the input of the user.
	 */
	public String processedText(String userText) {
		String processedText = "";

		if (userText != null && userText.length() > 0) 
		{
			if (chatCount < 5) 
			{
				processedText = userInfo(userText);
			}

			else if(chatCount >= 5)
			{
				processedText = randomTopic(userText);
			}
			else 
			{
				chatCount--;
				processedText = "Please Talk to me!";
			}
		}
		incrementChats();
		return processedText;

	}


	private String userInfo(String input) 
	{
		String userInfoText = "";

		if (chatCount == 0) 
		{
			myUser.setName(input);
			userInfoText = "Hello, " + myUser.getName() + " how old would you be?";
		}
		else if (chatCount == 1) 
		{
			int age = Integer.parseInt(input);
			myUser.setAge(age);
			userInfoText = myUser.getName() + ", heh heh, you're" + myUser.getAge() + 
					" I guess that's interesting.";
			userInfoText = "\nAre you cool?";
		}
		else if (chatCount == 2) 
		{
			boolean isCool = Boolean.parseBoolean(input);
			myUser.setIscool(isCool);
			userInfoText = "Noice I guess you are " + myUser.getIsCool();
			userInfoText = "Do you play any sports or have any hobbies? If so, what are they?";
		}
		else if (chatCount == 3) 
		{
			myUser.setHobbies(input);
			userInfoText = "That's pretty cool I like " + myUser.getHobbies();
			userInfoText = "I have one last question, and this is the most important....";
			userInfoText = "Do you believe in Harvey Dent?";
		}
		else if (chatCount == 4)
		{
			myUser.setBelievesInDent(input);
			userInfoText = "...Well, I see that you " + myUser.getBelievesInDent() + " that is very intriguing.";
		}
		return userInfoText;
	}

	/**
	 * After we have gather info from the user, the chatbot will start having
	 * random conversation, not really intellectual though.
	 * 
	 * @param input
	 *            The text input from the user.
	 * @return The return varies based on the randomChoice.
	 */
	private String randomTopic(String input) {
		String randomTopic = "";
		int randomChoice = (int) (Math.random() * 5);

		/**
		 * This calls the stringChecker when the randomChoice is 0.
		 */
		if (randomChoice == 0) {
			if (stringChecker(input)) {
				randomTopic = "Please be short in your words!!";
			} else {
				randomTopic = "Person 1: You know how I got these scars??  "
						+ "Person2: No... but I know how you got these!";
			}
		}

		/**
		 * this calls the memeChecker when the randomChoice is 1. Then responds
		 * based on the result of the checker.
		 */
		else if (randomChoice == 1) {
			if (memeChecker(input)) {
				randomTopic = "I see you have found:" + input;
			} else {
				randomTopic = "HIT ME!!.... Oh wait... actually try a meme";
			}
		}

		/**
		 * This adds a user input to the list, and then comments with a
		 * randomTopic using some of the users info. When the randomChoice is 2.
		 */
		else if (randomChoice == 2) {
			userInputList.add(0, input);
			randomTopic = "You either die a hero, or you live long enough to see "
					+ "yourself become the villain." + myUser.getName();
		}

		/**
		 * This also adds a user input to the userInputList, and also comments
		 * using some of the users given info. When the randomChoice is 3.
		 */
		else if (randomChoice == 3) {
			userInputList.add(0, input);
			randomTopic = "I believe in Harvey Dent."
					+ myUser.getBelievesInDent();
		}

		/**
		 * This calls the userInputChecker when the random choice is 4, then
		 * responds based on the result of the checker.
		 */
		else if (randomChoice == 4) {

			if (userInputChecker(input)) {
				randomTopic = "Hey now, your getting fancy here being all repeating like";
			} else {
				randomTopic = "Can you remember anything that you have said before? Also...... "
						+ "Oh, you think the darkness is your ally, but you merely adopted the dark. "
						+ "I was born in it, molded by it. I didn’t see the light until I was already a man;"
						+ "by then, it was nothing to me but blinding! The shadows betray you, because they belong to me. "
						+ "I will show you where I have made my home, whilst preparing to bring justice. Then, I will break you. "
						+ "Your precious armoury, gratefully accepted. We will need it. Ah yes, I was wondering what would break first. "
						+ "Your spirit, or your body.";
			}
		}

		/**
		 * This calls teh nameChecker, and based on the result for the name
		 * checker it will have one of two conversations.
		 */
		else if (randomChoice == 5) {
			if (chatbotNameChecker(input)) {
				randomTopic = chatbotNameConversation(input);
			} else {
				randomTopic = noNameConversation(input)
						+ " ... The force is strong with this one";
			}
		}
		return randomTopic;
	}

	/**
	 * Tests user input for a String match
	 * 
	 * @param input
	 *            The String input from the user
	 * @return will notify that it matches the input
	 */
	private boolean userInputChecker(String input) 
	{
		boolean matchesInput = false;

		
			for (int loopCount = 0; loopCount < userInputList.size(); loopCount++) 
			{
				if (input.equalsIgnoreCase(userInputList.get(loopCount))) 
				{
					matchesInput = true;
					userInputList.remove(loopCount);
					loopCount--;
				}
			}

		return matchesInput;
	}

	/**
	 * Fills the contents of the memeList with Internet memes.
	 */
	private void fillTheMemeList() {
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
	 * 
	 * @param currentText
	 *            Checks the users input text
	 * @return returns true or false if the meme is in the list or not.
	 */
	private boolean memeChecker(String userInput) {
		boolean isAMeme = false;

		for (String currentMeme : memeList) {
			if (userInput.equalsIgnoreCase(currentMeme)) {
				isAMeme = true;
			}
		}

		return isAMeme;
	}

	/**
	 * Check's the input from the user to see if it talks about a certain
	 * subject
	 * 
	 * @param input
	 *            If what the user put's in is in the contentArea, then it will
	 *            return true.
	 * @return if it talks about the content, then it will trigger the Content
	 *         prompt
	 */
	private boolean contentChecker(String input) {
		boolean isContent = false;

		if (input.contains(contentArea)) {
			isContent = true;
		}

		return isContent;
	}

	/**
	 * Checks the length of the users string.
	 * 
	 * @param input
	 *            The users input.
	 * @return returns whether or not the string that the user inputs is to long
	 */
	private boolean stringChecker(String input) {
		boolean isTooLong = false;

		if (input.length() >=25) 
		{
			isTooLong = true;
		}

		return isTooLong;
	}

	/**
	 * Checks to see if the name of the Chatbot is contrained within the String
	 * supplied by the user.
	 * 
	 * @param currentInput
	 *            The user supplied String.
	 * @return Whether the name is inside or not.
	 */
	private boolean chatbotNameChecker(String currentInput) {
		boolean hasNameInString = false;

		if (currentInput.indexOf(this.getName()) > -1) {
			hasNameInString = true;
		}

		return hasNameInString;
	}

	private String chatbotNameConversation(String currentInput) {
		String nameConversation = "This is what you typed after my name: ";

		nameConversation += currentInput.substring(
				currentInput.indexOf(this.getName()) + this.getName().length(),
				currentInput.length() - 1);

		return nameConversation;
	}

	private String noNameConversation(String currentInput) {
		String notNamed = "";

		int smallRandom = (int) (Math.random() * currentInput.length() / 2);
		int largerRandom = (int) ((Math.random() * smallRandom) + (Math
				.random() * (currentInput.length() / 2) + 1));

		notNamed = "You didn't say my name so here is a special phrase: "
				+ currentInput.substring(smallRandom, largerRandom);
		return notNamed;
	}

	/**
	 * Check's to see if you want to quit
	 * 
	 * @param input
	 *            determines what you put into the box
	 * @return returns whether or not it is okay to quit
	 */
	public boolean quitChecker(String input) {
		boolean okToQuit = false;

		if (input != null && input.equals("quit")) {
			okToQuit = true;
		}

		return okToQuit;
	}

}
