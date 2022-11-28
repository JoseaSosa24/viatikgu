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
        String black = "\033[30m", red = "\033[31m", green = "\033[32m", yellow = "\033[33m", blue = "\033[34m",
                cyan = "\033[36m", reset = "\u001B[0m", purple = "\u001B[35m";

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
        System.out.println(cyan+"\n*****************************************");
        System.out.println("********* BIENVENIDO A VIATIKGU *********");
        System.out.println("*****************************************\n"+reset);
        int option;

        do {
            System.out.println(cyan+"\n     *********MENÚ PRINCIPAL********\n");
            System.out.println("""
                    1. Registrar empleado\s
                    2. Registrar viajes (transporte, hospedaje, alimentación)\s
                    3. Ver empleados\s
                    4. Ver viajes de un empleado (trasporte, hospedaje, alimentacion)\s
                    5. Buscar un empleado\s
                    0. Salir\s"""+reset);
            option = read.nextInt();

            switch (option) {
                case 0:
                    break;

                case 1:
                    System.out.println(purple+"\n******INGRESANDO EMPLEADO*****\n"+reset);
                    objEmpleado = new Empleado();
                    objEmpleado.agregarEmpleado();
                    if (objEmpleado.buscarEmpleado(empleados, objEmpleado.getId()) == null) {
                        empleados.add(objEmpleado);
                        System.out.print(green+"\n¡Empleado agregado correctamente!\n"+reset);
                    } else {
                        System.out.println(yellow+"\nEl empleado con esa ID, YA existe"+reset);
                    }
                    break;

                case 2:
                    int optionTravel;
                    System.out.println(cyan+"\n****** Menú para ingresar viajes ******\n"+reset);
                    System.out.print(purple+"Ingrese el id del empleado para asignarle viaticos: "+purple);
                    String idEmpleado = read.next();
                    objEmpleado = new Empleado();
                    Empleado empleadoEncontrado = objEmpleado.buscarEmpleado(empleados, idEmpleado);
                    if (empleadoEncontrado != null) {
                        boolean banderaTransporte = false, banderaAlimentacion = false, banderaHospedaje = false;
//                        int contTransporte = 0, contAlimentacion = 0, contHospedaje = 0;
                        int swViajes = 0;

                        System.out.println(green+"\nDatos del EMPLEADO: ");
                        empleadoEncontrado.mostrarEmpleado();

                        do {
                            System.out.println(purple+"\n**** INGRESANDO VIATICOS ****"+reset);
                            System.out.println(purple+"\n" + """
                                    1. Ingresar Transporte
                                    2. Ingresar Alimentacion
                                    3. Ingresar Hospedaje
                                    0. Salir"""+reset);
                            optionTravel = read.nextInt();

                            switch (optionTravel) {

                                case 0:
                                    if (banderaTransporte && banderaAlimentacion && banderaHospedaje && swViajes == 1) {
                                        System.out.println(green+"\nVolviendo al menú principal..."+reset);
                                    } else {
                                        System.out.println(yellow+"\nADVERTENCIA: Le faltan viaticos por entrar de este viaje"+reset);
                                    }
                                    System.out.println("\n-->Presione ENTER para continuar<--");
                                    System.in.read();
                                    break;

                                case 1:
                                    if (banderaTransporte) {
                                        System.out.print(yellow+"ADVERTENCIA: Antes de registrar nuevamente un Transporte, debe terminar el registro COMPLETO del viaje actual\n"+reset);
                                    } else {
                                        swViajes++;
                                        System.out.println(purple+"\n**** Ingresando transporte ****\n"+reset);
                                        objTransporte = new Transporte();
                                        objTransporte.setIdEmpleado(idEmpleado);
                                        objTransporte.agregarTransporte();
                                        transportes.add(objTransporte);
                                        banderaTransporte = true;
                                        System.out.println(green+"\n¡Transporte agregado exitosamente!"+reset);
                                        Transporte transporte = objTransporte.buscarTransporte(transportes, idEmpleado);
                                        empleadoEncontrado.calcularBono(transporte,empleadoEncontrado);
                                    }
                                    System.out.println("\n-->Presione ENTER para continuar<--");
                                    System.in.read();
                                    break;

                                case 2:
                                    if (banderaAlimentacion) {
                                        System.out.print(yellow+"ADVERTENCIA: Antes de registrar nuevamente una Alimentación, debe terminar el registro COMPLETO del viaje actual\n"+reset);
                                    } else if (banderaTransporte) {
                                        System.out.println(purple+"\n**** Ingresando Alimentación ****"+reset);
                                        objAlimentacion = new Alimentacion();
                                        objAlimentacion.setIdEmpleado(idEmpleado);
                                        objAlimentacion.agregarAlimentacion();
                                        alimentos.add(objAlimentacion);
                                        banderaAlimentacion = true;
                                        System.out.println(green+"\n¡Alimentación agregada exitosamente!"+reset);
                                    } else {
                                        System.out.print(yellow+"\nDebe ingresar viaticos de transporte primero"+reset);
                                    }
                                    System.out.println("\n-->Presione ENTER para continuar<--");
                                    System.in.read();
                                    break;

                                case 3:
                                    if (banderaHospedaje) {
                                        System.out.print(yellow+"ADVERTENCIA: Antes de registrar nuevamente un Hospedaje, debe terminar el registro COMPLETO del viaje actual\n"+reset);
                                    } else if (banderaAlimentacion) {
                                        System.out.println(purple+"\n**** Ingresando Hospedaje ****\n"+reset);
                                        objHospedaje = new Hospedaje();
                                        objHospedaje.setIdEmpleado(idEmpleado);
                                        objHospedaje.agregarHospedaje();
                                        hospedajes.add(objHospedaje);
                                        banderaHospedaje = true;
//                                    contHospedaje++;
                                        System.out.println(green+"\n¡Hospedaje agregado exitosamente!"+reset);
                                    } else {
                                        System.out.print(yellow+"\nDebe ingresar viaticos de Alimentación primero"+reset);
                                    }
                                    System.out.println("\n-->Presione ENTER para continuar<--");
                                    System.in.read();
                                    break;
                                default:
                                    System.err.println("\nOpción no valida\n");
                            }
                            if (banderaTransporte && banderaAlimentacion && banderaHospedaje) {
                                System.out.print(green+"\n¡Los viaticos(transporte, hospedaje, alimentación) de este viaje para el empleado " + empleadoEncontrado.getNombre() + " han sido agregados extitosamente!\n"+reset);
                                System.out.print("\n¿Desea Registrarle otro viaje a este empleado? 1:SÍ 0:NO: ");
                                optionTravel = read.nextInt();
                                if (optionTravel == 1) {
                                    swViajes = 0;
                                    banderaTransporte = false;
                                    banderaAlimentacion = false;
                                    banderaHospedaje = false;
                                }

                            }

                        } while (optionTravel != 0 || (banderaTransporte && banderaAlimentacion && banderaHospedaje));
//                        while ((optionTravel != 0) || ((contTransporte < contHospedaje) || (contHospedaje < contAlimentacion) || (contTransporte < contAlimentacion) || (contHospedaje < contTransporte) || (contAlimentacion < contHospedaje)));

                    } else {
                        System.err.println("\nEl empleado no existe, NO se le puede asignar viaticos\n");
                    }

                    break;

                case 3:
                    System.out.println(purple+"\n-------MOSTRANDO EMPLEADOS----------"+reset);
                    objEmpleado = new Empleado();
                    objEmpleado.mostrarEmpleado(empleados);
                    System.out.println(purple+"\n------------------------------------\n"+reset);
                    break;
                case 4:
                    System.out.print(purple+"\nIngrese el id del empleado a mostrar viajes: "+reset);
                    String idEmpleadoBuscar = read.next();
                    objEmpleado = new Empleado();
                    objTransporte = new Transporte();
                    Empleado empleado = objEmpleado.buscarEmpleado(empleados, idEmpleadoBuscar);
                    Transporte empleadoTransporte;
                    empleadoTransporte = objTransporte.buscarTransporte(transportes, idEmpleadoBuscar);
                    if (empleado != null) {
                        objTransporte = new Transporte();
                        if (empleadoTransporte != null) {
                            System.out.println("El id del empleado es: " + empleadoTransporte.getIdEmpleado());
                            System.out.println(purple+"Los datos de sus viajes son: \n"+reset);
                            System.out.println(green+"Datos transporte:"+reset);
                            objAlimentacion = new Alimentacion();
                            objHospedaje = new Hospedaje();
                            objTransporte.buscarTransporte(transportes, idEmpleadoBuscar).mostrarTransporte(transportes);
                            System.out.println(green+"\nDatos Alimentacion: "+reset);
                            objAlimentacion.buscarAlimentacion(alimentos, idEmpleadoBuscar).mostrarAlimentacion(alimentos);
                            System.out.println(green+"\nDatos Hospedaje:"+reset);
                            objHospedaje.buscarHospedaje(hospedajes, idEmpleadoBuscar).mostrarHospedaje(hospedajes);
                        } else {
                            System.out.println(yellow+"\nEl empleado existe pero no tiene viajes realizados\n"+reset);
                        }
                    } else {
                        System.err.println("\nEl empleado NO existe\n");
                    }
                    break;
                case 5:
                    System.out.print(purple+"\nIngrese el id del empleado a buscar: "+reset);
                    String idBuscado = read.next();
                    objEmpleado = new Empleado();
                    if (objEmpleado.buscarEmpleado(empleados, idBuscado) != null) {
                        System.out.print(green+"¡EMPLEADO ECONTRADO!, SUS DATOS SON:\n"+reset);
                        objEmpleado.buscarEmpleado(empleados, idBuscado).mostrarEmpleado();
                    } else {
                        System.err.print("¡EL EMPLEADO NO EXISTE!\n");

                    }
                    System.out.println("\n-->Presione ENTER para continuar<--");
                    System.in.read();
                    break;
                default:
                    System.err.println("Opción no valida");
            }
        } while (option != 0);

    }

    public void esperarEnter() throws IOException{
        System.out.println("\n-->Presione ENTER para continuar<--");
        System.in.read();
    }
}