public class NullArtigo extends Entity implements Artigo {

    @Override
    public String name() {
        return "empty";
    }

    @Override
    public String description() {
        return "empty";
    }

    @Override
    public double price() {
        return 0.0;
    }

    @Override
    public void draw() {
        System.out.println(super.getIndent().toString() + this.toString() );        
    }

    public String toString() {
        return "ArtigoVazio [name= " + this.name() + ", description=" + this.description() +", price= "+ this.price() +"] ";
    }
    
}
