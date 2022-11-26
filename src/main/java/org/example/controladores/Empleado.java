package org.example.controladores;

import java.util.ArrayList;

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

    public Empleado buscarEmpleado(ArrayList<Empleado> empleados, String empleadoABuscar) {
        Empleado empleadoEncontrado = null;

        for (Empleado empleado : empleados) {
            if (empleado.getId().equals(empleadoABuscar)) {
                empleadoEncontrado = empleado;
            }
        }
        return empleadoEncontrado;
    }

}
