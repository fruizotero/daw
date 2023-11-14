public class Persona {

    private String nombre;
    private int edad;
    {edad=100;}

    Persona(String nombre) {
        this.nombre = nombre;
    }

    public  void imprimirDatos() {
        System.out.println(nombre);
        System.out.println(edad);
    }

}
