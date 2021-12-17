abstract class Employee {
    protected String name;
    public abstract String getName();
}

class Programmer extends Employee {
    public Programmer(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }
}

class NullEmployee extends Employee {
    @Override
    public String getName() {
        return "There is not any programmer with that name!";
    }
}