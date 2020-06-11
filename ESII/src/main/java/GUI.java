import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.WindowConstants;

public class GUI {
	
	private JFrame frame;
	private GitHubHandler git;
	private HTMLHelper html_helper;
	
	public GUI() {
		// TODO Auto-generated constructor stub
		frame = new JFrame("COVID-19 Spread Stats");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setSize(500,400);
		frame.setVisible(true);
		addComponents();
	}
	
	private void addComponents() {
		
		//UPPER PANEL
		JPanel upperPanel = new JPanel();
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		upperPanel.setLayout(layout);
		
		final JButton jb1 = new JButton("Connect to GitHub");
		JProgressBar jpb = new JProgressBar();
		jb1.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
					jb1.setEnabled(false);
					git = new GitHubHandler();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
