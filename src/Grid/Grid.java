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
	
	public ArrayList<Tile> getGrid() {
		return tiles;
	}
	
	public void add(Tile tile) {
		tiles.add(tile);
	}
	
	@Override
	public String toString() {
		String grid = "";
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				Tile tile = tiles.get(i*height + j);
				grid += tile.toString();
			}
		grid += "\n";
		}
		return grid;
	}

}
