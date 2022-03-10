package MainTest;

import Grid.*;

public class MainTest {
	
	public static void main(String[] args)
	   {
	      Grid grid = new Grid(16, 16);
	      GridGeneration gridGeneration = new GridGeneration(grid, 1, 0.2);
	      System.out.println(grid.toString());
	   }
}
