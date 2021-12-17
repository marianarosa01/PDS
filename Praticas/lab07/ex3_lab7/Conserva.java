package lab07;

public class Conserva extends Entity {
    private String name;
    private int weight;

    
    public Conserva(String name, int weight) {
        this.name = name;
        this.weight = weight;        
    }

    public int count(){
        return weight;
    }
    
    public String toString() {
		return "Conserva ' " + name + "' - Weight : " + weight;
	}
    public void draw() {
       System.out.println(super.getIndent().toString() + this.toString() );

   }
}