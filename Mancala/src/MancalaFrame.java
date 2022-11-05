import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MancalaFrame extends JFrame implements MouseListener {

	private int width = Toolkit.getDefaultToolkit().getScreenSize().width;

	private int height = Toolkit.getDefaultToolkit().getScreenSize().height;

	public MancalaFrame() {
		setTitle("Mancala");
		setSize(800, 400);
		setLocation((width - 800) / 2, (height - 400) / 2);
		setLayout(null);
		
		setResizable(false);
		JPanel jp = new JPanel();
		jp.setLocation(100, 100);
		jp.setSize(500, 500);
		
		JButton classicButton = new JButton("Classic Style");
		classicButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				remove(jp);
				//TODO add board style to this frame
				setBoardPanel(jp, new ClassicStyle());
				
			}
		});
		jp.add(classicButton);
		
		JButton modernButton = new JButton("Modern Style");
		modernButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(jp);
				//TODO add board style to this frame
				setBoardPanel(jp, new ModernStyle());
				
			}
		});
		jp.add(modernButton);
		
		
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
