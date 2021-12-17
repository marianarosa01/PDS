import java.util.HashMap;
import java.util.Map;

public class ex1_main {
    public static void main(String args[]) {
        employee_interface e1 = new Employee (1293);
        TeamMember tm1 = new TeamMember (new Employee (1741));
        TeamLeader tl1 = new TeamLeader (new Employee(1325));
        Manager m1 = new Manager (new TeamLeader (new Employee(154)));

        Map<employee_interface, String[]> allEmployers = new HashMap<>();
        allEmployers.put(e1, new String[]{ "8-04-2012","9-04-2016" });
        allEmployers.put(tm1, new String[]{ "9-04-2014","11-04-2018" });
        allEmployers.put(m1, new String[]{ "17-04-2019","20-04-2019" });
        allEmployers.put(tl1, new String[]{ "10-04-2019", "15-04-2019" });
        
        
        for (employee_interface emp : allEmployers.keySet()) {
            String [] datas = allEmployers.get(emp);
            emp.start(datas[0]);
            emp.work();
            emp.terminate(datas[1]);

        }

    }


}
