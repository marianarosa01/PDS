//package src;
import java.io.*;
import java.util.*;

//Notas:

public class WSSolver { //passar como argumento o nosso ficheiro

    public static void main(String[] args) throws IOException {
		Scanner sc = null; //1º passo, inicializar scanner
        int l=0; //contar as linhas
        //int idx = 0;
        ArrayList<String> chaves = new ArrayList<String>();
        String [] linhasTemp = new String[40];

        //ler o puzzle escolhido
		try {
			sc= new Scanner(new FileReader("sdl_02.txt"));
			
		} catch (IOException e) {
			System.err.println("Não é possível ler o ficheiro!");
			System.exit(0);
        }

        //ler cada uma das linhas do puzzle, ou seja, se forem maiúscula, caracteres alfabéticos 
        //e se não forem linhas vazias
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            if (isStringUpperCase(linha) && isAlpha(linha) && linha.isEmpty()== false) {
                linhasTemp[l] = linha; //reconstroi apenas o puzzle
                l++; //incrementa o nº de linhas
            }
            else if (!(linha.isEmpty())) { //Agora chegou à parte da lista de palavras
                String [] chave = linha.split("[; ,]+"); //retirar todos os caracteres que as separam
                for (int i=0; i<chave.length; i++){
                    chaves.add(chave [i]); //Adicionar cada chave a uma Arraylist de strings
                }
            }
            else if (linha.isEmpty()) {
                break;
            }
            
        } 
        ArrayList<String> chavesOrdenadas = new ArrayList<String>();
        chavesOrdenadas = (ArrayList<String>) chaves.clone(); // chaves pela ordem do enunciado
        ArrayList<ArrayList<String>> palavrasResolvidas = new ArrayList<ArrayList<String>>();

        //criar arraylist com as caracteristicas de cada palavra 
        for (int el = 0; el < chavesOrdenadas.size(); el++) {
            ArrayList<String> caracteristicas = new ArrayList<String>();
            caracteristicas.add(chavesOrdenadas.get(el));
            caracteristicas.add(String.valueOf(chavesOrdenadas.get(el).length()));
            palavrasResolvidas.add(caracteristicas);
        }
        
        chaves.sort((x, y) -> { // ordenar as chaves por ordem decrescente de tamanho
            if (x.length() > y.length())
                return -1;
            else if (x.length() < y.length())
                return 1;
            else
                return 0;
        });
        
        char[][] puzzle = new char [l][l]; // criar a sopa de letras (quadrada)      
        char[][] solutionPuzzle = new char [l][l]; // criar a solução da letras (quadrada)      
        //verificar se a matriz do puzzle é quadrado
        for (int i = 0; i < l; i++) {
            char [] linhaArray = linhasTemp[i].toCharArray();
            if (!(l == linhasTemp[i].length())) { //ou seja se o número de linhas corresponde ao número de colunas
                System.out.println("A matriz não é quadrada!");
                break;
            }
            for (int j = 0; j < l; j++) { 
                puzzle[i][j] = linhaArray[j]; //construir o puzzle 
            }
        }
        // vao receber as posicoes trancadas, todas menos a última. Isto é, as posições indisponíveis para encontrar palavras
        ArrayList<String> posUp = new ArrayList<String>();
        ArrayList<String> posDown = new ArrayList<String>();
        ArrayList<String> posLeft = new ArrayList<String>();
        ArrayList<String> posRight = new ArrayList<String>();
        ArrayList<String> posUp_Left = new ArrayList<String>();
        ArrayList<String> posUp_Right = new ArrayList<String>();
        ArrayList<String> posDown_Right= new ArrayList<String>();
        ArrayList<String> posDown_Left = new ArrayList<String>();


        //ir a procura das chaves

        for (String k : chaves) {
            String kUpper = k.toUpperCase();
            char[] word = kUpper.toCharArray(); //passar cada palavra em maiúscula para um array de caracteres
            int finds = 0;
            for (int y = 0; y < puzzle[1].length; y++) {  
                for (int x = 0; x < puzzle[1].length; x++) {  //percorrer o puzzle
                    if (word[0] == puzzle[x][y]) { 
                        //se encontrar a 1ª letra da palavra no puzzle entra neste ciclo de condição
                        //e vai verificar qual das direções consegue formar a palavra
                        //Iremos explicar como funciona para o up depois é tudo de igual modo só mudam os limites

                        if (up(x,y,word,puzzle,0)[1] == true) { //retorna {true, true}, entra
                            String pos = Integer.toString(x) + "," + Integer.toString(y); //cria as coordenadas que vai ocupar
                            if (finds >= 1) {
                                finds++; //se forem encontradas mais de uma solução o programa emite um aviso e acaba
                                severalSolutions(); //através desta função
                            }
                            else if (posUp.contains(pos)) {
                                continue; //se aquela posição no puzzle já está ocupada para outra palavra ele ignora, 
                                //pois sabe que não vai ser ali que irá formar
                            }
                            else { //se não, ele encontrou a palavra na sopa de letras e  vai formar neste sentido

                                //caracterizar cada uma das palavras
                                ArrayList<String> caracteristicasUp1 = new ArrayList<String>(); 
                                caracteristicasUp1.add(k); //a palavra em si
                                caracteristicasUp1.add(String.valueOf(k.length())); //o tamanho da palavra
                                int idxUp1 = palavrasResolvidas.indexOf(caracteristicasUp1); //procura o índice correspondente à palavra
                                caracteristicasUp1.add(pos); //adicionar a posicao trancada
                                caracteristicasUp1.add("up"); //adicionar a direcao
                                palavrasResolvidas.set(idxUp1,caracteristicasUp1); // Substitui o vetor que tem apenas a palavra e o tamanho, 
                                                                                //por outro vetor com nome+tamanho+posição+direçao
                                for (int a = x; a >= (x - word.length + 2); a--) {
                                    String lock = Integer.toString(a) + "," + Integer.toString(y); //para cada posição vamos trancar
                                    posUp.add(lock);
                                    solutionPuzzle[a][y] = puzzle[a][y]; //Atualizar o puzzle com as soluções
                                } 
                                solutionPuzzle[x-word.length+1][y] = puzzle[x-word.length+1][y]; //Retirar a última posição para poder formar palavras
                                            
                                finds++; //incrementa o número de soluções encontradas
                                
                            }
                        }
                            //O raciocionio para as restantes foi semelhante
                        else if (down(x,y,word,puzzle,0)[1] == true) {
                            String pos = Integer.toString(x) + "," + Integer.toString(y);
                            
                            if (finds >= 1) {
                                finds++;
                                severalSolutions();
                            }
                            else if (posDown.contains(pos)) {
                                continue;
                            }
                        
                            else {
                                ArrayList<String> caracteristicasDown1 = new ArrayList<String>();
                                caracteristicasDown1.add(k);
                                caracteristicasDown1.add(String.valueOf(k.length()));
                                int idxDown1 = palavrasResolvidas.indexOf(caracteristicasDown1);
                                caracteristicasDown1.add(pos);
                                caracteristicasDown1.add("down");
                                palavrasResolvidas.set(idxDown1,caracteristicasDown1);
                                for (int a = x; a <= (x + word.length - 2); a++) {
                                    String lock = Integer.toString(a) + "," + Integer.toString(y); //para cada posição vamos trancar
                                    posDown.add(lock);
                                    solutionPuzzle[a][y] = puzzle[a][y];
                                }
                                solutionPuzzle[x+word.length-1][y] = puzzle[x+word.length-1][y];
                                finds++;
                            }
                        }
                        else if (left(x,y,word,puzzle,0)[1] == true) {
                            String pos = Integer.toString(x) + "," + Integer.toString(y);
                            if (finds >= 1) {
                                finds++;
                                severalSolutions();
                            }
                            else if (posLeft.contains(pos)) {
                                continue;
                            }
                            else {
                                ArrayList<String> caracteristicasLeft1 = new ArrayList<String>();
                                caracteristicasLeft1.add(k);
                                caracteristicasLeft1.add(String.valueOf(k.length()));
                                int idxLeft1 = palavrasResolvidas.indexOf(caracteristicasLeft1);
                                caracteristicasLeft1.add(pos);
                                caracteristicasLeft1.add("left");
                                palavrasResolvidas.set(idxLeft1,caracteristicasLeft1);
                                for (int a = y; a >= (y - word.length + 2); a--) {
                                    String lock = Integer.toString(x) + "," + Integer.toString(a); //para cada posição vamos trancar
                                    posLeft.add(lock);
                                    solutionPuzzle[x][a] = puzzle[x][a];
                                }
                                solutionPuzzle[x][y-word.length+1] = puzzle[x][y-word.length+1];
                                finds++;
                            }
                        }
                        else if (right(x,y,word,puzzle,0)[1] == true) {
                            String pos = Integer.toString(x) + "," + Integer.toString(y);
                            if (finds >= 1) {
                                finds++;
                                severalSolutions();
                            }
                            else if (posRight.contains(pos)) {
                                continue;
                            }
                            else {
                                ArrayList<String> caracteristicasRight1 = new ArrayList<String>();
                                caracteristicasRight1.add(k);
                                caracteristicasRight1.add(String.valueOf(k.length()));
                                int idxRight1 = palavrasResolvidas.indexOf(caracteristicasRight1);
                                caracteristicasRight1.add(pos);
                                caracteristicasRight1.add("right");
                                palavrasResolvidas.set(idxRight1,caracteristicasRight1);

                                for (int a = y; a <= (y + word.length - 2); a++) {
                                    String lock = Integer.toString(x) + "," + Integer.toString(a); //para cada posição vamos trancar
                                    posRight.add(lock);
                                    solutionPuzzle[x][a] = puzzle[x][a];
                                }
                                solutionPuzzle[x][y+word.length-1] = puzzle[x][y+word.length-1];
                                finds++;
                            }
                        }
                        else if (up_left(x,y,word,puzzle,0)[1] == true) {
                            String pos = Integer.toString(x) + "," + Integer.toString(y);
                            if (finds >= 1) {
                                finds++;
                                severalSolutions();
                            }
                            else if (posUp_Left.contains(pos)) {
                                continue;
                            }
                            else {
                                ArrayList<String> caracteristicasUpLeft1 = new ArrayList<String>();
                                caracteristicasUpLeft1.add(k);
                                caracteristicasUpLeft1.add(String.valueOf(k.length()));
                                int idxUpLeft1 = palavrasResolvidas.indexOf(caracteristicasUpLeft1);
                                caracteristicasUpLeft1.add(pos);
                                caracteristicasUpLeft1.add("upLeft");
                                palavrasResolvidas.set(idxUpLeft1,caracteristicasUpLeft1);
                
                                for (int a = x, b = y; (a >= (x - word.length + 2)) && (b >= (y - word.length + 2)); a--, b--) {
                                    String lock = Integer.toString(a) + "," + Integer.toString(b); //para cada posição vamos trancar
                                    posUp_Left.add(lock);
                                    solutionPuzzle[a][b] = puzzle[a][b];
                                    
                                }
                                solutionPuzzle[x-word.length+1][y-word.length+1] = puzzle[x-word.length+1][y-word.length+1];
                                finds++;
                            }
                        }
                        else if (up_right(x,y,word,puzzle,0)[1] == true) {
                            String pos = Integer.toString(x) + "," + Integer.toString(y);
                            if (finds >= 1) {
                                finds++;
                                severalSolutions();
                            }
                            else if (posUp_Right.contains(pos)) {
                                continue;
                            }
                            else {
                                ArrayList<String> caracteristicasUpRight1 = new ArrayList<String>();
                                caracteristicasUpRight1.add(k);
                                caracteristicasUpRight1.add(String.valueOf(k.length()));
                                int idxUpRight1 = palavrasResolvidas.indexOf(caracteristicasUpRight1);
                                caracteristicasUpRight1.add(pos);
                                caracteristicasUpRight1.add("upRight");
                                palavrasResolvidas.set(idxUpRight1,caracteristicasUpRight1);

                                for (int a = x, b = y; (a >= (x - word.length + 2)) && (b <= (y + word.length - 2)); a--, b++) {
                                    String lock = Integer.toString(a) + "," + Integer.toString(b); //para cada posição vamos trancar
                                    posUp_Right.add(lock);
                                    solutionPuzzle[a][b] = puzzle[a][b];
                                }
                                solutionPuzzle[x-word.length+1][y+word.length-1] = puzzle[x-word.length+1][y+word.length-1];
                                finds++;
                            } 
                        }
                        else if (down_right(x,y,word,puzzle,0)[1] == true) {
                            String pos = Integer.toString(x) + "," + Integer.toString(y);
                            if (finds >= 1) {
                                finds++;
                                severalSolutions();
                            }
                            else if (posDown_Right.contains(pos)) {
                                continue;
                            }
                            else {
                                ArrayList<String> caracteristicasDownRight1 = new ArrayList<String>();
                                caracteristicasDownRight1.add(k);
                                caracteristicasDownRight1.add(String.valueOf(k.length()));
                                int idxDownRight1 = palavrasResolvidas.indexOf(caracteristicasDownRight1);
                                caracteristicasDownRight1.add(pos);
                                caracteristicasDownRight1.add("downRight");
                                palavrasResolvidas.set(idxDownRight1,caracteristicasDownRight1);
                                for (int a = x, b = y; (a <= (x + word.length - 2)) && (b <= (y + word.length - 2)); a++, b++) {
                                    String lock = Integer.toString(a) + "," + Integer.toString(b); //para cada posição vamos trancar
                                    posDown_Right.add(lock);
                                    solutionPuzzle[a][b] = puzzle[a][b];
                                }
                                solutionPuzzle[x+word.length-1][y+word.length-1] = puzzle[x+word.length-1][y+word.length-1];
                                finds++;
                           }   
                        }
                        else if (down_left(x,y,word,puzzle,0)[1] == true) {
                            String pos = Integer.toString(x) + "," + Integer.toString(y);
                            if (finds >= 1) {
                                finds++;
                                severalSolutions();
                            }
                            else if (posDown_Left.contains(pos)) {
                                continue;
                            }
                            else {
                                ArrayList<String> caracteristicasDownLeft1 = new ArrayList<String>();
                                caracteristicasDownLeft1.add(k);
                                caracteristicasDownLeft1.add(String.valueOf(k.length()));
                                int idxDownLeft1 = palavrasResolvidas.indexOf(caracteristicasDownLeft1);
                                caracteristicasDownLeft1.add(pos);
                                caracteristicasDownLeft1.add("downLeft");
                                palavrasResolvidas.set(idxDownLeft1,caracteristicasDownLeft1);
                                for (int a = x, b = y; (a <= (x + word.length - 2)) && (b >= (y - word.length + 2)); a++, b--) {
                                    String lock = Integer.toString(a) + "," + Integer.toString(b); //para cada posição vamos trancar
                                    posDown_Left.add(lock);
                                    solutionPuzzle[a][b] = puzzle[a][b];
                                }
                                solutionPuzzle[x+word.length-1][y-word.length+1] = puzzle[x+word.length-1][y-word.length+1];
                                finds++;
                           }   
                        }
                        
                        else {
                            continue;
                        }
                      
                    }
                    else if (x == puzzle[1].length-1 && y == puzzle[1].length-1 && finds == 0) {
                        noSolutions(); 
                    } //se nao existir nenhuma solução vai para uma função que alerta o utilizador e termina o  programa
                }
            }
        }  
       
        // criar novo ficheiro para dar output do final
        File f = new File("out2.txt");
        FileWriter writer = new FileWriter(f);
        //Criar a tabela da soluções
        StringBuilder sb = new StringBuilder();
        String st;
        for (int i=0 ;i< palavrasResolvidas.size(); i++  ) {
			st = "";
			st = String.format("%-14s %-2s %7s %8s\n", palavrasResolvidas.get(i).get(0), palavrasResolvidas.get(i).get(1), palavrasResolvidas.get(i).get(2), palavrasResolvidas.get(i).get(3));
			sb.append(st);
            System.out.println(st);
            writer.write(st + "\n");
		}
        

        // imprimir o novo puzzle (o das soluções) e guardar no ficheiro
        for (int x = 0; x < solutionPuzzle[1].length; x++) { 
            System.out.println();
            writer.write("\n");
            for (int y = 0; y < solutionPuzzle[1].length; y++) { 
                if ((int)solutionPuzzle[x][y] != 0) {
                    System.out.print(solutionPuzzle[x][y]); //escrever a letra da palavra correta da sopa de letras
                    writer.write(solutionPuzzle[x][y]);
                }
                else {
                    System.out.print("."); //se não existir letra imprime um ponto
                    writer.write(".");
                }
            }
        }
       
        writer.close();
    
}
           //funçao para verificar se a String está tudo em maiúscula
    public static boolean isStringUpperCase(String str){
                
                //convert String to char array
                char[] charArray = str.toCharArray();
                
                for(int i=0; i < charArray.length; i++){
                    
                    //if any character is not in upper case, return false
                    if(!Character.isUpperCase(charArray[i]))
                        return false;
                }
                
                return true;
            }
    
    public static boolean isAlpha(String name) { //Verificar se é um caracter alfabético
        return name.matches("[a-zA-Z]+");
        }
        
                        //coordenadas, linha e coluna
    public static boolean[] up(int l, int c, char[] word, char[][] puzzle, int upCalls) {
        //verficar se dá para formar a palavra na direção "up"


        //Criamos uma chamada recursiva que devolve dois valores booleanos. 
        //só quando os dois elementos forem verdadeiros é que termina a função, significando que já 
        //encontrou a palavra certa. Quando o número de chamadas à função for igual ao tamanho da palavra.
        if (upCalls >= word.length-1) { //quando o 
            boolean[] validation = {true,true};
            return  validation; 
        }
        if (l < 0) { //se a linha for 0, significa que já está a aceder uma posição que não existe e por isso retorna false
            boolean[] validation = {true,false};
            return  validation;
        }
        else {
            if (puzzle[l][c] == word[upCalls]) { //verificar se o caracter nessa posiçao do puzzle corresponde ao caracter da palavra
                upCalls++;
                l--; //subir
                boolean [] call = up(l, c, word, puzzle, upCalls);
                if (call[1]) { // se o 2º bool for true, isto é, se passou no primeiro if, dar return da call
                    return call;
                }
            }
        }
        boolean[] validation = {true,false}; 
        return  validation;
    }
    //para as restantes direções o raciocínio é quase o mesmo mudando o sentido.

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
            if (puzzle[l][c] == word[downCalls]) { //verificar se o caracter nessa posiçao do puzzle corresponde ao caracter da palavra
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
          
            if (puzzle[l][c] == word[leftCalls]) { //verificar se o caracter nessa posiçao do puzzle corresponde ao caracter da palavra
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
           
            if (puzzle[l][c] == word[rightCalls]) { //verificar se o caracter nessa posiçao do puzzle corresponde ao caracter da palavra
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
           
            if (puzzle[l][c] == word[up_leftCalls]) { //verificar se o caracter nessa posiçao do puzzle corresponde ao caracter da palavra
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
            if (puzzle[l][c] == word[up_rightCalls]) { //verificar se o caracter nessa posiçao do puzzle corresponde ao caracter da palavra
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
           
            if (puzzle[l][c] == word[down_rightCalls]) { //verificar se o caracter nessa posiçao do puzzle corresponde ao caracter da palavra
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
            
            if (puzzle[l][c] == word[down_leftCalls]) { //verificar se o caracter nessa posiçao do puzzle corresponde ao caracter da palavra
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

        //Se não encontrar nenhuma solução
        
        public static void noSolutions(){
            System.out.println("Pedimos desculpa, mas pelo menos uma das palavras da lista não tem correspondência na sopa de letras.");
            System.exit(0);
        }

        //Se encontraar   mais de uma solução
        public static void severalSolutions(){
            System.err.println("Existem palavras com mais do que uma solução na sopa de letras!");
            System.exit(0);
        }
} 