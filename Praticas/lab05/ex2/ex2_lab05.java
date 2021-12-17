public class ex2_lab05 extends Cake{ 
    public static void main(String[] args) {
        CakeMaster cakeMaster = new CakeMaster();
        CakeBuilder chocolate = new ChocolateCakeBuilder();
        cakeMaster.setCakeBuilder(chocolate);
        cakeMaster.createCake("Congratulations");
        Cake cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);
        // 1 cake layer
        CakeBuilder sponge = new SpongeCakeBuilder();
        cakeMaster.setCakeBuilder(sponge);
        cakeMaster.createCake(Shape.Square, 2, "Well done");
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake); // squared, 2 layers
        CakeBuilder yogurt = new YogurtCakeBuilder();
        cakeMaster.setCakeBuilder(yogurt);
        cakeMaster.createCake(3, "The best");
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake); // 3 cake layers
        CakeBuilder sweetEgg = new doceDeOvosCakeBuilder();
        cakeMaster.setCakeBuilder(sweetEgg);
        cakeMaster.createCake(Shape.Rectangular, 3, "Directly from Aveiro!");
        cake= cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake); // 3 cake layers

        }
}