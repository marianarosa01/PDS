import java.util.HashMap;

// package pds_2021_111.lab03;

public class Manager {
    private HashMap<String, Flight> flights = new HashMap<String, Flight>();

    public Manager() {

    }

    public void addFlight(String f_code, int t_rows, int t_cols) {
        Plane p = new Plane(t_rows, t_cols);
        Flight f = new Flight(f_code, p);

        flights.put(f_code, f);
        if (flights.get(f_code)!= null) {
            System.out.println("Flight " + f_code + " added with success");
        }
        else {
            System.out.println("Error while creating flight");
        }
    }

    public void addFlight(String f_code, int ex_rows, int ex_cols, int t_rows, int t_cols) {
        Plane p = new Plane(ex_rows, ex_cols, t_rows, t_cols);
        Flight f = new Flight(f_code, p);

        flights.put(f_code, f);
        if (flights.get(f_code)!= null) {
            System.out.println("Flight " + f_code + " created successfully");
        }
        else {
            System.out.println("Error while creating flight");
        }
    }

    public Flight getFlight(String f_code) {
        if (flights.containsKey(f_code)) {
            return flights.get(f_code);
        }
        return null;
    }

    public boolean reserveSeats(String f_code, char class_code, int n_seats) {
        
        Flight f = this.getFlight(f_code);
        int ex_seats = f.getPlane().getExecutiveSeats();

        //boolean t = false;
        //boolean e = false;

        if (f != null) {            

            if (class_code == 'T') {
                if (n_seats <= f.getTouristicAvlSeats()) {
                    // reservar lugares em classe turistica
                    Reservation res = f.reserveT(n_seats);
                    if (res != null) {
                        System.out.println(f_code + ":" + res.getNumber() + " = " + res.seatsToString());
                    }
                    else {
                        System.out.println("An error ocurred while trying to make your reservation");
                    }
                }
                else {
                    System.out.println("Touristic class does not have " + n_seats + " available. " + f.getTouristicAvlSeats() + " available.");
                    return false;
                }

            }
            else if (class_code == 'E') {

                if (ex_seats != 0){
                    //reservar lugares em classe executiva
                    if (n_seats <= f.getExecutiveAvlSeats()) {
                        Reservation res = f.reserveE(n_seats);
                        if (res != null) {
                            System.out.println(f_code + ":" + res.getNumber() + " = " + res.seatsToString());
                        }
                        else {
                            System.out.println("An error ocurred while trying to make your reservation");
                        }
                    }
                    else {
                        System.out.println("Executive class does not have " + n_seats + " available. " + f.getExecutiveAvlSeats() + " available.");
                        return false;
                    }
                } else {
                    System.out.println("This is flight doesn't have an Executive class");
                    return false;
                }

            }
            else {
                System.out.println("The class character must be a E for executive or a T for touristic.");
                return false;
            }
        }        
        else {
            System.out.println("The flight code you entered does not exist.");
            return false;
        }

        return false;
    }

    public void cancelReservation(String f_code, int r_number) {

        Flight f = this.getFlight(f_code);

        if (f != null) {
            if (f.cancelRes(r_number)){
                System.out.println(f_code + ":" + r_number + " deleted with success.");
            }
            else {
                System.out.println("Error while canceling your reservation. Maybe reservation " + r_number + " does not exist.");
            }
        }
        else{
            System.out.println("The flight code you entered does not exist.");
        }
    }

    public void printReservation(String f_code) {
        Flight f = this.getFlight(f_code);

        if (f != null) {
            f.printRes();
        }
        else {
            System.out.println("The flight code you entered does not exist.");
        }
    }
}
