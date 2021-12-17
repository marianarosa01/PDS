public class doceDeOvosCakeBuilder implements CakeBuilder{
    protected Cake cake;
    public Cake getCake(){
        return cake;
    }
    
    @Override
    public void createCake() {
        cake = new Cake();
        cake.setCakeLayer("Doce de Ovos");
    }
    public void setCakeShape(Shape shape){
        cake.setShape(Shape.Circular);
    }
    @Override
    public void addCakeLayer()  {
        cake.addCakeLayer(3);
    }
    @Override
    public void addCreamLayer() {
        cake.setMidLayerCream(Cream.Eggs_Cream);
    }
    @Override
    public void addTopLayer() {
        cake.setTopLayerCream(Cream.Whipped_Cream);

    }
    @Override
    public void addTopping() {
        cake.setTopping(Topping.Chocolate);
        
    }
    @Override
    public void addMessage(String m) {
        cake.setMessage("Directly from Aveiro!");
        
    }
    



   
    
    
}
