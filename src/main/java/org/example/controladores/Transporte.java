package org.example.controladores;

import java.util.ArrayList;
import java.util.Scanner;

public class Transporte {
    String black = "\033[30m", red = "\033[31m", green = "\033[32m", yellow = "\033[33m", blue = "\033[34m", cyan = "\033[36m", reset = "\u001B[0m", purple = "\u001B[35m";
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


    public Transporte(String tipoTransporte, double costoTransporte, String fechaSalida, String fechaRegreso, String ciudadOrigen, String ciudadDestino, String alcanceTransporte, String idEmpleado) {
        this.tipoTransporte = tipoTransporte;
        this.costoTransporte = costoTransporte;
        this.fechaSalida = fechaSalida;
        this.fechaRegreso = fechaRegreso;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.alcanceTransporte = alcanceTransporte;
        this.idEmpleado = idEmpleado;
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
        while (costoTransporte < 0) {
            Scanner read = new Scanner(System.in);
            System.out.println(this.red+"COSTO INVÁLIDO"+reset);
            System.out.print("Ingrese el costo del transporte: ");
            costoTransporte = read.nextDouble();
        }
        this.costoTransporte = costoTransporte;


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
        Scanner read = new Scanner(System.in);
        while (!alcanceTransporte.equals("NACIONAL") && !alcanceTransporte.equals("INTERNACIONAL")) {
            System.out.println(this.red + "INGRESE UN DESTINO VÁLIDO: NACIONAL o INTERNACIONAL" + this.reset);
            System.out.print("Ingrese si el destino es Nacional o Internacional: ");
            alcanceTransporte = read.next().toUpperCase();
        }
        this.alcanceTransporte = alcanceTransporte.toUpperCase();
    }

    // metodos
    public void agregarTransporte() {
        Scanner read = new Scanner(System.in);
        System.out.print("Ingrese el tipo de transporte: ");
        this.setTipoTransporte(read.next().toUpperCase());
        System.out.print("Ingrese el costo del transporte: ");
        this.setCostoTransporte(read.nextDouble());
        System.out.print("Ingrese la fecha de salida: ");
        this.setFechaSalida(read.next().toUpperCase());
        System.out.print("Ingrese la fecha de regreso: ");
        this.setFechaRegreso (read.next().toUpperCase());
        System.out.print("Ingrese la ciudad de salida: ");
        this.setCiudadOrigen(read.next().toUpperCase());
        System.out.print("Ingrese la ciudad de Destino: ");
        this.setCiudadDestino(read.next().toUpperCase());
        System.out.print("Ingrese si el destino es Nacional o Internacional: ");
        this.setAlcanceTransporte(read.next().toUpperCase());

    }


    public Transporte buscarTransporte(ArrayList<Transporte> transportes, String empleadoABuscar) {
        Transporte empleadoEncontrado = null;

        for (Transporte transporte : transportes) {
            if (transporte.getIdEmpleado().equals(empleadoABuscar)) {
                empleadoEncontrado = transporte;
                break;
            }
        }
        return empleadoEncontrado;
    }

    public void mostrarTransporte(ArrayList<Transporte> transportes) {
        for (Transporte transporte : transportes) {
            System.out.println("El tipo de transporte fue: " + transporte.tipoTransporte
                    + "\nEl costo del transporte es: " + transporte.costoTransporte
                    + "\nLa fecha de salida fue : " + transporte.fechaSalida
                    + "\nLa fecha de llegada es : " + transporte.fechaRegreso
                    + "\nLa ciudad de origen: " + transporte.ciudadOrigen
                    + "\nLa ciudad de destino es: " + transporte.ciudadDestino
                    + "\nEl alcance del viajes es " + transporte.alcanceTransporte+"\n"
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
