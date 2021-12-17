public class Utilizador {

    private String nome;
    private String cidade;
    private int idade;

    public Utilizador(String nome, String cidade, int idade) {
        this.nome = nome;
        this.cidade = cidade;
        this.idade = idade;
    }

    public String toString() {
        return nome;
    }

}
