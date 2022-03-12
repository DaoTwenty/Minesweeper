package UI;

import Model.MinesweeperAppModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MinesweeperApp extends JFrame implements ChangeListener {

    private final MenuBar menuBar;
    private final WindowPanel windowPanel;
    private MinesweeperAppModel minesweeperAppModel = new MinesweeperAppModel();

    public MinesweeperApp() throws HeadlessException {
        super("MineSweeper");
        menuBar = new MenuBar(this);
        setJMenuBar(menuBar);
        windowPanel = new WindowPanel(this, minesweeperAppModel.getGrid());
        setContentPane(windowPanel);
        minesweeperAppModel.addListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        pack() ;
        setVisible(true) ;
    }

    public MinesweeperAppModel getModel() {
        return minesweeperAppModel;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        windowPanel.notifyForUpdate();
    }

    public static BufferedImage getBufferedImage(String filename) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(filename));
        }
        catch (IOException e) {
            System.out.println(e);
        }
    return image;
    }

}
