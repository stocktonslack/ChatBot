package chatbot.controller;

import chatbot.model.Chatbot;
import chatbot.view.ChatbotFrame;
import chatbot.view.ChatbotPanel;
import chatbot.view.ChatbotView;

/**
 * Application Controller for the Chatbot string project. Responsible for
 * controlling the view and model packages.
 * 
 * @author ssla9721
 *@version 1.6 11/4/14 - Final Project?
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
	 * Starts the Chatbot App.
	 */
	public void start()
	{	
		((ChatbotPanel) baseFrame.getContentPane()).displayTextToUser(startMessage);	
	}

	/**
	 * This takes the text from the user and then it sends it off to the processedText method in the chatbot.
	 * @param userInput 
	 * @return this returns what it recieves back from the chatbot.
	 */
	public String sendTextToChatbot(String userInput)
	{
		String respondText = "";
		
		respondText = keithbot.processedText(userInput);
		
		return respondText;
	}
	
	/**
	 * quits the Chatbot application with a message to the user telling them
	 * that it is closing.
	 */
	private void quit()
	{
		appView.displayInformation("goodbye my friend");
		System.exit(0);
	}
}