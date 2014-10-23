package chatbot.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import chatbot.controller.ChatbotAppController;

/**
 * the ChatbotPanel gets characteristics from the JPanel
 * @author ssla9721
 *
 */
public class ChatbotPanel extends JPanel
{
	private ChatbotAppController baseController;
	private JButton sampleButton;
	private JTextField sampleField;
	private JTextArea chatArea;
	private JScrollPane chatPane;
	private SpringLayout baseLayout;

	public ChatbotPanel(ChatbotAppController baseController)
	{
		this.baseController = baseController;

		sampleButton = new JButton("click on me");
		sampleField = new JTextField(25);
		chatPane = new JScrollPane();
		
		baseLayout = new SpringLayout();
		baseLayout.putConstraint(SpringLayout.NORTH, sampleField, 1, SpringLayout.NORTH, sampleButton);
		baseLayout.putConstraint(SpringLayout.WEST, sampleField, 38, SpringLayout.EAST, sampleButton);
		
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
		this.add(sampleField);
		this.add(chatPane);
		sampleField = new JTextField(25);
		chatArea = new JTextArea(5, 25);
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 72, SpringLayout.SOUTH, sampleButton);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 115, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -114, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatArea, -129, SpringLayout.EAST, this);
		chatArea.setEnabled(false);
		chatArea.setLineWrap(true);
		
		add(chatArea);
		
		
	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, sampleButton, 5, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, sampleButton, -289, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, sampleField, 1, SpringLayout.NORTH, sampleButton);
		baseLayout.putConstraint(SpringLayout.WEST, sampleField, 31, SpringLayout.EAST, sampleButton);
	}

	private void setupListeners()
	{
		sampleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				sampleField.setText(sampleField.getText() + " Yes!");
			}
		});
		
	}
}
