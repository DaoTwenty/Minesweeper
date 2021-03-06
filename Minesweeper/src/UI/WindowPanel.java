package UI;

import Grid.Grid;

import javax.swing.*;
import java.awt.*;

public final class WindowPanel extends JPanel {

    private MinesweeperApp app;
    private HeaderPanel headerPanel;
    private GridPanel gridPanel;

    public WindowPanel(MinesweeperApp app, Grid grid) {
        super();
        this.app = app;
        setLayout(new BorderLayout());
        headerPanel = new HeaderPanel(app);
        add(headerPanel, BorderLayout.PAGE_START);
        JPanel gridHolder = new JPanel();
        gridHolder.setLayout( new SingleComponentAspectRatioKeeperLayout());
        gridHolder.add(gridPanel = new GridPanel(app, grid), BorderLayout.CENTER);
        add(gridHolder);
        setMinimumSize(getSize());
    }

    public void notifyForUpdate() {
        headerPanel.notifyForUpdate();
        gridPanel.notifyForUpdate();
    }

}
