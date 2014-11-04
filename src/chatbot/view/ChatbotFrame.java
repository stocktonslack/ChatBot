package chatbot.view;

import javax.swing.JFrame;

import chatbot.controller.ChatbotAppController;

/**
 * The chatbotFrame takes some of it's characteristics from the JFrame.
 * @author ssla9721
 */
public class ChatbotFrame extends JFrame
{
	/**
	 * creates the basePanel so that you can use it and set it's characteristics from the frame.
	 */
	private ChatbotPanel basePanel;

	/**
	 * creates the chatbotFrame with the parameters inside the AppController and baseController
	 * @param baseController
	 */
	public ChatbotFrame(ChatbotAppController baseController)
	{
		basePanel = new ChatbotPanel(baseController);
		setupFrame();
	}

	/**
	 * The basic setup and characteristics for the frame.
	 */
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(400, 400);
		this.setResizable(false);
		this.setVisible(true);
	}

}
