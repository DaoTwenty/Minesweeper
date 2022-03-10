package UI;

import javax.swing.*;
import java.awt.*;

public final class MenuBar extends JMenuBar {

    private MinesweeperApp app;
    private SettingsMenu settingsMenu;
    private StatisticsMenu statisticsMenu;

    MenuBar(MinesweeperApp app) {
        super();
        this.app = app;
        add(settingsMenu = new SettingsMenu(app));
        add(statisticsMenu = new StatisticsMenu(app));
    }
}
