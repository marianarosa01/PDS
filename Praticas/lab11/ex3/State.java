public interface State {
    void registBook(Book b); 
    void orderBook(Book b); //requisita
    void returnBook(Book b);
    void reserveBook(Book b); //reserva
    void cancelReserveBook(Book b); 
}
