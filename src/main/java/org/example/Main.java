package org.example;

import org.example.controladores.Alimentacion;
import org.example.controladores.Empleado;
import org.example.controladores.Hospedaje;
import org.example.controladores.Transporte;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Empleado> empleados = new ArrayList<>();
        ArrayList<Alimentacion> alimentos = new ArrayList<>();
        ArrayList<Hospedaje> hospedajes = new ArrayList<>();
        ArrayList<Transporte> transportes = new ArrayList<>();
        Alimentacion objAlimentacion = null;
        Transporte objTransporte = null;
        Empleado objEmpleado = null;
        Hospedaje objHospedaje = null;

        //Datos de prueba



        Scanner read = new Scanner(System.in);
        System.out.println("\n*****************************************");
        System.out.println("********* BIENVENIDO A VIATIKGU *********");
        System.out.println("*****************************************\n");
        int option;

        do {
            System.out.println("""
                    \s1. Registrar empleado\s
                    2. Registrar viajes (trasnporte, hospedaje, alimentación)\s
                    3. Ver empleados\s
                    4. Ver viajes de un empleado
                    0. Salir\s""");
            option = read.nextInt();

            switch (option) {
                case 0:
                    break;

                case 1:
                    System.out.println("\n******INGRESANDO EMPLEADO*****\n");
                    objEmpleado = new Empleado();
                    objEmpleado.agregarEmpleado();
                    empleados.add(objEmpleado);
                    break;

                case 2:
                    int optionTravel;
                    System.out.println("\n****** Menú para ingresar viajes ******\n");

                    do {
                        System.out.println("""
                              \n1. Ingresar transporte
                                2. Ingresar Alimentacion
                                3. Ingresar hospedaje
                                0. Salir""");
                        optionTravel = read.nextInt();

                        switch (optionTravel) {

                            case 0:
                                System.out.println("Ha elegido salir del programa");
                                break;

                            case 1:
                                System.out.println("\n**** ingresando transporte ****\n");
                                String idEmpleado;
                                System.out.print("Ingrese el documento del empleado: ");
                                idEmpleado = read.next();
                                if (objEmpleado.buscarEmpleado(empleados, idEmpleado) != null) {
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
                                System.out.println("\n**** Ingresando alimentación ****\n");
                                System.out.print("Ingrese el documento del empleado: ");
                                idEmpleado = read.next();
                                if (objEmpleado.buscarEmpleado(empleados, idEmpleado) != null) {
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
                                System.out.println("\n**** Ingresando Hospedaje ****\n");
                                System.out.print("Ingrese el documento del empleado: ");
                                idEmpleado = read.next();

                                if (objEmpleado.buscarEmpleado(empleados, idEmpleado) != null) {
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
                    if (objEmpleado.buscarEmpleado(empleados, idEmpleadoBuscar) != null) {
                        if (!transportes.isEmpty()) {
                            System.out.println("El id del empleado es: " + objEmpleado.getId());
                            System.out.println("Los datos de sus viajes son: \n");
                            System.out.println("Datos transporte:");
                            objTransporte.buscarTransporte(transportes, idEmpleadoBuscar).mostrarTransporte();
                            System.out.println("\nDatos Alimentacion: ");
                            objAlimentacion.buscarAlimentacion(alimentos, idEmpleadoBuscar).mostrarAlimentacion();
                            System.out.println("\nDatos Hospedaje:");
                            objHospedaje.buscarHospedaje(hospedajes, idEmpleadoBuscar).mostrarHospedaje();
                        } else {
                            System.out.println("El empleado existe pero no tiene viajes");
                        }
                    } else {
                        System.out.println("El empleado no existe");
                    }


                    break;

                default:
                    System.out.println("Opcion no valida");
            }


        } while (option != 0);


    }
}