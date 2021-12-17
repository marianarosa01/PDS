import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Iterator;

// Apenas pode modificar esta classe de acordo com o que é pedido no enunciado (linha 26)
// Pode (Deve!) também comentar linhas com erros para poder testar o código que for desenvolvendo

public class Mercadinho {

	public static void main(String[] args) throws FileNotFoundException {
		PrintStream fl = new PrintStream(new File("mercadinho.txt")); 
		test(System.out);  // executa e escreve na consola
		test(fl);		   // executa e escreve no ficheiro
		fl.close();
	}

	private static void test(PrintStream out) {
		
		StockManager iv = new SimpleStockManager();
		
		// alínea a)
		out.println("\nAlínea a) ----------------------------------\n");

		iv.registaArtigo("101", new Bebida("Cerveja", "Super Bock Abadia 33cl", 1.1, 6));
		iv.registaArtigo("102", new Bebida("Cidra", "Bandida do Pomar 33cl", 1.2, 6));
		iv.registaArtigo("103", new Bebida("Água", "Água Luso33cl", 0.5));
		iv.registaArtigo("104", new Doce("Bolachas Oreo", "Oreo Cookies pack", 2.9));
		iv.registaArtigo("105", new Doce("Bolachas Waffle", "Marca Continente Waffle", 1));

		Iterator<String> it = iv.iterator();
		while (it.hasNext()) {
			out.println(it.next());
		}
		
		
		// alínea b)
		out.println("\nAlínea b) ----------------------------------\n");
		Pacote c1 = new Pacote("Pack6", "Meia dúzia de guloseimas", 6);
		c1.add(new Doce("Cavacas", "Marca Durão, saco de 3", 1.75));
		c1.add(new Doce("Caladinhos", "Marca Mole, saco de 12", 4.75));
		c1.add(new Doce("Raivas", "Marca Fio Fino, saco de 12", 4));
		c1.add(new Bebida("Porto Vintage", "PDS 2020 Reserva", 38, 21));
		iv.registaArtigo("110", c1);
		iv.registaArtigo("111", new Bebida("Licor", "Beirão D'Honra", 10));

		for (String s : iv) { 
			out.println(s);
		}
		
		// alínea c)
		out.println("\nAlínea c) ----------------------------------\n");
		Artigo p1 = iv.removeArtigo("101"); // existe
		Artigo p2 = iv.removeArtigo("007"); // não existe
		out.println("Artigos retirados no SimpleStockManager: \n\t" + p1 + "\n\t" + p2);
		StockManager iv2 = new StoreStockManager(iv); // deve permitir também o construtor StoreStockManager()
		p1 = iv2.removeArtigo("110"); // existe
		p2 = iv2.removeArtigo("007"); // não existe
		out.println("Artigos retirados no StoreStockManager: \n\t" + p1 + "\n\t" + p2);
		for (String s : iv2) {
			out.println(s);
		}	
		
		// alineaD(out);  // descomentar após concluir alinea D
	}
	
	private static void alineaD(PrintStream out) {
		out.println("\nAlínea d) ----------------------------------\n");
		// .. ToDo
		//por falta de tempo,  não consegui implementar esta alínea, 
		//contudo se tivesse tempo iria implementar um Observer para estar atento a todas as entradas e saídas de artigos

	}
	
}

