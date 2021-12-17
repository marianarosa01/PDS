import java.util.ArrayList;
import java.util.List;

public class Pacote extends Entity implements Artigo {
    
    private String name;
    private String description;
    private Double price;
    private Integer priceInt;
    private Double priceDouble;
    private double totalPrice;
    private int countProducts = 0;
    private int numMaxArtigos = 10;

    private List <Artigo> products = new ArrayList<>();

    public  Pacote(String name, String description, Double priceDouble) {
        this.name = name;
        this.description = description;
        this.priceDouble = price;
    } 
    public  Pacote(String name, String description, Integer priceInt) {
        this.name = name;
        this.description = description;
        this.price = priceInt.doubleValue() ;
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
    
    public String ref() {
        return null;
    }
    public void add(Artigo a) {
        if (countProducts<numMaxArtigos){
            products.add(a);
        }
    
    }
    
   
    
    @Override
    public void draw() {
        for (Artigo c : products ) {
            if (c instanceof Pacote){
                totalPrice = totalPrice + c.price();
                countProducts = countProducts + 1;

            }
        }

        System.out.println(super.getIndent().toString() + toString());
        super.getIndent().append("   ");
        for (Artigo c : products ) {
            //this.total= getTotal();
            c.draw();
        }

        super.getIndent().setLength(super.getIndent().length() - 3);
	}    

    public double finalPrice(){
        this.totalPrice = totalPrice*0.95;
        return totalPrice;

    }

    public String toString() {
        return "Ref: " + this.ref() + " Caixa com  " + countProducts + "artigos. Preço  : " + totalPrice;
    }
}
    

    

