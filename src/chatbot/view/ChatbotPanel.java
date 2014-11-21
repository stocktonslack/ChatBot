package chatbot.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import chatbot.controller.ChatbotAppController;
import java.awt.Font;

/**
 * GUI Panel for our Chatbot
 * @author ssla9721
 * @version 1.2 Added method calls to listener for Chatbot. Method for sending info to the panel from the controller.
 */
public class ChatbotPanel extends JPanel
{
	private ChatbotAppController baseController;
	private JButton sampleButton;
	private JTextField sampleField;
	private JTextField sampleField_1;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	private SpringLayout baseLayout;

	/**
	 * The GUI for the user to view, what they see, on a panel.
	 * @param baseController
	 */
	public ChatbotPanel(ChatbotAppController baseController)
	{
		this.baseController = baseController;

		sampleButton = new JButton("click on me");
		sampleField_1 = new JTextField(25);
		chatPane = new JScrollPane();

		baseLayout = new SpringLayout();

		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();

	}

	/**
	 * Allows the user to scroll between several options.
	 */
	private void setupScrollPane()
	{

	}

	
	private void setupPanel()
	{
		this.setBackground(Color.ORANGE);

		this.setLayout(baseLayout);

		this.add(sampleButton);
		this.add(sampleField_1);
		this.add(chatPane);
		sampleField = new JTextField(25);
		chatArea = new JTextArea(5, 25);
		chatArea.setWrapStyleWord(true);
		chatArea.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 14));
		
		chatArea.setEnabled(false);
		chatArea.setLineWrap(true);

		add(chatArea);

	}

	/**
	 * The dumping place for the basic setup for the panel.
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, sampleField, 1, SpringLayout.NORTH, sampleButton);
		baseLayout.putConstraint(SpringLayout.WEST, sampleField, 31, SpringLayout.EAST, sampleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, sampleField_1, 1, SpringLayout.NORTH, sampleButton);
		baseLayout.putConstraint(SpringLayout.WEST, sampleField_1, 6, SpringLayout.EAST, sampleButton);
		baseLayout.putConstraint(SpringLayout.EAST, sampleField_1, -46, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, sampleButton, 23, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, sampleButton, -10, SpringLayout.SOUTH, this);baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 26, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 0, SpringLayout.WEST, sampleButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -21, SpringLayout.NORTH, sampleButton);
		baseLayout.putConstraint(SpringLayout.EAST, chatArea, -33, SpringLayout.EAST, this);
	}

	/**
	 * Listens for button clicks, and other such things.
	 */
	private void setupListeners()

	{

		/**
		 * When the button is clicked, the text in the textBox is sent to the chatbot, and displayed in the textField.
		 */
		sampleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userTypedText = sampleField.getText();
				String chatbotResponse = baseController.sendTextToChatbot(userTypedText);
				displayTextToUser(userTypedText);
				displayTextToUser(chatbotResponse);
				sampleField.setText("");
			}
		});

	}

	public void displayTextToUser(String input)
	{
		chatArea.append("\n" + input);
	}

}
