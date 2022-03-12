package UI;

import javax.swing.*;

public class NewGameButton extends JButton {

    private MinesweeperApp app;
    private Icon icon = new ImageIcon("Data/Minesweeper_smiley.png");

    public  NewGameButton(MinesweeperApp app) {
        super("New Game");
        this.app = app;
        setIcon(icon);
    }

}
