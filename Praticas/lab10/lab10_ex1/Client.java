public class Client extends Observer {

    public Client (String name) {
        super(name);
    }
    

    public void makeNewBid (Product p, double price) {
        System.out.println(this + " offered " + price + " for " + p);
        if (AuctionProducts.contains(p)) {
            System.out.println("WE HAVE A NEW BID!");
            if (price > p.getPrice()) {
                p.setNewClient(this);
                p.setPrice(price);
                //System.out.println(p.getClient() + " offered " + p.getPrice() + " for " + p);
            }
            else {
                System.out.println("Ups, "+ this + " someone is offering higher than that... You have to offer at least " + (p.getPrice()+1) + " to enter in this Auction."); 
            }
        } else {
            System.out.println("Ups! " + this + " the product " + p + " is not available for Auction.");
        }
        System.out.println("------------------------------------------");
    }




    @Override
    public void update(Product p, boolean newBidding) {
        if (newBidding == true) {
            System.out.println("NEW BIDING FOR "+ p + " BY " + this);
            System.out.println("-> Currently the client with the highest bid ("+  String.valueOf(p.getPrice()) + ") is " + p.getClient()+ " for " + p + ".") ;
        }
        else {
            switch (p.getProductState()) {
                case stock:
                    this.AuctionProducts.remove(p);
                    System.out.println("--- "+ this + ": " + p + " didnt' get any bid. It was removed from this Auction. ");
                    break;

                case auction:
                    System.out.println("--- " + this + ":  " + p + " will be put in the Auction. The price starting at: " + p.getPrice() + "€. ");
                    this.AuctionProducts.add(p);
                    break;

                case sold:
                    this.AuctionProducts.remove(p);
                    System.out.println("--- " + this + ":  " + p + " was sold for " + p.getPrice() + "€. Congratulations!");
                    break;

                }   
            }
    }

    public void notifications (Product p) {
        p.attach(this);
    }
    
}
