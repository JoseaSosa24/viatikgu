package org.example.controladores;

public class Transporte {
    private String tipoTransporte;
    private double costoTransporte;
    private String fechaSalida;
    private String fechaRegreso;
    private String ciudadOrigen;
    private String ciudadDestino;
    private String alcanceTransporte;

    public Transporte() {
    }

    public String getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(String tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

    public double getCostoTransporte() {
        return costoTransporte;
    }

    public void setCostoTransporte(double costoTransporte) {
       if (costoTransporte>0){
           this.costoTransporte = costoTransporte;
       }else{
           System.out.println("El valor es invalido..");
       }
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFechaRegreso() {
        return fechaRegreso;
    }

    public void setFechaRegreso(String fechaRegreso) {
        this.fechaRegreso = fechaRegreso;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public String getAlcanceTransporte() {
        return alcanceTransporte;
    }

    public void setAlcanceTransporte(String alcanceTransporte) {
        this.alcanceTransporte = alcanceTransporte;
    }
}
