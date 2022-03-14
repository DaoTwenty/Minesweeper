package Grid;


import java.util.ArrayList;

public abstract class Tile {

	private final int x;
	private final int y;
	private final Grid grid;
	private boolean marked = false;
	private boolean hidden;
	
	public Tile(int x, int y, Grid grid) {
		this.x = x;
		this.y = y;
		this.grid = grid;
		hidden = true;
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

	public boolean isMarked() {
		return marked;
	}

	public boolean mark() {
		marked = !marked;
		ArrayList<Tile> proxTiles = getProxTiles();
		for (Tile tile  : proxTiles) {
			if (tile.getType().equals("E")) {
				EmptyTile emptyTile = (EmptyTile) tile;
				if (marked) {
					emptyTile.addMarkedBombs(true);
				}
				else {
					emptyTile.addMarkedBombs(false);
				}
			}
		}
		return marked;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void unHide() {
		hidden = false;
	}
	
	@Override
	public String toString() {
		if (getType().equals("B")) {
			return "X";
		}
		else {
			EmptyTile eTile = (EmptyTile) this;
			return Integer.toString(eTile.getProx());
		}
	}

	public ArrayList<Tile> getProxTiles() {
		ArrayList<Tile> proxTiles = new ArrayList<Tile>();
		int x =  getX();
		int y =  getY();
		int lastX = getGrid().getHeight() - 1;
		int lastY = getGrid().getWidth() - 1;
		if (x==0) {
			if (y==0) {
				proxTiles.add(grid.getTile(x+1, y));
				proxTiles.add(grid.getTile(x, y+1));
				proxTiles.add(grid.getTile(x+1, y+1));
			}
			else if (y==lastY)  {
				proxTiles.add(grid.getTile(x+1, y));
				proxTiles.add(grid.getTile(x, y-1));
				proxTiles.add(grid.getTile(x+1, y-1));
			}
			else {
				proxTiles.add(grid.getTile(x+1, y));
				proxTiles.add(grid.getTile(x+1, y-1));
				proxTiles.add(grid.getTile(x+1, y+1));
				proxTiles.add(grid.getTile(x, y-1));
				proxTiles.add(grid.getTile(x, y+1));
			}
		}
		else if (x == lastX) {
			if (y == 0) {
				proxTiles.add(grid.getTile(x - 1, y));
				proxTiles.add(grid.getTile(x, y + 1));
				proxTiles.add(grid.getTile(x - 1, y + 1));
			} else if (y == lastY) {
				proxTiles.add(grid.getTile(x - 1, y));
				proxTiles.add(grid.getTile(x, y - 1));
				proxTiles.add(grid.getTile(x - 1, y - 1));
			} else {
				proxTiles.add(grid.getTile(x - 1, y));
				proxTiles.add(grid.getTile(x - 1, y - 1));
				proxTiles.add(grid.getTile(x - 1, y + 1));
				proxTiles.add(grid.getTile(x, y - 1));
				proxTiles.add(grid.getTile(x, y + 1));
			}
		}
		else {
			if (y == 0) {
				proxTiles.add(grid.getTile(x - 1, y));
				proxTiles.add(grid.getTile(x + 1, y));
				proxTiles.add(grid.getTile(x + 1, y + 1));
				proxTiles.add(grid.getTile(x, y + 1));
				proxTiles.add(grid.getTile(x - 1, y + 1));
			} else if (y == lastY) {
				proxTiles.add(grid.getTile(x - 1, y));
				proxTiles.add(grid.getTile(x + 1, y));
				proxTiles.add(grid.getTile(x + 1, y - 1));
				proxTiles.add(grid.getTile(x, y - 1));
				proxTiles.add(grid.getTile(x - 1, y - 1));
			} else {
				proxTiles.add(grid.getTile(x - 1, y));
				proxTiles.add(grid.getTile(x - 1, y - 1));
				proxTiles.add(grid.getTile(x - 1, y + 1));
				proxTiles.add(grid.getTile(x + 1, y));
				proxTiles.add(grid.getTile(x + 1, y - 1));
				proxTiles.add(grid.getTile(x + 1, y + 1));
				proxTiles.add(grid.getTile(x, y - 1));
				proxTiles.add(grid.getTile(x, y + 1));
			}
		}
		return proxTiles;
	}
	
}
