package org.example.controladores;

import java.util.ArrayList;
import java.util.Scanner;

public class Alimentacion {
    String black = "\033[30m", red = "\033[31m", green = "\033[32m", yellow = "\033[33m", blue = "\033[34m", cyan = "\033[36m", reset = "\u001B[0m", purple = "\u001B[35m";
    private String nombreEstablecimiento, tipoComida, fechaAlimentacion, direccionEstablecimiento, idEmpleado;
    private double costoComida;

    public Alimentacion() {
    }

    public Alimentacion(String nombreEstablecimiento, String tipoComida, double costoComida, String fechaAlimentacion, String direccionEstablecimiento, String idEmpleado) {
        this.nombreEstablecimiento = nombreEstablecimiento.toUpperCase();
        this.tipoComida = tipoComida.toUpperCase();
        this.costoComida = costoComida;
        this.fechaAlimentacion = fechaAlimentacion.toUpperCase();
        this.direccionEstablecimiento = direccionEstablecimiento.toUpperCase();
        this.idEmpleado = idEmpleado;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
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
        Scanner read = new Scanner(System.in);
        while (costoComida < 0) {
            System.out.println(red+"COSTO INVÁLIDO"+reset);
            System.out.print("Ingrese el costo de la comida: ");
            costoComida = read.nextDouble();
        }
        this.costoComida = costoComida;
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

    // métodos

    public void agregarAlimentacion() {
        Scanner read = new Scanner(System.in);
        System.out.print("\nDigite el nombre del establecimiento: ");
        this.setNombreEstablecimiento(nombreEstablecimiento = read.next().toUpperCase());
        System.out.print("Ingrese el tipo de comida: ");
        this.setTipoComida(read.next().toUpperCase());
        System.out.print("Ingrese el costo de la comida: ");
        this.setCostoComida(read.nextDouble());
        System.out.print("Ingrese la fecha de la comida: ");
        this.setFechaAlimentacion(read.next().toUpperCase());
        System.out.print("Ingrese la direccion del establecimiento: ");
        this.setDireccionEstablecimiento(read.next().toUpperCase());
    }

    public Alimentacion buscarAlimentacion(ArrayList<Alimentacion> alimentaciones, String empleadoABuscar) {
        Alimentacion empleadoEncontrado = null;

        for (Alimentacion alimentacion : alimentaciones) {
            if (alimentacion.getIdEmpleado().equals(empleadoABuscar)) {
                empleadoEncontrado = alimentacion;
                break;
            }
        }
        return empleadoEncontrado;
    }

    public void mostrarAlimentacion() {
        System.out.println("\nLugar alimentación: " + this.nombreEstablecimiento
                + "\nTipo comida: " + this.tipoComida
                + "\nCosto: " + this.costoComida
                + "\nFecha Comida: " + this.fechaAlimentacion
                + "\nDirección: " + this.direccionEstablecimiento + "\n"
        );
    }

    public void mostrarAlimentacion(ArrayList<Alimentacion> alimentaciones) {
        for (Alimentacion alimentacion : alimentaciones) {
            System.out.println("Lugar alimentación: " + alimentacion.nombreEstablecimiento
                    + "\nTipo comida: " + alimentacion.tipoComida
                    + "\nCosto: " + alimentacion.costoComida
                    + "\nFecha Comida: " + alimentacion.fechaAlimentacion
                    + "\nDirección: " + alimentacion.direccionEstablecimiento + "\n"
            );
        }

    }

    public void mostrarAlimentacion(ArrayList<Alimentacion> alimentaciones, String idEmpleadoViajero) {
        for (Alimentacion alimentacion : alimentaciones) {
            if (alimentacion.getIdEmpleado().equals(idEmpleadoViajero))
                System.out.println("\nLugar alimentación: " + alimentacion.nombreEstablecimiento
                        + "\nTipo comida: " + alimentacion.tipoComida
                        + "\nCosto: " + alimentacion.costoComida
                        + "\nFecha Comida: " + alimentacion.fechaAlimentacion
                        + "\nDirección: " + alimentacion.direccionEstablecimiento + "\n"
                );
        }
    }


}




