package chatbot.view;

import javax.swing.JOptionPane;

import chatbot.controller.ChatbotAppController;

/**
 * What the user see's.
 * @author ssla9721
 *
 */
public class ChatbotView
{
	/**
	 * the baseController for controlling
	 */
	private ChatbotAppController baseController;

	/**
	 * creates a public baseController in the ChatbotView
	 * @param baseController uses the this to make the basecontroller in the appController the same as the one that is created in the veiw.
	 */
	public ChatbotView(ChatbotAppController baseController)
	{
		this.baseController = baseController;
	}

	/**
	 * Displays the supplied String parameter to the user via popup and returns
	 * the users response to the controller.
	 * @param input           The supplied text to be displayed.
	 * @return The users input.
	 */
	public String displayChatbotConversations(String input)
	{
		String output = "";

		output = JOptionPane.showInputDialog(null, baseController.getkeithbot().getName() + "Says: " + input);

		return output;
	}

	/**
	 * Displays the supplied input via a popup window.
	 * @param input          The text to be displayed.
	 */
	public void displayInformation(String input)
	{
		JOptionPane.showMessageDialog(null, baseController.getkeithbot().getName() + " is cool...");
	}
}
