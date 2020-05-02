import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Immigration extends JFrame implements ActionListener,ChangeListener{
	
	PlayGround play;
    ImagePanel panelMain;
    ImagePanel panelcommand;
    ImagePanel panelslider;
    JButton menu;
    JButton pattern;
    JButton rules;
    JButton red; 
    JButton orange;
    JButton yellow;
    JButton green;
    JButton blue;
    JButton purple;
    JButton start;
    JButton stop;
    JButton clear;
    JLabel sliderspeed;
    JLabel slidersize;
    JSlider size; 
    JSlider speed;
	int w;
    int h;
    int a=50; //provisoire
    
    
    public Immigration(){
    	
    	 this.setTitle("immigration game");
         Toolkit tk = Toolkit.getDefaultToolkit();
         w = ((int) tk.getScreenSize().getWidth());
         h = ((int) tk.getScreenSize().getHeight());
         this.setBounds(0,0,w,h);
         setLayout(null);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setResizable(false);

         menu = new JButton (new ImageIcon("buttonhomeimm.png"));
         menu.setBounds( 4*w/100,4*h/100,20*w/100,60);
         menu.setBackground(Color.white);
         menu.addActionListener(this);
                 
         pattern = new JButton (new ImageIcon("buttonpatternimm.jpg"));
         pattern.setBounds(4*w/100,13*h/100,20*w/100,60*h/1000);
         pattern.setBackground(Color.white);
         pattern.addActionListener(this);
         
         rules = new JButton (new ImageIcon("buttonrulesimm.jpg"));
         rules.setBounds(4*w/100,22*h/100,20*w/100,60*h/1000);
         rules.setBackground(Color.white);
         rules.addActionListener(this);
         
         red= new JButton();
         red.setBackground(Color.red);
         red.setBounds(45*w/1000,520*h/1000,50,50);
         red.addActionListener(this);
         
         yellow= new JButton();
         yellow.setBackground(Color.yellow);
         yellow.setBounds(125*w/1000,520*h/1000,50,50);
         yellow.addActionListener(this);
                 
         orange= new JButton();
         orange.setBackground(Color.orange);
         orange.setBounds(200*w/1000,520*h/1000,50,50);
         orange.addActionListener(this);
         
         
         green= new JButton();
         green.setBackground(Color.green);
         green.setBounds(45*w/1000,600*h/1000,50,50);
         green.addActionListener(this);
         
         
         blue= new JButton();
         blue.setBackground(Color.blue);
         blue.setBounds(125*w/1000,600*h/1000,50,50);
         blue.addActionListener(this);
                  
         purple= new JButton();
         purple.setBackground(Color.magenta);
         purple.setBounds(200*w/1000,600*h/1000,50,50);
         purple.addActionListener(this);
         
                 
         start = new JButton(new ImageIcon(((new ImageIcon("buttonplayimm.png")).getImage()).getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH)));
         start.setBounds(4*w/100,67*h/100,70,70);
         start.setBackground(Color.white);
         start.addActionListener(this);
         
         stop = new JButton(new ImageIcon(((new ImageIcon("buttonpauseimm.jpg")).getImage()).getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH)));
         stop.setBounds(115*w/1000,67*h/100,70,70);
         stop.setBackground(Color.white);
         stop.addActionListener(this);
         
         clear = new JButton(new ImageIcon(((new ImageIcon("buttonclearimm.png")).getImage()).getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH)));
         clear.setBounds(19*w/100,67*h/100,70,70);
         clear.setBackground(Color.white);
         clear.addActionListener(this);
                         
         slidersize = new JLabel();
         slidersize.setText("Change the size of the grill:");
         slidersize.setFont(new Font("arial black", Font.PLAIN, 15));
         slidersize.setBounds(25*w/1000,0,300,50);
         slidersize.setForeground(Color.white);
         
                 
         sliderspeed = new JLabel();
         sliderspeed.setText("Change the speed of evolution:");
         sliderspeed.setFont(new Font("arial black", Font.PLAIN, 15));
         sliderspeed.setBounds(15*w/1000,8*h/100,300,50);
         sliderspeed.setForeground(Color.white);
         
         	
         size = new JSlider(10,100); //nb min et max de cellules
         size.setBounds(3*w/1000,5*h/100,300,30);
         size.setOpaque(false);
         size.setForeground(Color.white);
         size.setMajorTickSpacing(10);
         size.setMinorTickSpacing(5);
         size.setPaintTicks(false);
         size.setSnapToTicks(true);
         size.addChangeListener(this);
                           
         speed = new JSlider();
         speed.setBounds(2*w/1000,13*h/100,300,30);
         speed .setForeground(Color.white);
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
        
    	
    	panelcommand = new ImagePanel("pannelimmigration.jpg");
        panelcommand.setLayout(null);
        panelcommand.add(menu);
        panelcommand.add(pattern);
        panelcommand.add(rules);
        panelcommand.add(red);
        panelcommand.add(orange);
        panelcommand.add(yellow);
        panelcommand.add(green);
        panelcommand.add(blue);
        panelcommand.add(purple);
        panelcommand.add(start);
        panelcommand.add(stop);
        panelcommand.add(clear);
        
        panelslider = new ImagePanel("pannelslider.png");
        panelslider.setLayout(null);
        panelslider.add(slidersize);
        panelslider.add(sliderspeed);
        panelslider.add(size);
        panelslider.add(speed);
        
        panelslider.setBounds(37*w/1000,31*h/100, 25*w/100, 19*h/100);
        
        
        panelcommand.setBounds(65*w/100, h/10,410*h/1000,900*h/1000);
        panelcommand.add(panelslider);
        
        panelMain = new ImagePanel("bgimmigration.jpg");
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
    		
    	}else if (e.getSource() == red) {
    		//methode cellule rouge
    		
    	}else if (e.getSource() == orange) {
    		//methode cellule orange
    		
    	}else if (e.getSource() == yellow) {
    		//methode cellule jaune
    	
    	}else if (e.getSource() == green) {
    		//methode cellule green
    	
    	}else if (e.getSource() == blue) {
    		//methode cellule b

    	}else if (e.getSource() == purple) {
    		//methode cellule v

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
