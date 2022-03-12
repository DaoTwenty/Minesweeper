package UI;

import javax.swing.*;

public final class HeaderPanel extends JPanel {

    private MinesweeperApp app;
    private NewGameButton newGame;
    private CounterPanel timer;
    private CounterPanel markedCounter;

    public HeaderPanel(MinesweeperApp app) {
        super();
        this.app = app;
        newGame = new NewGameButton(app);
        timer = new CounterPanel(app);
        markedCounter = new CounterPanel(app);
        SpringLayout springLayout = new SpringLayout();
        setLayout(springLayout);
        add(markedCounter);
        add(newGame);
        add(timer);
        springLayout.putConstraint(SpringLayout.WEST, markedCounter, 5, SpringLayout.WEST, this );
        springLayout.putConstraint(SpringLayout.EAST, markedCounter, 5, SpringLayout.WEST, newGame );
        springLayout.putConstraint(SpringLayout.EAST, newGame, 5, SpringLayout.WEST, timer );
        springLayout.putConstraint(SpringLayout.EAST, timer, 5, SpringLayout.EAST, this );
    }

}
