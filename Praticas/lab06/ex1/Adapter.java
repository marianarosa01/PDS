import java.util.ArrayList;
import java.util.List;

public class Adapter extends Database {
	
	private Registos registo;
	
	public Adapter(Registos registo) {
		super();
		this.registo = registo;
	}
		
	
	public void addEmployee(Empregado empregado) {
		registo.insere(empregado);
	}
	
	public void removeEmployee(int codigo) {
		registo.remove(codigo);
	}
	
	public void isEmployee(int codigo) {
		registo.isEmpregado(codigo);
	}
	
	public void printEmployees() {	
		List <Empregado> empregados = new ArrayList <>();
    	empregados = registo.listaDeEmpregados();
    	System.out.println("Lista de empregados:");
        for (int i = 0; i < empregados.size(); i++) {
			System.out.println(empregados.get(i));
		}
	}

	
}