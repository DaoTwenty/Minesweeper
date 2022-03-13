package UI;

import Model.MinesweeperAppModel;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class MinesweeperApp extends JFrame implements ChangeListener {

    private final MenuBar menuBar;
    private final WindowPanel windowPanel;
    private MinesweeperAppModel minesweeperAppModel = new MinesweeperAppModel();

    public int getUnitSize() {
        return unitSize;
    }

    private int unitSize = 30;

    public MinesweeperApp() throws HeadlessException {
        super("MineSweeper");
        menuBar = new MenuBar(this);
        setJMenuBar(menuBar);
        windowPanel = new WindowPanel(this, minesweeperAppModel.getGrid());
        setContentPane(windowPanel);
        minesweeperAppModel.addListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setMinimumSize(getSize());
        setVisible(true);
        //setResizable(false);

    }

    public MinesweeperAppModel getModel() {
        return minesweeperAppModel;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        windowPanel.notifyForUpdate();
    }

    public BufferedImage getBufferedImage(String filename) {
        BufferedImage image = null;
        try {
            URI uri = this.getClass().getResource(filename).toURI();
            File file = new File(uri);
            FileImageInputStream inputStream = new FileImageInputStream(file);
            image = ImageIO.read(inputStream);
        }
        catch (IOException | URISyntaxException e) {
            System.out.println(e);
        }
    return image;
    }
}
