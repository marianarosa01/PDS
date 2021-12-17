import java.util.ArrayList;
import java.util.List;
class Registos {
    private ArrayList<Empregado> empregados;

    public Registos() {
        empregados = new ArrayList<>();
    }
    public void insere(Empregado emp) {
        if (!empregados.contains(emp) && emp != null) {
            empregados.add(emp);
        }
    }
    public void remove(int codigo) {
        for (int i = 0; i < empregados.size(); i++) {
            if (empregados.get(i).getCodigo() == codigo) {
                empregados.remove(i);
            }
        }
    }
    public boolean isEmpregado(int codigo) {
        for (int i = 0; i < empregados.size(); i++) {
            if (empregados.get(i).getCodigo() == codigo) {
                System.out.println("Yes, he/she belongs to the Database");
                return true;
            }
        }
        return false;
    }
    public List<Empregado> listaDeEmpregados() {
        List<Empregado> listaEmpregados = new ArrayList<>(); // changed to ArrayList, does this work?
        for (int i = 0; i < empregados.size(); i++) {
            System.out.println(empregados.get(i)); // only to print
            listaEmpregados.add(empregados.get(i));
        }
        return listaEmpregados;
    }
}
