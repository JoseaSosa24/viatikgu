package org.example.controladores;

import java.util.ArrayList;
import java.util.Scanner;

public class Empleado {
    //ATRIBUTOS
    private String nombre;
    private String apellido;
    private String id;
    private String cargo;
    private double sueldo;
    private String rango;

    public Empleado() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {

        if (sueldo > 0) {
            this.sueldo = sueldo;
        } else {
            System.out.println("Sueldo  no valido..");
        }
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public void agregarEmpleado() {
        Scanner read = new Scanner(System.in);
        System.out.print("Digite Id: ");
        this.setId(read.next());
        System.out.print("Digite nombre: ");
        this.setNombre(read.next());
        System.out.print("Digite apellido: ");
        this.setApellido(read.next());
        System.out.print("Digite cargo: ");
        this.setCargo(read.next());
        System.out.print("Digite rango: ");
        this.setRango(read.next());
        System.out.print("Digite sueldo: ");
        this.setSueldo(read.nextDouble());
    }

    public Empleado buscarEmpleado(ArrayList<Empleado> empleados, String empleadoABuscar) {
        Empleado empleadoEncontrado = null;

        for (Empleado empleado : empleados) {
            if (empleado.getId().equals(empleadoABuscar)) {
                empleadoEncontrado = empleado;
            }
        }
        return empleadoEncontrado;
    }

    public void mostrarEmpleado() {
        System.out.println("Id: " + this.id
                + "\nNombre: " + this.nombre
                + "\nApellido: " + this.apellido
                + "\nCargo: " + this.cargo
                + "\nRango: " + this.rango
                + "\nSueldo: " + this.sueldo
        );
    }

    public void mostrarEmpleado(ArrayList<Empleado> empleados) {
        for (Empleado empleado : empleados) {
            System.out.println("\nId: " + this.id
                    + "\nNombre: " + this.nombre
                    + "\nApellido: " + this.apellido
                    + "\nCargo: " + this.cargo
                    + "\nRango: " + this.rango
                    + "\nSueldo: " + this.sueldo+"\n");
        }
    }
}
