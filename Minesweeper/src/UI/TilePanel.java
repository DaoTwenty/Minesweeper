package UI;

import Grid.EmptyTile;
import Grid.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TilePanel extends JPanel {

    MinesweeperApp app;
    Tile tile;
    BufferedImage image;

    public TilePanel(MinesweeperApp app, Tile tile) {
        super();
        this.app = app;
        this.tile = tile;
        image = MinesweeperApp.getBufferedImage("Data/Minesweeper_hidden");
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }

    public void updateImage() {
        if (app.getModel().isFail() && tile.getType().equals("B")) {
            if (tile.isMarked()){
                image = MinesweeperApp.getBufferedImage("Data/Minesweeper_bomb");  //replace with red bomb tile
            }
            else {
                image = MinesweeperApp.getBufferedImage("Data/Minesweeper_bomb");  //replace with gray bomb tile
            }
        }
        else {
            if (tile.isHidden()) {
                if (tile.isMarked()) {
                    image = MinesweeperApp.getBufferedImage("Data/Minesweeper_flagged");
                } else {
                    image = MinesweeperApp.getBufferedImage("Data/Minesweeper_hidden");
                }
            }
            else {
                EmptyTile eTile = (EmptyTile) tile;
                switch (eTile.getProx()) {
                    case 0:
                        image = MinesweeperApp.getBufferedImage("Data/Minesweeper_0");
                        break;
                    case 1:
                        image = MinesweeperApp.getBufferedImage("Data/Minesweeper_1");
                        break;
                    case 2:
                        image = MinesweeperApp.getBufferedImage("Data/Minesweeper_2");
                        break;
                    case 3:
                        image = MinesweeperApp.getBufferedImage("Data/Minesweeper_3");
                        break;
                    case 4:
                        image = MinesweeperApp.getBufferedImage("Data/Minesweeper_4");
                        break;
                    case 5:
                        image = MinesweeperApp.getBufferedImage("Data/Minesweeper_5");
                        break;
                    case 6:
                        image = MinesweeperApp.getBufferedImage("Data/Minesweeper_6");
                        break;
                    case 7:
                        image = MinesweeperApp.getBufferedImage("Data/Minesweeper_7");
                        break;
                    case 8:
                        image = MinesweeperApp.getBufferedImage("Data/Minesweeper_8");
                        break;
                }
            }
        }
    }

    public void notifyForUpdate() {
        updateImage();
        repaint();
    }

}
