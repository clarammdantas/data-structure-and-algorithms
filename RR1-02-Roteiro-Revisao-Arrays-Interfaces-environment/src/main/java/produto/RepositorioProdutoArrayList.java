package produto;

import java.util.ArrayList;

/**
 * Classe que representa um repositório de produtos usando ArrayList como
 * estrutura sobrejacente. Alguns métodos (atualizar, remover e procurar) ou
 * executam com sucesso ou retornam um erro. Para o caso desde exercício, o erro
 * será representado por uma RuntimeException que não precisa ser declarada na
 * clausula "throws" do mos metodos.
 *
 * @author Adalberto
 */
public class RepositorioProdutoArrayList implements QualquerRepositorio {

   /**
    * A estrutura onde os produtos sao mantidos. Voce nao precisa se preocupar
    * por enquanto com o uso de generics em ArrayList.
    */
   private ArrayList produtos;

   /**
    * A posicao do ultimo elemento inserido no array de produtos. o valor
    * inicial é -1 para indicar que nenhum produto foi ainda guardado no array.
    */
   private int index = -1;

   public RepositorioProdutoArrayList(int size) {
      super();
      this.produtos = new ArrayList();
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
      for (int i = 0; i < produtos.size(); i++) {
         if (((Produto) produtos.get(i)).getCodigo() == codigo)
            ans = i;
      }

      return ans;
   }

   /* (non-Javadoc)
 * @see produto.QualquerRepositorio#existe(int)
 */
   @Override
public boolean existe(int codigo) {
      return procurar(codigo) != null;
   }

   /**
    * Insere um novo produto (sem se preocupar com duplicatas)
    */
   public void inserir(Object produto) {
	  if (produto instanceof Produto) {
		  produtos.add(produto);
	  }
   }

   /**
    * Atualiza um produto armazenado ou retorna um erro caso o produto nao
    * esteja no array. Note que, para localizacao, o código do produto será
    * utilizado.
    */
   @SuppressWarnings("unchecked")
public void atualizar(Produto produto) {
      for (int i = 0; i < produtos.size(); i++) {
         Produto umProduto = (Produto) produtos.get(i);

         if (umProduto.getCodigo() == produto.getCodigo())
            produtos.set(i, produto);
      }
   }

   /* (non-Javadoc)
 * @see produto.QualquerRepositorio#remover(int)
 */
   @Override
public void remover(int codigo) {
      for (int i = 0; i < produtos.size(); i++) {
         Produto umProduto = (Produto) produtos.get(i);

         if (umProduto.getCodigo() == codigo)
            produtos.remove(i);
      }
   }

   /* (non-Javadoc)
 * @see produto.QualquerRepositorio#procurar(int)
 */
   @Override
public Produto procurar(int codigo) {
      int produtoIndex = procurarIndice(codigo);
      Produto p;

      if (produtoIndex < 0 || produtoIndex >= produtos.size())
         p = null;

      else
         p = (Produto) produtos.get(produtoIndex);

      return p;
   }
}
