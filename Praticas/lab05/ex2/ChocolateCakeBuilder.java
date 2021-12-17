public class ChocolateCakeBuilder implements CakeBuilder{
    protected Cake cake;
    public Cake getCake(){
        return cake;
    }
    
    @Override
    public void createCake() {
        cake = new Cake();
        cake.setCakeLayer("Chocolate");
    }
    public void setCakeShape(Shape shape){
        cake.setShape(Shape.Circular);
    }
    @Override
    public void addCakeLayer()  {
        cake.addCakeLayer(1);
    }
    @Override
    public void addCreamLayer() {
    }
    @Override
    public void addTopLayer() {
        cake.setTopLayerCream(Cream.Whipped_Cream);

    }
    @Override
    public void addTopping() {
        cake.setTopping(Topping.Fruit);
        
    }
    @Override
    public void addMessage(String m) {
        cake.setMessage("Congratulations");
        
    }
    


   
    
    
}
