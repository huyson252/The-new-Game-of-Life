import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Rainbow extends JFrame implements ActionListener,ChangeListener{
	
	PlayGround play;
    ImagePanel panelMain;
    ImagePanel panelcommand;
    Timer delay;
    JButton menu;
    JButton pattern;
    JButton rules;
    JButton start;
    JButton stop;
    JButton clear;
    JLabel sliderspeed;
    JLabel slidersize;
    JSlider size; 
    JSlider speed;
	int w;
    int h;
    int a=25; //provisoire
	Timer mt;
	int timerDelay;
    
    public Rainbow(){
    	
    	 this.setTitle("Rainbow Life");
         Toolkit tk = Toolkit.getDefaultToolkit();
         w = ((int) tk.getScreenSize().getWidth());
         h = ((int) tk.getScreenSize().getHeight());
         
         //New timer object
         timerDelay = 500;
         mt = new Timer(timerDelay, this);
         
         this.setBounds(0,0,w,h);
         setLayout(null);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setResizable(false);

         menu = new JButton (new ImageIcon("buttonhomepurple.png"));
         menu.setBounds( 4*w/100,6*h/100,20*w/100,60*h/1000);
         menu.setBackground(Color.white);
         menu.addActionListener(this);
                 
         pattern = new JButton (new ImageIcon("buttonpatterngreen.jpg"));
         pattern.setBounds(4*w/100,18*h/100,20*w/100,60*h/1000);
         pattern.setBackground(Color.white);
         pattern.addActionListener(this);
         
         rules = new JButton (new ImageIcon("buttonrulesblue.jpg"));
         rules.setBounds(4*w/100,30*h/100,20*w/100,60*h/1000);
         rules.setBackground(Color.white);
         rules.addActionListener(this);
                
                 
         start = new JButton(new ImageIcon(((new ImageIcon("buttonplayorange.png")).getImage()).getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH)));
         start.setBounds(4*w/100,62*h/100,70,70);
         start.setBackground(Color.white);
         start.addActionListener(this);
         
         stop = new JButton(new ImageIcon(((new ImageIcon("buttonpausered.png")).getImage()).getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH)));
         stop.setBounds(115*w/1000,62*h/100,70,70);
         stop.setBackground(Color.white);
         stop.addActionListener(this);
         
         clear = new JButton(new ImageIcon(((new ImageIcon("buttonclearrainbow.png")).getImage()).getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH)));
         clear.setBounds(19*w/100,62*h/100,70,70);
         clear.setBackground(Color.white);
         clear.addActionListener(this);
                         
         slidersize = new JLabel();
         slidersize.setText("change the size of the grill:");
         slidersize.setFont(new Font("ink free", Font.PLAIN, 16));
         slidersize.setBounds(8*w/100,39*h/100,300,50);
         slidersize.setForeground(Color.magenta);
         
                 
         sliderspeed = new JLabel();
         sliderspeed.setText("change the speed of evolution:");
         sliderspeed.setFont(new Font("ink free", Font.PLAIN, 16));
         sliderspeed.setBounds(8*w/100,49*h/100,300,50);
         sliderspeed.setForeground(Color.blue);
         
         	
         size = new JSlider(10,100); //nb min et max de cellules
         size.setBounds(4*w/100,44*h/100,300,30);
         size.setOpaque(false);
         size.setMajorTickSpacing(10);
         size.setMinorTickSpacing(5);
         size.setPaintTicks(false);
         size.setSnapToTicks(true);
         size.addChangeListener(this);
                           
         speed = new JSlider(50, 500);
         speed.setOpaque(false);
         speed.setBounds(4*w/100,54*h/100,300,30);
         speed.setMajorTickSpacing(10);
         speed.setMinorTickSpacing(5);
         speed.setPaintTicks(false);
         speed.setSnapToTicks(true);
         speed.addChangeListener(this);
         
         
    	play = new PlayGround(a,start,stop);
    	//int a variable déterminée par JSlider size 
        play.setBounds(90*h/1000,140*h/1000,456*w/1000,685*h/1000);
        //faire de la taille de play une variable qui dépend de a le nb de cellule
        
    	
    	panelcommand = new ImagePanel("rainbowpannel.jpg");
        panelcommand.setLayout(null);
        panelcommand.add(menu);
        panelcommand.add(pattern);
        panelcommand.add(rules);
        panelcommand.add(start);
        panelcommand.add(stop);
        panelcommand.add(clear);
        panelcommand.add(slidersize);
        panelcommand.add(sliderspeed);
        panelcommand.add(size);
        panelcommand.add(speed);
                       
        panelcommand.setBounds(65*w/100, h/10,410*h/1000,950*h/1000);
        
        panelMain = new ImagePanel("bgrainbow.jpg");
        panelMain.setLayout(null);
        panelMain.add(panelcommand);
        panelMain.add(play);
        panelMain.setBounds(0,0,w,h);
        this.add(panelMain);
        
        delay = new Timer(500,this);
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


    	}else if (e.getSource() == start) {
			mt.start();
			//play.evolve();
    	}else if (e.getSource() == mt) {
			play.evolve();
		}else if (e.getSource() == stop) {
			mt.stop();
    		play.gameState(false);
    		
    	}else if (e.getSource() == clear) {
    		play.cleargrill();
    	}
    }
    public void stateChanged(ChangeEvent e) {
        //JSlider source = (JSlider)e.getSource();
        // a = (int)source.getValue();
        //mettre a jour la grille?
		timerDelay = 500 - speed.getValue();
		mt.stop();
		mt = new Timer(timerDelay, this);
		mt.start();
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
