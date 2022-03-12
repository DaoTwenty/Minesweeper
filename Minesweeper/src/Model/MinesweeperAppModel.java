package Model;

import Grid.*;
import UI.MinesweeperApp;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Timer;

public class MinesweeperAppModel extends Observable{

    private Grid grid;
    private boolean finished = false;
    private int height;
    private int width;
    private int generationAlgorithm;
    private double density;
    private ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>();
    private boolean fail = false;
    private boolean newGame = false;
    private int numMarked = 0;
    private Timer timer;

    public MinesweeperAppModel() {
        getSavedPreferences();
        grid = new Grid(height, width);
        GridGeneration gridGeneration = new GridGeneration(grid, generationAlgorithm, density);
    }

    public void addListener(ChangeListener listener) {
        listeners.add(listener);
    }

    private void stateChanges() {
        ChangeEvent event = new ChangeEvent(this);
        for (ChangeListener listener : listeners) {
            listener.stateChanged(event);
        }
    }

    private void getSavedPreferences() {
        height = 10;
        width = 20;
        generationAlgorithm = 1;
        density = 0.2;
    }

    public void createNew() {
        getSavedPreferences();
        grid = new Grid(height, width);
        GridGeneration gridGeneration = new GridGeneration(grid, generationAlgorithm, density);
        newGame = true;
        stateChanges();
    }

    public void isRightClicked(Tile tile) {
        if (!tile.isHidden()) {
            boolean marked = tile.mark();
            stateChanges();
            if (marked) {
                numMarked++;
            }
            else {
                numMarked--;
            }
            stateChanges();
        }
    }

    public void isClicked(Tile tile) {
        if (!tile.isMarked()) {
            if (tile.getType().equals("B")) {
                tile.unHide();
                fail = true;
            }
            else {
                EmptyTile emptyTile = (EmptyTile) tile;
                if (emptyTile.isHidden()) {
                    emptyTile.unHide();
                }
                else {
                    revealProx(emptyTile);
                }
            }
            stateChanges();
        }
    }

    public void revealProx(EmptyTile tile) {
        boolean bombsMarked = true;
        ArrayList<Tile> proxTiles = tile.getProxTiles();
        for (Tile oTile : proxTiles) {
            if (oTile.getType().equals("B")) {
                if (!tile.isMarked()) {
                    bombsMarked = false;
                }
            }
        }
        if (bombsMarked) {
            for (Tile oTile : tile.getGrid().getTiles()) {
                if (!oTile.isMarked()) {
                    EmptyTile oEmptyTile = (EmptyTile) oTile;
                    oEmptyTile.unHide();
                }
            }
        }
        else {
            fail = true;
        }
        stateChanges();
    }

    public void setFail(boolean fail) {
        this.fail = fail;
    }

    public boolean isFail() {
        return fail;
    }

    public void setNewGame(boolean newGame) {
        this.newGame = newGame;
    }

    public boolean isNewGame() {
        return newGame;
    }

    public Grid getGrid() {
        return grid;
    }
}
