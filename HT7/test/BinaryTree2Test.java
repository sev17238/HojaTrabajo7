
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clase de pruebas unitarias para la clase del nodo binario.
 * @author David Soto 17551
 * @author Diego Sevilla 17238
 */
public class BinaryTree2Test {
    
    public BinaryTree2Test() {
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
    
    /**
     * Test of addNodo method, of class BinaryTree2.
     */
    @Test
    public void testAddNodo() {
        System.out.println("addNodo");
        BinaryNode<String> nuevoNodo = null;
        BinaryTree2<String> tree = new BinaryTree2<String>(nuevoNodo);
        
        nuevoNodo = new BinaryNode<>("CHILD","NINO");
        tree.addNodo(nuevoNodo);
        
        BinaryNode actual1 = tree.getRaiz();
        String expected1 = "(CHILD, NINO)";
        
        if(actual1 != null){
            
        }else{
            assertEquals(expected1, actual1);
        }        
    }


    /**
     * Test of buscarPalabra method, of class BinaryTree2.
     */
    @Test
    public void testBuscarPalabra() {
        System.out.println("buscarPalabra");
        BinaryNode<String> nuevoNodo = null;
        BinaryTree2<String> tree = new BinaryTree2<String>(nuevoNodo);
        
        nuevoNodo = new BinaryNode<>("ICE", "HIELO");
        tree.addNodo(nuevoNodo);
        String actual1 = tree.buscarPalabra("ICE");
        String expected1 = "HIELO";
        
        assertEquals(expected1, actual1); 
    }
    
}
