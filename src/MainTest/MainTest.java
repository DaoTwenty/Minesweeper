package MainTest;

import Grid.*;

public class MainTest {
	
	public static void main(String[] args)
	   {
	      Grid grid = new Grid(16, 16);
	      GridGeneration.setDensity(0.2);
	      GridGeneration gridGeneration = new GridGeneration(grid, 1);
	      System.out.println(grid.toString());
	   }
}
