// package pds_2021_111.lab03;

public class JGaloLogic implements JGaloInterface {
    char currentPlayer;
    boolean isFinished;
    char winner;
    char[][] board = new char[3][3];

    public JGaloLogic() {
        this.currentPlayer = 'X';
        this.isFinished = false;
        this.winner = ' ';
    }

    public JGaloLogic(char player) {
        this.currentPlayer = player;
        this.isFinished = false;        
        this.winner = ' ';
    }

    public char getActualPlayer() {
        return this.currentPlayer;
    }

    public boolean setJogada(int lin, int col) {
        if (!this.squareFree(lin, col) || lin > 3 || col > 3) { // o jogo já acabou ou o espaço não está livre
            return false;
        }

        board[lin-1][col-1] = this.currentPlayer;

        if (this.currentPlayer == 'X'){
            this.currentPlayer = 'O';
        }
        else {
            this.currentPlayer = 'X';
        }

        return true;
    }

    public boolean isFinished() {
        if (this.horizontalWinner() || this.verticalWinner() || this.diagonalWinner() || isFull()) {
            this.isFinished = true;
        }       

        return this.isFinished;
    }

    public char checkResult() {
        return this.winner;
    }

    private boolean squareFree(int lin, int col) { // verifica se aquele quadrado está livre e pode ser jogado
        if (board[lin-1][col-1] == 0) {
            return true;
        }
        return false;
    }

    private boolean isFull(){
        for (int lin = 0; lin < 3; lin++){
            for (int col = 0; col < 3; col++){
                if (board[lin][col] == 0){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean horizontalWinner() {
        boolean ret = false;
        for (int lin = 0; lin < 3; lin++) { // linha a linha
            boolean end = true;
            char init = board[lin][0];

            if (init != 'X' && init != 'O') {
                end = false;
            }

            else{
                for (int col = 1; col < 3; col++) {                    
                    if (init != board[lin][col]) {
                        end = false;
                        break;
                    }
                }
            }

            if (end) {
                ret = true; // há um vencedor na horixontal
                this.winner = init;
                break;
            }
        }

        return ret;
    }

    private boolean verticalWinner() {
        boolean ret = false;
        for (int col = 0; col < 3; col++) {// coluna a coluna
            boolean end = true;
            char init = board[0][col];

            if (init != 'X' && init != 'O') {
                end = false;
            }

            else{
                for (int lin = 1; lin < 3; lin++) {                    
                    if (init != board[lin][col]) {
                        end = false;
                        break;
                    }
                }
            }

            if (end) {
                ret = true; // há um vencedor na vertical
                this.winner = init;
                break;
            }
        }

        return ret;
    }

    private boolean diagonalWinner() {
        boolean ret = false;

        if ( (board[0][0] == 'X' || board[0][0] == 'O') && board[0][0] == board[1][1] && board[0][0] == board[2][2] ) {
            ret = true;
            this.winner = board[0][0];
        }
        else if ( (board[0][2] == 'X' || board[0][2] == 'O') && board[0][2] == board[1][1] && board[0][2] == board[2][0] ) {
            ret = true;
            this.winner = board[0][2];
        }

        return ret;
    }
}
