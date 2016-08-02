package main;

import myListeners.ButtonListener;
import myListeners.TextListener;
import com.jtattoo.plaf.texture.TextureLookAndFeel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author ZozulyaRV
 */
public class MyCalc {

    public static final String INPUT_CHISLO = "введите число";

    private JButton buttonPlus;
    private JButton buttonMinus;
    private JButton buttonMultiolication;
    private JButton buttonDivision;
    private JButton buttonSqrt;
    private JButton buttonDegree;

    private JTextField fieldCh1;
    private JTextField fieldCh2;
    private JTextField fieldResult;

    private JLabel labelCh1;
    private JLabel labelCh2;
    private JLabel labelResult;

    private JPanel panelCh1;
    private JPanel panelCh2;
    private JPanel panelResult;
    private JPanel panelBtns;

    private JFrame frame;

    public static void main(String[] args) {

//<editor-fold defaultstate="collapsed" desc="My Skin">
        try {
            UIManager.setLookAndFeel(new TextureLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MyCalc.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFrame.setDefaultLookAndFeelDecorated(true);
//</editor-fold>

        MyCalc calc = new MyCalc();
        calc.creatLabels();
        calc.creatTextFields();
        calc.creatButtons();
        calc.creatPanels();
        calc.creatFrame();

        calc.frame.setVisible(true);

    }

//<editor-fold defaultstate="collapsed" desc="Methods">
    private void creatButtons() {

        buttonPlus = new JButton("+");
        buttonMinus = new JButton("-");
        buttonMultiolication = new JButton("*");
        buttonDivision = new JButton("/");
        buttonSqrt = new JButton("sqrt");
        buttonDegree = new JButton("x^y");

        addActionToButton();

    }

    private void creatTextFields() {
        fieldCh1 = new JTextField(INPUT_CHISLO, 10);

        fieldCh2 = new JTextField(INPUT_CHISLO, 10);

        fieldResult = new JTextField(15);
        fieldResult.setEditable(false);
        fieldResult.setFocusable(false);

        addTextFieldListeners();

    }

    private void creatLabels() {
        labelCh1 = new JLabel("Число 1:");

        labelCh2 = new JLabel("Число 2:");

        labelResult = new JLabel("Результат:");
    }

    private void creatPanels() {
        panelCh1 = new JPanel();
        panelCh1.setBorder(BorderFactory.createEtchedBorder());
        BoxLayout boxL1 = new BoxLayout(panelCh1, BoxLayout.Y_AXIS);
        panelCh1.setLayout(boxL1);
        panelCh1.setPreferredSize(new Dimension(150, 150));

        panelCh2 = new JPanel();
        panelCh2.setBorder(BorderFactory.createEtchedBorder());
        BoxLayout boxL2 = new BoxLayout(panelCh2, BoxLayout.Y_AXIS);
        panelCh2.setLayout(boxL2);
        panelCh2.setPreferredSize(new Dimension(150, 150));

        panelResult = new JPanel();
        panelResult.setBorder(BorderFactory.createEtchedBorder());
        BoxLayout boxL3 = new BoxLayout(panelResult, BoxLayout.Y_AXIS);
        panelResult.setLayout(boxL3);
        panelResult.setPreferredSize(new Dimension(450, 150));

        panelBtns = new JPanel(new GridLayout(3, 2, 2, 2));
        panelBtns.setBorder(BorderFactory.createEtchedBorder());
        panelBtns.setPreferredSize(new Dimension(150, 150));

        panelCh1.add(labelCh1);
        panelCh1.add(fieldCh1);

        panelCh2.add(labelCh2);
        panelCh2.add(fieldCh2);

        panelResult.add(labelResult);
        panelResult.add(fieldResult);

        panelBtns.add(buttonPlus);
        panelBtns.add(buttonMinus);
        panelBtns.add(buttonMultiolication);
        panelBtns.add(buttonDivision);
        panelBtns.add(buttonSqrt);
        panelBtns.add(buttonDegree);
    }

    private void creatFrame() {

        BorderLayout bl = new BorderLayout(2, 2);
        frame = new JFrame("My_Calc");
        frame.setLayout(bl);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setMinimumSize(new Dimension(450, 300));
        frame.setResizable(false);
        frame.setIconImage(new ImageIcon(getClass().getResource("/pic/calculator.png")).getImage());

        frame.getContentPane().add(panelCh1, BorderLayout.WEST);
        frame.getContentPane().add(panelCh2, BorderLayout.EAST);
        frame.getContentPane().add(panelResult, BorderLayout.SOUTH);
        frame.getContentPane().add(panelBtns, BorderLayout.CENTER);
    }

    private void addActionToButton() {

        ButtonListener bl = new ButtonListener(fieldCh1, fieldCh2, fieldResult);

        buttonPlus.addActionListener(bl);
        buttonMinus.addActionListener(bl);
        buttonMultiolication.addActionListener(bl);
        buttonDivision.addActionListener(bl);
        buttonSqrt.addActionListener(bl);
        buttonDegree.addActionListener(bl);

    }

    private void addTextFieldListeners() {
        fieldCh1.addFocusListener(new TextListener(fieldCh1));
        fieldCh2.addFocusListener(new TextListener(fieldCh2));
    }
}
