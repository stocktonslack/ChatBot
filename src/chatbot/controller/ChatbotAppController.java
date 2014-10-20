package chatbot.controller;

import chatbot.model.Chatbot;
import chatbot.view.ChatbotFrame;
import chatbot.view.ChatbotView;

/**
 * Application Controller for the Chatbot string project. Responsible for
 * controlling the view and model packages.
 * 
 * @author ssla9721
 *
 */
public class ChatbotAppController
{

	/**
	 * The GUI view for the application.
	 */
	private ChatbotView appView;

	/*
	 * The Chatbot Model instance
	 */
	private Chatbot keithbot;

	/**
	 * The startup message for out chatbot application.
	 */
	private String startMessage;
	
	/**
	 * The ending mesage when the app stops.
	 */
	private String endMessage;
	
	/**
	 * GUI frame for the app
	 */
	private ChatbotFrame baseFrame;

	/**
	 * Creates a ChatbotAppController and initializes the associated View and
	 * Model objects.
	 */
	public ChatbotAppController()
	{
		appView = new ChatbotView(this);
		baseFrame = new ChatbotFrame(this);
		keithbot = new Chatbot("Bruce Wayne");
		startMessage = "Welcome to your " + keithbot.getName() + " Chatbot, what is your name?";
	}

	/**
	 * Allows other objects to access the keithbot.
	 * 
	 * @return The Chatbot for this app.
	 */
	public Chatbot getkeithbot()
	{
		return keithbot;
	}

	/**
	 * Starts the Chatbot Application.
	 */
	public void start()
	{
		String message = appView.displayChatbotConversations(startMessage);
/*
		while (!keithbot.quitChecker(message))
		{
			message = keithbot.processText(message);
			message = appView.displayChatbotConversations(message);
		}

		quit();
*/	}

	/**
	 * The quits the Chatbot application with a message to the user telling them
	 * that it is closing.
	 */
	private void quit()
	{
		appView.displayInformation("goodbye my friend");
		System.exit(0);
	}
}