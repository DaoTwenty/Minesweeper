package Grid;

import java.util.ArrayList;
import java.util.Random;

/**
 * Generation process
 */
public class GridGeneration {
	
	private final Grid grid;
	private final int generationAlgorithm;
	private double density;
	
	public GridGeneration(Grid grid, int generationAlgorithm, double density) {
		this.grid = grid;
		this.density = density;
		this.generationAlgorithm = generationAlgorithm;
		switch (this.generationAlgorithm) {
			case 1:
				algorithmRandom();
				break;
		}
		ArrayList<Tile> tiles = grid.getTiles();
		for (Tile tile : tiles) {
			if (tile.getType().equals("E")) {
				int prox = 0;
				ArrayList<Tile> proxTiles = tile.getProxTiles();
				for (Tile oTile : proxTiles) {
					if (oTile.getType().equals("B")) {
						prox++;
					}
				}
				EmptyTile emptyTile = (EmptyTile) tile;
				emptyTile.setProx(prox);
			}
		}
	}

	public double getDensity() {
		return density;
	}
	
	public int getAlgorithm() {
		return generationAlgorithm;
	}
	
	private void algorithmRandom() {
		int h = grid.getHeight();
		int w = grid.getWidth();
		Random random = new Random();
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (random.nextFloat() <  density) {
					grid.add(new Bomb(i ,j, grid));
				}
				else {
					grid.add(new EmptyTile(i ,j, grid));
				}
			}
		}
	}
	
}
