import java.util.ArrayList;
import java.util.Arrays;
import java.lang.StringBuilder;
public class Puzzle {
    public int size;
    public char[][] matrix;
    public ArrayList<String> palavras;
    public char[][] solvedMatrix;
    // public static ArrayList<Integer> lpos;
    // public static ArrayList<Integer> cpos;
    // public static ArrayList<Integer> spos;
    
    public Puzzle(char[][] matrix, int size) {
        this.size = size;
        this.matrix = matrix;
        this.solvedMatrix = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.solvedMatrix[i][j] = '.';
            }
        }
    }
    public char[][] getMatrix() {
        return this.matrix;
    }
    public int getSize() {
        return this.size;
    }
    public void setPalavras(ArrayList<String> palavras) {
        this.palavras = palavras;
    }
    public void print() {
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(this.matrix[i][j]);
            }
        System.out.println();
        }
    }
    public void solveLine() {
        
        char[][] puzz = this.matrix;
        int s = this.size;
        char[] linhaChar;
        String linha;
        int pos;
        for (int se = 0; se < s; se++) {
            linhaChar = Arrays.copyOfRange(puzz[se], 0, s);             // retrieves array from puzzle line
            linha = String.valueOf(linhaChar);                          // ans transforms into String
            StringBuilder linhaRev = new StringBuilder();
            linhaRev.append(linha);
            linhaRev.reverse();                                         // reverses line to look for reversed words
            for (String w : palavras) {
                pos = linha.indexOf(w);                                 // looks for word on line 

                if (pos > -1) {                 // if it finds
                    System.out.print(w.toLowerCase() + "\t" + w.length() + "\t" + (se+1) + "," + (pos+1) + "\t" + "Right" + "\n");
                    for (int si=0; si<size; si++) {     // updates result matrix
                        if (si >= pos && si< pos+w.length()) {  // till the word ends
                            solvedMatrix[se][si] = w.charAt(si-pos);
                        }
                    }
                }

                pos = linhaRev.indexOf(w);      // if finds the reversed word
                if (pos > -1) {                 // does the same 
                    
                    
                    int invpos = s-pos;
                    // // this.lpos.add(se+1);
                    // // this.cpos.add(pos+1);
                    // // this.spos.add(w.length());
                    System.out.print(w.toLowerCase() + "\t" + w.length() + "\t" + (se+1) + "," + (invpos+1) + "\t" + "Left" + "\n");
                    int letra = 0;
                    for (int si=s; si>=0; si--) {
                        if (si <= invpos-1 && si> invpos-w.length()-1) {
                            solvedMatrix[se][si] = w.charAt(letra);
                            letra++;
                        }
                    }
                }                
            }
            
        }
    }

    public void solveColumn() {
        char[][] puzz = this.matrix;
        int s = this.size;

        int pos;

        StringBuilder col = new StringBuilder();

        for (int se = 0; se < s; se++) {
            for (int cc = 0; cc < s; cc++) {
                col.append(puzz[cc][se]);    
            }
            
            StringBuilder colRev = new StringBuilder();
            colRev.append(col);
            colRev.reverse();
            
            
            for (String w : palavras) {
                pos = col.indexOf(w);                                 // looks for word on line 

                if (pos > -1) {                 // if it finds

                    System.out.print(w.toLowerCase() + "\t" + w.length() + "\t" + (pos+1) + "," + (se+1) + "\t" + "Down" + "\n");
                    for (int si=0; si<size; si++) {     // updates result matrix
                        if (si >= pos && si< pos+w.length()) {  // till the word ends
                            solvedMatrix[si][se] = w.charAt(si-pos);
                        }
                    }
                }

                pos = colRev.indexOf(w);      // if finds the reversed word
                if (pos > -1) {                 // does the same 
                                        
                    int invpos = s-pos-1;

                    System.out.print(w.toLowerCase() + "\t" + w.length() + "\t" + (invpos) + "," + (se+1) + "\t" + "Up" + "\n");
                    int letra = 0;
                    for (int si=s; si>=0; si--) {
                        if (si <= invpos && si> invpos-w.length()) {
                            solvedMatrix[si][se] = w.charAt(letra);
                            letra++;
                        }
                    }
                }

                    
            }
            col.setLength(0);
        }
    }
                
    public void printSolvedPuzzle() {
            for (int i = 0; i < this.size; i++) {
                for (int j = 0; j < this.size; j++) {
                    System.out.print(solvedMatrix[i][j]);
                }
                System.out.println();
            }
    }
}