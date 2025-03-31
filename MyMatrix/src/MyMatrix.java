import java.util.*;

public class MyMatrix<T> implements Matrix<T>{

    private Map<MatrixIndex,T> matrixEntries = new HashMap<>();
    private int biggestColumn = 0;
    private int biggestRow = 0;


    @Override
    public int getRowCount() {
        if (matrixEntries.isEmpty()){
            return 0;
        }
        return biggestRow + 1;
    }

    @Override
    public int getColumnCount() {
        if (matrixEntries.isEmpty()){
            return 0;
        }
        return biggestColumn + 1;
    }

    @Override
    public int getObjectCount() {
        if (matrixEntries.isEmpty()){
            return 0;
        }else {
            int counter = 0;
            for (T value : matrixEntries.values()){
                if(value != null){
                    counter++;
                }
            }
            return counter;
        }
    }

    @Override
    public int getDistinctObjectCount() {
        Set <T> values = new HashSet<>();
        for (T value : matrixEntries.values()) {
            if (!values.contains(value) && value != null){
                values.add(value);
            }
        }
        return values.size();
    }

    @Override
    public Iterator<T> iterator() {
        return new DepthFirstIterator();
    }

    @Override
    public T get(int row, int column) {
        if (row < 0 || column < 0 || row > biggestRow || column > biggestColumn){
            throw new IllegalArgumentException();
        }
        if (matrixEntries.isEmpty()){
            return null;
        }
        for (MatrixIndex index : matrixEntries.keySet()) {
            if (index.getColumn() == column && index.getRow() == row){
                return matrixEntries.get(index);
            }
        }
        return null;
    }

    @Override
    public T put(int row, int column, T value) {
        if (row < 0 || column < 0){
            throw new IllegalArgumentException();
        }
        if (row <= biggestRow && column <= biggestColumn){
            return matrixEntries.put(new MatrixIndex(row,column),value);
        }else{
            if(row > biggestRow){
                biggestRow = row;
            }
            if(column > biggestColumn){
                biggestColumn = column;
            }

            matrixEntries.put(new MatrixIndex(row,column),value);

            boolean indexExist;
            for(int c = 0 ; c <= biggestColumn ; c++){
                for (int r = 0 ; r <= biggestRow ; r++){
                    indexExist = false;
                    for (MatrixIndex i : matrixEntries.keySet() ) {
                        if (i.getRow() == r && i.getColumn() == c){
                            indexExist = true;
                        }
                    }
                    if (!indexExist){
                        matrixEntries.put(new MatrixIndex(r,c),null);
                    }
                }
            }
            return null;
        }
    }
    @Override
    public boolean contains(T value) {
        return matrixEntries.containsValue(value);
    }

    public class DepthFirstIterator implements Iterator<T> {
        private int objectCount = 0;
        private int OldObjectCount = getObjectCount();
        private Map<MatrixIndex,T> matrixEntries2 = matrixEntries;

        public DepthFirstIterator(){}

        @Override
        public T next() {
            if(hasNext()){

                for(int c = 0 ; c <= biggestColumn ; c++){
                    for (int r = 0 ; r <= biggestRow ; r++){
                        for (MatrixIndex i : matrixEntries2.keySet() ) {
                            if (i.getRow() == r && i.getColumn() == c && matrixEntries2.get(i) != null){
                                T copy = matrixEntries2.get(i);
                                matrixEntries2.remove(i);
                                objectCount++;
                                return copy;

                            }
                        }
                    }
                }
            }
            throw new NoSuchElementException();
        }
        @Override
        public boolean hasNext() {
            return objectCount < OldObjectCount;
        }
    }


}
