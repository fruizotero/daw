public class Coche extends Vehiculo {
    private int puertas;
    private String matricula;

    public Coche(String marca, int ruedas, String tipoMotor, int estadoMotor, int puertas, String matricula) {
        super(marca, ruedas, tipoMotor, estadoMotor);
        this.puertas = puertas;
        this.matricula = matricula;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

}
