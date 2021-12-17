//package src;

import java.io.*;
import java.util.*;


public class WSGenerator {
    static Random rand = new Random();
    

    public static void main(String[] args) throws IOException {

        if (args.length < 4 || args.length > 6) { //se receber o número errado de argumentos
            System.err.println("usage: java WSGenerator -i [input file] -s [dimension] -o [output file] ");
            System.exit(0);
        }
        Scanner sc = null;
        String fileIn = args[1];
        int size = Integer.parseInt(args[3]);
        try {
            sc = new Scanner(new FileReader(fileIn)); //leitura do ficheiro
        } catch (IOException e) {
            System.err.println("Não é possível ler o ficheiro!");
            System.exit(0);
        }

        ArrayList<String> palavras = new ArrayList<String>(); // Recebe as palavras que vai encaixar na sopa de letras
        ArrayList<String> linhas = new ArrayList<String>(); // Recebe as linhas do ficheiro

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            linhas.add(linha);
            String[] chave = linha.split("[; ,]+");
            for (int i = 0; i < chave.length; i++) {
                palavras.add(chave[i]);
            } //ver que palavras vão ser chaves
        }

        char[][] puzzle = new char [size][size];

        // vao receber as posicoes trancadas, todas menos a última
        ArrayList<String> posUp = new ArrayList<String>();
        ArrayList<String> posDown = new ArrayList<String>();
        ArrayList<String> posLeft = new ArrayList<String>();
        ArrayList<String> posRight = new ArrayList<String>();
        ArrayList<String> posUp_Left = new ArrayList<String>();
        ArrayList<String> posUp_Right = new ArrayList<String>();
        ArrayList<String> posDown_Right = new ArrayList<String>();
        ArrayList<String> posDown_Left = new ArrayList<String>();

        // Preencher o puzzle

        for (String k : palavras) {
            int puts = 0;
            String kUpper = k.toUpperCase();
            char[] word = kUpper.toCharArray(); 
            for (int x = 0; x < size; x++) {
                for (int y = 0; y < size; y++) { //percorrer o puzzle
                    if (puts == 1) { 
                        break;
                    }
                    String pos = Integer.toString(x) + "," + Integer.toString(y); 
                    Random random = new Random();
                    int direcao = random.nextInt(8);
                    //gerar aleatoriamente uma direção para colocar a palavra e verificar se é possível
                    switch (direcao) {
                    case 0:
                        if ((!posUp.contains(pos)) && up(x, y, word, puzzle, 0)[1] == true) {
                            preencherUp(x, y, word, puzzle, posUp);
                            puts++;
                        }
                        break;
                    case 1:
                        if ((!posDown.contains(pos)) && down(x, y, word, puzzle, 0)[1] == true) {
                            preencherDown(x, y, word, puzzle, posDown);
                            puts++;
                        }
                        break;
                    case 2:
                        if ((!posLeft.contains(pos)) && left(x, y, word, puzzle, 0)[1] == true) {
                            preencherLeft(x, y, word, puzzle, posLeft);
                            puts++;
                        }
                        break;
                    case 3:
                        if ((!posRight.contains(pos)) && right(x, y, word, puzzle, 0)[1] == true) {
                            preencherRight(x, y, word, puzzle, posRight);
                            puts++;
                        }
                        break;
                    case 4:
                        if ((!posUp_Left.contains(pos)) && up_left(x, y, word, puzzle, 0)[1] == true) {
                            preencherUpLeft(x, y, word, puzzle, posUp_Left);
                            puts++;
                        }
                        break;
                    case 5:
                        if ((!posUp_Right.contains(pos)) && up_right(x, y, word, puzzle, 0)[1] == true) {
                            preencherUpRight(x, y, word, puzzle, posUp_Right);
                            puts++;
                        }
                        break;
                    case 6:
                        if ((!posDown_Right.contains(pos)) && down_right(x, y, word, puzzle, 0)[1] == true) {
                            preencherDownRight(x, y, word, puzzle, posDown_Right);
                            puts++;
                        }
                        break;
                    case 7:
                        if ((!posDown_Left.contains(pos)) && down_left(x, y, word, puzzle, 0)[1] == true) {
                            preencherDownLeft(x, y, word, puzzle, posDown_Left);
                            puts++;
                        }
                        break;
                    }

                }
            }
        }

        
        //imprimir no terminal caso não peça para imprimir num ficheiro
        if (args.length == 4) {
            for (int x = 0; x < size; x++) {
                System.out.println();
                for (int y = 0; y < size; y++) {
                    if ((int)puzzle[x][y] == 0) {
                        puzzle[x][y] = letra();
                        //puzzle[x][y] = '.'; PARA VER AS APENAS AS PALAVRAS INCLUIDAS           
                    }
                    System.out.print(puzzle[x][y]);
                }
            }
            System.out.println();
            for (int z = 0; z < linhas.size(); z++) {
                System.out.println(linhas.get(z));
            }
        }
        //Escrever num ficheiro o output
        else if (args.length == 6) {
            String fileOut = args[5];
            File f = new File(fileOut);
            FileWriter writer = new FileWriter(f);
            for (int x = 0; x < size; x++) {
                System.out.println();
                writer.write("\n");
                for (int y = 0; y < size; y++) {
                    if ((int)puzzle[x][y] == 0) {
                        puzzle[x][y] = letra();
                        //puzzle[x][y] = '.'; PARA VER AS APENAS AS PALAVRAS INCLUIDAS
                    }
                    System.out.print(puzzle[x][y]);
                    writer.write(puzzle[x][y]);
                }
            }
            System.out.println();
            writer.write("\n");
            for (int z = 0; z < linhas.size(); z++) {
                System.out.println(linhas.get(z));
                writer.write(linhas.get(z) + "\n");
            }
            writer.close();
        }
    }
    //funciona de igual modo ao WSsolver
    public static boolean[] up(int l, int c, char[] word, char[][] puzzle, int upCalls) {
        if (upCalls == word.length) {
            boolean[] validation = { true, true };
            return validation;
        }
        if (l < 0) { // se a linha for 0, significa que já está a aceder uma posição que não existe e por isso retorna false
            boolean[] validation = { true, false };
            return validation;
        } else {
            // ou no puzzle ta vazio ou ta igual

            if ((int) puzzle[l][c] == 0 || puzzle[l][c] == word[upCalls]) { // verificar se o caracter nessa posiçao do puzzle está vazio ou se corresponde ao caracter da palavra
                upCalls++;
                l--; // subir
                boolean[] call = up(l, c, word, puzzle, upCalls);
                if (call[1]) { // se o 2º bool for true, isto é, se passou no primeiro if, dar return da call
                    return call;
                }
            }
        }
        boolean[] validation = { true, false };
        return validation;
    }

    public static ArrayList<String> preencherUp(int x, int y, char[] word, char[][] puzzle, ArrayList<String> posUp) {
        for (int a = x; a > (x - word.length); a--) {
            String lock = Integer.toString(a) + "," + Integer.toString(y);
            posUp.add(lock);
            puzzle[a][y] = word[x - a];
        }
        return posUp;
    } //para gerar as palavras no sítio e ordem correta

    //funciona de igual modo para o resto das direçoes

    public static boolean[] down(int l, int c, char[] word, char[][] puzzle, int downCalls) {
        if (downCalls == word.length) {
            boolean[] validation = {true,true};
            return  validation; 
        }
        if (l > puzzle[1].length-1) { 
            boolean[] validation = {true,false};
            return  validation;
        }
        else {
            if ((int) puzzle[l][c] == 0 || puzzle[l][c] == word[downCalls]) { //verificar se o caracter nessa posiçao do puzzle corresponde ao caracter da palavra
                downCalls++;
                l++; //descer
                boolean [] call = down(l, c, word, puzzle, downCalls);
                if (call[1]) {
                    return call;
                }
            }
        }
        boolean[] validation = {true,false};
        return  validation;
    }

    public static ArrayList<String> preencherDown(int x, int y, char[] word, char[][] puzzle, ArrayList<String> posDown) {
        for (int a = x; a < (x + word.length); a++) {
            String lock = Integer.toString(a) + "," + Integer.toString(y);
            posDown.add(lock);
            puzzle[a][y] = word[a - x];
        }
        return posDown;
    }

    public static boolean[] left(int l, int c, char[] word, char[][] puzzle, int leftCalls) {
        if (leftCalls == word.length) {
            boolean[] validation = {true,true};
            return  validation; 
        }
        if (c < 0) {  //não pode ir mais para a esquerda, já está a aceder uma posição que não existe
            boolean[] validation = {true,false};
            return  validation;
        }
        else {
          
            if ((int) puzzle[l][c] == 0 || puzzle[l][c] == word[leftCalls]) { //verificar se o caracter nessa posiçao do puzzle corresponde ao caracter da palavra
                leftCalls++;
                c--; //esquerda
                boolean [] call = left(l, c, word, puzzle, leftCalls);
                if (call[1]) {
                    return call;
                }
            }
        }
        boolean[] validation = {true,false};
        return  validation;
    }

    public static ArrayList<String> preencherLeft(int x, int y, char[] word, char[][] puzzle, ArrayList<String> posLeft) {
        for (int a = y; a > (y - word.length); a--) {
            String lock = Integer.toString(x) + "," + Integer.toString(a);
            posLeft.add(lock);
            puzzle[x][a] = word[y - a];
        }
        return posLeft;
    }

    public static boolean[] right(int l, int c, char[] word, char[][] puzzle, int rightCalls) {
        if (rightCalls == word.length) {
            boolean[] validation = {true,true};
            return  validation; 
        }
        if (c > puzzle[1].length-1) {  //não pode ir mais para a direita, já está a aceder uma posição que não existe
            boolean[] validation = {true,false};
            return  validation;
        }
        else {
           
            if ((int) puzzle[l][c] == 0 || puzzle[l][c] == word[rightCalls]) { //verificar se o caracter nessa posiçao do puzzle corresponde ao caracter da palavra
                rightCalls++;
                c++; //direita
                boolean [] call = right(l, c, word, puzzle, rightCalls); 
                if (call[1]) {
                    return call;
                }
            }
        }
        boolean[] validation = {true,false};
        return  validation;
    }

    public static ArrayList<String> preencherRight(int x, int y, char[] word, char[][] puzzle, ArrayList<String> posRight) {
        for (int a = y; a < (y + word.length); a++) {
            String lock = Integer.toString(x) + "," + Integer.toString(a);
            posRight.add(lock);
            puzzle[x][a] = word[a - y];
        }
        return posRight;
    }
    
    public static boolean[] up_left(int l, int c, char[] word, char[][] puzzle, int up_leftCalls) {
       
        if (up_leftCalls == word.length) {
            boolean[] validation = {true,true};
            return  validation; 
        }
        if (l < 0 || c < 0) { //se a linha for <0 ou a coluna for <0 significa que nao pode ir mais para cima ou para a esquerda
            boolean[] validation = {true,false};
            return  validation;
        }
        else {
           
            if ((int) puzzle[l][c] == 0 || puzzle[l][c] == word[up_leftCalls]) { //verificar se o caracter nessa posiçao do puzzle está vazio ou se corresponde ao caracter da palavra
                up_leftCalls++;
                l--; //subir
                c--; //esquerda
                boolean [] call = up_left(l, c, word, puzzle, up_leftCalls);
                if (call[1]) { //se ambos forem true
                    return call;
                }
            }
        }
        boolean[] validation = {true,false};
        return  validation;
    }

    public static ArrayList<String> preencherUpLeft(int x, int y, char[] word, char[][] puzzle, ArrayList<String> posUp_Left) {
        for (int a = x, b = y; (a > (x - word.length)) && (b > (y - word.length)); a--, b--) {
            String lock = Integer.toString(a) + "," + Integer.toString(b); //para cada posição vamos trancar
            posUp_Left.add(lock);
            puzzle[a][b] = word[x - a];
        }
        return posUp_Left;
    }

    public static boolean[] up_right(int l, int c, char[] word, char[][] puzzle, int up_rightCalls) {
      
        if (up_rightCalls == word.length) {
            boolean[] validation = {true,true};
            return  validation; 
        }
        if (l < 0 || c > puzzle[1].length-1) { //se a linha for <0 ou a coluna for > que o tamanho das linhas, significa que nao pode ir mais para cima ou para a esquerda
            boolean[] validation = {true,false};
            return  validation;
        }
        else {
            if ((int) puzzle[l][c] == 0 || puzzle[l][c] == word[up_rightCalls]) { //verificar se o caracter nessa posiçao do puzzle corresponde ao caracter da palavra
                up_rightCalls++;
                l--; //subir
                c++; //direita
                boolean [] call = up_right(l, c, word, puzzle, up_rightCalls);
                if (call[1]) { //se ambos forem true
                    return call;
                }
            }
        }
        boolean[] validation = {true,false};
        return  validation;
    }

    public static ArrayList<String> preencherUpRight(int x, int y, char[] word, char[][] puzzle, ArrayList<String> posUp_Right) {
        for (int a = x, b = y; (a > (x - word.length)) && (b < (y + word.length)); a--, b++) {
            String lock = Integer.toString(a) + "," + Integer.toString(b); //para cada posição vamos trancar
            posUp_Right.add(lock);
            puzzle[a][b] = word[x - a];
        }
        return posUp_Right;
    }

    public static boolean[] down_right(int l, int c, char[] word, char[][] puzzle, int down_rightCalls) {
        
        if (down_rightCalls == word.length) {
            boolean[] validation = {true,true};
            return  validation; 
        }
        if (l > puzzle[1].length-1 || c > puzzle[1].length-1) { //se a linha ou a coluna for > que o tamanho das linhas significa que nao pode ir mais para baixo ou para a direita
            boolean[] validation = {true,false};
            return  validation;
        }
        else {
           
            if ((int) puzzle[l][c] == 0 || puzzle[l][c] == word[down_rightCalls]) { //verificar se o caracter nessa posiçao do puzzle corresponde ao caracter da palavra
                down_rightCalls++;
                l++; //descer
                c++; //direita
                boolean [] call = down_right(l, c, word, puzzle, down_rightCalls);
                if (call[1]) { //se ambos forem true
                    return call;
                }
            }
        }
        boolean[] validation = {true,false};
        return  validation;
    }

    public static ArrayList<String> preencherDownRight(int x, int y, char[] word, char[][] puzzle, ArrayList<String> posDown_Right) {
        for (int a = x, b = y; (a < (x + word.length)) && (b < (y + word.length)); a++, b++) {
            String lock = Integer.toString(a) + "," + Integer.toString(b); //para cada posição vamos trancar
            posDown_Right.add(lock);
            puzzle[a][b] = word[a - x];
        }
        return posDown_Right;
    }

    public static boolean[] down_left(int l, int c, char[] word, char[][] puzzle, int down_leftCalls) {
    
        if (down_leftCalls == word.length) {
            boolean[] validation = {true,true};
            return  validation; 
        }
        if (l > puzzle[1].length-1 || c < 0) { //se a linha for > que o tamanho das linhas ou a coluna for <0 significa que nao pode ir mais para baixo ou para a esquerda
            boolean[] validation = {true,false};
            return  validation;
        }
        else {
            
            if ((int) puzzle[l][c] == 0 || puzzle[l][c] == word[down_leftCalls]) { //verificar se o caracter nessa posiçao do puzzle corresponde ao caracter da palavra
                down_leftCalls++;
                l++; //descer
                c--; //esquerda
                boolean [] call = down_left(l, c, word, puzzle, down_leftCalls);
                if (call[1]) { //se ambos forem true
                    return call;
                }
            }
        }
        boolean[] validation = {true,false};
        return  validation;
    }
    
    public static ArrayList<String> preencherDownLeft(int x, int y, char[] word, char[][] puzzle, ArrayList<String> posDown_Left) {
        for (int a = x, b = y; (a < (x + word.length)) && (b > (y - word.length)); a++, b--) {
            String lock = Integer.toString(a) + "," + Integer.toString(b); //para cada posição vamos trancar
            posDown_Left.add(lock);
            puzzle[a][b] = word[a - x];
        }
        return posDown_Left;
    }

    public static char letra() {
        //para gerar letras random
        int x= rand.nextInt(26)+65;
        char convertedChar = (char)x;
        return convertedChar;

        
    }

}