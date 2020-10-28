import java.util.Scanner;

public class GamerLogic {

    public static void main(String[] args) {
        gridGame game = new gridGame();
        char x = 'X';
        char o = 'O';

        game.setTable(9, x);
        Scanner in = new Scanner(System.in);
        game.setTable(in.nextInt(), o);

        if(game.getTable(7) == o){
            game.setTable(3,x);
            game.setTable(in.nextInt(), o);
            if(game.getTable(6) == o) {
                game.setTable(1, x);
                game.setTable(in.nextInt(), o);
                if(game.getTable(5)== o){
                    game.setTable(2, x);
                    System.out.println("You lose!!!");
                }else {
                    game.setTable(5, x);
                    System.out.println("You lose!!!");
                }
            }else{
                game.setTable(6, x);
                System.out.println("You lose!!!");
            }
        }else if (game.getTable(3) == o){
            game.setTable(7,x);
            game.setTable(in.nextInt(), o);
            if(game.getTable(8) == o) {
                game.setTable(1, x);
                game.setTable(in.nextInt(), o);
                if(game.getTable(5)== o){
                    game.setTable(4, x);
                    System.out.println("You lose!!!");
                }else {
                    game.setTable(5, x);
                    System.out.println("You lose!!!");
                }
            }else{
                game.setTable(8, x);
                System.out.println("You lose!!!");
            }
        }else if (game.getTable(1) == o){
            game.setTable(3,x);
            game.setTable(in.nextInt(), o);
            if(game.getTable(6) == o) {
                game.setTable(7, x);
                game.setTable(in.nextInt(), o);
                if(game.getTable(5)== o){
                    game.setTable(8, x);
                    System.out.println("You lose!!!");
                }else {
                    game.setTable(5, x);
                    System.out.println("You lose!!!");
                }
            }else{
                game.setTable(6, x);
                System.out.println("You lose!!!");
            }
        }else if(game.getTable(5) == o){
            game.setTable(1,x);
            for (int i = 0; i < 3; i++){
                int num = in.nextInt();
                game.setTable(num, o);
                if( new GamerLogic().funLose(game, 6,3)||
                        new GamerLogic().funLose(game, 2,3)||
                        new GamerLogic().funLose(game, 4,7)||
                        new GamerLogic().funLose(game, 8,7)) {
                    return;
                }
                game.setTable(new GamerLogic().reversNum(num), x);
            }
            System.out.println("Game over");
        }else {
            game.setTable(5, x);
            game.setTable(in.nextInt(), o);
            if(game.getTable(1) == 'O'){
                if (game.getTable(6) == 'O' || game.getTable(4) == 'O'){
                    game.setTable(7, x);
                    game.setTable(in.nextInt(), o);
                    if (game.getTable(3) == '0'){
                        game.setTable(8, x);
                        System.out.println("You lose!!!");
                    }else{
                        game.setTable(3, x);
                        System.out.println("You lose");
                    }
                }else {
                    game.setTable(3, x);
                    game.setTable(in.nextInt(), o);
                    if (game.getTable(7) == '0'){
                        game.setTable(6, x);
                        System.out.println("You lose!!!");
                    }else{
                        game.setTable(7, x);
                        System.out.println("You lose");
                    }
                }
            }else{
                game.setTable(1, x);
                System.out.println("You lose!!!");
            }
        }
    }

    int reversNum(int num){
        if (num == 2) return 8;
        else if(num == 3) return 7;
        else if(num == 6) return 4;
        else if(num == 8) return 2;
        else if (num == 7) return 3;
        else if (num == 4) return 6;
        else return 0;
    }

    boolean winSet(gridGame game, int n1, int n2){
        if(game.getTable(n1) != 'O' && game.getTable(n2) != 'O' &&
                (game.getTable(n1) != 'X' || game.getTable(n2) != 'X'))
            return true;
        else return false;
    }

    boolean funLose(gridGame game, int n1, int n2){
        if(game.getTable(n1) != 'O' && game.getTable(n2) != 'O' &&
                (game.getTable(n1) == 'X' || game.getTable(n2) == 'X')) {
            if (game.getTable(n1) == 'X') game.setTable(n2, 'X');
            else game.setTable(n1, 'X');
            System.out.println("You lose!!!");
            return true;
        }
        return false;
    }
}

class gridGame{
    private char table[] = new char[9];

    public void setTable(int index, char player){
        table[index-1] =  player;
        System.out.println(player + " = " + index);
    }

    public char getTable(int index){
        return table[index-1];
    }
}