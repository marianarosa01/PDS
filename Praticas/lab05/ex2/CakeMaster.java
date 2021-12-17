public class CakeMaster {
//Director
    private CakeBuilder ck;

    public void createCake(Shape shape, int layers,  String Message){
        ck.createCake();
        ck.setCakeShape(shape);
        for (int l=0; l < layers; l++){
            ck.addCakeLayer();
        }
        ck.addMessage(Message);
        ck.addCreamLayer();
        ck.addTopLayer();
        ck.addTopping();
        ck.addCakeLayer();
    }
    public void createCake(String Message){
        createCake(Shape.Circular, 1, Message);
    }
    public void createCake(int layers, String Message){
        createCake(Shape.Circular, layers, Message);
    }
    public Cake getCake(){
        return ck.getCake();
    } 
    public void setCakeBuilder(CakeBuilder ck){
        this.ck = ck;

    }
     
    

    
}
