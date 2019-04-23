import br.com.fatec.model.Sumario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SumarioJUnitTest {
    
    private final String sumarioEsperado = "Sumario:\n"
            + "\tItem 1 ... 1\n"
            + "\tItem 2 ... 2\n"
            + "\t\tItem 2.2 ... 2.2\n"
            + "\t\t\tItem 2.2.1 ... 2.2.1\n"
            + "\tItem 3 ... 3\n"
            + "\tItem 4 ... 4\n";
    
    public SumarioJUnitTest() {
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
    public void sumarioCorreto(){
        Sumario sumario = new Sumario();
        Sumario item1 = new Sumario();
        Sumario item2 = new Sumario();
        Sumario item3 = new Sumario();
        Sumario item4 = new Sumario();
        Sumario item2_2 = new Sumario();
        Sumario item2_2_1 = new Sumario();
        
        sumario.setNome("Sumario:");
        item1.setNome("Item 1");
        item1.setNumeracao("1");
        
        item2.setNome("Item 2");
        item2.setNumeracao("2");
        
        item3.setNome("Item 3");
        item3.setNumeracao("3");
        
        item4.setNome("Item 4");
        item4.setNumeracao("4");
        
        item2_2.setNome("Item 2.2");
        item2_2.setNumeracao("2.2");
                
        item2_2_1.setNome("Item 2.2.1");
        item2_2_1.setNumeracao("2.2.1");
        
        sumario.addSubItem(item1);
        sumario.addSubItem(item2);
        sumario.addSubItem(item3);
        sumario.addSubItem(item4);
        
        item2.addSubItem(item2_2);
        item2_2.addSubItem(item2_2_1);
        
        //System.out.println(sumario.getTextoFormatado().equals(sumarioEsperado));
        System.out.println(sumario.getTextoFormatado());
        System.out.println(sumarioEsperado);
        assertEquals(sumario.getTextoFormatado(), sumarioEsperado);
    }
}
