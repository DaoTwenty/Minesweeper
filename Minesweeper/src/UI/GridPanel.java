package UI;

import Grid.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public final class GridPanel extends JPanel {

    private MinesweeperApp app;
    private Grid grid;
    private ArrayList<TilePanel> tiles = new ArrayList<>();
    private static int size;

    public GridPanel(MinesweeperApp app, Grid grid) {
        super();
        this.app = app;
        this.grid = grid;
        int x = grid.getHeight();
        int y = grid.getWidth();
        size = app.getUnitSize();
        setPreferredSize(new Dimension(y*size, x*size));
        setMinimumSize(getSize());
        setLayout( new GridLayout( x, y));
        for (Tile tile : grid.getTiles()) {
            TilePanel tilePanel = new TilePanel(app, tile);
            tiles.add(tilePanel);
            add(tilePanel);
        }
    }

    public void notifyForUpdate() {
        if (app.getModel().isNewGame()) {
            removeAll();
            updateUI();
            grid = app.getModel().getGrid();
            int x = grid.getHeight();
            int y = grid.getWidth();
            setLayout( new GridLayout( x, y));
            for (Tile tile : grid.getTiles()) {
                add(new TilePanel(app, tile));
            }
        }
        else {
            for (TilePanel tilePanel : tiles) {
                tilePanel.notifyForUpdate();
            }
        }
    }
}
