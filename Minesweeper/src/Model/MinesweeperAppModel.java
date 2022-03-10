package Model;

import Grid.*;
import UI.MinesweeperApp;

import java.util.Observable;

public class MinesweeperAppModel{

    private Grid grid;
    private boolean finished = false;

    public MinesweeperAppModel() {
        int height = 10; // A importer de l'historique
        int width = 20; // A importer de l'historique
        grid = new Grid(height, width);
        GridGeneration gridGeneration = new GridGeneration(grid, 1, 0.2);
    }
}
