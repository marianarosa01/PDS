abstract class Cozinheiro {
    private Cozinheiro cozinheiro = null;
    public void cozinha(String comida) {
        if (cozinheiro != null)
            cozinheiro.cozinha(comida);
        

        else if(cozinheiro.canCookFood(comida, "pasta") == false) 
            System.out.println("Pasta Chef: I can't cook that!");
        
        else if(cozinheiro.canCookFood(comida, "sushi") == false) 
            System.out.println("Sushi Chef: I can't cook that!");
        else 
            System.out.println("We're sorry but that request can't be satisfied by our service! ");
        

    }
    
    protected boolean canCookFood (String food, String foodType){
        food = food.toLowerCase();
        
        return (food.indexOf(foodType) != -1 ?  true : false);

    }
    
    public Cozinheiro setSucessor (Cozinheiro nextCooker) {
        this.cozinheiro = nextCooker;
        return this;
        
    }

    
}
