package produto;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestRepositorioProdutos {
	
	private QualquerRepositorio repositorio;
	
	@Before
	public void setUp() {
		this.repositorio = new RepositorioProdutoArrayList(10);
	}
	
	@Test
	public void testExiste() {
		assertFalse(repositorio.existe(5));
	}

	@Test
	public void testInserir() {
		((RepositorioProdutoArrayList) repositorio).inserir(new Produto(5,"Feijao",10.0,"Feijão carioca"));
		assertTrue(repositorio.existe(5));
	}

	@Test
	public void testAtualizar() {
		((RepositorioProdutoArrayList) repositorio).inserir(new Produto(5,"Feijao",10.0,"Feijão carioca"));
		((RepositorioProdutoArrayList) repositorio).atualizar(new Produto(5,"Feijao",10.0,"Feijão macassar"));
		assertEquals("Feijão macassar",repositorio.procurar(5).getDescricao());
	}

	@Test
	public void testRemover() {
		((RepositorioProdutoArrayList) repositorio).inserir(new Produto(5,"Feijao",10.0,"Feijão carioca"));
		repositorio.remover(5);
		assertFalse(repositorio.existe(5));
	}

	@Test
	public void testProcurar() {
		assertNull(repositorio.procurar(5));
		((RepositorioProdutoArrayList) repositorio).inserir(new Produto(5,"Feijao",10.0,"Feijão carioca"));
		assertNotNull(repositorio.procurar(5));		
	}
	
	private void insertNewProducts() {
		((RepositorioProdutoArrayList) repositorio).inserir(new Produto(6, "Queijo", 23.0, "Gorgonzola"));
		((RepositorioProdutoArrayList) repositorio).inserir(new Produto(10, "Doce", 50.0, "Bala"));
		((RepositorioProdutoArrayList) repositorio).inserir(new Produto(12, "Cafe", 10.0, "Melita"));
	}
	
	@Test
	public void test01() {
		insertNewProducts();
		
		assertTrue(repositorio.existe(10));
		assertTrue(repositorio.existe(6));
		assertTrue(repositorio.existe(12));
		
		assertFalse(repositorio.existe(100));
	}
	
	@Test
	public void test02() {
		insertNewProducts();
		
		assertEquals(6, repositorio.procurar(6).getCodigo());
		assertNull(repositorio.procurar(1000));
	}

}
