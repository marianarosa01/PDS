import java.util.ArrayList;


public abstract class Observer {
    protected String name;
    protected ArrayList<Product> AuctionProducts; 
    public abstract void update(Product p, boolean newBidding);

    public Observer(String name) {
        this.name = name;
        this.AuctionProducts = new ArrayList<Product>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
    
    public void notifications (Product p) {
        p.attach(this);
    }
}
