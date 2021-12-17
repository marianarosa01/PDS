import java.util.Iterator;
import java.util.HashMap;


public class StoreStockManager implements StockManager{
    java.util.HashMap<String,Artigo> stock = new HashMap<>();

    public StoreStockManager(StockManager iv) {
        //incompleto

    }

    @Override
    public Iterator<String> iterator() {
        return null;
    }

    @Override
    public boolean existeArtigo(String ref) {
        if (stock.containsKey(ref)){
            return true;
        }
        else { 
            return false;
        }
    }

    @Override
    public boolean registaArtigo(String ref, Artigo p) {
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
        Artigo deletedArtigo = new nullArtigo; //guardar que artigo vai ser eliminado
        stock.remove(ref); //removê-lo
        return deletedArtigo;
    }
    
}
