import java.util.ArrayList;
import java.util.List;

public class Product {
    public int id = 0;
    private static int counter = 0;
    public String description = "";
    public double basePrice;
    private List<Observer> observers;
    private State state;
    private Client client;
    


    public Product (String description, double price) {
        counter++;
        this.id = counter;
        this.description = description;
        this.basePrice = price;
        this.state = State.stock;
        this.observers = new ArrayList<Observer>();
    }

    public void attach (Observer ob){
        this.observers.add(ob);
    }

   
    public Client getClient() {
        return client;
    }

    public void setNewClient(Client client) {
        this.client = client;
    }
    
    public int getProductID() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void notifyObservers(boolean newBid) {
        for (Observer ob : this.observers) {
            ob.update(this,newBid);
        }
    }

    public Double getPrice() {
        return this.basePrice;
    }

    public void setPrice(Double price) {
        this.basePrice = price;
        this.notifyObservers(true); //new bid
    }

    public State getProductState() {
        return state;
    }

    public void setProductState(State productState) {
        this.state = productState;
        this.notifyObservers(false);
    }

    public String toString() {
        return "Product_ID "+ id + " : " + description;
    }

    
}