import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class PlayGround extends JPanel implements ActionListener {
	private Cell[][] cells;
	public PlayGround(int numberOfCells, JButton start, JButton stop) { //for example numberOfCells = 10 signifies a tables of 10x10 cells
		this.setLayout(null);
		this.setBackground(Color.white);
		cells = new Cell[numberOfCells][numberOfCells];
		int side = 700/cells.length;
		for (int i = 0; i < cells.length - 1; i++) {
			for (int j = 0; j< cells.length - 1; j++) {
				cells[i][j] = new Cell(false);
				cells[i][j].setBounds(i * side, j * side, side, side);
				if (i == 0 || j == 0 || i == cells.length - 2  || j == cells.length - 2 ) { //the border is always dead
					cells[i][j].setBackground(Color.GRAY);
					cells[i][j].addActionListener(this);
				} else {
					cells[i][j].setBackground(cells[i][j].color);
					cells[i][j].addActionListener(this);
				}
				this.add(cells[i][j]);
			}
		}
		
	}
	public int countAlive(int a, int b) {
		int count = 0;
		for (int i = a-1; i < a+2; i++) {
			for (int j = b - 1; j < b+2; j++) {
				if (cells[i][j].alive == true) count++;
			}
		}
		if (cells[a][b].alive == true) count -= 1;
		return count;
	}	
	public void evolve() { //evolution of a Cell
		boolean[][] nextGen = new boolean[cells.length][cells.length];
		for (int i = 1; i < cells.length -2 ; i++) {
			for (int j = 1; j< cells.length - 2; j++) {
				if (cells[i][j].alive == true && (countAlive(i,j) < 2 || countAlive(i,j) >3)) {
					nextGen[i][j] = false;
				} else if (cells[i][j].alive == false && countAlive(i,j) == 3) {
					nextGen[i][j] = true;
				} else nextGen[i][j] = cells[i][j].alive;	
			}			
		}
		for (int i = 1; i < cells.length -2 ; i++) {
			for (int j = 1; j< cells.length - 2; j++) {
				cells[i][j].alive = nextGen[i][j];
				visual(cells[i][j]);
			}
		}
	}
	public void visual(Cell c) { //change the color/shape of a cell
		if (c.alive == true) {
			//System.out.println("changing color to black");
			c.color = Color.black;
		}
		else if (c.alive == false) c.color = Color.white;
		c.setBackground(c.color);
	}
	public void cleargrill() {
		for (int i = 1; i < cells.length -2 ; i++) {
			for (int j = 1; j< cells.length - 2; j++) {
				if (cells[i][j].alive == true) {
					cells[i][j].setAlive(!cells[i][j].alive); 
					visual(cells[i][j]);
				}
				
			}
		}
		
	}
	public void gameState(boolean state) {
		
	}
	public void setColor(Color col) {
		
	}
	public void setImage(ImageIcon img) {
		
	}
	
	public void confinedCell(){
	}
	
	public void menInCell(){
		
	}
	public void infectedCell(){
		
	}
	public void setAveragecolor(Color col1, Color col2){

	}
	public void colorGen(int nbGen){
		
	}


	public void actionPerformed(ActionEvent e) {
			for (int i = 1; i < cells.length -2 ; i++) {
				for (int j = 1; j< cells.length - 2; j++) {
					if (e.getSource() == cells[i][j]) {
						cells[i][j].setAlive(!cells[i][j].alive); //reverse the state of a Cell when clicked on
						visual(cells[i][j]);
					} 
				}
			}
	}
}
