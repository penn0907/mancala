import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MancalaFrame extends JFrame{

	private int width = Toolkit.getDefaultToolkit().getScreenSize().width;

	private int height = Toolkit.getDefaultToolkit().getScreenSize().height;

	private StyleManager sm;

	private JPanel initPanel;
	private JLabel promptLabel;
	private JButton button1;
	private JButton button2;

	private int numOfStone;

	public MancalaFrame() {
		setTitle("Mancala");
		setSize(800, 400);
		setLocation((width - 800) / 2, (height - 400) / 2);
		setLayout(null);

		setResizable(false);
		initPanel = new JPanel();
		initPanel.setLocation(100, 100);
		initPanel.setSize(500, 500);
		promptLabel = new JLabel("Please selet board style: ");
		promptLabel.setFont(new Font("Plain", Font.PLAIN, 20));
		initPanel.add(promptLabel);
		button1 = new JButton("Classic Style");
		button2 = new JButton("Modern Style");

		button1.addActionListener(getStoneNumListener(MancalaUtil.BEGIN_STONES_3, MancalaUtil.CLASSIC_STYLE));
		initPanel.add(button1);

		button2.addActionListener(getStoneNumListener(MancalaUtil.BEGIN_STONES_4, MancalaUtil.MODERN_STYLE));
		initPanel.add(button2);

		add(initPanel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
	
	private ActionListener getStoneNumListener(int num, int style) {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (sm != null) {
					remove(initPanel);
					numOfStone = num;
					setBoardPanel(initPanel, sm);
				} else {
					if (style == 1) {
						sm = new ClassicStyle();
					} else {
						sm = new ModernStyle();
					}
					promptLabel.setText("Please selet stone number: ");
					button1.setText("3");
					button2.setText("4");
					repaint();
				}
			}
		};
	}

	private void setBoardPanel(JPanel jp, StyleManager sm) {
		BoardPanel bp = new BoardPanel(sm, numOfStone);
		add(bp);
		repaint();
	}

}
