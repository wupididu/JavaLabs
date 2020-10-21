package lab11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer;

public class Frame {
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private JPanel panel6;
    private JPanel panel7;
    private JPanel panel8;
    private JPanel panel9;
    private JPanel Panel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton TPmode;
    private JButton CPmode;
    private JButton resetButton;
    boolean turn1 = true; // очередь
    Game game = new Game();
    char player1 = 'R';
    char player2 = 'B';
    String mod = "TPmode";

    JPanel getPanel(){ return Panel;}

    Frame(){
        allReset();
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allReset();
            }
        });

        TPmode.setEnabled(false);

        TPmode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mod = "TPmode";
                TPmode.setEnabled(false);
                CPmode.setEnabled(true);
                allReset();
            }
        });

        CPmode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mod = "CPmode";
                CPmode.setEnabled(false);
                TPmode.setEnabled(true);
                allReset();
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(button1, 0,0);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(button2, 0,1);
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               action(button3,0,2);
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(button4, 1,0);
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(button5, 1,1);
            }
        });

        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(button6,1,2);
            }
        });

        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(button7,2,0);
            }
        });

        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(button8,2,1);
            }
        });

        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action(button9,2,2);
            }
        });
    }


    public int random_step(char player){
        int x = (int)(Math.random()*2.1);
        int y = (int)(Math.random()*2.1);
        if(game.getTable()[x][y] == 'n') {
            game.getTable()[x][y] = player;
            if(player == 'R')
                transfer(x,y).setBackground(Color.red);
            else if(player == 'B')
                transfer(x,y).setBackground(Color.blue);
            transfer(x,y).setEnabled(false);
            return 0;
        }else
            return random_step(player);
    }

    void action(JButton button, int x, int y){
        button.setEnabled(false);
        if(mod == "TPmode"){
            if(turn1){
                button.setBackground(Color.red);
                turn1 = false;
                game.set_table(x,y, player1);
                if(game.win(player1)){
                    System.out.println("Win Player1");
                    return;
                }else if(game.emptyTable()){
                    System.out.println("Nothing");
                    return;
                }
            }else {
                button.setBackground(Color.blue);
                turn1 = true;
                game.set_table(x,y, player2);
                if(game.win(player2)){
                    System.out.println("Win Player2");
                    return;
                }else if(game.emptyTable()){
                    System.out.println("Nothing");
                    return;
                }
            }
        }else if(mod == "CPmode"){
            button.setBackground(Color.red);
            game.set_table(x,y,player1);
            if(game.win(player1)){
                System.out.println("Win Player1");
                return;
            }else if(game.emptyTable()){
                System.out.println("Nothing");
                return;
            }
            if(!game.emptyTable())
                random_step(player2);
            if(game.win(player2)){
                System.out.println("Win CP");
                return;
            }else if(game.emptyTable()){
                System.out.println("Nothing");
                return;
            }
        }
    }

    public void allReset(){
        reset(button1);
        reset(button2);
        reset(button3);
        reset(button4);
        reset(button5);
        reset(button6);
        reset(button7);
        reset(button8);
        reset(button9);
        game.table_reset();
    }
    public void reset(JButton button){
        button.setEnabled(true);
        button.setBackground(Color.gray);
    }

    public JButton transfer(int x, int y){
        switch (x){
            case 0:
                switch (y){
                    case 0:
                        return button1;
                    case 1:
                        return button2;
                    case 2:
                        return button3;
                }
                break;
            case 1:
                switch (y){
                    case 0:
                        return button4;
                    case 1:
                        return button5;
                    case 2:
                        return button6;
                }
                break;
            case 2:
                switch (y){
                    case 0:
                        return button7;
                    case 1:
                        return button8;
                    case 2:
                        return button9;
                }
                break;
        }
        return null;
    }
}

