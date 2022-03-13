package UI;

import javax.swing.*;
import java.awt.*;

public final class CounterPanel extends JPanel {

    private JPanel leftCount;
    private JPanel centerCount;
    private JPanel rightCount;

    public CounterPanel() {
        super();
        leftCount = new JPanel();
        leftCount.add(new JLabel("0"));
        centerCount = new JPanel();
        centerCount.add(new JLabel("0"));
        rightCount = new JPanel();
        rightCount.add(new JLabel("0"));
        setLayout(new GridLayout(1,3));
        add(leftCount);
        add(centerCount);
        add(rightCount);
    }

}
