package lab07;

import java.util.ArrayList;
import java.util.List;

public class Caixa extends Entity {
    private List <Entity> products = new ArrayList<>();
    private String name;
    private int weight;
    private int total = weight;

    
    public Caixa(String name, int weight) {
        this.name = name;
        this.weight = weight;    
    
    }
   
    public void add (Entity p) {
        products.add(p);
        this.total += p.count();
    }
    
    public int getTotalWeight(){
        return this.total;
    }
    
    public int count(){
        return weight;
    }
    public int getTotal() {
        for (Entity c : products ) {
            if (c instanceof Caixa){
                this.total= this.total + c.getTotalWeight(); // peso da caixa
            }
        }
        this.total += this.getTotalWeight(); //peso da caixa + peso total

        return total;
    }

    public String toString() {
		return "* Caixa '" + name + "' - Weight : " + weight + " ; Total: " + getTotalWeight();
	}

	public void draw() {
        for (Entity c : products ) {
            if (c instanceof Caixa){
                this.total= this.total + c.getTotalWeight(); // peso da caixa
            }
        }
        this.total += this.count(); //peso da caixa + peso total

        System.out.println(super.getIndent().toString() + toString());
        super.getIndent().append("   ");
        for (Entity c : products ) {
            //this.total= getTotal();
            c.draw();
        }

        super.getIndent().setLength(super.getIndent().length() - 3);
	}
    
}
