package org.example.controladores;

import java.util.ArrayList;
import java.util.Scanner;

public class Transporte {
    private String tipoTransporte;
    private double costoTransporte;
    private String fechaSalida;
    private String fechaRegreso;
    private String ciudadOrigen;
    private String ciudadDestino;
    private String alcanceTransporte;
    private String idEmpleado;

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

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
        if (costoTransporte > 0) {
            this.costoTransporte = costoTransporte;
        } else {
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

    // metodos
    public void agregarTransporte() {
        Scanner read = new Scanner(System.in);
        System.out.print("Ingrese el tipo de transporte: ");
        this.tipoTransporte = read.next();
        System.out.print("Ingrese el costo del trasnporte: ");
        this.costoTransporte = read.nextDouble();
        System.out.print("Ingrese la fecha de salida: ");
        this.fechaSalida = read.next();
        System.out.print("Ingrese la fecha de regreso: ");
        this.fechaRegreso = read.next();
        System.out.print("Ingrese la ciudad de salida: ");
        this.ciudadOrigen = read.next();
        System.out.print("Ingrese la ciudad de Destino: ");
        this.ciudadDestino = read.next();
        System.out.print("Ingrese si el destino es nacional o internacional");
        this.alcanceTransporte = read.next();

    }


    public Alimentacion buscarTransporte(ArrayList<Alimentacion> transportes, String empleadoABuscar) {
        Alimentacion empleadoEncontrado = null;

        for (Alimentacion alimentacion : transportes) {
            if (alimentacion.getIdEmpleado().equals(empleadoABuscar)) {
                empleadoEncontrado = alimentacion;
                break;
            }
        }
        return empleadoEncontrado;
    }
    public void mostrarTransporte(ArrayList<Transporte> transportes) {
        for (Transporte transporte : transportes) {
            System.out.println("\nEl tipo de transporte fue: " + this.tipoTransporte
                    + "\nEl costo del transporte es: " + this.costoTransporte
                    + "\nLa fecha de salida fue : " + this.fechaSalida
                    + "\nLa fecha de llegada es : " + this.fechaRegreso
                    + "\nLa ciudad de origen: " + this.ciudadOrigen
                    + "\nLa ciudad de destino es: " + this.ciudadDestino
                    + "\nEl alcance del viajes es " + this.alcanceTransporte
            );
        }
    }

    public void mostrarTransporte() {
        System.out.println("\nEl tipo de transporte fue: " + this.tipoTransporte
                + "\nEl costo del transporte es: " + this.costoTransporte
                + "\nLa fecha de salida fue : " + this.fechaSalida
                + "\nLa fecha de llegada es : " + this.fechaRegreso
                + "\nLa ciudad de origen: " + this.ciudadOrigen
                + "\nLa ciudad de destino es: " + this.ciudadDestino
                + "\nEl alcance del viajes es " + this.alcanceTransporte
        );
    }
}
