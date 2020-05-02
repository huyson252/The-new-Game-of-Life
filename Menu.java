import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Menu extends JFrame implements ActionListener{
	private JButton coronalogo;
	private JButton rainbowlogo;
	private JButton immlogo;
	private JButton rules;
	ImagePanel panel;
    int w;
    int h;
	
	public Menu () {
	
	this.setTitle("MENU");
	Toolkit tk = Toolkit.getDefaultToolkit();
	 w = ((int) tk.getScreenSize().getWidth());
     h = ((int) tk.getScreenSize().getHeight());
     
    this.setBounds(0,0,w,h-(h/10));
	this.setResizable(false);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	coronalogo = new JButton(new ImageIcon(((new ImageIcon("corona.png")).getImage()).getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH)));
	coronalogo.setBounds(45*w/100,8*h/12,120,120);
	coronalogo.setBackground(Color.white);
	coronalogo.addActionListener(this);
	
	rainbowlogo= new JButton(new ImageIcon(((new ImageIcon("rainbowlogo.png")).getImage()).getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH)));
	rainbowlogo.setBounds((59*w/100),8*h/12,120,120);
	rainbowlogo.setBackground(Color.white);
	rainbowlogo.addActionListener(this);
	
	immlogo= new JButton(new ImageIcon(((new ImageIcon("logoimmigration.png")).getImage()).getScaledInstance(140, 140, java.awt.Image.SCALE_SMOOTH)));
	immlogo.setBounds((73*w/100),8*h/12,120,120);
	immlogo.setBackground(Color.white);
	immlogo.addActionListener(this);
	
	rules= new JButton (new ImageIcon("rulesacceuil.png"));
	rules.setBounds((87*w/100),68*h/100,150,100);
	rules.setBackground(Color.white);
	rules.addActionListener(this);
	
    
	panel = new ImagePanel("backgroundacceuil.jpg");
    panel.setLayout(null);
    panel.add(coronalogo);
    panel.add(rainbowlogo);
    panel.add(immlogo);
    panel.add(rules);
    panel.setBounds(0,0,w,h);
    this.add(panel);
    
    this.setVisible(true);

	}
	
	public void actionPerformed(ActionEvent e){
    
        if (e.getSource() == coronalogo){
        	this.setVisible(false);
        	Corona coro = new Corona();
        	
        }else if (e.getSource() == rainbowlogo) {
        	this.setVisible(false);
        	Rainbow rain = new Rainbow();
        }else if (e.getSource() == immlogo) {
        	this.setVisible(false);
        	Immigration imm = new Immigration();
        }else if (e.getSource() == rules) {
        	Rules rul = new Rules();
        	
        	
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



