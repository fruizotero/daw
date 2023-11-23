public class Main {


    public static double getDistance(double speed, double time) {
        return speed * (time / 2);

    }

    public static boolean isValidCar(double[] sensorProbability) {

        int total = 0;
        for (double value : sensorProbability) {
            total += value;
        }

        return total / sensorProbability.length < 10;
    }

    public static double checkObjectWithPatternBlackAndWhite(boolean[][] pattern, boolean[][] object) {

        int counter = 0;
        int filas = pattern.length;
        int columnas = pattern[0].length;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (pattern[i][j] != object[i][j]) counter++;
            }
        }

        return (double) counter * 100 / (filas * columnas);
    }

    public static double checkObjectWithPatternColour(int[][] pattern, int[][] object) {
        int counter = 0;
        int filas = pattern.length;
        int columnas = pattern[0].length;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {

                int pixelMayor = Math.max(pattern[i][j], object[i][j]);
                int pixelMenor = Math.min( pattern[i][j], object[i][j]);

                int diferencia = pixelMayor - pixelMenor;

                if (diferencia > 10) counter++;
            }
        }
        return (double) counter * 100 / (filas * columnas);
    }


    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}