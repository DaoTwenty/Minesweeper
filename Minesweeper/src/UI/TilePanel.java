package UI;

import Grid.EmptyTile;
import Grid.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TilePanel extends JLabel {

    MinesweeperApp app;
    Tile tile;
    BufferedImage image;
    //TileMouseListener mouseListener;

    public TilePanel(MinesweeperApp app, Tile tile) {
        super();
        this.app = app;
        this.tile = tile;
        //mouseListener = new TileMouseListener(app, this);
        image = app.getBufferedImage(app.getModel().getPNG("hidden"));
        setIcon( new StretchIcon(image, true));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //setIcon( new StretchIcon(image, true));
        System.out.println("repainted");
    }

    public void updateImage() {
        if (app.getModel().isFail() && tile.getType().equals("B")) {
            if (tile.isMarked()){
                image = app.getBufferedImage(app.getModel().getPNG("redbomb"));  //replace with red bomb tile
            }
            else {
                image = app.getBufferedImage(app.getModel().getPNG("graybomb"));  //replace with gray bomb tile
            }
        }
        else {
            if (tile.isHidden()) {
                if (tile.isMarked()) {
                    image = app.getBufferedImage(app.getModel().getPNG("flagged"));
                } else {
                    image = app.getBufferedImage(app.getModel().getPNG("hidden"));
                }
            }
            else {
                EmptyTile eTile = (EmptyTile) tile;
                switch (eTile.getProx()) {
                    case 0:
                        image = app.getBufferedImage(app.getModel().getPNG("0"));
                        break;
                    case 1:
                        image = app.getBufferedImage(app.getModel().getPNG("1"));
                        break;
                    case 2:
                        image = app.getBufferedImage(app.getModel().getPNG("2"));
                        break;
                    case 3:
                        image = app.getBufferedImage(app.getModel().getPNG("3"));
                        break;
                    case 4:
                        image = app.getBufferedImage(app.getModel().getPNG("4"));
                        break;
                    case 5:
                        image = app.getBufferedImage(app.getModel().getPNG("5"));
                        break;
                    case 6:
                        image = app.getBufferedImage(app.getModel().getPNG("6"));
                        break;
                    case 7:
                        image = app.getBufferedImage(app.getModel().getPNG("7"));
                        break;
                    case 8:
                        image = app.getBufferedImage(app.getModel().getPNG("8"));
                        break;
                }
            }
        }
        System.out.print("image updated");
    }



    public void updateImagePressed() {
        boolean pressed = app.getModel().isPressed();
        if (pressed) {
            image = app.getBufferedImage(app.getModel().getPNG("0"));
        }
        else {
            updateImage();
        }
        repaint();
        System.out.println("tile updated");
    }

    public Grid.Tile getTile() {
        return tile;
    }

    public void notifyForUpdate() {
        updateImage();
        repaint();
    }

    public void notifyPressed() {
        updateImagePressed();
        repaint();
    }

    public void notifyExited() {
        updateImage();
        repaint();
    }

}
