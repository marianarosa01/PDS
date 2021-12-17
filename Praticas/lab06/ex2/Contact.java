public class Contact {
    private String name;
    private int telephone;

    public Contact(){
        this.name = null;
        this.telephone = 0;
    }

    public Contact(String name){
        this.name = name;
        this.telephone = 0;
    }

    public Contact(String name, int telephone){
        this.name = name;
        this.telephone = telephone;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String n){
         this.name = n;
    }

    public int getTelephone(){
        return this.telephone;
    }
    public void setTelephone(int t){
         this.telephone = t;
    }

    @Override
    public String toString(){
        return this.name + " - " + this.telephone;
    }
}