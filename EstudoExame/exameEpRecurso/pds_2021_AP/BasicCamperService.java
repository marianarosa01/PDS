import java.util.ArrayList;

import java.util.HashMap;
//servicos necessarios para partilha

public class BasicCamperService implements ICamperService{
    Camper c;
    ArrayList<Utilizador> clientList = new ArrayList<Utilizador>();
    ArrayList<ICamper> campersList = new ArrayList<>();
    HashMap <Cliente, ICamper> mapBooking = new HashMap<>();
    ArrayList<ICamper> availableC = new ArrayList<ICamper>();


    @Override
    public void registaUtilizador(Utilizador u) {
        clientList.add(u);
    }

    @Override
    public ICamper registaCamper(int lugares, String descricao) {
        //		ICamper h1 = onwheels.registaCamper(4, "MotorHome com quatro lugares, 3 camas, cozinha, mesa, WC.");
        Camper newCamper = new Camper(lugares,descricao);
        c.setEstado(Estado.Disponivel);
        campersList.add(newCamper);
        return newCamper;

    }

    @Override
    public String registaAluguer(Cliente cliente, ICamper c) {
        if (c.getEstado() == Estado.Disponivel){
            mapBooking.put(cliente,c);
            c.setEstado(Estado.Reservado);
            return "Caravana reservada por " + cliente.getNome() + " .";
        }
        return "Aluguer";
           
    }

    @Override
    public String terminaAluguer(Cliente u, ICamper c) {
        mapBooking.remove(u,c);
        c.setEstado(Estado.Disponivel);
        availableC.remove(c);
        return "Caravana terminada de alugar.  Está livre";

    }

    public  ArrayList<ICamper> getCampersDisponiveis() {
        for(ICamper c: campersList) {
            if (c.getEstado() == Estado.Disponivel){
                availableC.add(c);
            }
        }
        return availableC;
    }


}
