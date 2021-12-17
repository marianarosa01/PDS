public class TeamLeader extends Employee_Decorator {
    public TeamLeader (employee_interface e) {
        super(e);
    }

    
	public void start(String data) {
		System.out.println("TeamLeader (" + super.toString() +") started at: " + data);
	}
    
    public void terminate (String data) {
        System.out.println("TeamLeader  (" + super.toString() +") has ended working at: " + data);
    }
    public void work() {
		System.out.println("TeamLeader (" + super.toString() + ") is working.");
    }
    
    public void plan() {
        System.out.println("TeamLeader (" + super.toString() + ") is planning right now.");
    }
    @Override
	public String toString() {
		return super.toString();
	}
    
}
