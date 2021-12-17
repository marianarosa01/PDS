class Cake {
    private Shape shape;
    private String cakeLayer; 
    private int numCakeLayers = 0;
    private Cream midLayerCream;
    private Cream topLayerCream;
    private Topping topping;
    private String message;



    public void setShape(Shape shape){
        this.shape = shape;
    };
    public void setCakeLayer( String cakeLayer){
        this.cakeLayer = cakeLayer;
    };
    public void addCakeLayer(int numCakeLayers){
        this.numCakeLayers = numCakeLayers++ ;
    }
    public void setMidLayerCream(Cream midLayerCream){
        this.midLayerCream=midLayerCream;
    }
    public void setTopLayerCream(Cream topLayerCream){
        this.topLayerCream=topLayerCream;
    }
    public void setTopping(Topping topping){
        this.topping=topping;
    }
    public void setMessage(String message){
        this.message=message;
    }
    public void setNumCakeLayers(int numCakeLayers) {
        this.numCakeLayers = numCakeLayers;
    }
    
    public Shape getShape() {
        return shape;
    }
    public int getNumCakeLayers() {
        return numCakeLayers;
    }
    public String getCakeLayer(){
        return cakeLayer;
    };
   
    public Cream getMidLayerCream() {
        return midLayerCream;
    }
    public Cream getTopLayerCream() {
        return topLayerCream;
    }
    public Topping getTopping() {
        return topping;
    }
    public String getMessage() {
        return message;
    }
    
    @Override public String toString() {
    return "" + (this.cakeLayer == "Chocolate" ? "Soft " + this.cakeLayer : this.cakeLayer) +
      " with " + this.numCakeLayers +  (this.numCakeLayers  > 1 ? " layers " : " layer ")
      + (this.midLayerCream == null ? "" : "and " + this.midLayerCream + " cream" ) + ", topped with " + this.topLayerCream +
      " cream and " + this.topping + ". Message says: \"" + this.message + "\"!";
  }
}


// all the possibilities

enum Shape {
    Circular,
    Rectangular, 
    Square
}
enum Cream {
    Chocolate,
    Vanilla,
    Strawberry,
    Red_Berries,
    Whipped_Cream,
    Eggs_Cream
}
enum Topping {
    Chocolate,
    EggsCream,
    Strawberry,
    Fruit,
    
}





