abstract class Employee_Decorator implements employee_interface {
    protected employee_interface e;
    Employee_Decorator(employee_interface e) {
        this.e = e;
    }
    public void work() {
        e.work();
    }
    public void start(String Date){
        e.start(Date);
    }
    public void terminate(String Date){
        e.terminate(Date);
    }

    public employee_interface get() {
        return e;
    }
    public void set(employee_interface e) {
		this.e = e;
	}
    
    @Override
	public String toString() {
		return e.toString();
	}

}
