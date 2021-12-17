public class Disciplina {

	private String codigo;
	private String designacao;
	
	public Disciplina(String codigo, String designacao) {
		this.codigo = codigo;
		this.designacao = designacao;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDesignacao() {
		return designacao;
	}

	public String toString() {
		return codigo + ";" + designacao;
	}
		
}
