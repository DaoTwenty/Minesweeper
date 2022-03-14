package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class NewGameButton extends JButton implements ActionListener {

    private MinesweeperApp app;
    private ImageIcon icon;
    private ImageIcon iconPressed;

    public  NewGameButton(MinesweeperApp app) {
        super();
        this.app = app;
        int size = (int) (1.5*app.getUnitSize());
        BufferedImage image = app.getBufferedImage(app.getModel().getPNG("happy"));
        icon =  new ImageIcon(image.getScaledInstance(size, size, Image.SCALE_SMOOTH));
        BufferedImage imagePressed = app.getBufferedImage(app.getModel().getPNG("happy pressed"));
        iconPressed =  new ImageIcon(imagePressed.getScaledInstance(size, size, Image.SCALE_SMOOTH));
        setBorderPainted(false);
        setBorder(null);
        setFocusable(false);
        setMargin(new Insets(0, 0, 0, 0));
        setContentAreaFilled(false);
        setIcon(icon);
        //setRolloverIcon(myIcon2);
        setPressedIcon(iconPressed);
        //setDisabledIcon(myIcon4);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        app.getModel().createNew();
    }
}
