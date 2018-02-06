package Algorithm.Matrix;

/**
 * Created by Clanner on 2018/1/12.
 */
public class Matrix {
    //行
    private int row;
    //列
    private int col;

    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
