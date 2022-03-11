package UI;

import javax.swing.*;

public final class WindowPanel extends JPanel {

    private MinesweeperApp app;
    private HeaderPanel headerPanel;
    private GridPanel gridPanel;

    public WindowPanel(MinesweeperApp app) {
        super();
        this.app = app;
        setLayout(new SpringLayout());
        add(headerPanel = new HeaderPanel(app));
    }

    public void notifyForUpdate() {

    }

}
