package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        ArrayList<Integer> temperatures = new ArrayList<>();
        ArrayList<Integer> humidities = new ArrayList<>();
        HashMap<String, Integer> colors = new HashMap<>();
        LocalTime timeMaxTemp = null;
        LocalTime timeMaxHum = null;

        //EJEMPLOS DE COMO ACCEDER A LA API

        //Enviar una petición POST
//        postAPI("localhost", "1880", "color", "orange");

        //Realizar una petición GET y mostrarla por pantalla
//        System.out.println(getAPI("192.168.7.21", "1880", "temperature"));

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("\n********************** Welcome to Arduino Menu *****************************");
            System.out.println("\n\t1. Ver Color.\t\t\t\t\t7. Humedad máxima.");
            System.out.println("\n\t2. Ver Humedad.\t\t\t\t\t8. Cambiar color.");
            System.out.println("\n\t3. Ver Temperatura.\t\t\t\t9. Color más repetido.");
            System.out.println("\n\t4. Temperatura mínima.\t\t\t10. Hora Temperatura máxima.");
            System.out.println("\n\t5. Humedad mínima.\t\t\t\t11. Hora Humedad máxima.");
            System.out.println("\n\t6. Temperatura máxima.\t\t\t0. Exit.");
            System.out.println("\n**************************************************************************");


            try {
                int choice = scanner.nextInt();
                if (choice == 1) {
                    //TODO
                    String color = getAPI("192.168.7.21", "1880", "color");
                    if (colors.get(color) == null) {
                        colors.put(color, 1);
                    } else {
                        colors.put(color, colors.get(color) + 1);
                    }

                    System.out.println(color);

                } else if (choice == 2) {
                    //TODO
                    String humidityString = getAPI("192.168.7.21", "1880", "humidity");
                    int humidity = Integer.parseInt(humidityString);
                    humidities.add(humidity);
                    System.out.println(humidity);
                } else if (choice == 3) {
                    //TODO
                    String temperatureString = getAPI("192.168.7.21", "1880", "temperature");
                    int temperature = Integer.parseInt(temperatureString);
                    temperatures.add(temperature);
                    System.out.println(temperature);
                } else if (choice == 4) {
                    //TODO
                    System.out.println(minValue(temperatures));
                } else if (choice == 5) {
                    //TODO
                    System.out.println(minValue(humidities));
                } else if (choice == 6) {
                    //TODO
                    System.out.println(maxValue(temperatures));
                    timeMaxTemp = LocalTime.now();
                } else if (choice == 7) {
                    //TODO
                    System.out.println(maxValue(humidities));
                    timeMaxHum = LocalTime.now();
                } else if (choice == 8) {
                    //TODO
                    String color = scanner.next();
                    postAPI("192.168.7.21", "1880", "color", color);
                } else if (choice == 9) {
                    //TODO
                    String colorAux = "";
                    int valueAux = 0;
                    for (Map.Entry<String, Integer> color : colors.entrySet()) {
                        if (valueAux < color.getValue()) {
                            valueAux = color.getValue();
                            colorAux = color.getKey();
                        }
                    }
                    System.out.println(colorAux + " :" + colors.get(colorAux));
                } else if (choice == 10) {
                    //TODO
                    System.out.println(timeMaxTemp);
                } else if (choice == 11) {
                    //TODO
                    System.out.println(timeMaxHum);
                } else if (choice == 0) {
                    System.out.println("Bye!!");
                    System.exit(0);
                    ;
                } else {
                    System.err.println("[ERROR] Your option is incorrect!! Try again!!");
                }

            } catch (
                    InputMismatchException e) {
                System.err.println("[ERROR] You must type a number!!!");
                scanner.next();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);


    }

    public static int minValue(ArrayList<Integer> values) {

        int valueMin = values.get(0);
        for (int value : values) {
            if (value < valueMin) {
                valueMin = value;
            }
        }
        return valueMin;
    }

    public static int maxValue(ArrayList<Integer> values) {

        int valueMax = values.get(0);

        for (int value : values) {
            if (value > valueMax) {
                valueMax = value;
            }
        }

        return valueMax;
    }

    public static String getAPI(String ip, String port, String path) throws URISyntaxException, IOException, InterruptedException {
        URI targetURI = new URI("http://" + ip + ":" + port + "/" + path);
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(targetURI).GET().build();
        //HttpClient httpClient = HttpClient.newHttpClient();
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static String postAPI(String ip, String port, String path, String message) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://" + ip + ":" + port + "/" + path))
                .POST(HttpRequest.BodyPublishers.ofString(message))
                .build();
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }


    /*
        Escribir en un archivo:

        FileWriter file = new FileWriter("./parameters.txt");
        PrintWriter pw = new PrintWriter(file);
        pw.println("Hola");
        pw.close();
     */

    /*
        Leer de un archivo:

       BufferedReader br = new BufferedReader(new FileReader ("./parameters.txt"));
       String line = "";
       while(!(line = br.readLine()) != null){
            System.out.println(line);
       }
     */

}