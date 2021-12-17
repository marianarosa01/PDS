import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

public class SimpleStockManager implements StockManager {
    //NOTAS IMPORTANTES SOBRE OS ARTIGOS:
    // Cada artigo é atómico, não tem quantidades associadas;
    
    HashMap<String,Artigo> stock = new HashMap<>();

    @Override

    public Iterator<String> iterator() {

        for (Iterator it=stock.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry stock = (Map.Entry)it.next();
            Object key = stock.getKey();
            Object value = stock.getValue();
            }
            return (Iterator<String>) ((HashMap<String, Artigo>) stock).get(key);

    }

    @Override
    public boolean existeArtigo(String ref) {
        if (stock.containsKey(ref)){
            return true;
        }
        else { 
            return false;
        }
        ///verifica se existe em stock
    }

    @Override
    public boolean registaArtigo(String ref, Artigo p) {
        // registar um artigo associado a um código
       // se a referencia ja existir, o artigo é substituido por outro

        if (stock.containsKey(ref)){
            stock.remove(ref); //elimina a referencia antiga
            stock.put(ref, p); //adiciona a nova
        } 

        else {
            stock.put(ref,p);
        }

        return true;
    }

    @Override
    public Artigo removeArtigo(String ref) {
        Artigo deletedArtigo = stock.get(ref); //guardar que artigo vai ser eliminado
        stock.remove(ref); //removê-lo
        return deletedArtigo;
    }
	
	
}
