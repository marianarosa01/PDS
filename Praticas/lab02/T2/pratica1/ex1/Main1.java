import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main1 {
    public static void main(String[] args) {
        
        try {
            File fl = new File("sdl_02.txt");
            Scanner sc = new Scanner(fl);

            String linha = sc.nextLine();
            int size = linha.length();

            ArrayList<String> palavras = new ArrayList<String>();

            char[][] matriz = new char[size][size];

            int c = 0;
            
            do {
                
                for (int s=0; s<size; s++) {
                    matriz[c][s] = linha.charAt(s);
                }

                linha = sc.nextLine();
                c++;
            } while (c < size);

            Puzzle puzzle = new Puzzle(matriz, size);

            // for (int i = 0; i < size; i++) {
            //     for (int j = 0; j < size; j++) {
            //         System.out.print(matriz[i][j]);
            //     }
            //     System.out.println();
            // }

            String[] arr = linha.split("[;,\\s]");
            
            for (String a : arr) {
              palavras.add(a.toUpperCase());
            }

            while (sc.hasNextLine()) {
              linha = sc.nextLine();
              // System.out.println(linha);
              arr = linha.split("[;,\\s]");
      
              for (String a : arr) {
                palavras.add(a.toUpperCase()) ;
              }
            }
            
            puzzle.setPalavras(palavras);
            // System.out.println(palavras);
            // puzzle.print();

            puzzle.solveLine();
            puzzle.solveColumn();
            puzzle.printSolvedPuzzle();

        } catch (FileNotFoundException e) {
            System.out.println("Não encontrado");
        }

    }
}