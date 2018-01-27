import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
	private JFrame mainFrame;
    private JPanel content;
	//private JLabel[][] loc;
	//private ImageIcon img;
	private JLabel info;
	private JButton looking, giving;
		
	public Main()
	{
		mainFrame = new JFrame("Swipe Daddy");
     	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     	mainFrame.setSize(360,640);
     	
     	looking = new JButton("Looking");
     	giving = new JButton("Giving");
     	content = new JPanel(new GridLayout(2, 2));
     	content.add(looking);
     	content.add(giving);
     	mainFrame.getContentPane().add(content);
     	mainFrame.setVisible(true);
     	
	}
	
    public static void main(String[] args) 
    {
        Main launcher = new Main();
    }
}
