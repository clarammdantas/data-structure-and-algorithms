package produto;

/**
 * Classe que representa um repositório de produtos usando arrays como estrutura
 * sobrejacente. Alguns métodos (atualizar, remover e procurar) ou executam com
 * sucesso ou retornam um erro. Para o caso desde exercício, o erro será
 * representado por uma RuntimeException que não precisa ser declarada na
 * clausula "throws" do mos metodos.
 * 
 * Obs: Note que você deve utilizar a estrutura de dados array e não
 * implementações de array prontas da API Collections de Java (como ArrayList,
 * por exemplo).
 * 
 * @author Adalberto
 *
 */
public class RepositorioProdutoNaoPerecivelArray implements QualquerRepositorio {

   /**
    * A estrutura (array) onde os produtos sao mantidos.
    */
   private ProdutoNaoPerecivel[] produtos;

   /**
    * A posicao do ultimo elemento inserido no array de produtos. o valor
    * inicial é -1 para indicar que nenhum produto foi ainda guardado no array.
    */
   private int index = -1;

   public RepositorioProdutoNaoPerecivelArray(int size) {
      super();
      this.produtos = new ProdutoNaoPerecivel[size];
   }

   /**
    * Recebe o codigo do produto e devolve o indice desse produto no array ou
    * -1 caso ele nao se encontre no array. Esse método é util apenas na
    * implementacao com arrays por questoes de localizacao. Outras classes que
    * utilizam outras estruturas internas podem nao precisar desse método.
    * 
    * @param codigo
    * @return
    */
   private int procurarIndice(int codigo) {
      int ans = -1;
      for (int i = 0; i < produtos.length; i++) {
         if (((Produto) produtos[i]).getCodigo() == codigo)
            ans = i;
      }

      return ans;
   }

   /**
    * Recebe o codigo e diz se tem produto com esse codigo armazenado
    * 
    * @param codigo
    * @return
    */
   public boolean existe(int codigo) {
      int ans = procurarIndice(codigo);
      return ans != 1;
   }

   /**
    * Insere um novo produto (sem se preocupar com duplicatas)
    */
   public void inserir(Object produto) {
	  if (produto instanceof ProdutoNaoPerecivel)
		  produtos[++this.index] = (ProdutoNaoPerecivel) produto;
   }

   /**
    * Atualiza um produto armazenado ou retorna um erro caso o produto nao
    * esteja no array. Note que, para localizacao, o código do produto será
    * utilizado.
    */
   public void atualizar(ProdutoNaoPerecivel produto) {
      for (int i = 0; i < produtos.length; i++) {
         if (((Produto) produtos[i]).getCodigo() == produto.getCodigo())
            produtos[i] = produto;
      }
   }

   /**
    * Remove produto com determinado codigo, se existir, ou entao retorna um
    * erro, caso contrário. Note que a remoção NÃO pode deixar "buracos" no
    * array.
    * 
    * @param codigo
    */
   public void remover(int codigo) {
      //ProdutoNaoPerecivel[] produtosNaoRemovidos = new ProdutoNaoPerecivel[produtos.length];

      for (int i = 0; i < produtos.length; i++) {
         if (((Produto) produtos[i]).getCodigo() == codigo) {
            produtos[i] = null;
         }
      }
   }

   /**
    * Retorna um produto com determinado codigo ou entao um erro, caso o
    * produto nao esteja armazenado
    * 
    * @param codigo
    * @return
    */
   public ProdutoNaoPerecivel procurar(int codigo) {
      int produtoIndex = procurarIndice(codigo);
      Produto p;

      if (produtoIndex < 0 || produtoIndex >= produtos.length)
         p = null;

      else
         p = (ProdutoNaoPerecivel) produtos[produtoIndex];

      return (ProdutoNaoPerecivel) p;
   }

}
