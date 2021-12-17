public class Available implements State {
    public void registBook(Book b) {
        System.out.println("Operação não disponível");
        System.out.println();
    }

    @Override
    public void orderBook(Book b) {
        b.setState(new Borrowed());

    }

    @Override
    public void returnBook(Book b) {
        System.out.println("Operação não disponível");
        System.out.println();    }

    @Override
    public void reserveBook(Book b) {
        b.setState(new Reserved());
        
    }

    @Override
    public void cancelReserveBook(Book b) {
        System.out.println("Operação não disponível");
        System.out.println();
    } 
    
    public String toString() {
        return "Disponível";
    }
}
