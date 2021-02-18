package org.lila_systems.mypet.model;

public class Proveedor {
 private int id;
    private Persona Proveedor;
    private String rfc;
    private String razonSocial;

    public Persona getProveedor() {
        return Proveedor;
    }

    public void setProveedor(Persona Proveedor) {
        this.Proveedor = Proveedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    
}
