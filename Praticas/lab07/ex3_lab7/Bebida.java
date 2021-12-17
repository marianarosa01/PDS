
package lab07;

public class Bebida extends Entity {
    private String name;
    private int weight;

    
    public Bebida(String name, int weight) {
        this.name = name;
        this.weight = weight;        
    }


    public String toString() {
		return "Bebida " + name + "' - Weight : " + weight;
	}

    public int count(){
        return weight;
    }
    
    public void draw() {
       System.out.println(super.getIndent().toString() + this.toString() );

   }
}

