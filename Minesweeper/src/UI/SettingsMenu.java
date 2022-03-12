package UI;

import javax.swing.*;

public final class SettingsMenu extends JMenuItem {

    MinesweeperApp app;

    public SettingsMenu(MinesweeperApp app) {
        super("Settings");
        this.app = app;
    }

}
