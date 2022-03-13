package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class NewGameButton extends JButton {

    private MinesweeperApp app;
    private ImageIcon icon;

    public  NewGameButton(MinesweeperApp app) {
        super();
        this.app = app;
        BufferedImage image = app.getBufferedImage(app.getModel().getPNG("happy"));
        int size = (int) 1.5*app.getUnitSize();
        icon =  new ImageIcon(image.getScaledInstance(size, size, Image.SCALE_SMOOTH));
        setIcon(icon);
        setMaximumSize(getSize());
        setMinimumSize(getSize());
    }

}
