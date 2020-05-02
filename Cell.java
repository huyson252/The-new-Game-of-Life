import java.awt.Color;
import javax.swing.*;

public class Cell extends JButton{
	protected boolean alive; 
	protected Color color ;
	public Cell(boolean a){
		alive = a;
		color = Color.white;
	}
	public void setAlive(boolean a) {
		this.alive = a;
	}
}
	
