import com.algoritmos.listas.ListaEstatica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListaEstaticaTestP {

    private ListaEstatica lista;

    @BeforeEach
    public void setUp() {
        lista = new ListaEstatica();
    }

    @Test
    public void testInserirMantendoOrdem() {
        lista.inserir(20);
        lista.inserir(10);
        lista.inserir(30);
        lista.inserir(25);
        lista.inserir(5);
        
        assertEquals("5,10,20,25,30", lista.toString());
    }
    
    @Test
    public void testInserirElementoExistente() {
        lista.inserir(10);
        lista.inserir(20);
        lista.inserir(10);
        
        assertEquals("10,10,20", lista.toString());
    }
    
    @Test
    public void testInserirComRedimensionamento() {
        for (int i = 1; i <= 15; i++) {
            lista.inserir(i * 2); // Insere múltiplos de 2
        }
        assertEquals(15, lista.getTamanho());
        assertEquals("2,4,6,8,10,12,14,16,18,20,22,24,26,28,30", lista.toString());
    }
    
    @Test
    public void testInserirElementoMenorQueTodos() {
        lista.inserir(50);
        lista.inserir(40);
        lista.inserir(30);
        lista.inserir(20);
        lista.inserir(10);
        lista.inserir(5);
        
        assertEquals("5,10,20,30,40,50", lista.toString());
    }
}
