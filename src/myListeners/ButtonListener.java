package myListeners;

import logic.CalcOperations;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author ZozulyaRV
 */
public class ButtonListener implements ActionListener {

    private JTextField fieldCh1;
    private JTextField fieldCh2;
    private JTextField fieldResult;

    public ButtonListener(JTextField fieldCh1, JTextField fieldCh2, JTextField fieldResult) {
        this.fieldCh1 = fieldCh1;
        this.fieldCh2 = fieldCh2;
        this.fieldResult = fieldResult;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!(e.getSource() instanceof JButton)) {
            return;
        }

        JButton btn = (JButton) e.getSource();
        final double a = Double.parseDouble(fieldCh1.getText().replace(',', '.'));
        final double b = Double.parseDouble(fieldCh2.getText().replace(',', '.'));

        switch (btn.getActionCommand()) {
            case "+":
                fieldResult.setText(String.valueOf(CalcOperations.add(a, b)));
                break;
            case "-":
                fieldResult.setText(String.valueOf(CalcOperations.subtract(a, b)));
                break;
            case "*":
                fieldResult.setText(String.valueOf(CalcOperations.multiply(a, b)));
                break;
            case "/":
                fieldResult.setText(String.valueOf(CalcOperations.divide(a, b)));
                break;
            case "sqrt":
                fieldResult.setText(String.valueOf(CalcOperations.extractRoot(a, b)));
                break;
            case "x^y":
                fieldResult.setText(String.valueOf(CalcOperations.exponentiate(a, b)));
                break;
            default:
                break;
        }

    }

}
