package UI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public final class HeaderPanel extends JPanel {

    private MinesweeperApp app;
    private NewGameButton newGame;
    private CounterPanel timer;
    private CounterPanel markedCounter;

    public HeaderPanel(MinesweeperApp app) {
        super( new SpringLayout());
        this.app = app;
        int size = (int) (1.5* app.getUnitSize());
        newGame = new NewGameButton(app);
        JPanel centerPanel = new JPanel( new BorderLayout());
        centerPanel.add(newGame, BorderLayout.CENTER);
        centerPanel.setPreferredSize(new Dimension(size, size));
        timer = new CounterPanel(app);
        app.getModel().setClockListener(timer);
        JPanel rightPanel = new JPanel( new BorderLayout());
        rightPanel.add(timer, BorderLayout.EAST);
        markedCounter = new CounterPanel(app);
        app.getModel().setCountListener(markedCounter);
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
        newGame.notifyForUpdate();
    }
}
