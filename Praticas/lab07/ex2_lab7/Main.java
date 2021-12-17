public class Main {
    public static void main(String [] args) {
        TextReader reader = new TextReader("test.txt");
        System.out.println(reader.next());
        TermFilter termReader = new TermFilter(new TextReader("test.txt"));
        System.out.println(termReader.next());
        NormalizationFilter normReader = new NormalizationFilter(new TextReader("test.txt"));
        System.out.println(normReader.next());
        VowelFilter vowelReader = new VowelFilter(new TextReader("test.txt"));
        System.out.println(vowelReader.next());
        CapitalizationFilter capitalizationReader = new CapitalizationFilter(new TextReader("test.txt"));
        System.out.println(capitalizationReader.next());
        System.out.println(capitalizationReader.next());
    } 
}
