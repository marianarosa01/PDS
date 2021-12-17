public class Context {
    private Strategy orderStrategy;
    
    public Context(Strategy order) {
        this.orderStrategy = order; }
    
    public Phone[] sort(Phone[] phones){
        orderStrategy.sort(phones);
        return phones;
    }
    
    public void setStrategy(Strategy strategy){
        orderStrategy = strategy;}

}