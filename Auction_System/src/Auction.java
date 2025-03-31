import java.util.*;

public abstract class Auction {

    private boolean closed = false;
    private List<Person> bidders = new LinkedList<Person>();
    private List<Item> allItems = new LinkedList<Item>();

    public Auction(){}
    public void addBid(Item bidItem, String nameOfBidder, long price){
        if (bidItem == null){
            throw new NullPointerException();
        }
        if(closed){
            throw new IllegalStateException();
        }
        if(nameOfBidder.isEmpty() || price <= 0){
            throw new IllegalArgumentException();
        }
        if (!allItems.contains(bidItem)){
            throw new NoSuchElementException();
        }
        Person p = new Person(nameOfBidder);
        bidders.add(p);
        bidItem.addBid(p,price);
    }
    public String closeAuction(){
        if (closed){
            throw new IllegalStateException();
        }
        this.closed = true;
        return generateItemListString();
    }
    public String generateAllBidsString(Item item){
        if (item == null){
            throw new NullPointerException();
        }
        if (item.getAllBids().isEmpty()){
            return "All bids:\n";
        }

        String s = "";
        for (Bid b : item.getAllBids()){
            s = s + b.toString() + "\n";
        }
        return "All bids:\n" + s;
    }
    public String generateItemListString(){
        String s = "";

        for (Item i : allItems){
            s = s + generateItemString(i);
        }
        return s;    }
    public void registerItem(Item item){
        if(closed){
            throw new IllegalStateException();
        }
        if (item == null) {
            throw new NullPointerException();
        }
        if (allItems.contains(item)){
            throw new IllegalArgumentException();
        }

        allItems.add(item);
    }
    public abstract String generateItemString(Item item);
    public List<Item> getAllItems(){
        if (allItems.isEmpty()){
            return Collections.emptyList();
        }
        return allItems;
    }
}