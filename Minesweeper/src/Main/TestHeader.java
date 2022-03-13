package Main;

import UI.CounterPanel;
import UI.SpringUtilities;

import javax.swing.*;
import java.awt.*;

public class TestHeader {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Test Header");
        JPanel windowPanel = new JPanel (new SpringLayout());
        JPanel leftPanel = new JPanel();
        CounterPanel clock = new CounterPanel();
        clock.setSize(10,30);
        leftPanel.setLayout( new BorderLayout());
        leftPanel.add(clock, BorderLayout.WEST);
        JPanel centerPanel = new JPanel();
        JButton button = new JButton("Start");
        centerPanel.setLayout( new BorderLayout());
        centerPanel.add(button, BorderLayout.CENTER);
        JPanel rightPanel = new JPanel();
        CounterPanel counter =  new CounterPanel();
        rightPanel.setLayout( new BorderLayout());
        rightPanel.add(counter, BorderLayout.EAST);
        windowPanel.add(leftPanel);
        windowPanel.add(centerPanel);
        windowPanel.add(rightPanel);
        SpringUtilities.makeGrid(windowPanel,1,3,10,10,10,10);
        windowPanel.setMinimumSize(windowPanel.getSize());
        frame.setContentPane(windowPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setMinimumSize(frame.getSize());
        frame.setMaximumSize( new Dimension(Integer.MAX_VALUE, frame.getHeight()));
        frame.setVisible(true);
    }

}
