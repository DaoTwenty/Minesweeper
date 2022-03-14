package UI;

import Grid.Tile;
import Model.MinesweeperAppModel;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TileMouseListener extends MouseAdapter {

    MinesweeperApp app;
    TilePanel tilePanel;

    public TileMouseListener(MinesweeperApp app, TilePanel tilePanel) {
        super();
        this.app = app;
        this.tilePanel = tilePanel;
    }

    @Override
    public final void mouseClicked(MouseEvent e) {
        MinesweeperAppModel model = app.getModel();
        Tile tile = tilePanel.getTile();
        //System.out.println("There is a ");
        if (SwingUtilities.isLeftMouseButton(e)) {
            System.out.println("left click at " + Integer.toString(tile.getX()) + ", " + Integer.toString(tile.getY()));
            model.isClicked(tile);
        }
        else if (SwingUtilities.isRightMouseButton(e)) {
            System.out.println("right click at " + Integer.toString(tile.getX()) + ", " + Integer.toString(tile.getY()));
            model.isRightClicked(tile);
        }
    }

    /*
    @Override
    public final void mousePressed(MouseEvent e) {
        MinesweeperAppModel model = app.getModel();
        model.setPressed(true);
        tilePanel.notifyPressed();
    }

    @Override
    public final void mouseReleased(MouseEvent e) {
        MinesweeperAppModel model = app.getModel();
        model.setPressed(false);
        Tile tile = tilePanel.getTile();
        if (SwingUtilities.isLeftMouseButton(e)) {
            model.isClicked(tile);
        }
        else if (SwingUtilities.isRightMouseButton(e)) {
            model.isRightClicked(tile);
        }
    }

    @Override
    public final void mouseEntered(MouseEvent e) {
        tilePanel.notifyPressed();
    }

    @Override
    public final void mouseExited(MouseEvent e) {
        tilePanel.notifyExited();
    }

     */
}
