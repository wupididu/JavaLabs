package study;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyForm {
    private JPanel panel1;
    private JButton button1;
    private JTextArea textArea1;

    JPanel getPanel1(){
        return panel1;
    }

    MyForm(){
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
}
