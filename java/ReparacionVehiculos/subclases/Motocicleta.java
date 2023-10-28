public class Motocicleta extends Vehiculo {

    private String matricula;

    public Motocicleta(String marca, int ruedas, String tipoMotor, int estadoMotor, String matricula) {
        super(marca, ruedas, tipoMotor, estadoMotor);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

}
