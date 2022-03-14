package Model;

import Grid.*;
import UI.CountChangeEvent;
import UI.MinesweeperApp;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import javax.swing.Timer;

public class MinesweeperAppModel extends Observable{

    private Grid grid;
    private boolean finished = false;
    private int height;
    private int width;
    private int generationAlgorithm;
    private double density;
    private ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>();
    private ChangeListener clockListener;
    private ChangeListener countListener;
    private boolean fail = false;
    private boolean newGame = false;
    private boolean pressed = false;
    private boolean gameStarted = false;
    private int numMarked = 0;
    private int time = 0;
    ActionListener taskPerformer = evt -> {
        time ++;
        updateClock();
    };
    int delay = 1000; //milliseconds
    private Timer timer = new Timer(delay, taskPerformer);

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
        time = 0;
        numMarked = 0;
        if (gameStarted) {
            endGame();
        }
        stateChanges();
        updateClock();
        updateCount();
    }

    public void isRightClicked(Tile tile) {
        if (tile.isHidden()) {
            boolean marked = tile.mark();
            stateChanges();
            if (marked) {
                numMarked++;
                updateCount();
            }
            else {
                numMarked--;
                updateCount();
            }
            stateChanges();
        }
    }

    public void isClicked(Tile tile) {
        if (!gameStarted) {
            startGame();
        }
        if (!tile.isMarked()) {
            if (tile.getType().equals("B")) {
                tile.unHide();
                setFail(true);
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
                    Bomb bTile = (Bomb) oTile;
                    bTile.setNotFound(true);
                }
            }
        }
        if (bombsMarked) {
            for (Tile oTile : tile.getProxTiles()) {
                if (!oTile.isMarked()) {
                    EmptyTile oEmptyTile = (EmptyTile) oTile;
                    oEmptyTile.unHide();
                    if (oEmptyTile.getProx() == 0) {
                        revealProx(oEmptyTile);
                    }
                }
            }
        }
        else {
            setFail(true);
        }
        stateChanges();
    }

    public void setFail(boolean fail) {
        this.fail = fail;
        if (fail) {
            endGame();
        }
    }

    public boolean isFail() {
        return fail;
    }

    public void setNewGame(boolean newGame) {
        this.newGame = newGame;
        stateChanges();
    }

    public void startGame() {
        gameStarted = true;
        timer.start();
    }

    public void endGame() {
        gameStarted = false;
        timer.stop();
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
            return "/Data/Minesweeper_bomb_red.png";
        }
        else if (pngName.equals("graybomb")) {
            return "/Data/Minesweeper_bomb.png";
        }
        else if (pngName.equals("crossedbomb")) {
            return "/Data/Minesweeper_bomb_crossed.png";
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
        else if (pngName.equals("surprised")) {
            return "/Data/Minesweeper_surprised.png";
        }
        else if (pngName.equals("happy pressed")) {
            return "/Data/Minesweeper_happy_pressed.png";
        }
        else {
            return "";
        }
    }

    public void setCountListener(ChangeListener countListener) {
        this.countListener = countListener;
    }

    public void setClockListener(ChangeListener clockListener) {
        this.clockListener = clockListener;
    }

    public void updateClock() {
        CountChangeEvent change = new CountChangeEvent(this, time);
        clockListener.stateChanged(change);
    }

    public void updateCount() {
        CountChangeEvent change = new CountChangeEvent(this, numMarked);
        countListener.stateChanged(change);
    }
}
