public class ex1_lab06 { 
    public static void main(String[] args) {

        Database d = new Database();
        Employee emp1 = new Employee ("Maria Rodrigues", 234, 765.0);
        d.addEmployee(emp1);
        Employee emp2 = new Employee ("Valter Rosa", 235, 765.0);
        d.addEmployee(emp2);
        Employee emp3 = new Employee ("Teresa Silva", 236, 770.0);
        d.addEmployee(emp3);
        d.getAllEmployees();
        d.deleteEmployee(emp3.getEmpNum());
        d.getAllEmployees();


        Registos r = new Registos();
        Empregado e1 = new Empregado("João", "Fernandes", 1, 760.0);
        r.insere(e1);
        Empregado e2 = new Empregado("Anita", "Rosário", 2, 850.0);
        r.insere(e2);
        Empregado e3 = new Empregado("Col", "Needham", 3, 999.0);
        r.insere(e3);
        r.isEmpregado(3);
        r.listaDeEmpregados();
        r.remove(2);
        r.listaDeEmpregados();
        
    }
}
