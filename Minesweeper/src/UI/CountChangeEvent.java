package UI;

import javax.swing.event.ChangeEvent;

public class CountChangeEvent extends ChangeEvent {

    private int count;

    public CountChangeEvent(Object source, int count) {
        super(source);
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
