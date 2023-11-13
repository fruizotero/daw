
import java.util.ArrayList;
import java.util.Arrays;

public class Ej_1 {

    public static void desplazarPosicion(int[] array, int posicion) {

        int ultimo = array[9];

        for (int i = posicion; i > 0; i--) {
            array[i + 1] = array[i];
        }

        array[0] = ultimo;

        System.out.println(Arrays.toString(array));

    }

    public static void paresImpares(int numMinimo, int numMaximo) {
        int[] numeros = new int[20];
        ArrayList<Integer> listaPares = new ArrayList<>();
        ArrayList<Integer> listaImpares = new ArrayList<>();

        for (int i = 0; i < 20; i++) {

            int valorEntero = (int) (Math.floor(Math.random() * (numMaximo - numMinimo + 1) + numMinimo));

            numeros[i] = valorEntero;

            if (valorEntero % 2 == 0) {
                listaPares.add(valorEntero);
            } else {
                listaImpares.add(valorEntero);
            }
        }

        Object[] impares = listaImpares.toArray();
        Object[] pares = listaPares.toArray();

        System.out.println(Arrays.toString(pares));
        System.out.println(Arrays.toString(impares));

    }

    public static void ordenarMenorMayor(ArrayList<Integer> numeros, int length) {

        int[] arrayOrdenado = new int[length];
        int contador = 0;
        while (numeros.size() > 0) {

            int aux;
            aux = numeros.get(0);

            for (int i = 0; i < numeros.size(); i++) {
                if (aux > numeros.get(i)) {
                    aux = numeros.get(i);
                }
            }

            int index = numeros.indexOf(aux);

            if (index != -1) {
                numeros.remove(numeros.indexOf(aux));
            }

            arrayOrdenado[contador] = aux;

            if (numeros.size() > 0) {
                aux = numeros.get(0);
            }

            contador++;
        }

        System.out.println(Arrays.toString(arrayOrdenado));

    }

    public static void tablaBidimensional(int filas, int columnas) {

        int[][] tabla = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {

                tabla[i][j] = i + j;
            }
        }

        for (int[] fil : tabla) {

            for (int valor : fil) {
                System.out.printf("%d ", valor);
            }
            System.out.println();
        }

    }

}
