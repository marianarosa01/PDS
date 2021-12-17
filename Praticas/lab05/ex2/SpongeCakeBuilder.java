public class SpongeCakeBuilder implements CakeBuilder{
    protected Cake cake;
    public Cake getCake(){
        return cake;
    }
    
    @Override
    public void createCake() {
        cake = new Cake();
        cake.setCakeLayer("Sponge");
    }

    public void setCakeShape(Shape shape){
        cake.setShape(Shape.Square);
    }
    @Override
    public void addCakeLayer()  {
        cake.addCakeLayer(2);
    }
    @Override
    public void addCreamLayer() {
        cake.setMidLayerCream(Cream.Red_Berries);
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
        cake.setMessage("Well done");
        
    }
    
}
