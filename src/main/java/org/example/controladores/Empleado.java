package org.example.controladores;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Empleado {

    String black = "\033[30m", red = "\033[31m", green = "\033[32m", yellow = "\033[33m", blue = "\033[34m", cyan = "\033[36m", reset = "\u001B[0m", purple = "\u001B[35m";

    //ATRIBUTOS
    private String id, nombre, apellido, cargo, rango;
    private double sueldo;

    public Empleado() {
    }

    public Empleado(String id, String nombre, String apellido, String cargo, String rango, double sueldo) {
        this.id = id;
        this.nombre = nombre.toUpperCase();
        this.apellido = apellido.toUpperCase();
        this.cargo = cargo.toUpperCase();
        this.rango = rango.toUpperCase();
        this.sueldo = sueldo;
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

        boolean isNumeric = (id != null && id.matches("[0-9]+"));

        while (id.length() > 10 || !isNumeric) {
            Scanner read = new Scanner(System.in);

            if (id.length() > 10 && isNumeric) {
                System.out.println(this.red + "La longitud de caracteres del id es mayor a la requerida" +
                        " (El numero debe ser menor o igual a 10 digitos)" + reset);
                System.out.println("ingrese nuevamente el numero de documento de identidad");
                id = read.next();
                //isNumeric = (id != null && id.matches("[0-9]+"));

            } else if (!isNumeric) {
                System.out.println(this.red + "Ha ingresado datos no numericos o un numero negativo" + reset);
                System.out.println("ingrese nuevamente el numero de documento de identidad");
                id = read.next();
                isNumeric = (id != null && id.matches("[0-9]+"));

            } else {

                break;
            }



        }
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
        while (sueldo < 0) {
            Scanner read = new Scanner(System.in);
            System.out.println(red + "SUELDO INVÁLIDO" + reset);
            System.out.print("Digite sueldo: ");
            sueldo = read.nextDouble();

        }
        this.sueldo = sueldo;


    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        Scanner read = new Scanner(System.in);
        while (!rango.equals("SENIOR") && !rango.equals("JUNIOR")) {
            System.out.println(this.red + "INGRESE UN RANGO VÁLIDO: JUNIOR o SENIOR" + this.reset);
            System.out.print("Digite rango: ");
            rango = read.next().toUpperCase();
        }
        this.rango = rango.toUpperCase();
    }

    public void agregarEmpleado() {
        Scanner read = new Scanner(System.in);
        System.out.print("Digite Id: ");
        this.setId(read.next());
        System.out.print("Digite nombre: ");
        this.setNombre(read.next().toUpperCase());
        System.out.print("Digite apellido: ");
        this.setApellido(read.next().toUpperCase());
        System.out.print("Digite cargo: ");
        this.setCargo(read.next().toUpperCase());
        System.out.print("Digite rango: ");
        this.setRango(read.next().toUpperCase());
        System.out.print("Digite sueldo: ");
        this.setSueldo(read.nextDouble());
    }

    public Empleado buscarEmpleado(ArrayList<Empleado> empleados, String empleadoABuscar) {
        Empleado empleadoEncontrado = null;

        for (Empleado empleado : empleados) {
            if (empleado.getId().equals(empleadoABuscar)) {
                empleadoEncontrado = empleado;
                break;
            }
        }
        return empleadoEncontrado;
    }


    public void mostrarEmpleado() {
        System.out.println(this.green + "Id: " + this.reset + this.id + this.green + "\nNombre: " + this.reset + this.nombre + this.green + "\nApellido: " + this.reset + this.apellido + this.green + "\nCargo: " + this.reset + this.cargo + this.green + "\nRango: " + this.reset + this.rango + this.green + "\nSueldo: " + this.reset + this.sueldo);
    }

    public void mostrarEmpleado(ArrayList<Empleado> empleados) {
        for (Empleado empleado : empleados) {
            System.out.println(this.green + "\nId: " + this.reset + empleado.id + this.green + "\nNombre: " + this.reset + empleado.nombre + this.green + "\nApellido: " + this.reset + empleado.apellido + this.green + "\nCargo: " + this.reset + empleado.cargo + this.green + "\nRango: " + this.reset + empleado.rango + this.green + "\nSueldo: " + this.reset + empleado.sueldo);
        }
    }


    public void calcularBono(Transporte empleadoTransporte, Empleado empleado) {

        switch (empleado.getRango()) {
            case "JUNIOR":
                if (empleadoTransporte.getAlcanceTransporte().equals("NACIONAL")) {
                    empleado.setSueldo(empleado.getSueldo() + (0.2 * empleado.getSueldo()));
                    System.out.println(this.green + "Se le dará un bono del 20% al " + empleado.cargo + " JUNIOR por viaje nacional\n" + this.reset);
                } else if (empleadoTransporte.getAlcanceTransporte().equals("INTERNACIONAL")) {
                    empleado.setSueldo(empleado.getSueldo() + (0.4 * empleado.getSueldo()));
                    System.out.println(this.green + "Se le dará un bono del 40% al " + empleado.cargo + " JUNIOR por viaje internacional\n" + this.reset);
                }
                break;
            case "SENIOR":
                if (empleadoTransporte.getAlcanceTransporte().equals("NACIONAL")) {
                    empleado.setSueldo(empleado.getSueldo() + (0.3 * empleado.getSueldo()));
                    System.out.println(this.green + "Se le dará un bono del 30% al " + empleado.cargo + " SENIOR por viaje nacional\n" + this.reset);
                } else if (empleadoTransporte.getAlcanceTransporte().equals("INTERNACIONAL")) {
                    empleado.setSueldo(empleado.getSueldo() + (0.5 * empleado.getSueldo()));
                    System.out.println(this.green + "Se le dará un bono del 50% al " + empleado.cargo + " SENIOR por viaje internacional\n" + this.reset);
                }
                break;
        }

    }

}
