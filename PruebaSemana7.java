/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author Joaquín Gómez Flores
 */
package pruebasemana7;
import java.util.Scanner;

public class PruebaSemana7 {
    /**
     * @param args the command line arguments
     */
    static class Venta {
        String ubicacion;
        double precioFinal;
        String tipoDescuento;

        public Venta(String ubicacion, double precioFinal, String tipoDescuento) {
            this.ubicacion = ubicacion;
            this.precioFinal = precioFinal;
            this.tipoDescuento = tipoDescuento;
        }
        
        public void mostrarVenta() {
            System.out.println("Ubicación: " + ubicacion + " | Precio Final: $" + precioFinal + " | Descuento: " + tipoDescuento);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vip = 30000;
        int pBaja = 15000;
        int pAlta = 18000;
        int palco = 13000;
            
        double dctoEst = 0.9;
        double dctoAm = 0.85;
                
        Venta[] ventas = new Venta[50]; // arreglo para guardar hasta 50 ventas
        int ventasRealizadas = 0;
        
        System.out.println("*******************************************");
        System.out.println("Bienvenido al sistema de compra de entradas");
        System.out.println("*******************************************");
        
        boolean continuar = true;
        while (continuar) {
            System.out.println("\nSeleccione qué desea hacer: ");
            System.out.println("1. Venta de Entradas");
            System.out.println("2. Visualizar Resumen de ventas");
            System.out.println("3. Generar Boleta");
            System.out.println("4. Calcular Ingresos Totales");
            System.out.println("5. Salir\n");

            try {
                int menuNum = sc.nextInt();
                sc.nextLine(); // limpiar salto
                switch (menuNum) {
                    case 1:
                        System.out.println("\nSeleccionaste la opción 1: Venta de Entradas");
                        System.out.println("Ahora selecciona la ubicación que deseas comprar:");
                        System.out.println("1. VIP ($30.000)");
                        System.out.println("2. Platea Baja ($15.000)");
                        System.out.println("3. Platea Alta ($18.000)");
                        System.out.println("4. Palco ($13.000)");
                        int opcionUbicacion = sc.nextInt();
                        sc.nextLine();
                        String ubicacion = "";
                        double precioBase = 0;

                        switch (opcionUbicacion) {
                            case 1: ubicacion = "VIP"; precioBase = vip; break;
                            case 2: ubicacion = "Platea Baja"; precioBase = pBaja; break;
                            case 3: ubicacion = "Platea Alta"; precioBase = pAlta; break;
                            case 4: ubicacion = "Palco"; precioBase = palco; break;
                            default:
                                System.out.println("Opción no válida. Volviendo al menú principal.");
                                continue;
                        }

                        System.out.println("¿Es estudiante? (1. Sí / 2. No)");
                        int esEstudiante = sc.nextInt();
                        sc.nextLine();

                        String tipoDescuento = "Sin descuento";
                        double descuento = 1.0;

                        if (esEstudiante == 1) {
                            descuento = dctoEst;
                            tipoDescuento = "Estudiante";
                        } else {
                            System.out.println("¿Es persona de la tercera edad? (1. Sí / 2. No)");
                            int esTerceraEdad = sc.nextInt();
                            sc.nextLine();
                            if (esTerceraEdad == 1) {
                                descuento = dctoAm;
                                tipoDescuento = "Adulto Mayor";
                            }
                        }
                        double precioFinal = precioBase * descuento;

                        if (ventasRealizadas < ventas.length) {
                            ventas[ventasRealizadas] = new Venta(ubicacion, precioFinal, tipoDescuento);
                            ventasRealizadas++;
                            System.out.println("Venta realizada exitosamente:");
                            ventas[ventasRealizadas - 1].mostrarVenta();
                        } else {
                            System.out.println("No se pueden registrar más ventas (límite alcanzado).");
                        }
                        break;
                        
                    case 2:
                        System.out.println("\nSeleccionaste la opción 2, Visualizar Resumen de ventas");
                        System.out.println("Resumen de ventas realizadas:");
                        if (ventasRealizadas == 0) {
                            System.out.println("No hay ventas registradas.");
                        } else {
                            for (int i = 0; i < ventasRealizadas; i++) {
                                ventas[i].mostrarVenta();
                            }
                        }
                        break;
                        
                    case 3:
                        System.out.println("\nSeleccionaste la opción 3, Generar Boleta:");
                        if (ventasRealizadas == 0) {
                            System.out.println("No hay ventas para generar boleta.");
                        } else {
                        double totalPagar = 0;

                        System.out.println("\n-------------------------------------------");
                        System.out.println("                Teatro Moro");
                        System.out.println("-------------------------------------------");

                        for (int i = 0; i < ventasRealizadas; i++) {
                            Venta venta = ventas[i];
                            double costoBase = 0;
                        
                        switch (venta.ubicacion) {
                            case "VIP": costoBase = vip; break;
                            case "Platea Baja": costoBase = pBaja; break;
                            case "Platea Alta": costoBase = pAlta; break;
                            case "Palco": costoBase = palco; break;
                        }
                        
                        int porcentajeDescuento = 0;
                        if (venta.tipoDescuento.equals("Estudiante")) {
                            porcentajeDescuento = 10;
                        } else if (venta.tipoDescuento.equals("Adulto Mayor")) {
                            porcentajeDescuento = 15;
                        }
                        System.out.println("Ubicación: " + venta.ubicacion);
                        System.out.println("Valor Base: $" + (int)costoBase);
                        System.out.println("Descuento Aplicado: " + porcentajeDescuento + "%");
                        System.out.println("Valor Final: $" + (int)venta.precioFinal);
                        System.out.println("-------------------------------------------");
                        totalPagar += venta.precioFinal;
                        }
                        System.out.println("Monto total a pagar: $" + (int)totalPagar);
                        System.out.println("-------------------------------------------");
                        System.out.println("Gracias por su visita al Teatro Moro");
                        System.out.println("-------------------------------------------");
                        }
                        break;
                                                
                    case 4:
                        System.out.println("\nSeleccionaste la opción 4, Calcular Ingresos Totales");
                        double ingresosTotales = 0;
                        for (int i = 0; i < ventasRealizadas; i++) {
                            ingresosTotales += ventas[i].precioFinal;
                        }
                        System.out.println("Ingresos totales del teatro: $" + ingresosTotales);
                        break;     
                        
                    case 5:
                        System.out.println("\nSeleccionaste la opción 5, Salir.");
                        System.out.println("Gracias por su compra, nos vemos pronto!");
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
            sc.nextLine();
            }
        }
    sc.close();    
    }    
}
