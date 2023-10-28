
public class Taller {

    private Motor motor;

    public Taller(Motor motor) {
        this.motor = motor;
    }

    public double reparar() {

        double horas = 0;

        if (TiposMotores.ELECTRICO.toString() == this.motor.getTipo()) {
            horas = ((10 - this.motor.getEstado()) / 3) * 1;
        }

        if (TiposMotores.GASOLINA.toString() == this.motor.getTipo()) {
            horas = ((10 - this.motor.getEstado()) / 2.5) * 2;
        }
        if (TiposMotores.DIESEL.toString() == this.motor.getTipo()) {
            horas = ((10 - this.motor.getEstado()) / 2) * 3;

        }

        return horas;
    }

    public double cobro() {

        return reparar() * 23.5;
    }

}
