public class Borrowed implements State {
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
        b.setState(new Available());
        System.out.println();
    }

    @Override
    public void reserveBook(Book b) {
        System.out.println("Operação não disponível");
        System.out.println();
    }

    @Override
    public void cancelReserveBook(Book b) {
        System.out.println("Operação não disponível");
        System.out.println();
    }
    public String toString() {
        return "Emprestado";
    }
    
}
