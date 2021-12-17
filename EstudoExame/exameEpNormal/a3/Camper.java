package a3;

public class Camper implements ICamper {

  private Estado e;
  private String descricao;
  private int lugares;

  public Camper(String descricao, int lugares) {
    this.e = Estado.Disponivel;
    this.descricao = descricao;
    this.lugares = lugares;
  }

  @Override
  public void setEstado(Estado e) {
    // TODO Auto-generated method stub
    this.e = e;
  }

  @Override
  public Estado getEstado() {
    // TODO Auto-generated method stub
    return e;
  }

  @Override
  public int getLugares() {
    // TODO Auto-generated method stub
    return lugares;
  }

  @Override
  public String getDescricao() {
    // TODO Auto-generated method stub
    return descricao;
  }

  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return descricao;
  }

}
