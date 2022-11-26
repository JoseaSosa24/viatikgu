package org.example;

import org.example.controladores.Alimentacion;
import org.example.controladores.Empleado;
import org.example.controladores.Hospedaje;
import org.example.controladores.Transporte;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        ArrayList<Alimentacion> alimentos = new ArrayList<Alimentacion>();
        ArrayList<Hospedaje> hospedajes = new ArrayList<Hospedaje>();
        ArrayList<Transporte> transportes = new ArrayList<Transporte>();
        Alimentacion objAlimentacion = null;
        Transporte objTransporte = null;
        Empleado objEmpleado = null;
        Hospedaje objHospedaje = null;

        Scanner read = new Scanner(System.in);
        System.out.println("********* Aplicación de viáticos *********");
        int option;

        do {
            System.out.println("1. Registrar empleado \n" +
                    "2. Registrar viajes (trasnporte, hospedaje, alimentación) \n" +
                    "3. Ver empleados \n" +
                    "4. Ver viajes de un empleado\n" +
                    "0. Salir ");
            option = read.nextInt();

            switch (option) {
                case 0:
                    break;

                case 1:
                    System.out.println("******INGRESANDO EMPLEADO*****\n");
                    objEmpleado = new Empleado();
                    objEmpleado.agregarEmpleado();
                    empleados.add(objEmpleado);
                    break;

                case 2:
                    int optionTravel;
                    System.out.println("****** Menú para ingresar viajes ******");

                    do {
                        System.out.println("1. Ingresar transporte\n" +
                                "2. Ingresar Alimentacion\n" +
                                "3. Ingresar hospedaje\n" +
                                "0. Salir");
                        optionTravel = read.nextInt();

                        switch (optionTravel) {

                            case 0:
                                System.out.println("Ha elegido salir del programa");
                                break;

                            case 1:
                                System.out.println("**** ingresando transporte ****");
                                String idEmpleado;
                                System.out.println("Ingrese el documento del empleado");
                                idEmpleado = read.next();
                                if(objEmpleado.buscarEmpleado(empleados, idEmpleado) != null){
                                    objTransporte = new Transporte();
                                    objTransporte.setIdEmpleado(idEmpleado);
                                    objTransporte.agregarTransporte();
                                    transportes.add(objTransporte);

                                } else {
                                    System.out.println("El empleado no existe, no se le puede asignar" +
                                            " trasnporte");
                                }

                                break;

                            case 2:
                                System.out.println("**** Ingresando alimentación ****");
                                System.out.println("Ingrese el documento del empleado");
                                idEmpleado = read.next();
                                if(objEmpleado.buscarEmpleado(empleados, idEmpleado) != null){
                                    objAlimentacion = new Alimentacion();
                                    objAlimentacion.setIdEmpleado(idEmpleado);
                                    objAlimentacion.agregarAlimentacion();
                                    alimentos.add(objAlimentacion);

                                } else {
                                    System.out.println("El empleado no existe, no se le puede asignar" +
                                            " alimentacion");
                                }

                                break;

                            case 3:
                                System.out.println("**** Ingresando Hospedaje ****");
                                System.out.println("Ingrese el documento del empleado");
                                idEmpleado = read.next();

                                if(objEmpleado.buscarEmpleado(empleados, idEmpleado) != null){
                                    objHospedaje = new Hospedaje();
                                    objHospedaje.setIdEmpleado(idEmpleado);
                                    objHospedaje.agregarHospedaje();
                                    hospedajes.add(objHospedaje);

                                } else {
                                    System.out.println("El empleado no existe, no se le puede asignar" +
                                            " un hospedaje");
                                }
                                break;

                            default:
                                System.out.println("Opción no valida");

                        }

                    } while (optionTravel != 0);

                    break;

                case 3:
                    objEmpleado.mostrarEmpleado(empleados);
                    break;
                case 4:
                    System.out.println("Ingrese el id del empleado");
                    String idEmpleadoBuscar = read.next();
                    if(objEmpleado.buscarEmpleado(empleados, idEmpleadoBuscar) != null){
                        System.out.println("El id del empleado es: " + objEmpleado.getId());
                        objTransporte.mostrarTransporte(transportes);


                    }
                    
                    break;

                default:
                    System.out.println("Opcion no valida");
            }


        } while (option != 0);


    }
}