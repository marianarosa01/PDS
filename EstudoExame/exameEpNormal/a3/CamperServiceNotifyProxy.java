package a3;

public class CamperServiceNotifyProxy extends CamperService {

  public CamperServiceNotifyProxy(BasicCamperService camperService) {
    super(camperService);
  }

  @Override
  public String aceitaPedido(Cliente u, ICamper c) {
    String msg = super.aceitaPedido(u, c);
    u.notify(msg);
    return msg;
  }

  @Override
  public String rejeitaPedido(Cliente u, ICamper c) {
    String msg = super.rejeitaPedido(u, c);
    u.notify(msg);
    return msg;
  }

  @Override
  public String registaPedido(Cliente u, ICamper c) {
    String msg = super.registaPedido(u, c);
    this.getCamperProprietario(c).notify(msg);
    return msg;
  }

  @Override
  public String cancelaPedido(Cliente u, ICamper c) {
    String msg = super.cancelaPedido(u, c);
    this.getCamperProprietario(c).notify(msg);
    return msg;
  }

}
