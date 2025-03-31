public class AllPayAuction extends Auction{

    public String generateItemString(Item item){
        if (item == null){
            throw new NullPointerException();
        }

        String s = item.toString() + "\n";

        if(item.getAllBids().isEmpty()){
            return s + "No bids placed\n";
        }

        s = s + "Highest bid: " + item.getHighestBid().toString() + "\n";
        return s + generateAllBidsString(item);
    }
}
