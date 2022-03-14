package Grid;

public class Bomb extends Tile{

	private boolean notFound;

	public Bomb(int x, int y, Grid grid) {
		super(x ,y ,grid);
	}

	public String getType() {
		return "B";
	}

	public boolean isNotFound() {
		return notFound;
	}

	public void setNotFound(boolean notFound) {
		this.notFound = notFound;
	}
}
