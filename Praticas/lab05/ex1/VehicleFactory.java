class VehicleFactory{
    public static Vehicle getVehicle(int numSeats, int[] luggage, boolean wheelchair){
        int volume=0;
        String error = "Sorry, we can't find a vehicle for you.";
        for (int i : luggage){
            volume= volume + i;
        }
        if (volume == 0) {
            if (wheelchair == false) {
                System.out.printf("Vehicle for " + numSeats + " passengers: ");
            }      
            else {
                System.out.printf("Vehicle for " + numSeats + " passengers " + luggage.length + " items of luggage and wheelchair: ");
            }   
        }
        else if (volume != 0 && wheelchair == false) {
            System.out.printf("Vehicle for " + numSeats + " passengers: " + luggage.length + " items of luggage: ");
        }
        else if (volume != 0 && wheelchair == true) {
            System.out.printf("Vehicle for " + numSeats + " passengers " + luggage.length + " items of luggage and wheelchair: ");
        }


        if (numSeats == 1 && volume==0){
            return new Scooter(); 
        }
        else if (numSeats == 1 && volume<=250 && wheelchair== false){
            return new Micro();
        }
        else if (numSeats <=3 && volume<=250 && wheelchair== false){
            return new City();
        }
        else if (numSeats <= 4 && volume<=600 && wheelchair== false){
            return new Family();
        }
        else if (numSeats<=4  && volume<=1000) {
            return new Van();
        }
        else{
            System.out.println(error);
            return null;
        }



    }
    public static Vehicle getVehicle(int numSeats){
        int [] luggage = new int [1];
        luggage[0]=0;
        return getVehicle(numSeats, luggage, false);
    }
    public static Vehicle getVehicle(int numSeats, boolean wheelchair){
        int [] luggage = new int [1];
        luggage[0]=0;
        return getVehicle(numSeats,luggage , true);
    }
    public static Vehicle getVehicle(int numSeats, int [] luggage){
        return getVehicle(numSeats,luggage , false);
    }
    
    
}