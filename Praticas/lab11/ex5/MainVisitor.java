
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class MainVisitor {

    private static int total = 0; 
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        if(args.length==0){
            System.err.println("Número inválido de argumentos;");
        }
        
        for(int i = 0; i < args.length; i++){
            Path start = Paths.get(args[i]);
            try{
                if((i+1) != args.length && args[i+1].equals("-r")){
                    recursiveSum(start);
                    i++;   
                } else {
                    simpleSum(Paths.get(args[i]),false);
                }
            } catch(IndexOutOfBoundsException e){
                System.err.println("Lista de argumentos inválida!");
                System.exit(1);
            } 
        }
        
        System.out.println("\nTotal: " + total + " bytes");
        
    }
    
    private static void recursiveSum(Path start) throws IOException{
        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
            int soma = 0;
            List<Path> subDirs = new ArrayList<>();
            
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException  {
                soma+=attrs.size();
                return FileVisitResult.CONTINUE;
            }
            
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                if(dir.equals(start)){
                    System.out.print(dir.getFileName()+": ");
                } else if(dir.getParent().equals(start)){
                    subDirs.add(dir);
                }
                return FileVisitResult.CONTINUE;
            }
            
            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException e) throws IOException {
                if (e == null) {
                    if(dir.equals(start)){
                        total+=soma;
                        System.out.println(soma+" bytes");
                        for(Path p : subDirs){
                            System.out.print("|-> ");
                            simpleSum(p,true);
                        }
                    }
                    return FileVisitResult.CONTINUE;
                } else {
                    throw e;
                }
            }
        });
    }
    
    private static void simpleSum(Path start, boolean calledFromRecursive) throws IOException{
        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
            int soma = 0;
            
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException  {
                soma+=attrs.size();
                return FileVisitResult.CONTINUE;
            }
            
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                if(dir.equals(start)){
                    System.out.print(dir.getFileName()+": ");
                }
                return FileVisitResult.CONTINUE;
            }
            
            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException e) throws IOException {
                if (e == null) {
                    if(dir.equals(start)){
                        if(!calledFromRecursive){
                           total+=soma; 
                        }
                        System.out.println(soma+" bytes");
                    }
                    return FileVisitResult.CONTINUE;
                } else {
                    throw e;
                }
            }
            
            @Override
            public FileVisitResult visitFileFailed(Path file, IOException e){
                System.out.println("Ficheiro "+file.toString()+" não é válido!");
                return FileVisitResult.TERMINATE;
            }
        });
    }
    
}