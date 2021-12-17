package lab08_1_b;

class Person {
    private String name;
    private BankAccount bankAccount;

    public Person (String n) {
        name = n;
        //bankAccount = new BankAccountImpl("PeDeMeia", 0);
        bankAccount = new Proxy("PeDeMeia", 0);

    }

    public String getName() {
        return name;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }
}
