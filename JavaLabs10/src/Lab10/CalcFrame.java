package Lab10;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcFrame extends JFrame{
    private JPanel panel1;
    private JPanel numPud;
    private JButton button7;
    private JButton buttonEq;
    private JTextField textField;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button8;
    private JButton button9;
    private JButton buttonPlus;
    private JButton buttonMinus;
    private JButton buttonMult;
    private JButton buttonDiv;
    private JButton button0;
    private JButton button00;
    private JButton buttonDote;
    private JButton cButton;
    private JTextField textRes;
    double res = 0;
    double res1 = 0;
    String op = "";

    JPanel getPanel(){ return panel1;}

    CalcFrame(){
        setBounds(100,100,350,400);
        setTitle("Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(panel1);
        setVisible(true);
        setResizable(false);

        textRes.setText(null);

        try {

            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField.setText(textField.getText() + 1);
                }
            });

            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField.setText(textField.getText() + 2);
                }
            });

            button3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField.setText(textField.getText() + 3);
                }
            });

            button4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField.setText(textField.getText() + 4);
                }
            });

            button5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField.setText(textField.getText() + 5);
                }
            });

            button6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField.setText(textField.getText() + 6);
                }
            });

            button7.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField.setText(textField.getText() + 7);
                }
            });

            button8.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField.setText(textField.getText() + 8);
                }
            });

            button9.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField.setText(textField.getText() + 9);
                }
            });

            button0.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField.setText(textField.getText() + 0);
                }
            });

            button00.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField.setText(textField.getText() + "00");
                }
            });

            buttonDote.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField.setText(textField.getText() + ".");
                }
            });

            buttonPlus.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(textRes.getText() == null || textRes.getText().trim().isEmpty())
                        res = Double.valueOf(textField.getText());
                    textRes.setText(textRes.getText() + textField.getText() + "+");
                    textField.setText("");
                    op = "+";
                }
            });

            buttonMinus.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(textRes.getText() == null || textRes.getText().trim().isEmpty())
                        res = Double.valueOf(textField.getText());
                    textRes.setText(textRes.getText() + textField.getText() + "-");
                    textField.setText("");
                    op = "-";
                }
            });

            buttonMult.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(textRes.getText() == null || textRes.getText().trim().isEmpty())
                        res = Double.valueOf(textField.getText());
                    textRes.setText(textRes.getText() + textField.getText() + "*");
                    textField.setText("");
                    op = "*";
                }
            });

            buttonDiv.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(textRes.getText() == null || textRes.getText().trim().isEmpty())
                        res = Double.valueOf(textField.getText());
                    textRes.setText(textRes.getText() + textField.getText() + "/");
                    textField.setText("");
                    op = "/";
                }
            });

            buttonEq.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    res1 = Double.valueOf(textField.getText());
                    textRes.setText(String.valueOf(new Calculation().calc(res, op, res1)));
                    res = new Calculation().calc(res, op, res1);
                    textField.setText("");
                }
            });

            cButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    res = 0;
                    res1 = 0;
                    op = "";
                    textField.setText("");
                    textRes.setText("");
                }
            });
        }catch (ArithmeticException exception){
            textField.setText("Can not divide by zero");
        }
    }


}
