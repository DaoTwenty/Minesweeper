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
        setLayout(new GridLayout(2,1));
        add(headerPanel = new HeaderPanel(app));
        add(gridPanel = new GridPanel(app, grid));
    }

    public void notifyForUpdate() {
        headerPanel.notifyForUpdate();
        gridPanel.notifyForUpdate();
    }

}
