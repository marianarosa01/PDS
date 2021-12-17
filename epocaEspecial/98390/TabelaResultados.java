import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class TabelaResultados {
    private String evento;
    private Disciplina d;
    private String data_evento;
    private Atleta atleta;
    private double resultado;
    private HashMap<Atleta, Double> tabela = new HashMap<>();
    
    //Classe que representa resultados em determinado evento e disciplina
    public TabelaResultados(String evento, Disciplina d, String data_evento){
        this.evento = evento;
        this.d = d;
        this.data_evento = data_evento;
    }

    //add atleta
    //remove atleta
    //setResultado
    public void adicionarAtleta (Atleta atleta,double resultado) {
        if (!tabela.containsKey(atleta)){
            tabela.put(atleta, resultado);
        }
    }

    public void removerAtleta (Atleta atleta,double resultado) {
        if (tabela.containsKey(atleta)){
            tabela.remove(atleta);
        }
    }

    public void setResultado (Atleta atleta,double resultado) {
        if (tabela.containsKey(atleta)) {
            tabela.put(atleta,resultado);
        }
        else {
            System.out.println("Erro! Não existe esta atleta.");
        }
    }
    /*
    public void printAll(){
        //ArrayList<Atleta> chaves = new ArrayList<>();
        Object chaves = tabela.keySet().toArray();
        //ArrayList<Atleta> valores = new ArrayList();

        Object valores = tabela.keySet().toArray();
       

        for (int i = 0; i < tabela.size(); i++) {
            System.out.println(chaves[i] + ";" + valores[i]);
        }
    }
    */
    
    public String toString() {
            return this.evento + ";" + this.d + ";" + this.data_evento + "\n" +  tabela.entrySet() ;
        
    }

    


}

