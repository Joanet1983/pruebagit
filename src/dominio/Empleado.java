package dominio;

import persistencia.imp.EmpleadoDAOImp;

import java.util.List;

public class Empleado {

    private int codigo;
    private String nombre;
    private String apellidos;
    private String password;

    private EmpleadoDAOImp empleadoDAO;

    public Empleado(int codigo, String nombre, String apellidos, String password) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.password = password;
        this.empleadoDAO = new EmpleadoDAOImp();
    }

    public Empleado() {
        this(0, null, null, null);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Empleado> leerEmpleados() {
        return empleadoDAO.leerEmpleados();
    }

    public boolean actualizarEmpleados(List<Empleado> empleados) {
        return empleadoDAO.actualizarEmpleados(empleados);
    }

}
