/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebasemana5;
import java.util.Scanner;
/**
 * @author Joaquín Gómez Flores
 */
public class PruebaSemana5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    Scanner sc = new Scanner(System.in);
    String sector = "";
    String entrada1 = "";
    String entrada2 = "";
    String entrada3 = "";
    String entrada4 = "";
    
    int menuNum;
    int vip = 30000;
    int pBaja = 15000;
    int pAlta = 18000;
    int palco = 13000;
    int edad;
    
    double dctoEst = 0.9;
    double dctoAm = 0.85;
    
    double precioEnt;
    double totalEnt = 0;
    double totalTo = 0;
    
    System.out.println("*******************************************");    
    System.out.println("Bienvenido al sistema de compra de entradas");
    System.out.println("*******************************************");
    boolean continuar = true;
        while (continuar) {
            menuNum = 0;
            System.out.println("Selccione que desea hacer: ");
            System.out.println("1. Compra de Entradas");
            System.out.println("2. Promociones de Entradas");
            System.out.println("3. Búsqueda de Entradas");
            System.out.println("4. Eliminacion de Entradas");
            System.out.println("5. Salir y pagar" + "\n");
            menuNum = sc.nextInt();
           
            switch (menuNum) {
                case 1:
                    boolean continuarCompra = true;
                    while (continuarCompra) {
                    System.out.println("Seleccionaste la opción 1, Compra de entradas");
        
                    if (totalEnt >= 4) {
                    System.out.println("Ya alcanzaste el límite máximo de 4 entradas." + "\n");
                    continuarCompra = false;
                    break;
                    }
                    System.out.println("Favor selecciona el lugar donde deseas comprar entrada");
                    System.out.println("Opción 1, Sector VIP");
                    System.out.println("Opción 2, Sector Platea Baja");
                    System.out.println("Opción 3, Sector Platea Alta");
                    System.out.println("Opción 4, Sector Palco");
                    int sectorNum = sc.nextInt();
                    precioEnt = 0;

                    System.out.println("Ingresa tu edad:"+ "\n");
                    edad = sc.nextInt();

                    switch (sectorNum) {
                    case 1:                
                        System.out.println("Seleccionaste el sector VIP");
                        System.out.println("El precio por entrada en este sector es de $30.000");
                        precioEnt = vip; 
                        sector = "VIP";
                        if (edad <= 18) {
                        System.out.println("Tienes descuento Estudiante del 10%");
                        precioEnt *= dctoEst;
                        } else if (edad > 64) {
                        System.out.println("Tienes descuento Tercera Edad del 15%");
                        precioEnt *= dctoAm;
                        } else {
                        System.out.println("No tienes descuento");
                        }
                        break;

                    case 2:                
                        System.out.println("Seleccionaste el sector Platea Baja");
                        System.out.println("El precio por entrada en este sector es de $15.000");
                        precioEnt = pBaja;
                        sector = "Platea Baja";
                        if (edad <= 18) {
                        System.out.println("Tienes descuento Estudiante del 10%");
                        precioEnt *= dctoEst;
                        } else if (edad > 64) {
                        System.out.println("Tienes descuento Tercera Edad del 15%");
                        precioEnt *= dctoAm;
                        } else {
                        System.out.println("No tienes descuento");
                        }
                        break;

                    case 3:                
                        System.out.println("Seleccionaste el sector Platea Alta");
                        System.out.println("El precio por entrada en este sector es de $18.000");
                        precioEnt = pAlta;
                        sector = "Platea Alta";
                        if (edad <= 18) {
                        System.out.println("Tienes descuento Estudiante del 10%");
                        precioEnt *= dctoEst;
                        } else if (edad > 64) {
                        System.out.println("Tienes descuento Tercera Edad del 15%");
                        precioEnt *= dctoAm;
                        } else {
                        System.out.println("No tienes descuento");
                        }
                        break;

                    case 4:                
                        System.out.println("Seleccionaste el sector Palco");
                        System.out.println("El precio por entrada en este sector es de $13.000");
                        precioEnt = palco;
                        sector = "Palco";
                        if (edad <= 18) {
                        System.out.println("Tienes descuento Estudiante del 10%");
                        precioEnt *= dctoEst;
                        } else if (edad > 64) {
                        System.out.println("Tienes descuento Tercera Edad del 15%");
                        precioEnt *= dctoAm;
                        } else {
                        System.out.println("No tienes descuento");
                        }
                        break;

                    default:
                        System.out.println("Opción inválida.");
                        continue; 
        }

                    if (precioEnt > 0) {
                    totalEnt++; 
                    totalTo += precioEnt; 
            
                    String descuento;
                    if (edad<=18){
                        descuento = "Descuento Estudiante Aplicado";
                    } else if (edad>64){
                        descuento = "Descuento Adulto Mayor Aplicado";
                    } else {
                        descuento = "No tienes descuento";
                    }
                    
                    if (totalEnt == 1) entrada1 = sector + " ($" + precioEnt + ") - " + descuento;
                    else if (totalEnt == 2) entrada2 = sector + " ($" + precioEnt + ") - " + descuento;
                    else if (totalEnt == 3) entrada3 = sector + " ($" + precioEnt + ") - " + descuento;
                    else if (totalEnt == 4) entrada4 = sector + " ($" + precioEnt + ") - " + descuento;

            System.out.println("Entrada registrada con éxito."+ "\n");
        }

        continuarCompra = false; 
    }
    break;
                case 2:
                    System.out.println("Seleccionaste la opción 2, Promociones"+ "\n");
                    System.out.println("Promoción Estudiante = 10% de Descuento");
                    System.out.println("Promoción Adulto Mayor = 15% de Descuento");
                    System.out.println("Promoción 3 o mas entradas, Descuento del 5% del precio total");
                    continuar = true; 
                    break;
                    
                case 3:
                    System.out.println("Seleccionaste la opción 3: Buscar entradas por número"+ "\n");
                    System.out.println("Ingresa el número de la entrada que deseas buscar (1, 2, 3 o 4):");
                    int buscarNumero = sc.nextInt();
                    
                    if (buscarNumero == 1 && !entrada1.isEmpty()) {
                    System.out.println("Entrada 1: Sector " + entrada1); 
                    } else if (buscarNumero == 2 && !entrada2.isEmpty()) {
                    System.out.println("Entrada 2: Sector " + entrada2); 
                    } else if (buscarNumero == 3 && !entrada3.isEmpty()) {
                    System.out.println("Entrada 3: Sector " + entrada3);
                    } else if (buscarNumero == 4 && !entrada4.isEmpty()) {
                    System.out.println("Entrada 4: Sector" + entrada4);
                    } else {
                    System.out.println("Entrada no encontrada o número de entrada inválido.");
                    }
                    break;
                     
                case 4:
                    System.out.println("Seleccionaste la opción 4: Eliminar una entrada");
                    System.out.println("Entradas actuales:");
                 if (!entrada1.isEmpty()) System.out.println("1. Sector " + entrada1);
                 if (!entrada2.isEmpty()) System.out.println("2. Sector " + entrada2);
                    if (!entrada3.isEmpty()) System.out.println("3. Sector " + entrada3);
                    if (!entrada4.isEmpty()) System.out.println("4. Sector " + entrada4);

                    System.out.println("¿Qué número de entrada deseas eliminar? (1 a 4)"+ "\n");
                    int eliminar = sc.nextInt();

                    String entradaEliminar = "";
                    if (eliminar == 1 && !entrada1.isEmpty()) {
                    entradaEliminar = entrada1; entrada1 = ""; totalEnt--;
                    } else if (eliminar == 2 && !entrada2.isEmpty()) {
                    entradaEliminar = entrada2; entrada2 = ""; totalEnt--;
                    } else if (eliminar == 3 && !entrada3.isEmpty()) {
                    entradaEliminar = entrada3; entrada3 = ""; totalEnt--;
                    } else if (eliminar == 4 && !entrada4.isEmpty()) {
                    entradaEliminar = entrada4; entrada4 = ""; totalEnt--;
                    } else {
                    System.out.println("Número inválido o entrada ya eliminada."+ "\n");
                    break;
    }
                    if (entradaEliminar.contains("VIP")) totalTo -= 30000;
                    else if (entradaEliminar.contains("Platea Baja")) totalTo -= 15000;
                    else if (entradaEliminar.contains("Platea Alta")) totalTo -= 18000;
                    else if (entradaEliminar.contains("Palco")) totalTo -= 13000;

                    System.out.println("Entrada eliminada con éxito."+ "\n");
                    break;
                
                case 5:
                    System.out.println("Seleccionaste la opción 5, Salir y pagar"+ "\n");
                    continuar = false; 
                    break;
                default:
                    System.out.println("Selecciona una opción válida.");
                    break;
                            }  
                        }
        System.out.println("Este es el resumen de tus compras");
        System.out.println("Ubicaciones y precios de las entradas:");
        if (!entrada1.isEmpty()) System.out.println("1. Sector " + entrada1);
        if (!entrada2.isEmpty()) System.out.println("2. Sector " + entrada2);
        if (!entrada3.isEmpty()) System.out.println("3. Sector " + entrada3);
        if (!entrada4.isEmpty()) System.out.println("4. Sector " + entrada4);
        
        System.out.println("Total de entradas compradas: " + totalEnt);
        if (totalEnt > 2){
            System.out.println("** Aplica promoción por compras de mas de 3 entradas**");
            System.out.println("Monto a pagar sin descuento = $"+ totalTo);
            System.out.println("Monto a descontar = $" + totalTo * 0.05);
            totalTo = totalTo * 0.95;
        }
        System.out.println("Monto total a pagar = $" + totalTo);
        System.out.println("Gracias por comprar en Teatro Moro");
        sc.close();
                    }
}
