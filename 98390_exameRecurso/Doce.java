
public class Doce extends Entity implements Artigo {

    private String name;
    private String description;
    private Double doublePrice;
    private Integer intPrice;
    private Double price;

    private int isAlchoolic;

    public  Doce(String name, String description, Double doublePrice) {
        this.name = name;
        this.description = description;
        this.doublePrice = price;
    } 

    public  Doce(String name, String description, Integer intPrice) {
        this.name = name;
        this.description = description;
        this.price =  intPrice.doubleValue();
    } 
    public String name() {
        return name;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public double price() {
        return price;
    }
    public void draw() {
        System.out.println(super.getIndent().toString() + this.toString() );
 
    }
    public String toString() {
        return "Doce [name= " + name + ", description=" + description +", price= "+ price +"] ";
        
    }
}
    

