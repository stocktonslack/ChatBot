package chatbot.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import chatbot.controller.ChatbotAppController;
import java.awt.Font;

/**
 * GUI Panel for our Chatbot
 * 
 * @author ssla9721
 * @version 1.5 Final Project?
 */
public class ChatbotPanel extends JPanel
{
	/**
	 * The controller for the app and GUI
	 */
	private ChatbotAppController baseController;

	/**
	 * The button for the user to click
	 */
	private JButton sampleButton;

	/**
	 * The TextField where the user types.
	 */
	private JTextField userTypedText;

	/**
	 * This is where all of the text is displayed from the user, along with the
	 * chatbots response.
	 */
	private JTextArea chatArea;
	
	/**
	 * The layout of the panel.
	 */
	private SpringLayout baseLayout;

	/**
	 * The GUI for the user to view, what they see, on a panel.
	 * 
	 * @param baseController
	 */
	public ChatbotPanel(ChatbotAppController baseController)
	{
		this.baseController = baseController;

		sampleButton = new JButton("click on me");
		userTypedText = new JTextField(25);
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
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setEditable(false);
	}

	/**
	 * The computer generated code, for the setup of the frame and panel.
	 */
	private void setupPanel()
	{
		this.setBackground(new Color(102, 204, 102));
		this.setLayout(baseLayout);
		this.add(sampleButton);
		this.add(userTypedText);
		this.setSize(450,350);
		chatArea = new JTextArea(10, 25);
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 22, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 0, SpringLayout.WEST, sampleButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -40, SpringLayout.NORTH, userTypedText);
		baseLayout.putConstraint(SpringLayout.EAST, chatArea, 0, SpringLayout.EAST, userTypedText);
		add(chatArea);
		
		JScrollPane scrollPane = new JScrollPane(chatArea);
		add(scrollPane);
		
		
		
		setPreferredSize(new Dimension(450, 350));
		
		add(scrollPane, BorderLayout.CENTER);
	}

	/**
	 * The dumping place for the basic setup for the panel.
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.SOUTH, userTypedText, -12, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, sampleButton, -1, SpringLayout.NORTH, userTypedText);
		baseLayout.putConstraint(SpringLayout.WEST, sampleButton, 23, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, userTypedText, -43, SpringLayout.EAST, this);
	}

	/**
	 * Listens for button clicks, and other such things.
	 */
	private void setupListeners()

	{

		/**
		 * When the button is clicked, the text in the textBox is sent to the
		 * chatbot, and displayed in the textField.
		 */
		sampleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String theInput = userTypedText.getText();
				String chatbotResponse = baseController.sendTextToChatbot(theInput);
				displayTextToUser(theInput);
				displayTextToUser(chatbotResponse);
				chatArea.setText("");
				chatArea.requestFocus();
			}
		});

	}

	/**
	 * This takes whatever text you send to it and puts it in the chatArea, so that everyone can see it.
	 * @param input
	 */
	public void displayTextToUser(String input)
	{
		chatArea.append("\n" + input);
	}
}
