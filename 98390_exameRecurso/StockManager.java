public interface StockManager extends Iterable<String> {

	public boolean existeArtigo(String ref);
	public boolean registaArtigo(String ref, Artigo p);
	public Artigo removeArtigo(String ref);
	
}
