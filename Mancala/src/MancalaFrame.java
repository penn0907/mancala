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

public class MancalaFrame extends JFrame implements MouseListener {

	private int width = Toolkit.getDefaultToolkit().getScreenSize().width;

	private int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	public static final int THREE_STONES = 3;
	public static final int FOUR_STONES = 4;
	
	private StyleManager sm;
	
	private int numOfStone;

	public MancalaFrame() {
		setTitle("Mancala");
		setSize(800, 400);
		setLocation((width - 800) / 2, (height - 400) / 2);
		setLayout(null);
		
		setResizable(false);
		JPanel jp = new JPanel();
		jp.setLocation(100, 100);
		jp.setSize(500, 500);
		JLabel jl = new JLabel("Please selet board style: ");
		jl.setFont(new Font("Plain", Font.PLAIN, 20));
		jp.add(jl);
		JButton button1 = new JButton("Classic Style");
		JButton button2 = new JButton("Modern Style");
		
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(sm != null) {
					remove(jp);
					numOfStone = THREE_STONES;
					setBoardPanel(jp, sm);
				}
				sm = new ClassicStyle();
				//TODO add board style to this frame
				jl.setText("Please selet stone number: ");
				button1.setText("3");
				button2.setText("4");
				repaint();
			}
		});
		jp.add(button1);
		
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO add board style to this frame
				if(sm != null) {
					remove(jp);
					numOfStone = FOUR_STONES;
					setBoardPanel(jp, sm);
				}
				sm = new ModernStyle();
				jl.setText("Please selet stone number: ");
				button1.setText("3");
				button2.setText("4");
				repaint();
				
			}
		});
		jp.add(button2);
		
		
		add(jp);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
	
	private void setBoardPanel(JPanel jp, StyleManager sm) {
		BoardPanel bp = new BoardPanel(sm);
		add(bp);
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}
