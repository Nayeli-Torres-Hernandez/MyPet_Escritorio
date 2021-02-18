package org.lila_systems.mypet.model;

public class Mascota {
    int id;
    Producto producto;
    String raza;
    String especie;
    String fechaNacimiento;
    String fechaLlegada;

    public Mascota() {
    }

    public Mascota(int id, Producto producto, String raza, String especie, String fechaNacimiento, String fechaLlegada) {
        this.id = id;
        this.producto = producto;
        this.raza = raza;
        this.especie = especie;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaLlegada = fechaLlegada;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public int getId() {
        return id;
    }

    public Producto getProducto() {
        return producto;
    }

    public String getRaza() {
        return raza;
    }

    public String getEspecie() {
        return especie;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

}
