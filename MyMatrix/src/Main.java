public class Main {
    public static void main(String[] args) {
        System.out.println("MATRIX!\n");
        Matrix<String> m = new MyMatrix<String>();
        String a = "a";
        String b = "b";

        m.put(0, 1, a);
        m.put(1, 3, b);
        m.put(2, 0, a);

        System.out.println("ROW: " + m.getRowCount() + "\nCOLUMN: " + m.getColumnCount());
        System.out.println("Object count: " + m.getObjectCount() + "\nDistinct Object: " + m.getDistinctObjectCount());
    }
}