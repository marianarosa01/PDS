public class Reserved implements State {
    public void registBook(Book b) {
        System.out.println("Operação não disponível");
        System.out.println();
    }

    @Override
    public void orderBook(Book b) {
        System.out.println("Operação não disponível");
        System.out.println();
    }

    @Override
    public void returnBook(Book b) {
        System.out.println("Operação não disponível");
        System.out.println();
    }

    @Override
    public void reserveBook(Book b) {
        System.out.println("Operação não disponível");
        System.out.println();
    }

    @Override
    public void cancelReserveBook(Book b) {
        b.setState(new Available());
    }
    public String toString() {
        return "Reservado";
    }
}
