package produto;

public interface QualquerRepositorio {

	/**
	    * Recebe o codigo e diz se tem produto com esse codigo armazenado
	    * 
	    * @param codigo
	    * @return
	    */
	boolean existe(int codigo);

	/**
	    * Remove produto com determinado codigo, se existir, ou entao retorna um
	    * erro, caso contrário. Note que a remoção NÃO pode deixar "buracos" no
	    * array.
	    * 
	    * @param codigo
	    */
	void remover(int codigo);

	/**
	    * Retorna um produto com determinado codigo ou entao um erro, caso o
	    * produto nao esteja armazenado
	    * 
	    * @param codigo
	    * @return
	    */
	Produto procurar(int codigo);
	
	void inserir(Object ob);

}