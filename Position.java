/**
 * Class position finds and defines positions on board of Connect Four game
 * @author Zeb J-A
 * @version 05/25/22
 */
public class Position {
    private int row, col;

    public Position(int row, int col) {
        
    }
    public Position() {
        row = -1;
        col = -1;
    }

    /**
     * Method getRow returns row at current position
     * @return
     */
    public int getRow() {
        return row;
    }

    /**
     * Method getColumn returns row at current position
     */
    public int getColumn() {
        return col;
    }

    /**
     * Method setRow initializes row to new value
     * @param row
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * Method setCol initializes column to new value
     * @param col
     */
    public void setCol(int col) {
        this.col = col;
    }

    /**
     * Method equals determines whether two positions are equal to each other by comparing row and column values
     * @param o
     * @return
     */
    public boolean equals(Object o) {
        if(o instanceof Position) {
            Position temp = (Position)o;
            return this.row == temp.row && this.col == temp.col;
        }
        return false;
    }

}
