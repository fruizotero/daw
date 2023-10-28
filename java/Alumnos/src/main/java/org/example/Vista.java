package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Vista {
    Scanner scanner;
    ArrayList<Alumno> alumnos = new ArrayList<>();

    public Vista() {
        // TODO
        // Crear varios alumnos
        Alumno al1 = new Alumno("alumno 1", "uno", "11111111x", 4);
        Alumno al2 = new Alumno("alumno 2", "dos", "22222222x", 4);
        Alumno al3 = new Alumno("alumno 3", "tres", "33333333x", 4);
        Alumno al4 = new Alumno("alumno 4", "cuatro", "44444444x", 4);

        // TODO
        // Añadirlos al arrayList de alumnos
        alumnos.addAll(Arrays.asList(al1, al2, al3, al4));
    }

    public void getStarted() {
        do {
            System.out.println("\n******************** Bienvenido a IES de Teis ****************************");
            System.out.println("\n\t1. Ver Alumnos.\t\t\t\t\t\t\t\t5. Añadir Alumno.");
            System.out.println("\n\t2. Ver Alumno Estrella.\t\t\t\t\t\t6. Borrar Alumno.");
            System.out.println("\n\t3. Ver Alumnos Suspensos.\t\t\t\t\t7. Añadir Nota.");
            System.out.println("\n\t4. Ver Nota media.\t\t\t\t\t\t\t0. Exit.");
            System.out.println("\n**************************************************************************");
            scanner = new Scanner(System.in);

            try {
                int choice = scanner.nextInt();
                if (choice == 1) {
                    System.out.println("Lista de alumnos matriculados:");
                    // TODO
                    for (Alumno alumno : alumnos) {
                        System.out.println(alumno.getNombre());
                    }
                } else if (choice == 2) {
                    // TODO
                } else if (choice == 3) {
                    // TODO
                } else if (choice == 4) {
                    // TODO
                } else if (choice == 5) {
                    // TODO
                } else if (choice == 6) {
                    // TODO
                } else if (choice == 7) {
                    // TODO
                } else if (choice == 0) {
                    System.out.println("Bye!!");
                    System.exit(0);
                    ;
                } else {
                    System.err.println("[ERROR] Your option is incorrect!! Try again!!");
                }

            } catch (InputMismatchException e) {
                System.err.println("[ERROR] You must type a number!!!");
                scanner.next();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
    }

}
