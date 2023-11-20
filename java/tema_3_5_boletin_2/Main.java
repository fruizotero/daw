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

    public static boolean numeroArmstrong(int numero) {

        int sumaDigitosElevados = 0;

        String[] numerosString = String.valueOf(numero).split("");
        int potencia = numerosString.length;

        for (String numeroString : numerosString) {
            int digito = Integer.parseInt(numeroString);
            sumaDigitosElevados += Math.pow(digito, potencia);
        }

        return sumaDigitosElevados == numero;
    }

    public static boolean esOmirp(int numero) {

        return esPrimo(numero) && esPrimo(numeroInvertido(numero));

    }

    public static int numeroInvertido(int numero) {

        String[] digitosNumeros = String.valueOf(numero).split("");

        String numeroInvertidoString = "";
        for (int i = digitosNumeros.length - 1; i >= 0; i--) {
            numeroInvertidoString += digitosNumeros[i];
        }

        return Integer.parseInt(numeroInvertidoString);
    }

    public static boolean esPrimo(int numero) {

        int contador = 0;

        if (numero == 1) return false;

        for (int i = 1; i <= numero; i++) {

            if (numero % i == 0) contador++;
        }
        return contador == 2;

    }


    public static void main(String[] args) {
        // mostrarMenorMayor(new int[] { -1, -2, 5, 4, -1, 2, 3, 10, 15 });
        // figuraTrianguloRectangulo(5);
        // figuraRombo(21);

//        System.out.println(numeroArmstrong(4210818));

//        System.out.println(esPrimo(1597));
        System.out.println(esOmirp(13751));

    }
}