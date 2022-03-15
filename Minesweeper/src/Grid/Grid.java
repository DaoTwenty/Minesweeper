package Grid;

import java.util.ArrayList;

public class Grid {
	
	private final int height;
	private final int width;
	private final ArrayList<Tile> tiles;
	
	public Grid(int height, int width) {
		tiles = new ArrayList<Tile>();
		this.height = height;
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}

	public int size()  {
		return tiles.size();
	}
	
	public ArrayList<Tile> getTiles() {
		return tiles;
	}
	
	public void add(Tile tile) {
		System.out.print(" to " + tile.getX() + " ," +tile.getY());
		System.out.println("");
		tiles.add(tile.getX()*width + tile.getY(),tile);
	}

	public Tile getTile(int n) {
		return tiles.get(n);
	}

	public Tile getTile(int x, int y)  {
		int n = (x*width) + y;
		Tile tile =  getTile(n);
		return tile;
	}
	
	@Override
	public String toString() {
		String grid = "";
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				Tile tile = getTile(i, j);
				grid += tile.toString();
			}
		grid += "\n";
		}
		return grid;
	}

	public void print() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				Tile tile = getTile(i,j);
				if (tile.isHidden()) {
					System.out.print("°");
				}
				else {
					System.out.print(tile.getType());
				}
			}
			System.out.println("");
		}
	}

}
