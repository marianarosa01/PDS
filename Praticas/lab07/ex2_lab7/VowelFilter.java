public class VowelFilter extends TextReaderDecorator {
    String [] words;
    String finalString = "";
    public VowelFilter(TextReaderInterface rInterface) {
        super(rInterface);
    }
    
    public String next() {
        this.words = super.next().split("[ ]+");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String newWord = "";
            for (int j = 0; j < word.length(); j++) {
                if (!isVowel(word.charAt(j))) {
                    newWord = newWord + word.charAt(j);
                }
            }
            if (i > 0) {
                this.finalString = this.finalString + " " + newWord;
            }
            else {
                this.finalString = newWord;
            }
        }
        return finalString;
    }

    public boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
      }
}
