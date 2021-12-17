public class Book {
    private String title;
    private int ISBN;
    private static int currentISBN = 1;
    private int year;
    private String author;
    private State currentState;
    
    public Book (String title, String author, int year) {
        currentState = new Inventory();
        this.title = title;
        ISBN = currentISBN++;
        this.author = author;
        this.year = year;
    }
    
    public void registBook () {
        this.currentState.registBook(this);
    }

    public void orderBook () {
        this.currentState.orderBook(this);
    }

    public void returnBook () {
        this.currentState.returnBook(this);
    }

    public void reserveBook () {
        this.currentState.reserveBook(this);
    }

    public void cancelReserveBook () {
        this.currentState.cancelReserveBook(this);
    }
    public void setState(State state) {
        this.currentState = state;
    }

    public String toString() {
        return String.format("%-5d %-20s %-20s %-15s", ISBN, title, author,
                "[" + currentState + "]");
    }
}
