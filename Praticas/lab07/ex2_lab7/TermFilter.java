public class TermFilter extends TextReaderDecorator {
    String [] words;
    int wordIdx;
    public TermFilter(TextReaderInterface rInterface) {
        super(rInterface);
        this.words = new String [0];
        this.wordIdx = 0;
    }
    public String next() {
        if (words.length == wordIdx) {
            this.words = super.next().split("[ .,]+");
            this.wordIdx = 0;
        }
        
        String nextWord = words[wordIdx];
        this.wordIdx++;

        return nextWord;
    }
}
