import br.com.fatec.model.livro.Livro;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LivroJUnitTest {
        
    public LivroJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void CompraDeveSerRealizada() {
        Livro livro = new Livro();
        livro.setPreco(105.5f);
        livro.setQuantidade(2);
        
        livro.comprar(1);
        
        assertEquals(livro.getQuantidade(), 1);
    }
    
    @Test
    public void CompraNaoDeveSerRealizada_Esgotado() {
        Livro livro = new Livro();
        livro.setPreco(105.5f);
        livro.setQuantidade(0);
        
        try {
            livro.comprar(1);
            throw new RuntimeException("Quantidade excedida");
        }catch(RuntimeException ex){
            
        }
    }
    
    @Test
    public void CompraNaoDeveSerRealizada_LimiteExcedido(){
        Livro livro = new Livro();
        livro.setPreco(105.5f);
        livro.setQuantidade(10);
        
       try {
            livro.comprar(20);
            throw new RuntimeException("Quantidade excedida");
        }catch(RuntimeException ex){
            
        }
    }
}
