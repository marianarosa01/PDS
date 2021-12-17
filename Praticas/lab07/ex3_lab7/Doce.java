package lab07;


public class Doce extends Entity {
    private String name;
    private int weight;

    
    public Doce(String name, int weight) {
        this.name = name;
        this.weight = weight;        
    }

    public String toString() {
		return "Doce " + name + "' - Weight : " + weight;
	}
    public void draw() {
       System.out.println(super.getIndent().toString() + this.toString() );
    }

    public int count(){
        return weight;
    }

}