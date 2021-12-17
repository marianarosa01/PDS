import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VoosMain {

    Manager manager = new Manager();

    public static void main(String[] args) throws FileNotFoundException {
        VoosMain menu = new VoosMain();
        if (args.length == 0) {            
            menu.menu();
        }
        else if (args.length == 1 && args[0].contains(".txt")) {
            readFile(args[0]);
        }
        else {
            System.out.println("Error! VoosMain.java only takes one argument and it must be .txt file.");
        }
    }

    public void menu(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Option: (H for help)");
        while(options(sc.nextLine())){
            System.out.println("Option: (H for help)");
        }

        sc.close();
    }

    public boolean options(String line) {
        boolean ret = true;
        String[] input = line.split(" ");

        switch(input[0]){
        
            case "H":
                printHelp();
                break;
                
            case "I":
                if(input.length == 2){  // verificar se há input depois do I   
                    if (!input[1].contains(".txt")){
                        System.err.println("Input file must be .txt");
                    }

                    String filename = input[1];
                    printFlightInfo(filename);

                } else { System.out.println("[ERROR] Usage: I <filename> (example: 'I flight1.txt')"); menu();}
                break;

            case "M":
                if(input.length == 2){  // verificar se há input depois do M   
                    if (!validFlightCode(input[1])){
                        System.err.println("Flight code must be type AA0000");
                    }

                    String flight_code = input[1];
                    manager.printReservation(flight_code);

                } else { System.out.println("[ERROR] Usage: M <flight_code> (example: 'M TP1920')"); menu();}
                break;

            case "F":

                String[] num_seats_tourist = input[2].split("x"); 
                int t_rows = 0; int t_cols = 0; int e_rows = 0; int e_cols = 0;

                String f_error = "[ERROR] Usage: F <flight_code> <num_seats_executive> <num_seats_tourist> (example: 'F TP1930 5x3 12x4') (<num_seats_executive> is optional)";
                
                if (input.length == 3){
                    if (validFlightCode(input[1]) && input[2].matches("[0-9]+x[0-9]+")){
                        
                        String flight_code = input[1];
                        t_rows = Integer.parseInt(num_seats_tourist[0]); 
                        t_cols = Integer.parseInt(num_seats_tourist[1]);
                        manager.addFlight(flight_code, t_rows, t_cols);

                    } else { System.out.println(f_error); menu();}

                } else if (input.length == 4){
                    if (validFlightCode(input[1]) && input[2].matches("[0-9]+x[0-9]+") && input[3].matches("[0-9]+x[0-9]+")){
                        String flight_code = input[1];

                        String[] num_seats_executive = input[2].split("x"); 
                        e_rows = Integer.parseInt(num_seats_executive[0]); 
                        e_cols = Integer.parseInt(num_seats_executive[1]);
                        
                        num_seats_tourist = input[3].split("x"); 
                        t_rows = Integer.parseInt(num_seats_tourist[0]); 
                        t_cols = Integer.parseInt(num_seats_tourist[1]);
                        
            
                        manager.addFlight(flight_code, e_rows, e_cols, t_rows, t_cols);
                        
                    } else { System.out.println(f_error); menu();}

                } else { System.out.println(f_error); menu();}
                break;

            case "R":

                String r_error = "[ERROR] Usage: R <flight_code> <class> <number_seats> (example: 'R TP1930 T 3')";
                if(input.length  == 4){
                    if (!validFlightCode(input[1]) || !input[2].matches("T|E") || !isInt(input[3])){        // se qqlr um deles n verificar dá erro
                        System.out.println(r_error); 
                    }

                    String flight_code = input[1];
                    char cl = input[2].charAt(0);
                    int number_seats = Integer.parseInt(input[3]);
                    manager.reserveSeats(flight_code, cl, number_seats);

                } else { System.out.println(r_error); menu();}
                break;

            case "C":

                String c_error = "C <reservation_code> (flight_code:sequential_reservation_number) (example: 'C TP1920:2')";
                if (input.length == 2){
        
                    String[] reservation_code = input[1].split(":");

                    if (!validFlightCode(reservation_code[0]) || !isInt(reservation_code[1])){
                        System.out.println(c_error);
                    }

                    String flight_code = reservation_code[0];
                    int reservation_number = Integer.parseInt(reservation_code[1]);

                    manager.cancelReservation(flight_code, reservation_number);

                } else {System.out.println(c_error); menu(); }
                break;
            case "Q":
                System.out.println("Goodbye!");
                ret = false;
                break;
            default:
                System.out.println("Invalid menu option!");
        }
        return ret;
    }

    private static void printHelp(){
        String str = "";
        str += "\n------------------------------- Program Usage: -------------------------------\n" ;
        str += "I <filename> - Ler ficheiro de texto contento informação sobre um voo\n";
        str += "M <flight_code> - Exibir mapa das reservas de um voo\n";
        str += "F <flight_code> <num_seats_executive> <num_seats_tourist> - AcrescentaR um novo voo (ter lugares na executiva é opcional)\n";
        str += "R <flight_code> <class> <number_seats> - Acrescentar nova reserva a um voo\n";
        str += "C <reservation_code> (flight_code:sequential_reservation_number) - Cancelar reserva\n";
        str += "Q - Sair\n";
        str += "-------------------------------------------------------------------------------";

        System.out.println(str);

    }

    private static boolean validFlightCode(String code){
        boolean ret = false;
    
        String pattern = "[A-Z]{2}[0-9]{4}";
        if (code.matches(pattern)){
            ret = true;
        }

        return ret;
    }

    private static boolean isInt(String str) {
        boolean ret = false;
        
        try {
            int x = Integer.parseInt(str);
            return true; 

        } catch (NumberFormatException e) { ret = false; }

      return ret;
        
    }

    public static void readFile(String fname) throws FileNotFoundException {

        VoosMain menu = new VoosMain();

        File f = new File(fname);
        Scanner sc = new Scanner(f);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            menu.options(line);
        }

        sc.close();
    }
      

    private static void printFlightInfo(String fname){

        String str = "";
        String[] word = {};

        try {
            File file = new File(fname);
            Scanner sc = new Scanner(file);

            int number_e_seats = 0;
            int number_t_seats = 0;

            while (sc.hasNextLine()) {
                word = sc.nextLine().split(" ");

                String flight_code = word[0].replace(">","");  // turn string '>TP1920' to 'TP1920'

                if (validFlightCode(flight_code) && word.length == 3){ // ha cadeiras executive e turistica
                    
                    str+="Código de voo " + flight_code + ". Lugares disponíveis: " ;
                
                    String[] e_seats = word[1].split("x");       // executiva
                    String[] t_seats = word[2].split("x");      // turistica
                
                    if (isInt(e_seats[0]) && isInt(e_seats[1]) && isInt(t_seats[0]) && isInt(t_seats[1])){  // verifica q tudo é numeros
                        number_e_seats = Integer.parseInt(e_seats[0]) * Integer.parseInt(e_seats[1]);
                        str += number_e_seats + " lugares em classe Executiva; ";
                        number_t_seats = Integer.parseInt(t_seats[0]) * Integer.parseInt(t_seats[1]);
                        str += number_t_seats + " lugares em classe Turística.\n";
                    }


                } else if (validFlightCode(flight_code) && word.length == 2){    // ha cadeiras turistica só
                    
                    str +="Código de voo " + flight_code + ". Lugares disponíveis: " ;
                    
                    String[] t_seats = word[1].split("x");      // turistica

                    if (isInt(t_seats[0]) && isInt(t_seats[1])){  // verifica q tudo é numeros
                        number_t_seats = Integer.parseInt(t_seats[0]) * Integer.parseInt(t_seats[1]);
                        str += number_t_seats + " lugares em classe Turística.\nClasse executiva não disponível neste voo.\n";
                    }
                
                } else if (word.length == 2 && (word[0].charAt(0)  == 'T') || (word[0].charAt(0)  == 'E')){     // linha q representa lugares
                    
                    if (word[0].charAt(0)  == 'T'){

                        if (isInt(word[1])){
                            int seat_taken_t = Integer.parseInt(word[1]);
                            if (number_t_seats >= seat_taken_t){
                                number_t_seats -= seat_taken_t;
                            } else { str += "Não foi possível obter lugares para a reserva: " + word[0] + " " + word[1]; }
                        }

                    } else if (word[0].charAt(0) == 'E'){
                        if (isInt(word[1])){
                            int seat_taken_e = Integer.parseInt(word[1]);
                            if (number_e_seats >= seat_taken_e){
                                number_e_seats -= seat_taken_e;
                            } else { str += "Não foi possível obter lugares para a reserva: " + word[0] + " " + word[1]; }
                        }
                    }
 
                } else {System.out.println("[ERROR] Invalid syntax!"); System.exit(0); }
            }

            System.out.println(str + "\n");
            sc.close();
            
        } catch (FileNotFoundException e) {
            System.err.println("[ERROR] File doesn't exist!");
            System.exit(0);
        }
    }
}                        


