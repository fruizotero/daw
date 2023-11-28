import java.util.HashMap;
import java.util.Map;

public class Main {


    public static int countContainWords(String[] phrases, String words) {

        int counter = 0;
        String wordsLc = words.toLowerCase();
        for (String phrase : phrases) {
            String phraseLc = phrase.toLowerCase();

            if (phraseLc.contains(wordsLc)) counter++;
        }

        return counter;
    }

    public static double getFinalNum(int num, double percentage) {

        double percentageNumber = (num * percentage) / 100;
        double finalNumber = percentageNumber;

        if (percentageNumber < 1000 && percentageNumber > 100) finalNumber = percentageNumber / 3;
        if (percentageNumber < 10) finalNumber = percentageNumber * 3;

        return finalNumber;
    }

    public static String traducirMorse(String frase) {
        HashMap<String, String> abecedarioMorse = abecedarioMorse();
        String morse = "";
        String[] palabras = frase.split(" ");

        for (int i = 0; i < palabras.length; i++) {
            String[] letras = palabras[i].split("");

            for (int j = 0; j < letras.length; j++) {

                morse += abecedarioMorse.get(letras[j].toUpperCase());
                morse += j == letras.length - 1 ? "" : " ";
            }
            morse += i == palabras.length - 1 ? "" : "/";
        }

        return morse;
    }

    public  static  String traducirMorseAlfabeto(String fraseMorse){

        HashMap<String, String> abecedarioMorse = abecedarioMorse();
        String morseAlfabeto = "";
        String[] palabrasMorse = fraseMorse.split("/");

        for (int i = 0; i < palabrasMorse.length; i++) {
            String[] letrasMorse = palabrasMorse[i].split(" ");

            for (int j = 0; j < letrasMorse.length; j++) {

                morseAlfabeto += getKeyFromValue(letrasMorse[j],abecedarioMorse);
            }
            morseAlfabeto += i == palabrasMorse.length - 1 ? "" : " ";
        }

        return morseAlfabeto;

    }


    public static HashMap<String, String> abecedarioMorse() {

        HashMap<String, String> morse = new HashMap<>();

        morse.put("A", ".-");
        morse.put("B", "-...");
        morse.put("C", "-.-.");
        morse.put("D", "-..");
        morse.put("E", "·");
        morse.put("F", "..-.");
        morse.put("G", "--.");
        morse.put("H", "....");
        morse.put("I", "..");
        morse.put("J", ".---");
        morse.put("K", "-.-");
        morse.put("L", ".-..");
        morse.put("M", "--");
        morse.put("N", "-.");
        morse.put("Ñ", "--.--");
        morse.put("O", "---");
        morse.put("P", ".--.");
        morse.put("Q", "--.-");
        morse.put("R", ".-.");
        morse.put("S", "···");
        morse.put("T", "-");
        morse.put("U", "..-");
        morse.put("V", "...-");
        morse.put("W", ".--");
        morse.put("X", "-..-");
        morse.put("Y", "-.--");
        morse.put("Z", "--..");


        return morse;
    }


    public static String getKeyFromValue(String value, HashMap<String, String> map) {

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(value)) return entry.getKey();
        }
        return "";
    }

    public static int[] getFirstRow(int[][] matrix, int columns) {

        int[] vector = new int[columns];

        for (int i = 0; i < columns; i++) {
            vector[i] = matrix[0][i];
        }

        return vector;

    }


    public static void main(String[] args) {
//        System.out.println("Hello world!");
//        System.out.println(getKeyFromValue("- - · ·", abecedarioMorse()));

        System.out.println(traducirMorse("frank edgar"));
        System.out.println(traducirMorseAlfabeto("..-. .-. .- -. -.-/· -.. --. .- .-."));

    }
}