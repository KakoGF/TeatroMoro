/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba.semana.pkg4;
/**
 * @author Joaquín Gómez Flores
 */
import java.util.Scanner;

public class PruebaSemana4 {
    public static void main(String[] args) {
        var teclado = new Scanner(System.in);
        int totalEntradas = 0; 
        double montoTotal = 0; 
        String ubicaciones = ""; 
        int menuNum;
        // Menú principal
        System.out.println("*******************************");
        System.out.println("Hola, Bienvenido al teatro Moro");
        System.out.println("*******************************");

        boolean continuar = true;
        while (continuar) {
            menuNum = 0;
            System.out.println("Seleccione una opcion para continuar: ");
            System.out.println("Presiona 1 si quieres comprar entradas");
            System.out.println("Presiona 2 si quieres salir"+ "\n") ;
            menuNum = teclado.nextInt();

            switch (menuNum) {
                case 1:
                    boolean continuarCompra = true; 
                    while (continuarCompra) {
                        System.out.println("Seleccionaste la opción 1, Compra de entradas");
                        System.out.println("Favor selecciona el lugar donde deseas comprar entrada"+ "\n");
                        System.out.println("Opción 1, VIP");
                        System.out.println("Opción 2, Platea Baja");
                        System.out.println("Opción 3, Platea Alta");
                        System.out.println("Opción 4, Palco");
                        int sectorNum = teclado.nextInt();

                        double precioEntrada = 0;
                        String sector = "";

                        switch (sectorNum) {
                            case 1:
                                System.out.println("Seleccionaste la opción 1, Sector VIP");
                                System.out.println("El precio en este sector es de $30,000");
                                System.out.println("Veamos si aplica descuento Estudiante o Tercera Edad");
                                System.out.println("Ingresa tu edad");
                                int edad = teclado.nextInt();
                                if (edad > 65 && edad < 100) {
                                    System.out.println("Tienes descuento Tercera Edad del 15%");
                                    precioEntrada = 30000 * 0.85; 
                                    sector = "VIP";
                                } else if (edad <= 18) {
                                    System.out.println("Tienes descuento Estudiante del 10%");
                                    precioEntrada = 30000 * 0.9; 
                                    sector = "VIP";
                                } else {
                                    System.out.println("No tienes descuento");
                                    precioEntrada = 30000; 
                                    sector = "VIP";
                                }
                                break;

                            case 2:
                                System.out.println("Seleccionaste la opción 2, Sector Platea Baja");
                                System.out.println("El precio en este sector es de $15,000");
                                System.out.println("Veamos si aplica descuento Estudiante o Tercera Edad");
                                System.out.println("Ingresa tu edad");
                                int edadB = teclado.nextInt();
                                if (edadB > 65 && edadB < 100) {
                                    System.out.println("Tienes descuento Tercera Edad del 15%");
                                    precioEntrada = 15000 * 0.85; 
                                    sector = "Platea Baja";
                                } else if (edadB <= 18) {
                                    System.out.println("Tienes descuento Estudiante del 10%");
                                    precioEntrada = 15000 * 0.9; 
                                    sector = "Platea Baja";
                                } else {
                                    System.out.println("No tienes descuento");
                                    precioEntrada = 15000; 
                                    sector = "Platea Baja";
                                }
                                break;

                            case 3:
                                System.out.println("Seleccionaste la opción 3, Sector Platea Alta");
                                System.out.println("El precio en este sector es de $18,000");
                                System.out.println("Veamos si aplica descuento Estudiante o Tercera Edad");
                                System.out.println("Ingresa tu edad");
                                int edadA = teclado.nextInt();
                                if (edadA > 65 && edadA < 100) {
                                    System.out.println("Tienes descuento Tercera Edad del 15%");
                                    precioEntrada = 18000 * 0.85; 
                                    sector = "Platea Alta";
                                } else if (edadA <= 18) {
                                    System.out.println("Tienes descuento Estudiante del 10%");
                                    precioEntrada = 18000 * 0.9; 
                                    sector = "Platea Alta";
                                } else {
                                    System.out.println("No tienes descuento");
                                    precioEntrada = 18000; 
                                    sector = "Platea Alta";
                                }
                                break;

                            case 4:
                                System.out.println("Seleccionaste la opción 4, Sector Palco");
                                System.out.println("El precio en este sector es de $13,000");
                                System.out.println("Veamos si aplica descuento Estudiante o Tercera Edad");
                                System.out.println("Ingresa tu edad");
                                int edadPa = teclado.nextInt();
                                if (edadPa > 65 && edadPa < 100) {
                                    System.out.println("Tienes descuento Tercera Edad del 15%");
                                    precioEntrada = 13000 * 0.85; 
                                    sector = "Palco";
                                } else if (edadPa <= 18) {
                                    System.out.println("Tienes descuento Estudiante del 10%");
                                    precioEntrada = 13000 * 0.9; 
                                    sector = "Palco";
                                } else {
                                    System.out.println("No tienes descuento");
                                    precioEntrada = 13000; 
                                    sector = "Palco";
                                }
                                break;

                            default:
                                System.out.println("Opción inválida.");
                        }
                        if (precioEntrada > 0) {
                            totalEntradas++; 
                            montoTotal += precioEntrada; 
                            ubicaciones += sector + " ($" + precioEntrada + ")\n"; 
                        }
                        continuarCompra = false;
                    }
                    break;

                case 2:
                    System.out.println("Seleccionaste la opción 2, Salir y pagar");
                    continuar = false; 
                    break;

                default:
                    System.out.println("Selecciona una opción válida.");
                    break;
            }
        } 
        System.out.println("Este es el resumen de tus compras:");
        System.out.println("Total de entradas compradas: " + totalEntradas);
        System.out.println("Ubicaciones y precios de las entradas:");
        System.out.println(ubicaciones);
        System.out.println("Monto total a pagar: $" + montoTotal);
        teclado.close();
    }
}