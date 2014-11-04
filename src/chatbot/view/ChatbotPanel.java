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

	public ChatbotPanel(ChatbotAppController baseController)
	{
		this.baseController = baseController;

		sampleButton = new JButton("click on me");
		sampleField_1 = new JTextField(25);
		chatPane = new JScrollPane();

		baseLayout = new SpringLayout();
		baseLayout.putConstraint(SpringLayout.NORTH, sampleField_1, 1, SpringLayout.NORTH, sampleButton);
		baseLayout.putConstraint(SpringLayout.WEST, sampleField_1, 6, SpringLayout.EAST, sampleButton);
		baseLayout.putConstraint(SpringLayout.EAST, sampleField_1, -46, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, sampleButton, 23, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, sampleButton, -10, SpringLayout.SOUTH, this);

		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();

	}

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
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 26, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 0, SpringLayout.WEST, sampleButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -21, SpringLayout.NORTH, sampleButton);
		baseLayout.putConstraint(SpringLayout.EAST, chatArea, -33, SpringLayout.EAST, this);
		chatArea.setEnabled(false);
		chatArea.setLineWrap(true);

		add(chatArea);

	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, sampleField, 1, SpringLayout.NORTH, sampleButton);
		baseLayout.putConstraint(SpringLayout.WEST, sampleField, 31, SpringLayout.EAST, sampleButton);
	}

	private void setupListeners()

	{

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
