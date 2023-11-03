package br.com.buenojp.cm.model;

import br.com.buenojp.cm.exceptions.ExplosaoException;
import br.com.buenojp.cm.model.Campo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void testValorPadraoAtributoMarcado() {
        assertFalse(campo.isMarcado());
    }

    @Test
    void testAlternarMarcacao() {
        campo.alternarMarcacao();
        assertTrue(campo.isMarcado());
    }

    @Test
    void testAlternarMarcacaoDuasChamadas() {
        campo.alternarMarcacao();
        campo.alternarMarcacao();
        assertFalse(campo.isMarcado());
    }

    @Test
    void testAbrirNaoMinadoNaoMarcado() {
        assertTrue(campo.abrir());
    }

    @Test
    void testAbrirNaoMinadoEstaMarcado() {
        campo.alternarMarcacao();
        assertFalse(campo.abrir());
    }

    @Test
    void testAbrirEstaMinadoEstaMarcado() {
        campo.alternarMarcacao();
        campo.minar();
        assertFalse(campo.abrir());
    }

    @Test()
    void testAbrirMinadoNaoMarcado() {
        campo.minar();
        assertThrows(ExplosaoException.class, () -> {
            campo.abrir();
        });
    }

    @Test
    void testeAbriComVizinhos() {

        Campo campo11 = new Campo(1,1);
        Campo campo22 = new Campo(2,2);

        campo22.adicionarVizinho(campo11);

        campo.adicionarVizinho(campo22);
        campo.abrir();

        assertTrue(campo22.isAberto() && campo11.isAberto());
    }

    @Test
    void testeAbriComVizinhos2() {

        Campo campo11 = new Campo(1,1);
        Campo campo12 = new Campo(1,2);
        campo12.minar();

        Campo campo22 = new Campo(2,2);
        campo22.adicionarVizinho(campo11);
        campo22.adicionarVizinho(campo12);

        campo.adicionarVizinho(campo22);
        campo.abrir();

        assertTrue(campo22.isAberto() && campo11.isFechado());
    }
}
