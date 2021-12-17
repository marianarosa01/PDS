package lab08_1_b;

class Employee {
    private double salary;
    private Person person;
    private String bank;
    private double initialDeposit;
    private BankAccountImpl bankAcc;

    public Employee (Person p, double s){
        this.person = p;
        this.salary = s;
        this.bankAcc = new BankAccountImpl(bank, initialDeposit);
    }
    public double getSalary() {
        return salary;
    }
    public Person getPerson() {
        return person;
    }
    public BankAccount getBankAccount() {
        return bankAcc;
    }
}
