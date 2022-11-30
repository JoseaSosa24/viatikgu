package org.example.controladores;

import java.util.ArrayList;
import java.util.Scanner;

public class Hospedaje {
    String black = "\033[30m", red = "\033[31m", green = "\033[32m", yellow = "\033[33m", blue = "\033[34m", cyan = "\033[36m", reset = "\u001B[0m", purple = "\u001B[35m";

    private String nombre, fechaIngreso, fechaSalida, direccion, ciudad, idEmpleado;
    private double costo;

    public Hospedaje() {
    }

    public Hospedaje(String nombre, double costo, String fechaIngreso, String fechaSalida, String direccion, String ciudad, String idEmpleado) {
        this.nombre = nombre.toUpperCase();
        this.costo = costo;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.direccion = direccion.toUpperCase();
        this.ciudad = ciudad.toUpperCase();
        this.idEmpleado = idEmpleado;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {

        Scanner read = new Scanner(System.in);
        while (costo < 0) {
            System.out.println(this.red + "COSTO INVÁLIDO" + this.reset);
            System.out.print("Ingrese el costo del lugar de hospedaje: ");
            costo = read.nextDouble();
        }
        this.costo = costo;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad.toUpperCase();
    }

    // metodos
    public void agregarHospedaje() {
        Scanner read = new Scanner(System.in);
        System.out.print("Ingrese el nombre del lugar de hospedaje: ");
        this.setNombre (read.next().toUpperCase());
        System.out.print("Ingrese el costo del lugar de hospedaje: ");
        this.setCosto(read.nextDouble());
        System.out.print("Ingrese la fecha de ingreso: ");
        this.setFechaIngreso (read.next().toUpperCase());
        System.out.print("Ingrese la fecha de salida: ");
        this.setFechaSalida(read.next());
        System.out.print("Ingrese la direccion del lugar de hospedaje: ");
        this.setDireccion(read.next().toUpperCase());
        System.out.print("Ingrese la ciudad del lugar de hospedaje: ");
        this.setCiudad (read.next().toUpperCase());
    }

    public Hospedaje buscarHospedaje(ArrayList<Hospedaje> hospedajes, String empleadoABuscar) {
        Hospedaje empleadoEncontrado = null;

        for (Hospedaje hospedaje : hospedajes) {
            if (hospedaje.getIdEmpleado().equals(empleadoABuscar)) {
                empleadoEncontrado = hospedaje;
                break;
            }
        }
        return empleadoEncontrado;
    }

    public void mostrarHospedaje() {
        System.out.println("\nLugar de Hospedaje: " + this.nombre
                + "\nCosto: " + this.costo
                + "\nFecha Ingreso: " + this.fechaIngreso
                + "\nFecha Salida: " + this.fechaSalida
                + "\nDirección: " + this.direccion
                + "\nCiudad: " + this.ciudad + "\n"
        );
    }

    public void mostrarHospedaje(ArrayList<Hospedaje> hospedajes) {

        for (Hospedaje hospedaje : hospedajes) {
            System.out.println("Lugar de Hospedaje: " + hospedaje.nombre
                    + "\nCosto: " + hospedaje.costo
                    + "\nFecha Ingreso: " + hospedaje.fechaIngreso
                    + "\nFecha Salida: " + hospedaje.fechaSalida
                    + "\nDirección: " + hospedaje.direccion
                    + "\nCiudad: " + hospedaje.ciudad + "\n"
            );
        }
    }

}
