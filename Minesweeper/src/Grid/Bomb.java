package Grid;

public class Bomb extends Tile{
	
	private boolean marked = false;
	
	public Bomb(int x, int y, Grid grid) {
		super(x ,y ,grid);
	}
	
	public boolean isMarked() {
		return marked;
	}
	
	public void Mark(boolean marked) {
		this.marked = marked;
	}
	
	public String getType() {
		return "B";
	}
}
