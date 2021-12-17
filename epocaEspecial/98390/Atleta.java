public class Atleta {

	private String pais;
	private String nome;
	
	public Atleta(String pais, String nome) {
		this.pais = pais;
		this.nome = nome;
	}

	public String getPais() {
		return pais;
	}

	public String getNome() {
		return nome;
	}

	public String toString() {
		return pais + ";" + nome;
	}

}
