package UI;

import Model.MinesweeperAppModel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class MinesweeperApp extends JFrame implements ChangeListener {

    private final MenuBar menuBar;
    private final WindowPanel windowPanel;
    private MinesweeperAppModel minesweeperAppModel = new MinesweeperAppModel();

    public MinesweeperApp() throws HeadlessException {
        super("MineSweeper");
        menuBar = new MenuBar(this);
        setJMenuBar(menuBar);
        windowPanel = new WindowPanel(this);
        setContentPane(windowPanel);
        minesweeperAppModel.addListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        pack() ;
        setVisible(true) ;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        windowPanel.notifyForUpdate();
    }
}
