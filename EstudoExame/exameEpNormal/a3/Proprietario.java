package a3;

public class Proprietario extends Utilizador {

  public Proprietario(String nome, String cidade, int idade) {
    super(nome, cidade, idade);
  }

  @Override
  public void notify(String msg) {
    System.out.print("[PROPRIETARIO] ");
    super.notify(msg);
  }

}
