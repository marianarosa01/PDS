public class Bebida extends Entity implements Artigo {
    //	Bebida("Cerveja", "Super Bock Abadia 33cl", 1.1, 6));
    private String name;
    private String description;
    private Double price;
    private Integer priceInt;
    private Integer teorAlcoolico;
    private boolean isAlchoolic;

    public  Bebida(String name, String description, Double price, Integer teorAlcoolico) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.teorAlcoolico = teorAlcoolico;
        this.isAlchoolic = true;
    } 
    public  Bebida(String name, String description, Integer priceInt, Integer teorAlcoolico) {
        this.name = name;
        this.description = description;
        this.price = priceInt.doubleValue();
        this.teorAlcoolico = teorAlcoolico;
        this.isAlchoolic = true;

    } 
    public  Bebida(String name, String description, Integer priceInt) {
        this.name = name;
        this.description = description;
        this.price = priceInt.doubleValue();
        this.isAlchoolic = false;

    } 
    public  Bebida(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.isAlchoolic = false;

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
        if (this.isAlchoolic  == true){
            return "Bebida [name= " + name + ", description=" + description +", price= "+ price +"] [alcoólica]";
        }
        else {
            return "Bebida [name= " + name + ", description=" + description +", price= "+ price +"] [não alcoólica]";
            
        }
    }
	
}
