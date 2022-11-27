package org.example.controladores;

import java.util.ArrayList;
import java.util.Scanner;

public class Alimentacion {

    private String nombreEstablecimiento;
    private String tipoComida;
    private double costoComida;
    private String fechaAlimentacion;
    private String direccionEstablecimiento;
    private String idEmpleado;


    public Alimentacion() {
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
        if (costoComida > 0) {
            this.costoComida = costoComida;
        } else {
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

    // métodos

    public void agregarAlimentacion() {
        Scanner read = new Scanner(System.in);
        System.out.print("Digite el nombre del establecimiento ");
        this.nombreEstablecimiento = read.next();
        System.out.print("Ingrese el tipo de comida");
        this.tipoComida = read.next();
        System.out.print("Ingrese el costo de la comida");
        this.costoComida = read.nextDouble();
        System.out.print("Ingrese la fecha de la comida");
        this.fechaAlimentacion = read.next();
        System.out.print("Ingrese la direccion del establecimiento");
        this.direccionEstablecimiento = read.next();
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
            System.out.println("\nLugar alimentación: " + this.nombreEstablecimiento
                    + "\nTipo comida: " + this.tipoComida
                    + "\nCosto: " + this.costoComida
                    + "\nFecha Comida: " + this.fechaAlimentacion
                    + "\nDirección: " + this.direccionEstablecimiento + "\n"
            );
        }

    }

}




