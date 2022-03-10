package UI;

import javax.swing.*;
import java.awt.*;

public class MinesweeperApp extends JFrame {

    private final MenuBar menuBar;
    private final WindowPanel windowPanel;

    public MinesweeperApp() throws HeadlessException {
        super("MineSweeper");
        menuBar = new MenuBar(this);
        setJMenuBar(menuBar);
        windowPanel = new WindowPanel(this);
        setContentPane(windowPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        pack() ;
        setVisible(true) ;
    }
}
