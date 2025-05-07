package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import Principal.Parcial;

public class ParcialTest {

    @Test
    public void testPotenciaBaseYExponentePositivos() {
        assertEquals(8, Parcial.potencia(2, 3));
        assertEquals(1, Parcial.potencia(5, 0));
        assertEquals(0, Parcial.potencia(0, 5));
    }

    @Test
    public void testPotenciaExponenteCero() {
        assertEquals(1, Parcial.potencia(7, 0));
    }

    @Test
    public void testPotenciaConUno() {
        assertEquals(1, Parcial.potencia(1, 1000));
        assertEquals(5, Parcial.potencia(5, 1));
    }

    @Test
    public void testCeroElevadoACero() {
        Exception excepcion = assertThrows(ArithmeticException.class, () -> {
            Parcial.potencia(0, 0);
        });
        assertEquals("0 elevado a 0 es una indeterminacion.", excepcion.getMessage());
    }

    @Test
    public void testExponenteNegativo() {
        Exception excepcion = assertThrows(IllegalArgumentException.class, () -> {
            Parcial.potencia(2, -3);
        });
        assertEquals("Exponente negativo invalido: generaria una raiz y posiblemente un numero no entero.", excepcion.getMessage());
    }

    @Test
    public void testDesbordamiento() {
        Exception excepcion = assertThrows(ArithmeticException.class, () -> {
            Parcial.potencia(100000, 5);  // esto excede el rango de int
        });
        assertTrue(excepcion.getMessage().contains("Desbordamiento"));
    }
    @Test
    public void testSinDesbordamiento() {
        // Este caso pasa por el if pero NO lanza excepción
        assertEquals(16, Parcial.potencia(2, 4));
    }

}
