import java.util.ArrayList;

public class Gestor extends Observer {

    private ArrayList<Product> prodInStock;
    private ArrayList<Product> soldProducts; 

    public Gestor(String name) {
        super(name); 
        this.prodInStock = new ArrayList<Product>();
        this.soldProducts = new ArrayList<Product>();
    }

    public void updateState(Product p, State s) {
        p.setProductState(s);
    }

    @Override
    public void update(Product p, boolean newBidding) {
        if (newBidding == true) {
            System.out.println("MANAGER " + this + ": " + p.getClient() + " has offered " + String.valueOf(p.getPrice()) + "€ for " + p);
        }
        else {
            switch (p.getProductState()){
                case stock:
                    this.AuctionProducts.remove(p);
                    this.prodInStock.add(p);
                    System.out.println("MANAGER " + this + ": " + p + " didnt' get any bid. It was removed from this Auction and added to the stock. ");
                    System.out.println("------------------------------------------");
                    break;
                case auction:
                   System.out.println("MANAGER " + this + ": " + p + " will be put in the Auction. The price starting at: " + p.getPrice() + "€. ");
                   this.prodInStock.remove(p);
                   this.AuctionProducts.add(p);
                   System.out.println("------------------------------------------");
                   break;

                case sold:
                    this.AuctionProducts.remove(p);
                    this.soldProducts.add(p);
                    System.out.println("MANAGER " + this + ": SOLD!!! " + p + " was sold to " + p.getClient() + " for " + p.getPrice() + "€. Congratulations!");
                    System.out.println("------------------------------------------");
                    break;
            }
        }
    }
}