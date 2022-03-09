package Grid;


public abstract class Tile {

	private final int x;
	private final int y;
	private final Grid grid;
	
	public Tile(int x, int y, Grid grid) {
		this.x = x;
		this.y = y;
		this.grid = grid;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Grid getGrid() {
		return grid;
	}
	
	public abstract String getType();
	
	@Override
	public String toString() {
		return getType();
	}
	
}
