import java.sql.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*Creación de un objeto en una la clase "Estudiante" con datos quemados*/
        Estudiante estudianteNuevo = new Estudiante();
        /*Para que el usuario pueda digitar*/
        Scanner  sc = new Scanner(System.in);
        /*Ingreso de datos del usuario*/
        System.out.println("Ingrese la cedula del estudiante (solo inserte numeros):");
        String cedula = sc.nextLine();
        estudianteNuevo.setCedula(cedula);
        System.out.println("Ingrese el nombre del estudiante:");
        String nombre = sc.nextLine();
        estudianteNuevo.setNombre(nombre);
        System.out.println("Ingrese la nota del estudiante en el primer bimestre (coloque con decimales con coma, ej: 15,30, " +
                "recuerde la nota es sobre 20 ):");
        float nota = sc.nextFloat();
        estudianteNuevo.setNota1(nota);
        System.out.println("Ingrese la nota del estudiante en el segundo bimestre (coloque con decimales con coma, ej: 15,30)," +
                "recuerde la nota es sobre 20 ):");
        float nota2 = sc.nextFloat();
        estudianteNuevo.setNota2(nota2);
        /*Linea de conexión*/
        String url = "jdbc:mysql://localhost:3306/clasePoo";
        String usuario = "root";
        String contrasenia = "123456";
        /*¿Qué suscede si la conexión se realiza satisfactoriamente?*/
        try (Connection connection=DriverManager.getConnection(url, usuario, contrasenia)){
            System.out.println("Conectado a la base de datos");
            /*Se coloca la sentencia de inserción de Mysql en una variabe*/
            String insertar = "insert into estudiantes(cedula, nombre, b1, b2) values (?, ?, ?, ?)";
            /*Se define la inserción de Mysql cantes guardada en una variable*/
            PreparedStatement resultadoInsertar = connection.prepareStatement(insertar);
            /*Se llena cada uno de los signos de "?"*/
            resultadoInsertar.setString(1, estudianteNuevo.getCedula());
            resultadoInsertar.setString(2, estudianteNuevo.getNombre());
            resultadoInsertar.setFloat(3, estudianteNuevo.getNota1());
            resultadoInsertar.setFloat(4, estudianteNuevo.getNota2());
            /*Para que se ejecuten los cambios*/
            resultadoInsertar.executeUpdate();
            System.out.println("Se ha insertado correctamente al estudiante nuevo");
        }
        /*¿Qué suscede si la conexión no se realiza satisfactoriamente?*/
        catch (SQLException e){
            System.out.println("Existe un error en la conexión, verificquela");
            System.out.println(e.getMessage());
        }
    }
}