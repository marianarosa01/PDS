public class TeamMember extends Employee_Decorator {
    public TeamMember (employee_interface e) {
        super(e);
    }

    
	public void start(String data) {
		System.out.println("TeamMember  (" + super.toString() +") started at: " + data);
	}
    
    public void terminate (String data) {
        System.out.println("TeamMember  (" + super.toString() +") has ended working at: " + data);
    }
    public void work() {
		System.out.println("TeamMember (" + super.toString() + ") is working.");
    }
    
    public void colaborate() {
        System.out.println("TeamMember (" + super.toString() + ") is colaborating right now.");
    }
    
	@Override
	public String toString() {
		return super.toString();
	}

}
 
