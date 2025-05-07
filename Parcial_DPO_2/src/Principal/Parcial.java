package Principal;
public class Parcial {

    public static int potencia(int b, int e) {
        if (e < 0) {
            throw new IllegalArgumentException("Exponente negativo invalido: generaria una raiz y posiblemente un numero no entero.");
        }

        if (b == 0 && e == 0) {
            throw new ArithmeticException("0 elevado a 0 es una indeterminacion.");
        }

        int resultado = 1;
        int contador = 1;
        while (contador <= e) {
            // mirar si ya voy a generar un numero muy grande
            if (b != 0 && resultado > 2147483647 / b) {
                throw new ArithmeticException("Desbordamiento: resultado excede el rango de los enteros.");
            }
            resultado *= b;
            contador++;
        }

        return resultado;
    }
}

