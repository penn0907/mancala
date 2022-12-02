import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Mancala view main frame
 * 
 * @author Yupeng Ni, Hebai Lian, Wesley Zhao
 * CS151, Team Project
 */
public class MancalaFrame extends JFrame{

	private JPanel initPanel;	//style and number of stone selection panel
	private JLabel promptLabel;	//message label to prompt user to select
	private JButton button1;
	private JButton button2;

	private int numOfStone;	// number of stone

	/**
	 * constructor, setting layout
	 */
	public MancalaFrame() {
		setTitle("Mancala");
		setSize(800, 400);
		setLayout(null);

		setResizable(false);
		initPanel = new JPanel();
		initPanel.setLocation(100, 100);
		initPanel.setSize(500, 500);
		
		Font font = new Font("Plain", Font.PLAIN, 20);
		promptLabel = new JLabel("Please selet board style: ");
		promptLabel.setFont(font);
		initPanel.add(promptLabel);
		button1 = new JButton("Classic");
		button1.setBackground(Color.LIGHT_GRAY);
		button1.setForeground(Color.WHITE);
		button1.setFont(font);
		
		button2 = new JButton("Modern");
		button2.setBackground(Color.LIGHT_GRAY);
		button2.setForeground(Color.WHITE);
		button2.setFont(font);
		initPanel.add(button1);

		
		initPanel.add(button2);

		add(initPanel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public JPanel getInitPanel() {
		return initPanel;
	}

	public JLabel getPromptLabel() {
		return promptLabel;
	}

	public JButton getButton1() {
		return button1;
	}

	public JButton getButton2() {
		return button2;
	}

	public int getNumOfStone() {
		return numOfStone;
	}

	public void setNumOfStone(int numOfStone) {
		this.numOfStone = numOfStone;
	}

}
