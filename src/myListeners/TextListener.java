package myListeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;
import main.MyCalc;

public class TextListener implements FocusListener {

    private JTextField field;

    public TextListener(JTextField field) {
        this.field = field;
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (field.getText().equals(MyCalc.INPUT_CHISLO)) {
            field.setText("");
            field.setForeground(Color.BLACK);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (field.getText().trim().equals("")) {
            field.setText(MyCalc.INPUT_CHISLO);
            field.setForeground(Color.GRAY);
        }
    }

}
