package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        System.out.println("********* Aplicación de viáticos *********");
        int option;

        do{
            System.out.println("1. Registrar empleado \n" +
                    "2. Registrar viajes (trasnporte, hospedaje, alimentación) \n" +
                    "3. Ver empleados \n" +
                    "4. Ver viajes de un empleado\n" +
                    "0. Salir ");
            option = read.nextInt();

            switch (option){
                case 0:
                    break;

                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Opcion no valida");
            }



        }while(option != 0);








    }
}