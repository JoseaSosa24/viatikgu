package org.example.controladores;

import java.util.ArrayList;
import java.util.Scanner;

public class Hospedaje {

    private String nombre;
    private double costo;
    private String fechaIngreso;
    private String fechaSalida;
    private String direccion;
    private String ciudad;
    private String idEmpleado;

    // constructor vacio
    public Hospedaje() {
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

        if (costo > 0) {
            this.costo = costo;
        } else {
            System.out.println("Valor invalido.. ");
        }
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
        this.ciudad = ciudad;
    }

    // metodos
    public void agregarHospedaje() {
        Scanner read = new Scanner(System.in);
        System.out.print("Ingrese el nombre del lugar de hospedaje: ");
        this.nombre = read.next();
        System.out.print("Ingrese el costo del lugar de hospedaje: ");
        this.costo = read.nextDouble();
        System.out.print("Ingrese la fecha de ingreso: ");
        this.fechaIngreso = read.next();
        System.out.print("Ingrese la fecha de salida: ");
        this.fechaSalida = read.next();
        System.out.print("Ingrese la direccion del lugar de hospedaje: ");
        this.direccion = read.next();
        System.out.println("Ingrese la ciudad del lugar de hospedaje");
        this.ciudad = read.next();
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
}
