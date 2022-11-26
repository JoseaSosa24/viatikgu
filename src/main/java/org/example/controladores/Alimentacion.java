package org.example.controladores;

public class Alimentacion {

    private String nombreEstablecimiento;
    private String tipoComida;
    private double costoComida;
    private String fechaAlimentacion;
    private String direccionEstablecimiento;

    private String idEmpleado;

    public Alimentacion() {
    }

    public String getNombreEstablecimiento() {
        return nombreEstablecimiento;
    }

    public void setNombreEstablecimiento(String nombreEstablecimiento) {
        this.nombreEstablecimiento = nombreEstablecimiento;
    }

    public String getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }

    public double getCostoComida() {
        return costoComida;
    }

    public void setCostoComida(double costoComida) {
        if (costoComida>0){
            this.costoComida = costoComida;
        }else {
            System.out.println("Valor invalido, digita de nuevo..");
        }
    }

    public String getFechaAlimentacion() {
        return fechaAlimentacion;
    }

    public void setFechaAlimentacion(String fechaAlimentacion) {
        this.fechaAlimentacion = fechaAlimentacion;
    }

    public String getDireccionEstablecimiento() {
        return direccionEstablecimiento;
    }

    public void setDireccionEstablecimiento(String direccionEstablecimiento) {
        this.direccionEstablecimiento = direccionEstablecimiento;
    }
}
