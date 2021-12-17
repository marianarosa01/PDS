import java.util.ArrayList;
import java.util.HashMap;

public class alinea2 {
    ArrayList <Utilizador> utilizadores =  new ArrayList<>();
    HashMap <Proprietario,Utilizador> mapaReservas =  new HashMap<>();
    HashMap <Cliente,ICamper> listaPedidos =  new HashMap<>();

    HashMap <Proprietario,ICamper> mapaCaravanas =  new HashMap<>();

    //agora ha clientes e proprietarios. Nesta nova solucao quando o cliente pede uma caravana ou tenta, o pedido fica pendente e terá de ser aceite pelo proprietario antes de o aluger se tornar efetivo. Podendo tambem ser rejeitado.
    public void registaUtilizador(Utilizador u){
        utilizadores.add(u);
    }
    public ICamper registaCamper(Proprietario p, int lugares, String descricao){
        Camper registaCamper = new Camper(lugares,descricao);
        mapaCaravanas.put(p,registaCamper);
        return registaCamper;

    }
    public String registaPedido(Cliente u, ICamper c){
        listaPedidos.put(u,c);
        return u.getNome() + "pediu " + c.getDescricao();
    }

    
    public String cancelaPedido(Cliente u, ICamper c);

    public String aceitaPedido(Cliente u, ICamper c){
        //Se o proprietario tiver daquele tipo ele aceita

    }


    public String registaDevolucao(Cliente u, ICamper c);

}
