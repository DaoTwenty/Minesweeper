package Main;

import UI.MinesweeperApp;

import javax.swing.*;
import java.awt.*;

public class Main {

    /*
    static {
        System.setProperty("apple.laf.useScreenMenuBar", "true");
    }
     */

    public static void main(String[] args) {
        try {
            new MinesweeperApp();
        }
        catch (HeadlessException e) {
            JPanel myPanel = new JPanel();
            JOptionPane.showMessageDialog(null, "Incompatible mouse, display or keyboard",
                    "Cannot Execute Application", JOptionPane.ERROR_MESSAGE);
        }
    }
}
