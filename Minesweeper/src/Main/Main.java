package Main;

import UI.MinesweeperApp;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        try {
            new MinesweeperApp();
        }
        catch (HeadlessException e) {
            JPanel myPanel = new JPanel();
            JOptionPane.showMessageDialog(null, "Incompatible mouse, display or keyboard",
                    "Path Impossible", JOptionPane.ERROR_MESSAGE);
        }
    }
}
