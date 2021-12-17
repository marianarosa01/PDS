import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.lang.StringBuilder;

public class WSGenerator {
    public static void main(String[] args) {
        
        String fileName="";
        int size=0;

        if (args.length == 4) {
            
            if (args[0].equals("-i")) {
                size = Integer.parseInt(args[3]);
                fileName = args[1];
            }
            else if (args[0].equals("-s")) {
                size = Integer.parseInt(args[1]);
                fileName = args[3];
            }
            else {
                System.out.println("Argumentos Inválidos");
                System.exit(1);
            }
            
        }
        else {
            System.out.println("Número de Argumentos Inválidos");
            System.exit(1);
        }

        try {
            File fl = new File("palavras.txt");
            Scanner sc = new Scanner(fl);

            ArrayList<String> palavras = new ArrayList<String>();

            String linha;
            String[] arr;

            char[][] puzzle = new char[size][size];

            while (sc.hasNextLine()) {

                linha = sc.nextLine();
                // System.out.println(linha);
                arr = linha.split("[;,\\s]");

                for (String a : arr) {
                    palavras.add(a) ;
                }
            }

            System.out.println(palavras);
            System.out.println(size);
            System.out.println(fileName);

            Random r = new Random();
            int i = 0;
            int j = 0;

            for (i = 0; i < size; i++) {
                for (j = 0; j < size; j++) {
                    char c = (char)(r.nextInt(26) + 'A');
                    puzzle[i][j] = c;
                    // System.out.print(c);

                }
                // System.out.println();
            }


            // UP = 0 / RIGHT = 1 / DOWN = 2 / LEFT = 3
            int direcao, linepos, colpos, pos;
            for (String p : palavras) {
                direcao = r.nextInt(4);
                
                
                pos = 0;
                if (direcao == 0) { // UP
                    colpos = r.nextInt(size-p.length());
                    linepos = r.nextInt(size);
                    StringBuilder bdr = new StringBuilder();
                    bdr.append(p);
                    bdr.reverse();

                    j = linepos;
                    for (i = colpos; i < colpos+p.length(); i++) {
                        puzzle[i][j] = bdr.charAt(pos);
                        pos++;
                    }
                }
                else if (direcao == 1) { // RIGHT
                    linepos = r.nextInt(size-p.length());
                    colpos = r.nextInt(size);
                    i = colpos;
                    for (j = linepos; j < linepos+p.length(); j++) {
                        puzzle[i][j] = p.charAt(pos);
                        pos++;
                    }
                }
                else if (direcao == 2) { // DOWN
                    colpos = r.nextInt(size-p.length());
                    linepos = r.nextInt(size);
                    j = linepos;
                    for (i = colpos; i < colpos+p.length(); i++) {
                        puzzle[i][j] = p.charAt(pos);
                        pos++;
                    }
                }
                else {
                    linepos = r.nextInt(size-p.length());
                    colpos = r.nextInt(size);
                    StringBuilder bdr = new StringBuilder();
                    bdr.append(p);
                    bdr.reverse();

                    i = colpos;
                    for (j = linepos; j < linepos+p.length(); j++) {
                        puzzle[i][j] = p.charAt(pos);
                        pos++;
                    }
                }
            }
            
            for (i = 0; i < size; i++) { // LEFT
                for (j = 0; j < size; j++) {
                    System.out.print(puzzle[i][j]);
                }
                System.out.println();
            }

        } catch (FileNotFoundException e ) {
            System.out.println("Não encontrado");
        }
    }
}