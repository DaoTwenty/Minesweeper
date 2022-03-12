package UI;

import javax.swing.*;
import java.awt.*;

public final class WindowPanel extends JPanel {

    private MinesweeperApp app;
    private HeaderPanel headerPanel;
    private GridPanel gridPanel;

    public WindowPanel(MinesweeperApp app) {
        super();
        this.app = app;
        setLayout(new GridLayout(2,1));
        add(headerPanel = new HeaderPanel(app));
    }

    public void notifyForUpdate() {

    }

}
