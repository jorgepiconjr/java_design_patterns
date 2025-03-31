import java.util.Objects;

public class MatrixIndex {

    private int row;
    private int column;

    public MatrixIndex(int row, int column){
        if (row < 0 || column < 0){
            throw new IllegalArgumentException();
        }
        this.row =row;
        this.column = column;
    }

    public int getColumn() {
        return column;
    }
    public int getRow() {
        return row;
    }
    @Override
    public boolean equals(Object o){
        if (o instanceof MatrixIndex){
            MatrixIndex m = (MatrixIndex)o;
            return row == m.getRow() && column == m.getColumn();
        }
        return false;
    }
    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}