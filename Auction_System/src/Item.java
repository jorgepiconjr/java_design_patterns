import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.util.Objects;

public class Item {

    private String name;
    private String description;
    private long minPrice;
    private List<Bid> allBids = new LinkedList<Bid>();
    private Bid highestBid;

    public Item(String name, String description, long minPrice){
        if (name.isEmpty() || description.isEmpty() || minPrice <= 0){
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.description = description;
        this.minPrice = minPrice;
    }
    public void addBid(Person bidder, long price){
        if (bidder == null){
            throw new NullPointerException();
        }
        if (price <= 0 ){
            throw new IllegalArgumentException();
        }
        if (price >= minPrice ) {
            if (highestBid == null) {
                Bid b = new Bid(bidder, price);
                highestBid = b;
                allBids.add(b);
            } else if (getHighestBid().getPrice() < price) {
                Bid b = new Bid(bidder, price);
                highestBid = b;
                allBids.add(b);

            }
        }
    }
    public List<Bid> getAllBids(){
        if (allBids.isEmpty()){
            return Collections.emptyList();
        }
        return allBids;
    }
    public String getName(){
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Bid getHighestBid() {
        return highestBid;
    }
    public String toString(){
        return name + ": " + description + " (minimum bidding price: " + minPrice + " EUR)";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return name.equals(item.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}