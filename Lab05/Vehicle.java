public interface Vehicle {
public int getMaxVolume();
public int getMaxPassangers();
}

class Scooter implements Vehicle{
    protected Scooter() {System.out.println("Use a scooter.");}
    public int getMaxVolume() {
        return 0;
    }
    public int getMaxPassangers() {
        return 1;
    }

}


class Micro implements Vehicle{
    protected Micro() {System.out.println("Use a Micro car.");}

    public int getMaxVolume() {
        return 250;
    }
    public int getMaxPassangers(){
        return 1;
    }
}

class City implements Vehicle{
    protected City() {System.out.println("Use a City car.");}

    public int getMaxVolume() {
        return 250;
    }
    public int getMaxPassangers(){
        return 3;
    }
}


class Family implements Vehicle{
    protected Family() {System.out.println("Use a Family car.");}

    public int getMaxVolume() {
        return 600;
    }
    public int getMaxPassangers(){
        return 4;
    }
}

class Van implements Vehicle{
    protected Van() {System.out.println("Use a Van.");}

    public int getMaxVolume() {
        return 1000;
    }
    public int getMaxPassangers(){
        return 4;
    }
    public boolean hasWheelchair(){
        return true;
    }
}