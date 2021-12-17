import java.util.ArrayList;
import java.util.Scanner;

public class StateDemo {
    public static void main(String[] args) {
        Book b1 = new Book("Java Anti-Stress", "Omodionah", 2001);
        Book b2 = new Book("A Guerra dos Padrões", "Jorge Omel", 2001);
        Book b3 = new Book("A Procura da Luz", "Khumatkli", 2001);
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(b1);
        books.add(b2);
        books.add(b3);
        Scanner scanner = new Scanner(System.in);
        String answer = "";
        int op = 0;

        while (op >= 0 && op < 7) {
            System.out.println("*** Biblioteca ***");

            for (Book b : books) {
                System.out.println(b);
            }

            System.out.println(">>  <livro>, <operação: (1)regista; (2)requisita; (3)devolve; (4)reserva; (5)cancela; (6)sair");
            answer = scanner.nextLine();
                
            if (answer.length() == 1) {
                op = Integer.parseInt(answer);
                if (op == 6) {
                    break;
                }
                else {
                    System.out.println("Operação inválida!");
                    break;
                }
            }

            int book = Integer.parseInt(answer.split(",")[0]) - 1;
            op = Integer.parseInt(answer.split(",")[1]);

            switch (op) {
                case 1:
                    books.get(book).registBook();
                    break;
                case 2:
                    books.get(book).orderBook();
                    break;
                case 3: 
                    books.get(book).returnBook();
                    break;
                case 4: 
                    books.get(book).reserveBook();
                    break;
                case 5: 
                    books.get(book).cancelReserveBook();
                    break;
                default:
                    System.out.println("Insira uma opção válida!");
                    break;
            }
           
    }
        
    scanner.close(); 
 
    }
    
}