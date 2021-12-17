public class TextReaderDecorator implements TextReaderInterface {
    private TextReaderInterface reader;
    TextReaderDecorator(TextReaderInterface rInterface) {
        this.reader = rInterface;
    }
    public boolean hasNext() {
        return this.reader.hasNext();
    }
    public String next() {
        return this.reader.next();
    }
}
