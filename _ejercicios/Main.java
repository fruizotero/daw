import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {

        // int[] array = { 1, 2, 34, 4, 5, 6, 7, 8, 9, 10 };
        // Ej_1.desplazarPosicion(array, 8);
        // Ej_1.paresImpares(0, 20);

        ArrayList<Integer> miLista = new ArrayList<Integer>() ;
        miLista.add(1);
        miLista.add(5);
        miLista.add(-10);
        miLista.add(-1);
        miLista.add(3);

        Ej_1.ordenarMenorMayor(miLista, 5);


        Ej_1.tablaBidimensional(5, 5);
    }
}