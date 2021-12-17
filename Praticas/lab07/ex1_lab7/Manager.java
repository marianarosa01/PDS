public class Manager extends Employee_Decorator {
    public Manager(employee_interface e) {
        super(e);
    }

    
	public void start(String data) {
		System.out.println("Manager  (" + super.toString() +") started at: " + data);
	}
    
    public void terminate (String data) {
        System.out.println("Manager  (" + super.toString() +") has ended working at: " + data);
    }
    public void work() {
		System.out.println("Manager (" + super.toString() + ") is working.");
    }
    
    public void manage() {
        System.out.println("Manager (" + super.toString() + ") is managing right now.");
    }

    @Override
	public String toString() {
        return super.toString();

	}
	

}
