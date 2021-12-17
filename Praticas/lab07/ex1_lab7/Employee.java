public class Employee implements employee_interface {
    private int numFunc;
    private String dataInicio;
    private String dataFim;

    public Employee(int numFunc, String dataInicio, String dataFim) {
		this.numFunc= numFunc;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		
	}

    public Employee (int numFunc ) {
        this.numFunc = numFunc;
        this.dataInicio = null;
        this.dataFim = null;

    }

    public String getDataInicio() {
		return dataInicio;
	}

    public int getNumFunc() {
		return numFunc;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}



	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}


    @Override
    public void start(String date) {
        System.out.println("Employee number " + numFunc + " started working at "+ date);       
        this.dataInicio = date;
    }

    @Override
    public void terminate(String date) {
        System.out.println("Employee number " + numFunc + " ended working at "+ date);       
        this.dataFim = date;
        
    }

    @Override
    public void work() {
        System.out.println("Employee number " + numFunc + " is working");        
    }

    @Override
	public String toString() {
		return "Employee number  " + numFunc ;
	}

}
