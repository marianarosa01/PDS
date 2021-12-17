
public class Main {
    public static void main(String[] args){
        Product p1 = new Product("House on a beach", 300000);
        Product p2 = new Product("iPhone 11", 700);
        Product p3 = new Product("Fiat 500", 14000);
        Product p4 = new Product("Macbook", 2000);
        Product p5 = new Product("HP Computer", 1000);

        Client cl1 = new Client("Eva Pomposo");
        Client cl2 = new Client("Daniel Figueiredo");
        Client cl3 = new Client("Ines Freitas");

        Gestor g = new Gestor ("André Moniz");

        g.notifications(p1);
        g.notifications(p2);
        g.notifications(p2);
        g.notifications(p4);
        g.notifications(p5);

        cl1.notifications(p1);
        cl1.notifications(p2);
        cl1.notifications(p3);

        cl2.notifications(p1);
        cl2.notifications(p2);
        cl2.notifications(p3);
         
    
        cl3.notifications(p1);
        cl3.notifications(p2);
        cl3.notifications(p3);


        System.out.println("---------------------ATTENTION! The Auction will beguin---------------------");
        g.updateState(p1, State.auction);
        g.updateState(p2, State.auction);
        g.updateState(p3, State.auction);       //não recebe licitações     
        
        System.out.println("-----------------------------------------------------------------------------");

        cl1.makeNewBid(p1, 200000); //wont work
        System.out.println();
        cl2.makeNewBid(p2, 800); //will work
        cl3.makeNewBid(p3, 80000); //will work

        g.updateState(p2, State.sold);

    }
}
