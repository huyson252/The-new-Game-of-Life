import java.util.LinkedList;
import java.util.ArrayList; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Corona extends JFrame implements ActionListener,ChangeListener{
	
	PlayGround play;
    ImagePanel panelMain;
    ImagePanel panelcommand;
    JButton menu;
    JButton pattern;
    JButton rules;
    JButton men; 
    JButton locked;
    JButton infect;
    JButton start;
    JButton stop;
    JButton clear;
    JLabel countmen;
    JLabel countlocked;
    JLabel countinfect;
    JLabel sliderspeed;
    JLabel slidersize;
    JSlider size; 
    JSlider speed;
	int w;
    int h;
    int a=30; //provisoire
    int cmen = 20; //compteur d'homme restant (voir exemple IHM sur discord)
    int cinfect= 20;//compteur corona
    int clocked= 20;//compteur cellule locked
    
    
    public Corona(){
    	
    	 this.setTitle("Game Of Corolife");
         Toolkit tk = Toolkit.getDefaultToolkit();
         w = ((int) tk.getScreenSize().getWidth());
         h = ((int) tk.getScreenSize().getHeight());
         this.setBounds(0,0,w,h);
         setLayout(null);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setResizable(false);

         menu = new JButton (new ImageIcon("buttonhomecorona.png"));
         menu.setBounds(4*w/100,6*h/100,20*w/100,60*h/1000);
         menu.setBackground(Color.black);
         menu.addActionListener(this);
         
         pattern = new JButton (new ImageIcon("buttonpatterncorona.jpg"));
         pattern.setBounds(4*w/100,15*h/100,20*w/100,60*h/1000);
         pattern.setBackground(Color.black);
         pattern.addActionListener(this);
         
         rules = new JButton(new ImageIcon(((new ImageIcon("buttonrulescorona.jpg")).getImage()).getScaledInstance(300, 60, java.awt.Image.SCALE_SMOOTH)));
         rules.setBounds(4*w/100,24*h/100,20*w/100,60*h/1000);
         rules.setBackground(Color.black);
         rules.addActionListener(this);
         
         men = new JButton(new ImageIcon(((new ImageIcon("bonhommevivant.png")).getImage()).getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH)));
         men.setBounds(4*w/100,51*h/100,70*h/1000,70*h/1000);
         men.setBackground(Color.white);
         men.addActionListener(this);
        
         locked = new JButton(new ImageIcon(((new ImageIcon("caseblockedcorona.png")).getImage()).getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH)));
         locked.setBounds(115*w/1000,51*h/100,70*h/1000,70*h/1000);
         locked.setBackground(Color.white);
         locked.addActionListener(this);
                  
         infect = new JButton(new ImageIcon(((new ImageIcon("corona.png")).getImage()).getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH)));
         infect.setBounds(19*w/100,51*h/100,70*h/1000,70*h/1000);
         infect.setBackground(Color.white);
         infect.addActionListener(this);
         
         start = new JButton(new ImageIcon(((new ImageIcon("buttonplaycorona.png")).getImage()).getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH)));
         start.setBounds(4*w/100,65*h/100,70*h/1000,70*h/1000);
         start.setBackground(Color.white);
         start.addActionListener(this);
         
         stop = new JButton(new ImageIcon(((new ImageIcon("buttonpausecorona.png")).getImage()).getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH)));
         stop.setBounds(115*w/1000,65*h/100,70*h/1000,70*h/1000);
         stop.setBackground(Color.white);
         stop.addActionListener(this);
         
         clear = new JButton(new ImageIcon(((new ImageIcon("buttonclearcorona.png")).getImage()).getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH)));
         clear.setBounds(19*w/100,65*h/100,70*h/1000,70*h/1000);
         clear.setBackground(Color.white);
         clear.addActionListener(this);
         
         countmen = new JLabel ();
         countmen.setText("<"+cmen+">");
         countmen.setFont(new Font("Courier", Font.PLAIN,15));
         countmen.setBounds(5*w/100,58*h/100,70*h/1000,50*h/1000);
         countmen.setForeground(Color.white);
     
         
         countinfect = new JLabel ();
         countinfect.setText("<"+cinfect+">");
         countinfect.setFont(new Font("courier", Font.PLAIN, 15));
         countinfect.setBounds(125*w/1000,58*h/100,70*h/1000,50*h/1000);
         countinfect.setForeground(Color.white);
                  
         countlocked = new JLabel ();
         countlocked.setText("<"+clocked+">");
         countlocked.setFont(new Font("courier", Font.PLAIN, 15));
         countlocked.setBounds(20*w/100,58*h/100,70*h/1000,50*h/1000);
         countlocked.setForeground(Color.white);
         
         slidersize = new JLabel();
         slidersize.setText("change the size of the grill:");
         slidersize.setFont(new Font("courier", Font.PLAIN, 15));
         slidersize.setBounds(70,320,300,50);
         slidersize.setForeground(Color.white);
                 
         sliderspeed = new JLabel();
         sliderspeed.setText("change the speed of evolution:");
         sliderspeed.setFont(new Font("courier", Font.PLAIN, 15));
         sliderspeed.setBounds(70,400,300,50);
         sliderspeed.setForeground(Color.white);
         	
         size = new JSlider(10,100); //nb min et max de cellules
         size.setBounds(55,370,300,30);
         size.setOpaque(false);
         size.setMajorTickSpacing(10);
         size.setMinorTickSpacing(5);
         size.setPaintTicks(false);
         size.setSnapToTicks(true);
         size.addChangeListener(this);
                  
         speed = new JSlider();
         speed.setBounds(55,450,300,30);
         speed.setOpaque(false);
         speed.setMajorTickSpacing(10);
         speed.setMinorTickSpacing(5);
         speed.setPaintTicks(false);
         speed.setSnapToTicks(true);
         speed.addChangeListener(this);
         

         
    	play = new PlayGround(a);
    	//int a variable déterminée par JSlider size 
        play.setBounds(90*h/1000,140*h/1000,456*w/1000,685*h/1000);
        //faire de la taille de play une variable qui dépend de a le nb de cellule
        
    	
    	panelcommand = new ImagePanel("pannelcorona.png");
        panelcommand.setLayout(null);
        panelcommand.add(menu);
        panelcommand.add(pattern);
        panelcommand.add(rules);
        panelcommand.add(men);
        panelcommand.add(locked);
        panelcommand.add(infect);
        panelcommand.add(start);
        panelcommand.add(stop);
        panelcommand.add(clear);
        panelcommand.add(countmen);
        panelcommand.add(countlocked);
        panelcommand.add(countinfect);
        panelcommand.add(slidersize);
        panelcommand.add(sliderspeed);
        panelcommand.add(size);
        panelcommand.add(speed);
        
        
        panelcommand.setBounds(4*w/6, h/10,500*h/1000,800*h/1000);
        
        panelMain = new ImagePanel("backgroundcorona.png");
        panelMain.setLayout(null);
        panelMain.add(panelcommand);
        panelMain.add(play);
        panelMain.setBounds(0,0,w,h);
        this.add(panelMain);
        
        this.setVisible(true);

    }
    
    
    public void actionPerformed (ActionEvent e){
    	if (e.getSource() == menu) {
    		this.setVisible(false);
        	Menu men = new Menu();
    		
    	}else if (e.getSource() == rules) {
    		
    		Rules rul = new Rules();
    		
    	}else if (e.getSource() == pattern) {
    		
    		Pattern pat = new Pattern();
    		//methode inserer pattern
    		
    	}else if (e.getSource() == men) {
    		//methode inserer un homme dans la grille
    		
    		if (cmen > 0) {
    			cmen=cmen-1;
        		this.countmen.setText("<"+cmen+">");
    		}
    		
    	}else if (e.getSource() == infect) {
    		//methode inserer un virus dans la grille
    		
    		if (cinfect > 0) {
    			cinfect=cinfect-1;
        		this.countinfect.setText("<"+cinfect+">");
    		}
    		
    	}else if (e.getSource() == locked) {
    		//methode inserer locked dans la grille

    		if (clocked > 0) {
    			clocked=clocked-1;
        		this.countlocked.setText("<"+clocked+">");
    		}
    		
    	}else if (e.getSource() == start) {
    		play.evolve();
    		play.startgame();
    		
    	}else if (e.getSource() == stop) {
    		play.stopgame();
    		
    	}else if (e.getSource() == clear) {
    		play.cleargrill();
    	}
    }
    
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
         a = (int)source.getValue();
        //mettre a jour la grille?
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
