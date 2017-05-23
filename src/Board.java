/**
 * Created by Jasman on 2017-05-23.
 */
public class Board {
    public static final int ROW = 3;
    public static final int COL = 3;
    Cell[][] cell;
    int curRow;
    int curCol;

    public Board(){
        cell = new Cell[ROW][COL];
        for(int i=0;i<ROW;i++){
            for(int j=0;j<COL;j++){
                cell[i][j]=new Cell(i,j);
            }
        }
    }

    public void init(){
        for(int i=0;i<ROW;i++){
            for(int j=0;j<COL;j++){
                cell[i][j].clear();
            }
        }
    }

    public boolean endDraw(){
        for(int i=0;i<ROW;i++){
            for(int j=0;j<COL;j++){
                if(cell[i][j].content == Seed.EMPTY){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean endWin(Seed seed){
        if ( ((cell[curRow][0]).content == seed)&&((cell[curRow][1]).content == seed)&&((cell[curRow][2]).content == seed) ){
            return true;
        }

        if ( ((cell[0][curCol]).content == seed)&&((cell[1][curCol]).content == seed)&&((cell[2][curCol]).content == seed) ){
            return true;
        }

        if ( ((cell[0][0]).content == seed)&&((cell[1][1]).content == seed)&&((cell[2][2]).content == seed) ){
            return true;
        }
        if ( ((cell[0][2]).content == seed)&&((cell[1][1]).content == seed)&&((cell[2][0]).content == seed) ){
            return true;
        }
        return false;
    }

    public void paintBoard(){
        for (int row = 0; row < ROW; ++row) {
            for (int col = 0; col < COL; ++col) {
                cell[row][col].paint();   // each cell paints itself
                if (col < COL - 1) System.out.print("|");
            }
            System.out.println();
            if (row < ROW - 1) {
                System.out.println("-------");
            }
        }
    }
}
