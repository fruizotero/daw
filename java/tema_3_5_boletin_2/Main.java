import java.util.Arrays;

/**
 * Main
 */
public class Main {

    public static void mostrarMenorMayor(int[] numeros) {

        for (int i = 0; i < numeros.length; i++) {
            int aux = numeros[i];
            int indexNumeroIntercambiar = -1;
            for (int j = i; j < numeros.length; j++) {
                if (aux > numeros[j]) {
                    aux = numeros[j];
                    indexNumeroIntercambiar = j;
                }
            }

            if (indexNumeroIntercambiar != -1) {
                numeros[indexNumeroIntercambiar] = numeros[i];
                numeros[i] = aux;
            }

        }
        System.out.println(Arrays.toString(numeros));

    }

    public static void figuraTrianguloRectangulo(int filas) {

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");

            }
            System.out.println();
        }

    }

    public static void figuraRombo(int filas) {

        int numeroAsteriscos = 1;
        boolean restarAsteriscos = false;
        for (int i = 1; i <= filas; i++) {

            String asteriscos = new String(new char[numeroAsteriscos]).replace('\0', '*');
            int espacios = (filas - numeroAsteriscos) / 2;

            String format = espacios > 0 ? "%" + espacios + "s%s%n" : "%s%s%n";

            System.out.printf(format, "", asteriscos);

            if (numeroAsteriscos == filas)
                restarAsteriscos = true;

            if (restarAsteriscos) {
                numeroAsteriscos -= 2;
            } else {
                numeroAsteriscos += 2;
            }

        }

    }

    public static void main(String[] args) {
        // mostrarMenorMayor(new int[] { -1, -2, 5, 4, -1, 2, 3, 10, 15 });
        // figuraTrianguloRectangulo(5);
        // figuraRombo(21);

        String[][] crucigrama = new String[][] {
                { "0 0", "0 1", "0 2", "0 3", "0 4" },
                { "1 0", "1 1", "1 2", "1 3", "1 4" },
                { "2 0", "2 1", "2 2", "2 3", "2 4" },
                { "3 0", "3 1", "3 2", "3 3", "3 4" },
                { "4 0", "4 1", "4 2", "4 3", "4 4" },
        };

        for (int i = crucigrama.length-1; i >= 0; i--) {
        // for (int i = 0; i < crucigrama.length; i++) {
            // int tmp = 0;
            System.out.print("i:" + i);
            System.out.println();
            int tmp_i = i;
            for (int j = 0; j <= i; j++) {
                
                if (j != 0)
                tmp_i--;
                System.out.printf("i: %s  j:%s\n", tmp_i, j);
            }
           
        }

    }
}