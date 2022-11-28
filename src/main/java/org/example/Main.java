package org.example;

import org.example.controladores.Alimentacion;
import org.example.controladores.Empleado;
import org.example.controladores.Hospedaje;
import org.example.controladores.Transporte;


import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        ArrayList<Empleado> empleados = new ArrayList<>();
        ArrayList<Alimentacion> alimentos = new ArrayList<>();
        ArrayList<Hospedaje> hospedajes = new ArrayList<>();
        ArrayList<Transporte> transportes = new ArrayList<>();
        Alimentacion objAlimentacion;
        Transporte objTransporte;
        Empleado objEmpleado;
        Hospedaje objHospedaje;

        //Datos de prueba
        Empleado e1 = new Empleado("1", "Carly", "Kaines", "BackDeveloper", "JUNIOR", 1000000);
        Empleado e2 = new Empleado("2", "Wildon", "Sapson", "FronDeveloper", "SENIOR", 685973);
        Empleado e3 = new Empleado("3", "Nanice", "Mascall", "FronDeveloper", "SENIOR", 19046);
        Empleado e4 = new Empleado("4", "Garry", "Wooffitt", "Desarrollador", "JUNIOR", 768036);
        Empleado e5 = new Empleado("5", "Tina", "Lyndon", "Desarrollador", "JUNIOR", 203358);
        Empleado e6 = new Empleado("6", "Kellyann", "Ledward", "FronDeveloper", "JUNIOR", 582416);
        empleados.add(e1);
        empleados.add(e2);
        empleados.add(e3);
        empleados.add(e4);
        empleados.add(e5);
        empleados.add(e6);


        Scanner read = new Scanner(System.in);
        System.out.println("\n*****************************************");
        System.out.println("********* BIENVENIDO A VIATIKGU *********");
        System.out.println("*****************************************\n");
        int option;

        do {
            System.out.println("\n     *********MENÚ PRINCIPAL********\n");
            System.out.println("""
                    1. Registrar empleado\s
                    2. Registrar viajes (transporte, hospedaje, alimentación)\s
                    3. Ver empleados\s
                    4. Ver viajes de un empleado (trasporte, hospedaje, alimentacion)\s
                    5. Buscar un empleado\s
                    0. Salir\s""");
            option = read.nextInt();

            switch (option) {
                case 0:
                    break;

                case 1:
                    System.out.println("\n******INGRESANDO EMPLEADO*****\n");
                    objEmpleado = new Empleado();
                    objEmpleado.agregarEmpleado();
                    if (objEmpleado.buscarEmpleado(empleados, objEmpleado.getId()) == null) {
                        empleados.add(objEmpleado);
                        System.out.print("\n¡Empleado agregado correctamente!\n");
                    } else {
                        System.out.println("\nEl empleado con esa ID, YA existe");
                    }
                    break;

                case 2:
                    int optionTravel;
                    System.out.println("\n****** Menú para ingresar viajes ******\n");
                    System.out.print("Ingrese el id del empleado para asignarle viaticos: ");
                    String idEmpleado = read.next();
                    objEmpleado = new Empleado();
                    Empleado empleadoEncontrado = objEmpleado.buscarEmpleado(empleados, idEmpleado);
                    if (empleadoEncontrado != null) {
                        boolean banderaTransporte = false, banderaAlimentacion = false, banderaHospedaje = false;
//                        int contTransporte = 0, contAlimentacion = 0, contHospedaje = 0;
                        int swViajes = 0;

                        System.out.println("\nDatos del EMPLEADO: ");
                        empleadoEncontrado.mostrarEmpleado();

                        do {
                            System.out.println("\n**** INGRESANDO VIATICOS ****");
                            System.out.println("\n" + """
                                    1. Ingresar Transporte
                                    2. Ingresar Alimentacion
                                    3. Ingresar Hospedaje
                                    0. Salir""");
                            optionTravel = read.nextInt();

                            switch (optionTravel) {

                                case 0:
                                    if (banderaTransporte && banderaAlimentacion && banderaHospedaje && swViajes == 1) {
                                        System.out.println("\nVolviendo al menú principal...");
                                    } else {
                                        System.out.println("\nLe faltan viaticos por entrar de este viaje");
                                    }
                                    System.out.println("\n-->Presione ENTER para continuar<--");
                                    System.in.read();
                                    break;

                                case 1:
                                    if (banderaTransporte) {
                                        System.out.print("Antes de registrar nuevamente un Transporte, debe terminar el registro COMPLETO del viaje actual\n");
                                    } else {
                                        swViajes++;
                                        System.out.println("\n**** Ingresando transporte ****\n");
                                        objTransporte = new Transporte();
                                        objTransporte.setIdEmpleado(idEmpleado);
                                        objTransporte.agregarTransporte();
                                        transportes.add(objTransporte);
                                        banderaTransporte = true;
                                        System.out.println("\n¡Transporte agregado exitosamente!");


                                        Transporte transporte = objTransporte.buscarTransporte(transportes, idEmpleado);
                                        if (empleadoEncontrado.getRango().equals("JUNIOR") && transporte.getAlcanceTransporte().equals("NACIONAL")) {
                                            empleadoEncontrado.setSueldo(empleadoEncontrado.getSueldo() + (0.2 * empleadoEncontrado.getSueldo()));
                                            System.out.println("Se le dará un bono del 20% al analista junior por viaje nacional\n");

                                        } else if (empleadoEncontrado.getRango().equals("JUNIOR") && transporte.getAlcanceTransporte().equals("INTERNACIONAL")) {
                                            empleadoEncontrado.setSueldo(empleadoEncontrado.getSueldo() + (0.4 * empleadoEncontrado.getSueldo()));
                                            System.out.println("Se le dará un bono del 40% al analista junior por viaje internacional\n");

                                        } else if (empleadoEncontrado.getRango().equals("SENIOR") && transporte.getAlcanceTransporte().equals("NACIONAL")) {
                                            empleadoEncontrado.setSueldo(empleadoEncontrado.getSueldo() + (0.3 * empleadoEncontrado.getSueldo()));
                                            System.out.println("Se le dará un bono del 30% al analista senior por viaje nacional\n");

                                        } else if (empleadoEncontrado.getRango().equals("SENIOR") && transporte.getAlcanceTransporte().equals("INTERNACIONAL")) {
                                            empleadoEncontrado.setSueldo(empleadoEncontrado.getSueldo() + (0.5 * empleadoEncontrado.getSueldo()));
                                            System.out.println("Se le dará un bono del 50% al analista senior por viaje internacional\n");

                                        }
                                    }
                                    System.out.println("\n-->Presione ENTER para continuar<--");
                                    System.in.read();
                                    break;

                                case 2:
                                    if (banderaAlimentacion) {
                                        System.out.print("Antes de registrar nuevamente una Alimentación, debe terminar el registro COMPLETO del viaje actual\n");
                                    } else if (banderaTransporte) {
                                        System.out.println("\n**** Ingresando Alimentación ****");
                                        objAlimentacion = new Alimentacion();
                                        objAlimentacion.setIdEmpleado(idEmpleado);
                                        objAlimentacion.agregarAlimentacion();
                                        alimentos.add(objAlimentacion);
                                        banderaAlimentacion = true;
                                        System.out.println("\n¡Alimentación agregada exitosamente!");
                                    } else {
                                        System.out.print("\nDebe ingresar viaticos de transporte primero");
                                    }
                                    System.out.println("\n-->Presione ENTER para continuar<--");
                                    System.in.read();
                                    break;

                                case 3:
                                    if (banderaHospedaje) {
                                        System.out.print("Antes de registrar nuevamente un Hospedaje, debe terminar el registro COMPLETO del viaje actual\n");
                                    } else if (banderaAlimentacion) {
                                        System.out.println("\n**** Ingresando Hospedaje ****\n");
                                        objHospedaje = new Hospedaje();
                                        objHospedaje.setIdEmpleado(idEmpleado);
                                        objHospedaje.agregarHospedaje();
                                        hospedajes.add(objHospedaje);
                                        banderaHospedaje = true;
//                                    contHospedaje++;
                                        System.out.println("\n¡Hospedaje agregado exitosamente!");
                                    } else {
                                        System.out.print("\nDebe ingresar viaticos de Alimentación primero");
                                    }
                                    System.out.println("\n-->Presione ENTER para continuar<--");
                                    System.in.read();
                                    break;
                                default:
                                    System.out.println("\nOpción no valida\n");
                            }
                            if (banderaTransporte && banderaAlimentacion && banderaHospedaje) {
                                System.out.print("\n¡Los viaticos(transporte, hospedaje, alimentación) de este viaje para el empleado " + empleadoEncontrado.getNombre() + " han sido agregados extitosamente!\n");
                                System.out.print("\n¿Desea Registrarle otro viaje a este empleado? 1:SÍ 0:NO: ");
                                optionTravel = read.nextInt();
                                if (optionTravel==1){
                                    swViajes = 0;
                                    banderaTransporte = false;
                                    banderaAlimentacion = false;
                                    banderaHospedaje = false;
                                }

                            }

                        } while (optionTravel != 0 || !banderaTransporte && !banderaAlimentacion  && !banderaHospedaje);


//                        while ((optionTravel != 0) || ((contTransporte < contHospedaje) || (contHospedaje < contAlimentacion) || (contTransporte < contAlimentacion) || (contHospedaje < contTransporte) || (contAlimentacion < contHospedaje)));

                    } else {
                        System.out.println("\nEl empleado no existe, NO se le puede asignar viaticos\n");
                    }

                    break;

                case 3:
                    System.out.println("\n-------MOSTRANDO EMPLEADOS----------");
                    objEmpleado = new Empleado();
                    objEmpleado.mostrarEmpleado(empleados);
                    System.out.println("\n------------------------------------\n");
                    break;
                case 4:
                    System.out.print("\nIngrese el id del empleado a mostrar viajes: ");
                    String idEmpleadoBuscar = read.next();
                    objEmpleado = new Empleado();
                    objTransporte =new Transporte();
                    Empleado empleado=objEmpleado.buscarEmpleado(empleados,idEmpleadoBuscar);
                    Transporte empleadoTransporte;
                    empleadoTransporte = objTransporte.buscarTransporte(transportes, idEmpleadoBuscar);
                    if (empleado!= null) {
                        objTransporte = new Transporte();
                        if (empleadoTransporte!=null) {
                            System.out.println("El id del empleado es: " + empleadoTransporte.getIdEmpleado());
                            System.out.println("Los datos de sus viajes son: \n");
                            System.out.println("Datos transporte:");
                            objAlimentacion = new Alimentacion();
                            objHospedaje = new Hospedaje();
                            objTransporte.buscarTransporte(transportes, idEmpleadoBuscar).mostrarTransporte(transportes);
                            System.out.println("\nDatos Alimentacion: ");
                            objAlimentacion.buscarAlimentacion(alimentos, idEmpleadoBuscar).mostrarAlimentacion(alimentos);
                            System.out.println("\nDatos Hospedaje:");
                            objHospedaje.buscarHospedaje(hospedajes, idEmpleadoBuscar).mostrarHospedaje(hospedajes);
                        } else {
                            System.out.println("\nEl empleado existe pero no tiene viajes realizados\n");
                        }
                    } else {
                        System.out.println("\nEl empleado NO existe\n");
                    }
                    break;
                case 5:

                    break;
                default:
                    System.out.println("Opcion no valida");
            }


        } while (option != 0);


    }
}