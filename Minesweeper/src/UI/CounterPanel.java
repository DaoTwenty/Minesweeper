package UI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public final class CounterPanel extends JPanel implements ChangeListener {

    private MinesweeperApp app;
    private JPanel leftCount;
    private JPanel centerCount;
    private JPanel rightCount;

    public CounterPanel(MinesweeperApp app) {
        super();
        this.app = app;
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

    public void updateLeft(String s) {
        leftCount.removeAll();
        leftCount.add( new JLabel(s));
        leftCount.revalidate();
        leftCount.repaint();
    }

    public void updateCenter(String s) {
        centerCount.removeAll();
        centerCount.add( new JLabel(s));
        centerCount.revalidate();
        centerCount.repaint();
    }

    public void updateRight(String s) {
        rightCount.removeAll();
        rightCount.add( new JLabel(s));
        rightCount.revalidate();
        rightCount.repaint();
    }

    public void setCount(int x) {
        if ((x < 999) && (x > 0)) {
            if (x<10) {
                String xS = Integer.toString(x);
                updateRight(String.valueOf(xS.charAt(0)));
            }
            else if (x<100) {
                String xS = Integer.toString(x);
                updateCenter(String.valueOf(xS.charAt(0)));
                updateRight(String.valueOf(xS.charAt(1)));
            }
            else if (x == 0)  {
                updateRight("0");
                updateCenter("0");
                updateLeft("0");
            }
            else {
                String xS = Integer.toString(x);
                updateLeft(String.valueOf(xS.charAt(0)));
                updateCenter(String.valueOf(xS.charAt(1)));
                updateRight(String.valueOf(xS.charAt(2)));
            }
        }
        else if (x > 999) {
            updateLeft("9");
            updateCenter("9");
            updateRight("9");
        }
        else {
            updateLeft("0");
            updateCenter("0");
            updateRight("0");
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        CountChangeEvent change = (CountChangeEvent) e;
        setCount(change.getCount());
    }
}
