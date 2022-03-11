package Grid;

import java.util.ArrayList;

public class EmptyTile extends Tile{
	
	public int prox;
	public int markedBombs = 0;
	
	public EmptyTile(int x, int y, Grid grid) {
		super(x, y, grid);
	}
	
	public void setProx(int prox) {
		this.prox = prox;
	}
	
	public int getProx() {
		return prox;
	}
	
	public String getType() {
		return "E";
	}

	public void addMarkedBombs(boolean add) {
		if (add) {
			markedBombs++;
		}
		else {
			markedBombs--;
		}
	}

	public int getMarkedBombs() {
		return markedBombs;
	}
}
