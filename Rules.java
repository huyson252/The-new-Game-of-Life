import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.event.ChangeEvent;

public class Rules extends JFrame implements ActionListener{
	
	JButton next1;
	JButton next2;
	JButton previous2;
	JButton previous3;
	JButton next3;
	JButton previous4;
	ImagePanel page1;
	ImagePanel page2;
	ImagePanel page3;
	ImagePanel page4;
	int h;
	
	JPanel panelMain;
	
	public Rules(){
		this.setTitle("RULES");
		 Toolkit tk = Toolkit.getDefaultToolkit();
		 h = ((int) tk.getScreenSize().getHeight());
		this.setBounds(0,0,900,900);
		setLocationRelativeTo(null);
		setLayout(null);
        this.setResizable(false);

        next1 = new JButton (new ImageIcon(((new ImageIcon("next.png")).getImage()).getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH)));
        next1.setBounds(780,780,60,60);
        next1.addActionListener(this);
        
        next2 = new JButton (new ImageIcon(((new ImageIcon("nextc.png")).getImage()).getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH)));
        next2.setBounds(780,780,60,60);
        next2.addActionListener(this);
        
        next3 = new JButton (new ImageIcon(((new ImageIcon("nextr.png")).getImage()).getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH)));
        next3.setBounds(780,780,60,60);
        next3.addActionListener(this);
        
        previous2 = new JButton (new ImageIcon(((new ImageIcon("previousc.png")).getImage()).getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH)));
        previous2.setBounds(50,780,60,60);
        previous2.addActionListener(this);
        
        previous3 = new JButton (new ImageIcon(((new ImageIcon("previousr.png")).getImage()).getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH)));
        previous3.setBounds(50,780,60,60);
        previous3.addActionListener(this);
        
        previous4 = new JButton (new ImageIcon(((new ImageIcon("previousi.png")).getImage()).getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH)));
        previous4.setBounds(50,780,60,60);
        previous4.addActionListener(this);
        
        page1 = new ImagePanel("rulespage1.JPG");
        page1.setLayout(null);
        page1.add(next1);
        page1.setBounds(0,0,900,900);
        
        page2 = new ImagePanel("rulespage2.png");
        page2.setLayout(null);
        page2.add(next2);
        page2.add(previous2);
        page2.setBounds(0,0,900,900);
        page2.setVisible(false);
        
        page3 = new ImagePanel("rulespage3.JPG");
        page3.setLayout(null);
        page3.add(next3);
        page3.add(previous3);
        page3.setBounds(0,0,900,900);
        page3.setVisible(false);
        
        page4 = new ImagePanel("rulespage4.JPG");
        page4.setLayout(null);
        page4.add(previous4);
        page4.setBounds(0,0,900,900);
        page4.setVisible(false);
        
        
        panelMain = new JPanel();
        panelMain.setLayout(null);
        panelMain.add(page1);
        panelMain.add(page2);
        panelMain.add(page3);
        panelMain.add(page4);
        panelMain.setBounds(0,0,900,900);
        this.add(panelMain);
        this.setVisible(true);
        
        
        

	}
	
	
	 public void actionPerformed (ActionEvent e){
	    	if (e.getSource() == next1) {
	    		page1.setVisible(false);
	    		page2.setVisible(true);
	    		
	    		
	    	}else if (e.getSource() == next2) {
	    		page2.setVisible(false);
	    		page3.setVisible(true);
	    			    		    		
	    	}else if (e.getSource() == next3) {
	    		page3.setVisible(false);
	    		page4.setVisible(true);
	    		
	    	}else if (e.getSource() == previous2) {
	    		page1.setVisible(true);
	    		page2.setVisible(false);
	    		
	    	}else if (e.getSource() == previous3) {
	    		page2.setVisible(true);
	    		page3.setVisible(false);
	    		
	    	}else if (e.getSource() == previous4) {
	    		page3.setVisible(true);
	    		page4.setVisible(false);
	    		
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
