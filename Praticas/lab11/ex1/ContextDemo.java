import java.util.Scanner;

public class ContextDemo {
	
	public static void main(String[] args) {
		Phone[] phones = new Phone[] { new Phone(1000, 128, "iPhone", 20), new Phone(600, 64, "Huaweii", 17),
            new Phone(400, 64, "Samsung", 20), new Phone(700, 64, "One", 16) }; 
		Context ctx = null;
		Strategy strategy = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose an algoritm to sort the list of phones by price:");
		System.out.println("1. BubbleSort");
		System.out.println("2. InsertionSort");
		System.out.println("3. SelectionSort");
		int s = sc.nextInt();
		
		switch(s)
        {
            case 1 :
                strategy = new BubbleSort();
                ctx = new Context(strategy);
                ctx.sort(phones);
                break;
                
            case 2 :
                strategy = new InsertionSort();
                ctx = new Context(strategy);
                ctx.sort(phones);
                break;
            case 3:
                strategy = new SelectionSort();
                ctx = new Context(strategy);
                ctx.sort(phones);
                break;
        }
        System.out.println("Result:");
        for (Phone p : phones) {
            System.out.println(p);
            
        }
	}
	
}