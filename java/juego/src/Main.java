import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
//import  java.net.Http
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

//        String[] ips = {"192.168.7.21", "192.168.7.17", "192.168.7.13", "192.168.7.9", "192.168.7.5", "192.168.7.1",
//                "192.168.7.18", "192.168.7.14", "192.168.7.10", "192.168.7.2", "192.168.7.6", "192.168.7.11",
//                "192.168.7.15", "192.168.7.19", "192.168.7.3", "192.168.7.20", "192.168.7.16", "192.168.7.8",
//                "192.168.7.4"};
        String[] ips = {"localhost", "127.0.0.1"};
        play(ips);
    }

    public static String consumeAPI(String ip, String path) throws URISyntaxException, IOException, InterruptedException {
        URI targetURI = new URI("http://" + ip + ":8080/" + path);
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(targetURI).GET().build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public static void play(String[] ips) throws URISyntaxException, IOException, InterruptedException {
        int numApis = 0;
        int puntuacion = 0;

        Scanner sc = new Scanner(System.in);

        for (String ip : ips) {
            try {
                //Verifica que la API de la IP está disponible

                if (consumeAPI(ip, "").equalsIgnoreCase("true")) {

                    numApis++;
                    for (int i = 1; i < 4; i++) {
                        String pista = consumeAPI(ip, "pista" + i) + " : (Responder s/n)";
                        System.out.println(pista);
                        if (sc.nextLine().equalsIgnoreCase("s")) {
                            System.out.print("Respuesta: ");
                            String respuesta = sc.nextLine();
                            boolean respuestaCorrecta = consumeAPI(ip, "resolver/" + respuesta).equalsIgnoreCase("true");
                            System.out.println(respuestaCorrecta);
                            if (respuestaCorrecta) {
                                puntuacion += (10 / i);
                            }
                            break;
                        }

                    }

                }
            } catch (Exception e) {
                System.out.println("Api no disponible");
                System.out.println("Error" + e);
            }

            System.out.println("Mi puntuación actual es de : " + puntuacion + " puntos");
            System.out.println(numApis + " de " + ips.length + " preguntas");
        }

        System.out.println("PUNTUACIÓN FINAL: " + puntuacion + " puntos en un total de " + numApis + " preguntas");

        int puntuacionAnterior = Integer.parseInt(consumeAPI("localhost", "score"));

        if (puntuacion > puntuacionAnterior) {
            consumeAPI("localhost", "score/ff456889211/" + puntuacion);
        }

        //Comprueba que tu nueva puntuación sea superior a la que tienes en tu API.
        //Si es superior envíala para que quede registrado tu nuevo record.
    }

}