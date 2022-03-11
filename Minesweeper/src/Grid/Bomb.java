package Grid;

public class Bomb extends Tile{

	public Bomb(int x, int y, Grid grid) {
		super(x ,y ,grid);
	}

	public String getType() {
		return "B";
	}
}
