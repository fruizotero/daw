import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        triple(new int[]{2, 9, 7, 10, 12}, 3);
        distance(new int[]{100102, 900001});
        vowelCounter("manzana"); //Después prueba con patata

        String[] frutas = {"Pera", "Pera", "Manzana", "Naranja", "Pera"};
//        String[] frutas2 = {"Pera", "Pera", "Manzana", "Naranja"};
        frutas(frutas, "Pera");
//        frutas(frutas2);


        decimalToRomano(1567);

    }


    public static void decimalToRomano(int numeroAnio) {

        int[] numerosRomanosEnteros = new int[]{1000, 500, 100, 50, 10};

        HashMap<Integer, String> numerosRomanos = new HashMap<>();
        numerosRomanos.put(1, "I");
        numerosRomanos.put(2, "II");
        numerosRomanos.put(3, "III");
        numerosRomanos.put(4, "IV");
        numerosRomanos.put(5, "V");
        numerosRomanos.put(6, "VI");
        numerosRomanos.put(7, "VII");
        numerosRomanos.put(8, "VIII");
        numerosRomanos.put(9, "IX");
        numerosRomanos.put(10, "X");
        numerosRomanos.put(50, "L");
        numerosRomanos.put(100, "C");
        numerosRomanos.put(500, "D");
        numerosRomanos.put(1000, "M");

        int numeroAnioTmp = numeroAnio;
        String numeroRomano = "";
        for (int valorNumero : numerosRomanosEnteros) {

            int cantidadNumeroRomanoLetras = numeroAnioTmp / valorNumero;


            if (cantidadNumeroRomanoLetras != 0) {
                for (int i = 0; i < cantidadNumeroRomanoLetras; i++) {
                    numeroRomano += numerosRomanos.get(valorNumero);
                }
                numeroAnioTmp = numeroAnioTmp % valorNumero;
            }

        }

        System.out.println(numeroRomano + numerosRomanos.get(numeroAnioTmp));

    }


    //Cambia el siguiente método para que pueda recibir como parámetro un array de números para
    //que sean multiplcados por 3
    public static void triple(int[] numeros, int multiplicador) {

        for (int numero : numeros) {
            System.out.println(numero * multiplicador);
        }
    }

    //Cambia el siguiente método para se le pueda pasar un array de centrimetros.
    public static void distance(int[] arrayCentimeters) {

        for (int centimeters : arrayCentimeters) {

            int km = centimeters / 100000;
            int m = (centimeters % 100000) / 100;
            int cm = (centimeters % 100);
            System.out.println(km + " Kilometros " + m + " metros " + cm + " centimetros");
        }

    }

    //Arregla este método. Está raro.
    public static void vowelCounter(String palabra) {
        int counter = 0;

        Pattern pattern = Pattern.compile("[aeiou]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(palabra);

        while (matcher.find()) {
            counter++;
        }

        System.out.println("Número de vocales: " + counter);
    }

    //Nuestro programador no sabe como obtener el número de frutas iguales que están las bolsas
    public static void frutas(String[] frutas, String keyFruit) {
        //El siguiente tipo de estructura de datos se llama diccionario, HashMap o clave/valor.
        //Permite encontrar un valor buscando por su clave.
        HashMap<String, Integer> fruitsCounter = new HashMap<>();

        for (String fruta : frutas) {
            if (fruitsCounter.get(fruta) != null) {
                int amountFruits = fruitsCounter.get(fruta) + 1;
                fruitsCounter.put(fruta, amountFruits);
            } else {
                fruitsCounter.put(fruta, 1);
            }
        }

        System.out.println("Cantidad de " + keyFruit + " :" + fruitsCounter.get(keyFruit));
        //Para añadir una fruta. Siendo 1 el número de peras en la bolsa
//        fruitsCounter.put("Pera", 1);
//        //Para conseguir el número de peras de la bolsa
//        fruitsCounter.get("Pera")
    }


}