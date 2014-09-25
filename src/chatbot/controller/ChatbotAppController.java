package chatbot.controller;

import javax.swing.JOptionPane;

import chatbot.model.Chatbot;
import chatbot.view.ChatbotView;

public class ChatbotAppController
{
	private ChatbotView appView;
	private Chatbot keith;
	
	/**
	 * Creates a ChatbotAppController and initializes the associated View and Model objects.
	 */
	public ChatbotAppController()
	{
		appView = new ChatbotView(this);
		keith = new Chatbot("Bruce Wayne");
	}
	
	/**
	 * Starts the Chatbot Application.
	 */
	public void start()
	{
		/**
		 * This asks if you want to continue, if you do not then it will quit the program.
		 */
		String message = JOptionPane.showInputDialog(null, "Will you continue?");
		if(keith.quitChecker(message))
		{
			quit();
		}
		
		JOptionPane.showMessageDialog(null, "Why so serious?...");
	}
	
	/**
	 * The quitting message.
	 */
	private void quit()
	{
		JOptionPane.showMessageDialog(null, "bye");
		System.exit(0);
	}
}
