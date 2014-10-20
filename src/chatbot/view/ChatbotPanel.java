package chatbot.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import chatbot.controller.ChatbotAppController;

/**
 * the ChatbotPanel gets characteristics from the JPanel
 * 
 * @author ssla9721
 *
 */
public class ChatbotPanel extends JPanel
{
	private ChatbotAppController baseController;
	private JButton sampleButton;
	private JTextField sampleField;

	private SpringLayout baseLayout;

	public ChatbotPanel(ChatbotAppController baseController)
	{
		this.baseController = baseController;

		sampleButton = new JButton("click on me");
		sampleField = new JTextField(25);

		baseLayout = new SpringLayout();

		setupPanel();
		setupLayout();
		setupListeners();

	}

	private void setupPanel()
	{
		this.setBackground(Color.ORANGE);

		this.setLayout(baseLayout);

		this.add(sampleButton);
		this.add(sampleField);

	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, sampleField, 84, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, sampleField, 0, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, sampleButton, 5, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, sampleButton, -289, SpringLayout.EAST, this);
	}

	private void setupListeners()
	{

	}
}
