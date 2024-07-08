public class Estudiante {
    String cedula;
    String nombre;
    float nota1;
    float nota2;
    public Estudiante() {}

    public Estudiante(String cedula, String nombre, float nota1, float nota2) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getNota1() {
        return nota1;
    }

    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    public float getNota2() {
        return nota2;
    }

    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }
}
