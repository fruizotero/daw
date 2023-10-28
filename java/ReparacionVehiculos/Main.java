import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
//TODO:: distinguir entre si es una moto/coche/bicicleta
        Bicicleta bici = new Bicicleta("Endura", 2, TiposMotores.ELECTRICO.toString(), 2);

        Coche coche = new Coche("honda", 4, TiposMotores.DIESEL.toString(), 5, 4, "qwer45");

        Motocicleta moto = new Motocicleta("yamaha", 2, TiposMotores.GASOLINA.toString(), 5, "qwerty85");

        vehiculos.addAll(Arrays.asList(bici, coche, moto));


        for (Vehiculo vehiculo : vehiculos) {
            Taller taller = new Taller(vehiculo.getMotor());

            System.out.println(taller.cobro());
        }

    }

}
