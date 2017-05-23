/**
 * Created by Jasman on 2017-05-23.
 */
import java.util.Scanner;


public class Main_Game {
    Board board;
    Seed currentPlayer;
    GameState currentState;
    Scanner in = new Scanner(System.in);

    public Main_Game(){
        board = new Board();
        initGame();
        do{
            playerMove(currentPlayer);
            board.paintBoard();


        }while(currentState == GameState.PLAYING);

    }

    public void initGame(){
        board.init();
        currentPlayer = Seed.CROSS;
        currentState = GameState.PLAYING;
    }

    public void playerMove(Seed seed){
        boolean validIn = false;
        do{
            if (seed == Seed.CROSS) {
                System.out.print("Player 'X', enter your move (row[1-3] column[1-3]): ");
            }
            else {
                System.out.print("Player 'O', enter your move (row[1-3] column[1-3]): ");
            }

            int row = in.nextInt() - 1;
            int col = in.nextInt() - 1;

            if (row >= 0 && row < Board.ROW && col >= 0 && col < Board.COL && board.cell[row][col].content == Seed.EMPTY) {
                board.cell[row][col].content = seed;
                board.curRow = row;
                board.curCol = col;
                validIn = true;
            } else {
                System.out.println("This move at (" + (row + 1) + "," + (col + 1) + ") is not valid. Try again...");
            }
        }while(!validIn);
    }

    public void updateGame(Seed seed){
        if(board.endWin(seed)){
            currentState = (seed == Seed.CROSS) ? GameState.CROSS_WIN : GameState.NOT_WIN;
        }
        else if(board.endDraw()){
            currentState = GameState.DRAW;
        }
    }

    public static void main(String[] args) {
        new Main_Game();
    }



}
