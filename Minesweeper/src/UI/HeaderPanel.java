package UI;

import javax.swing.*;
import java.awt.*;

public final class HeaderPanel extends JPanel {

    private MinesweeperApp app;
    private NewGameButton newGame;
    private CounterPanel timer;
    private CounterPanel markedCounter;

    public HeaderPanel(MinesweeperApp app) {
        super( new SpringLayout());
        this.app = app;
        newGame = new NewGameButton(app);
        JPanel centerPanel = new JPanel( new BorderLayout());
        centerPanel.add(newGame, BorderLayout.CENTER);
        timer = new CounterPanel();
        JPanel rightPanel = new JPanel( new BorderLayout());
        rightPanel.add(timer, BorderLayout.EAST);
        markedCounter = new CounterPanel();
        JPanel leftPanel = new JPanel( new BorderLayout());
        leftPanel.add(markedCounter, BorderLayout.WEST);
        add(leftPanel);
        add(centerPanel);
        add(rightPanel);
        SpringUtilities.makeGrid(this, 1, 3, 10, 10, 10, 10);
        setMinimumSize(getSize());
        setMaximumSize( new Dimension(Integer.MAX_VALUE, getHeight()));
    }

    public void notifyForUpdate() {

    }
}
