/**
 * Created by Jasman on 2017-05-23.
 */
public class Cell {

    int row;
    int col;

    Seed content;

    public Cell(int row,int col){
        this.row=row;
        this.col=col;
        clear();
    }

    public void clear(){
        content = Seed.EMPTY;
    }

    public void paint(){
        switch(content){
            case CROSS:
                System.out.print('X');
                break;
            case NOT:
                System.out.print('O');
                break;
            case EMPTY:
                System.out.print(" ");
                break;
        }
    }

}
