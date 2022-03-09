package Grid;

import java.util.Random;

/**
 * Generation process
 */
public class GridGeneration {
	
	private final Grid grid;
	private final int generationAlgorithm;
	private static double density;
	
	public GridGeneration(Grid grid, int generationAlgorithm) {
		this.grid = grid;
		this.generationAlgorithm = generationAlgorithm;
		switch (this.generationAlgorithm) {
			case 1:
				algorithmRandom();
				break;
		}
	}
	
	public static void setDensity(double d) {
		GridGeneration.density = d;
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
