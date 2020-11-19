package lab11;

public class Game {
    private char[][] table = {{'n','n','n'},
                      {'n','n','n'},
                      {'n','n','n'}};

    public void table_reset() {
        for (int i = 0; i < 3; i++){
            for (int j = 0; j<3; j++){
                table[i][j] = 'n';
            }
        }
    }

    public boolean win(char player){
        for (int i = 0; i < 3; i++){
            if (table[i][0] == player && table[i][1] == player && table[i][2] == player)
                return true;
            if (table[0][i] == player && table[1][i] == player && table[2][i] == player)
                return true;
        }
        if(table[0][0] == player && table[1][1] == player && table[2][2] == player)
            return true;
        if(table[0][2] == player && table[1][1] == player && table[2][0] == player)
            return true;
        return false;
    }

    public void set_table(int x, int y, char player){
        table[x][y] = player;
    }

    public char[][] getTable() {
        return table;
    }

    public boolean emptyTable(){
        for (int i = 0; i< 3; i++){
            for (int j = 0; j < 3; j++){
                if (table[i][j] == 'n')
                    return false;
            }
        }
        return true;
    }

    public boolean isEmpty(int x, int y){
        return table[x][y] != 'n';
    }
}

