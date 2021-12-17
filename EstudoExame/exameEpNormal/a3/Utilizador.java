package a3;

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

    public void notify(String msg) {
        System.out.println("Nova Notificação para " + this + " - \"" + msg + "\"");
    }

}
