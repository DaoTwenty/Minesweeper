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
    private boolean pressed = false;
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

    public boolean isPressed() {
        return pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }

    public String getPNG(String pngName) {
        if (pngName.equals("0")) {
            return "/Data/Minesweeper_0.png";
        }
        else if (pngName.equals("1")) {
            return "/Data/Minesweeper_1.png";
        }
        else if (pngName.equals("2")) {
            return "/Data/Minesweeper_2.png";
        }
        else if (pngName.equals("3")) {
            return "/Data/Minesweeper_3.png";
        }
        else if (pngName.equals("4")) {
            return "/Data/Minesweeper_4.png";
        }
        else if (pngName.equals("5")) {
            return "/Data/Minesweeper_5.png";
        }
        else if (pngName.equals("6")) {
            return "/Data/Minesweeper_6.png";
        }
        else if (pngName.equals("7")) {
            return "/Data/Minesweeper_7.png";
        }
        else if (pngName.equals("8")) {
            return "/Data/Minesweeper_8.png";
        }
        else if (pngName.equals("flagged")) {
            return "/Data/Minesweeper_flagged.png";
        }
        else if (pngName.equals("hidden")) {
            return "/Data/Minesweeper_hidden.png";
        }
        else if (pngName.equals("redbomb")) {
            return "/Data/Minesweeper_bomb.png"; //replace with red bomb
        }
        else if (pngName.equals("graybomb")) {
            return "/Data/Minesweeper_bomb.png"; //replace with gray bomb
        }
        else if (pngName.equals("happy")) {
            return "/Data/Minesweeper_happy.png";
        }
        else if (pngName.equals("sad")) {
            return "/Data/Minesweeper_sad.png";
        }
        else if (pngName.equals("cool")) {
            return "/Data/Minesweeper_cool.png";
        }
        else if (pngName.equals("happy")) {
            return "/Data/Minesweeper_surprised.png";
        }
        else {
            return "";
        }
    }
}
