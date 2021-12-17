public class TestMe {

	public static void main(String[] args) {

		TabelaResultados tabelaWTJ = new TabelaResultados("JO 2020", new Disciplina("WTJ", "Women’s Triple Jump"), "2021/08/01");
		
		tabelaWTJ.adicionarAtleta(new Atleta("VEN", "Yulimar Rojas"), 15.67);
		tabelaWTJ.adicionarAtleta(new Atleta("POR", "Patricia Mamona"), 15.01);
		tabelaWTJ.adicionarAtleta(new Atleta("ESP", "Ana Peleteiro"), 14.87);
		System.out.println("1. Listagem dos resultados de 3 atletas em Triplo Salto Feminino");
		System.out.println(tabelaWTJ);

		// escolher formato CSV...
//		ArmazenamentoInterface csv = new ArmazenamentoCSV("tabelaWTJ_JO2020.csv");
//		csv.gravarTabela(tabelaWTJ);

		// ... ou o formato OBJ (serial)
//		ArmazenamentoInterface serial = new ArmazenamentoSerial("tabelaWTJ_JO2020.obj");
//		serial.gravarTabela(tabelaWTJ);


		Atleta a1 = new Atleta("JAM", "Shanieka Ricketts");

		tabelaWTJ.adicionarAtleta(a1, 12.04);
		tabelaWTJ.setResultado(a1, 14.84);
		System.out.println("2. Listagem dos resultados de 4 atletas em Triplo Salto Feminino");
		System.out.println(tabelaWTJ);

		
		// escolher o formato CSV ou OBJ (serial)
//		System.out.println(csv.lerTabela());
//		System.out.println(serial.lerTabela());

		// descomentar depois de implementar a alínea c)
		System.out.println("3. Listagem dos resultados por ordem crescente");
//		tabelaWTJ.setOrdem(TabelaResultados.Ordem.CRESCENTE);
//		System.out.println(tabelaWTJ);
//		tabelaWTJ.setOrdem(TabelaResultados.Ordem.DECRESCENTE);


		// Testar o comando undo aqui ...


	}
}