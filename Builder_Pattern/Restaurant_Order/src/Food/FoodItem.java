import Packing.Packing;

public interface FoodItem {
    public String name();
    public int calories();
    public Packing packing();
    public double price();
}
