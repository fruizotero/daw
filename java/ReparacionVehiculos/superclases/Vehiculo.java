public class Vehiculo {

    private String marca;
    private int ruedas;
    private Motor motor;

    public Vehiculo(String marca, int ruedas, String tipoMotor, int estadoMotor) {
        this.marca = marca;
        this.ruedas = ruedas;
        this.motor = new Motor(tipoMotor, estadoMotor);
        
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

}
