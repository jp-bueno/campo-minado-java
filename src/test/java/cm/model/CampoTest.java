package cm.model;

import br.com.buenojp.cm.model.Campo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CampoTest {

    private Campo campo;

    @BeforeEach
    public void setUp() {
        campo = new Campo(3, 3);
    }

    @Test
    public void testVizinhoRealDistancia1Esquerda() {
        Campo vizinho = new Campo(3, 2);
        boolean result = campo.adicionarVizinho(vizinho);
        assertTrue(result);
    }

    @Test
    public void testVizinhoRealDistancia1Direita() {
        Campo vizinho = new Campo(3, 4);
        boolean result = campo.adicionarVizinho(vizinho);
        assertTrue(result);
    }

    @Test
    public void testVizinhoRealDistancia1Cima() {
        Campo vizinho = new Campo(2, 3);
        boolean result = campo.adicionarVizinho(vizinho);
        assertTrue(result);
    }

    @Test
    public void testVizinhoRealDistancia1Baixo() {
        Campo vizinho = new Campo(4, 3);
        boolean result = campo.adicionarVizinho(vizinho);
        assertTrue(result);
    }

    @Test
    public void testVizinhoRealDistancia2Diagonal() {
        Campo vizinho = new Campo(2, 2);
        boolean result = campo.adicionarVizinho(vizinho);
        assertTrue(result);
    }

    @Test
    public void testNaoVizinho() {
        Campo vizinho = new Campo(1, 1);
        boolean result = campo.adicionarVizinho(vizinho);
        assertFalse(result);
    }
}
