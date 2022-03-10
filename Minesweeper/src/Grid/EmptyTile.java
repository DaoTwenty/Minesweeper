package Grid;

public class EmptyTile extends Tile{
	
	public int prox;
	private boolean hidden = true;
	
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
	
	public boolean isHidden() {
		return hidden;
	}
	
	public void unHide() {
		hidden = false;
	}

}
