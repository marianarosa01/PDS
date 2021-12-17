package lab08_1_b;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class Company {
    public static User user;
    private List<Employee> emps = new ArrayList<>();
    private List<Person> persons = new ArrayList<>();

    public void admitPerson(String name) {
        Person p = new Person(name);
        persons.add(p);
    }
    public void admitEmployee(Person person, double salary) {
        Employee e = new Employee(person, salary);
        emps.add(e);
    }

    public void paySalaries(int month) {
        for (Employee e : emps) {
            BankAccount ba = e.getBankAccount();
            System.out.println(e.getSalary());
            ba.deposit(e.getSalary());
        }
    }
    public List<Employee> employees() {
        return Collections.unmodifiableList(emps);
    }
}
