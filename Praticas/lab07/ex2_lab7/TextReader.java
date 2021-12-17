import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextReader implements TextReaderInterface {
    File file;
    int paragraphCounter;
    public TextReader(String f) {
        try {
            this.file = new File(f);
            this.paragraphCounter = 0;
        }
        catch (Exception e) {
            System.out.println("File not found, please try again.");
            System.exit(0);
        }
    }

    public boolean hasNext() {
        try {
            Scanner reader = new Scanner(this.file);
            for (int i = 0; i < this.paragraphCounter; i++) { // recover last paragraph
                reader.nextLine();
            }
            if (reader.nextLine() != null) { // check if there's a next paragraph
                reader.close();
                return true;
            }
            reader.close();
            this.paragraphCounter = 0; // if the program reaches this state, it means that there's nothing more in the
            return false;                   // file to be read, so we reset the paragraphCounter
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found, please try again.");
            System.exit(0);
            return false;
        }
    }

    public String next() {
        if (hasNext()) {
            try {
                Scanner reader = new Scanner(this.file);
                for (int i = 0; i < this.paragraphCounter; i++) { // recover last paragraph
                    reader.nextLine();
                }
                this.paragraphCounter++;
                String nextLine = reader.nextLine();
                reader.close();
                return nextLine;
            }
            catch (FileNotFoundException e) {
                System.out.println("File not found, please try again.");
            }
        }
        return null;
    }
}
