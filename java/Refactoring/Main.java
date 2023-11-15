import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        triple(new int[]{2, 9, 7, 10, 12}, 3);
        distance(new int[]{100102, 900001});
        vowelCounter("patata"); //Después prueba con patata

        String[] frutas = {"Pera", "Pera", "Manzana", "Naranja", "Pera"};
        String[] frutas2 = {"Pera", "Pera", "Manzana", "Naranja"};
        frutas(frutas, "Pera");
        frutas(frutas2, "Manzana");


        decimalToRomano(951);


    }


    public static void decimalToRomano(int anio) {

        HashMap<Integer, String> numerosRomanosMap = numerosRomanos();
        int[] numerosRomanosDivisores = new int[]{1000, 500, 100, 50, 10};

        int anioResto = anio;
        String numeroRomanoString = "";
        for (int numeroRomanoDivisor : numerosRomanosDivisores) {

            int cantidadNumeroRomanoLetras = anioResto / numeroRomanoDivisor;

            if (cantidadNumeroRomanoLetras != 0) {
                for (int i = 0; i < cantidadNumeroRomanoLetras; i++) {
                    numeroRomanoString += numerosRomanosMap.get(numeroRomanoDivisor);
                }
                anioResto = anioResto % numeroRomanoDivisor;
            }

            if (cantidadNumeroRomanoLetras > 3) {
                numeroRomanoString = numeroRomanoString.replaceFirst("DCCCC", "CM");
                numeroRomanoString = numeroRomanoString.replaceFirst("CCCC", "CD");
                numeroRomanoString = numeroRomanoString.replaceFirst("LXXXX", "XC");
                numeroRomanoString = numeroRomanoString.replaceFirst("XXXX", "XL");
            }

        }
        numeroRomanoString = numeroRomanoString + numerosRomanosMap.get(anioResto);
        System.out.println(numeroRomanoString);

    }

    public static HashMap<Integer, String> numerosRomanos() {
        HashMap<Integer, String> numeros = new HashMap<>();
        numeros.put(0, "");
        numeros.put(1, "I");
        numeros.put(2, "II");
        numeros.put(3, "III");
        numeros.put(4, "IV");
        numeros.put(5, "V");
        numeros.put(6, "VI");
        numeros.put(7, "VII");
        numeros.put(8, "VIII");
        numeros.put(9, "IX");
        numeros.put(10, "X");
        numeros.put(50, "L");
        numeros.put(100, "C");
        numeros.put(500, "D");
        numeros.put(1000, "M");

        return numeros;
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