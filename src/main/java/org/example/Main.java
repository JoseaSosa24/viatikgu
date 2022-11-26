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
        Alimentacion objAlimentacion=null;
        Transporte objTransporte=null;
        Empleado objEmpleado=null;
        Hospedaje objHospedaje=null;

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
                    objEmpleado=new Empleado();
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

                    } while (optionTravel != 0);

                    break;

                case 3:
                    objEmpleado.mostrarEmpleado(empleados);
                    break;
                case 4:

                    break;

                default:
                    System.out.println("Opcion no valida");
            }


        } while (option != 0);


    }
}