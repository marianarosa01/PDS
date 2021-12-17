package a3;

public class Cliente extends Utilizador {

  public Cliente(String nome, String cidade, int idade) {
    super(nome, cidade, idade);
  }

  @Override
  public void notify(String msg) {
    System.out.print("[CLIENTE] ");
    super.notify(msg);
  }

}
