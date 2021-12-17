import java.util.LinkedHashMap;
import java.util.Map;

public class CamperService {

  private BasicCamperService camperService;
  private Map<ICamper, Cliente> pedidos = new LinkedHashMap<>();
  private Map<ICamper, Proprietario> propCamper = new LinkedHashMap<>();

  public CamperService(BasicCamperService camperService) {
    this.camperService = camperService;
  }

  public void registaUtilizador(Utilizador u) {
    this.camperService.registaUtilizador(u);
  }

  public ICamper registaCamper(Proprietario p, int lugares, String descricao) {
    ICamper c = this.camperService.registaCamper(lugares, descricao);
    propCamper.put(c, p);
    return c;
  }

  public String registaPedido(Cliente u, ICamper c) {
    boolean sucesso = false;

    if (c.getEstado() == Estado.Disponivel) {
      c.setEstado(Estado.Reservado);
      this.pedidos.put(c, u);
      sucesso = true;
    }

    return "Pedido de " + u + " para " + c + ": " + (sucesso ? "Pendente" : "Não Efetuado");
  }

  public String cancelaPedido(Cliente u, ICamper c) {
    boolean sucesso = false;

    if (c.getEstado() == Estado.Reservado && this.pedidos.get(c) == u) {
      c.setEstado(Estado.Disponivel);
      this.pedidos.remove(c);
      sucesso = true;
    }

    return "Pedido de " + u + " para " + c + ": " + (sucesso ? "Cancelado" : "Não Cancelado");
  }

  public String aceitaPedido(Cliente u, ICamper c) {
    boolean sucesso = false;

    if (c.getEstado() == Estado.Reservado && this.pedidos.get(c) == u) {
      this.pedidos.remove(c);
      this.camperService.registaAluguer(u, c);
      sucesso = true;
    }

    return "Pedido de " + u + " para " + c + ": " + (sucesso ? "Aceite" : "Não Aceite");
  }

  public String rejeitaPedido(Cliente u, ICamper c) {
    boolean sucesso = false;

    if (c.getEstado() == Estado.Reservado && this.pedidos.get(c) == u) {
      c.setEstado(Estado.Disponivel);
      this.pedidos.remove(c);
      sucesso = true;
    }

    return "Pedido de " + u + " para " + c + ": " + (sucesso ? "Rejeitado" : "Não Rejeitado");
  }

  public String registaDevolucao(Cliente u, ICamper c) {
    return this.camperService.terminaAluguer(u, c);
  }

  public ICamper[] getCampersDisponiveis() {
    return this.camperService.getCampersDisponiveis();
  }

}
