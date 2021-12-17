import java.util.Vector;
class Database {
    private Vector<Employee> employees;

    public Database() {
        employees = new Vector<>();
    }
    public boolean addEmployee(Employee employee) {
        if (employees.contains(employee) || employee == null) {
            return false;
        }
        else {
            employees.add(employee);
            return true;
        }
            
    }
    public void deleteEmployee(long emp_num) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmpNum() == emp_num) {
                employees.remove(i);
            }
        } 
    }
    public Employee[] getAllEmployees() {
        Employee[] staff = new Employee[employees.size()];
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i));
            staff[i] = employees.get(i);
        }
        return staff;
    }
    


}