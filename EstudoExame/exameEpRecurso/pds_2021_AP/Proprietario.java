import java.util.ArrayList;
import java.util.List;


public class Proprietario {
    private String nome;
    private String localidade;
    private int idade;
    ArrayList<ICamper> viaturas = new ArrayList<ICamper>();

    public Proprietario(String nome, String localidade, int idade) {
        this.nome = nome;
        this.localidade = localidade;
        this.idade = idade;
    }

    
    public void addVeiculos(ICamper c){
        viaturas.add(c);
    }


    public String getLocalidade() {
        return localidade;
    }
    public int getAge() {
        return idade;
    }
    public String getName() {
        return nome;
    }
    
}
