import java.util.ArrayList;
import java.util.List;

public class BasicCamperService implements ICamperService {
  private List<Utilizador> users = new ArrayList<>();
  private List<ICamper> campers = new ArrayList<>();

  @Override
  public void registaUtilizador(Utilizador u) {
    users.add(u);
  }

  @Override
  public ICamper registaCamper(int lugares, String descricao) {
    ICamper c = new Camper(descricao, lugares);
    campers.add(c);
    return c;
  }

  @Override
  public String registaAluguer(Cliente u, ICamper c) {
    boolean success = false;

    if (c.getEstado() != Estado.Indisponivel) {
      success = true;
      c.setEstado(Estado.Indisponivel);
    }

    return "Utilizador " + u + " " + (success ? "alugou" : "tentou alugar") + " " + c;
  }

  @Override
  public String terminaAluguer(Cliente u, ICamper c) {
    // TODO Auto-generated method stub
    boolean success = false;

    if (c.getEstado() == Estado.Indisponivel) {
      success = true;
      c.setEstado(Estado.Disponivel);
    }

    return "Utilizador " + u + " " + (success ? "devolveu" : "tentou devolver") + " " + c;
  }

  public ICamper[] getCampersDisponiveis() {
    List<ICamper> livres = new ArrayList<>();

    for (ICamper iCamper : campers)
      if (iCamper.getEstado() == Estado.Disponivel)
        livres.add(iCamper);

    return livres.toArray(new ICamper[0]);
  }

}
