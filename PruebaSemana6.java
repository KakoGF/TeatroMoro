/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebasemana6;
import java.util.Scanner;

public class PruebaSemana6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sector = "";
        String entrada1 = "";
        String entrada2 = "";
        String entrada3 = "";
        String entrada4 = "";
        String entrada5 = "";
        String[] estadoEntradas = new String[5];
        for (int i = 0; i < estadoEntradas.length; i++) {
            estadoEntradas[i]="Disponible";           
        }
        int vip = 30000;
        int pBaja = 15000;
        int pAlta = 18000;
        int palco = 13000;

        double precioEnt = 0;
        double totalEnt = 0;
        double totalTo = 0;

        System.out.println("*******************************************");
        System.out.println("Bienvenido al sistema de compra de entradas");
        System.out.println("*******************************************");

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nSeleccione que desea hacer: ");
            System.out.println("1. Reserva de Entradas");
            System.out.println("2. Compra de Entradas");
            System.out.println("3. Modificar Entradas");
            System.out.println("4. Imprimir Boleta");
            System.out.println("5. Salir\n");

            try {
                int menuNum = Integer.parseInt(sc.nextLine());

                switch (menuNum) {
                    case 1:
                        System.out.println("Seleccionaste la opción 1, Reserva de Entradas");
                        System.out.println("\nEstado actual de las entradas:");
                        for (int i = 0; i < 5; i++) {
                            String estado = estadoEntradas[i];
                            if (estado == null) estado = "Disponible";
                            System.out.println("Entrada " + (i + 1) + ": " + estado);                                
                            }
                            boolean hayDisponibles = false;
                            for (int i = 0; i < estadoEntradas.length; i++) {
                                String estado = estadoEntradas[i];
                                if (estado == null || estado.equals("Disponible")) {
                                    hayDisponibles = true;
                                    break;                                    
                                }                            
                        }
                            if (!hayDisponibles) {
                                System.out.println("\nNo hay entradas disponibles para reservar");
                                break;                            
                        }
                        
                        System.out.println("Favor selecciona el lugar donde deseas reservar una entrada");
                        System.out.println("Opción 1, Sector VIP");
                        System.out.println("Opción 2, Sector Platea Baja");
                        System.out.println("Opción 3, Sector Platea Alta");
                        System.out.println("Opción 4, Sector Palco");
                        //breakpoint
                        int sectorNum = Integer.parseInt(sc.nextLine());
                        switch (sectorNum) {
                            case 1: sector = "VIP"; precioEnt = vip; break;
                            case 2: sector = "Platea Baja"; precioEnt = pBaja; break;
                            case 3: sector = "Platea Alta"; precioEnt = pAlta; break;
                            case 4: sector = "Palco"; precioEnt = palco; break;
                            default: System.out.println("Opción inválida."); continue;
                        }
                        //breakpoint
                        boolean reservada = false;
                        for (int i = 0; i < 5; i++) {
                            if (estadoEntradas[i] == null || estadoEntradas[i].equals("Disponible")) {
                                String texto = sector + " ($"+precioEnt + ")";
                                if (i == 0) entrada1 = texto;
                                else if (i == 1) entrada2 = texto;
                                else if (i == 2) entrada3 = texto;
                                else if (i == 3) entrada4 = texto;
                                else if (i == 4) entrada5 = texto;
                                estadoEntradas[i] = "Reservada";
                                totalEnt++;
                                totalTo += precioEnt;    
                                System.out.println("Entrada " + (i + 1) + " reservada correctamente.\n");
                                reservada = true;
                                break;
                            }
                        }
                        if (!reservada) {
                            System.out.println("No fue posible realizar la reserva.");
                        }
                        break;

                    case 2:
                        System.out.println("Seleccionaste la opción 2, Compra de Entradas");
                        System.out.println("Entradas Reservadas: ");
                        boolean hayReservadas = false;

                        for (int i = 0; i < 5; i++) {
                        if ("Reservada".equals(estadoEntradas[i])) {
                        String texto = "";
                        if (i == 0) texto = entrada1;
                        else if (i == 1) texto = entrada2;
                        else if (i == 2) texto = entrada3;
                        else if (i == 3) texto = entrada4;
                        else if (i == 4) texto = entrada5;

                        System.out.println((i + 1) + ". " + texto + " [" + estadoEntradas[i] + "]");
                        hayReservadas = true;
                            }
                        }

                        if (!hayReservadas) {
                            System.out.println("No hay entradas reservadas para comprar.");
                        break;
                        }

                        System.out.print("¿Qué entrada desea comprar? (1 a 5): ");
                        //breakpoint
                        int comprar = Integer.parseInt(sc.nextLine());
                        if (comprar >= 1 && comprar <= 5 && "Reservada".equals(estadoEntradas[comprar - 1])) {
                        estadoEntradas[comprar - 1] = "Comprada";
                        System.out.println("Entrada " + comprar + " comprada con éxito.");
                        } else {
                            System.out.println("Entrada inválida o ya comprada.");
                        }
                        break;

                    case 3:
                        System.out.println("Seleccionaste la opción 3, Modificar Entradas");
                        System.out.println("¿Desea cambiar el sector de una entrada COMPRADA? (1: Sí / 2: No)");
                        int cambiar = Integer.parseInt(sc.nextLine());
                        if (cambiar == 1) {
                            System.out.print("Entradas compradas: \n");
                            boolean hayCompradas = false;
                            
                            for (int i = 0; i < 5; i++) {
                            if ("Comprada".equals(estadoEntradas[i])) {
                            String texto = "";
                            if (i == 0) texto = entrada1;
                            else if (i == 1) texto = entrada2;
                            else if (i == 2) texto = entrada3;
                            else if (i == 3) texto = entrada4;
                            else if (i == 4) texto = entrada5;

                            System.out.println((i + 1) + ". " + texto);
                            hayCompradas = true;
                                }
                            }

                            if (!hayCompradas) {
                            System.out.println("No hay entradas compradas para modificar.");
                            break;
                            }
                            
                            System.out.print("\n¿Cual entrada desea modificar? (1 a 5): ");
                            int entrada = Integer.parseInt(sc.nextLine());
                            if (entrada >= 1 && entrada <= 5 && "Comprada".equals(estadoEntradas[entrada - 1])) {
                                System.out.println("Nuevo sector:\n1. VIP\n2. Platea Baja\n3. Platea Alta\n4. Palco");
                                int nuevoSector = Integer.parseInt(sc.nextLine());
                                String texto = "";
                                switch (nuevoSector) {
                                    case 1: texto = "VIP ($30000)"; break;
                                    case 2: texto = "Platea Baja ($15000)"; break;
                                    case 3: texto = "Platea Alta ($18000)"; break;
                                    case 4: texto = "Palco ($13000)"; break;
                                    default: System.out.println("Opción inválida."); continue;
                                }
                                if (entrada == 1) entrada1 = texto;
                                else if (entrada == 2) entrada2 = texto;
                                else if (entrada == 3) entrada3 = texto;
                                else if (entrada == 4) entrada4 = texto;
                                else if (entrada == 5) entrada5 = texto;
                                System.out.println("Sector actualizado.");
                            } else {
                                System.out.println("Entrada inválida o no comprada.");
                            }
                        }
                        break;

                    case 4:
                        System.out.println("Seleccionaste la opción 4, Emisión de Boleta");
                        System.out.println("Revisa tu Boleta de Entradas compradas");
                        int cantidadCompradas = 0;
                        double totalBoleta = 0;

                        //breakpoint
                        for (int i = 0; i < 5; i++) {
                            if("Comprada".equals(estadoEntradas[i])){
                            String entradaTexto = "";
                                switch(i){
                                case 0: entradaTexto = entrada1;
                                case 1: entradaTexto = entrada2;
                                case 2: entradaTexto = entrada3;
                                case 3: entradaTexto = entrada4;
                                case 4: entradaTexto = entrada5;
                                default: entradaTexto = "";
                                break;
                            };
                            System.out.println((i + 1) + ". " + entradaTexto);
                            cantidadCompradas++;
                            
                                if (entradaTexto.contains("VIP")) totalBoleta += vip; 
                                else if (entradaTexto.contains("Platea Baja")) totalBoleta += pBaja;    
                                else if (entradaTexto.contains("Platea Alta")) totalBoleta += pAlta; 
                                else if (entradaTexto.contains("Palco")) totalBoleta += palco;    
                            }
                        }

                        System.out.println("Total entradas compradas: " + cantidadCompradas);
                        System.out.println("Total a pagar: $" + totalBoleta);
                        System.out.println("Gracias por comprar en Teatro Moro");
                        break; 

                    case 5:
                        System.out.println("Seleccionaste la opción 5, Salir.");
                        System.out.println("Gracias por usar el sistema de Teatro Moro.");
                        System.out.println("Nos vemos pronto!");
                        continuar = false;
                        break;

                    default:
                        System.out.println("Opción no válida.");
                        System.out.println("Favor, selecciona una opción entre los numeros 1-5");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida.");
                System.out.println("Recuerda que la respuesta solo utiliza números enteros");
                System.out.println("Favor, selecciona una opción entre los numeros 1-5");
            }
        }
        sc.close();
    }
    }