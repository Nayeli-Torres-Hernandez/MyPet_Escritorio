package org.lila_systems.mypet.model;

public class Empleado {
    private int id;
    private Persona Empleado;
    private String correo;
    private String contrasenia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Persona getEmpleado() {
        return Empleado;
    }

    public void setEmpleado(Persona Empleado) {
        this.Empleado = Empleado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
}