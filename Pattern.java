import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.event.ChangeEvent;

public class Pattern extends JFrame implements ActionListener {

	JButton next1;
	JButton previous2;
	ImagePanel page1;
	ImagePanel page2;
	JPanel panelMain;
	//JButton à rajouter quand ils seront crées 
	
	//we can add more page depending if we have too much special pattern for now i assume there's only two
	
	public Pattern() {
		
	
		this.setBounds(0,0,900,900);
		setLocationRelativeTo(null);
		setLayout(null);
        this.setResizable(false);

        next1 = new JButton (new ImageIcon(((new ImageIcon("next1.png")).getImage()).getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH)));
        next1.setBounds(780,780,60,60);
        next1.addActionListener(this);
        
        previous2 = new JButton (new ImageIcon(((new ImageIcon("previous1.png")).getImage()).getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH)));
        previous2.setBounds(50,780,60,60);
        previous2.addActionListener(this);
        
        page1 = new ImagePanel("patternsprincipal.JPG");
        page1.setLayout(null);
        page1.add(next1);
        page1.setBounds(0,0,900,900);
        
        page2 = new ImagePanel("patternssuite.JPG");
        page2.setLayout(null);
        page2.add(previous2);
        page2.setBounds(0,0,900,900);
        page2.setVisible(false);
		
		panelMain = new JPanel();
        panelMain.setLayout(null);
        panelMain.add(page1);
        panelMain.add(page2);
        panelMain.setBounds(0,0,900,900);
        this.add(panelMain);
        this.setVisible(true);
	}
	 
	
	
	public void actionPerformed (ActionEvent e){
		
		if (e.getSource() == next1) {
    		page1.setVisible(false);
    		page2.setVisible(true);
		}else if (e.getSource() == previous2) {
    		page1.setVisible(true);
    		page2.setVisible(false);
		}
    				 
	 }

	
	 class ImagePanel extends JPanel {

     private Image img;

     public ImagePanel(String img) {
         this(new ImageIcon(img).getImage());
     }

    
     
     public ImagePanel(Image img) {
         this.img = img;
         Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
         setPreferredSize(size);
         setMinimumSize(size);
         setMaximumSize(size);
         setSize(size);
         setLayout(null);
     }

     public void paintComponent(Graphics g) {
         g.drawImage(img, 0, 0, null);
     }

	 }
	 
	 
}
