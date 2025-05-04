/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 * @author Joaquín Gómez Flores
 */
package pruebasemana8;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

public class PruebaSemana8 {
   
    static class Venta {
        static int contadorID =150;//solo para que no parta desde el 1, asi parece que han vendido mas entradas hahahaha. :)
        int id;
        String nombreCliente;
        String ubicacion;
        double precioFinal;
        String tipoDescuento;

        public Venta(String nombreCliente,String ubicacion, double precioFinal, String tipoDescuento) {
            this.id = contadorID++;
            this.nombreCliente = nombreCliente;
            this.ubicacion = ubicacion;
            this.precioFinal = precioFinal;
            this.tipoDescuento = tipoDescuento;
        }
        public void mostrarVenta() {
            System.out.println("ID: " + id + " | Cliente: " + nombreCliente + " | Ubicación: " + ubicacion + " | Precio Final: $" + precioFinal + " | Descuento: " + tipoDescuento);
        }
        public void mostrarDetalle() {
            System.out.println("ID: " + id);
            System.out.println("Cliente: " + nombreCliente);
            System.out.println("Ubicación: " + ubicacion);
            int valorBase = Utilidades.obtenerPrecioBase(ubicacion);
            System.out.println("Valor Base: $" + valorBase);
            int desc = Utilidades.obtenerDescuentoPorcentaje(tipoDescuento);
            System.out.println("Descuento Aplicado: " + desc + "%");
            System.out.println("Valor Final: $" + (int) precioFinal);
            System.out.println("-------------------------------------------");
        }
        public static Venta desdeReserva(Reserva r) {
            return new Venta(r.nombreCliente, r.ubicacion, r.precioFinal, r.tipoDescuento);
        }
    }

        static class Reserva {
            String nombreCliente;
            String ubicacion;
            double precioBase;
            String tipoDescuento;
            double precioFinal;

        public Reserva(String nombreCliente, String ubicacion, double precioBase, String tipoDescuento, double precioFinal) {
            this.nombreCliente = nombreCliente;
            this.ubicacion = ubicacion;
            this.precioBase = precioBase;
            this.tipoDescuento = tipoDescuento;
            this.precioFinal = precioFinal;
        }
    }

        static class Boleta {
            static int idBoleta = 1000;//tambien le puse un valor desde 1000, para que parezca que llevan muchas ventas
            int id;
            ArrayList<Venta> entradas;
            double total;

        public Boleta(ArrayList<Venta> entradas) {
            this.id = idBoleta++;
            this.entradas = new ArrayList<>(entradas);
            double suma = 0;
            for (Venta v : entradas) {
                suma += v.precioFinal;
                }
            this.total = suma;
        }

        public void mostrarBoleta() {
            System.out.println("\nBoleta ID: " + id);
            System.out.println("-------------------------------------------");
            System.out.println("               Teatro Moro");
            System.out.println("-------------------------------------------");
            for (Venta venta : entradas) venta.mostrarDetalle();
            System.out.println("Monto total a pagar: $" + (int) total);
            System.out.println("-------------------------------------------");
            System.out.println("Gracias por su visita al Teatro Moro");
            System.out.println("-------------------------------------------");
            }
        }
        
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Reserva> reservas = new ArrayList<>();
        LinkedList<Venta> ventas = new LinkedList<>();
        ArrayList<Boleta> boletas = new ArrayList<>();

        System.out.println("*******************************************");
        System.out.println("Bienvenido al sistema de compra de entradas");
        System.out.println("*******************************************");

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nSeleccione qué deseas hacer el día de hoy: ");
            System.out.println("1. Reserva de Entradas");
            System.out.println("2. Venta de Entradas");
            System.out.println("3. Revisar y Editar Entradas");
            System.out.println("4. Generar Boleta");
            System.out.println("5. Calcular Ingresos Totales Diarios");
            System.out.println("6. Salir\n");

            try {
                int menuNum = sc.nextInt(); 
                sc.nextLine();

                switch (menuNum) {
                    case 1:
                        System.out.println("Seleccionaste la opción 1: Reserva de Entradas");
                        System.out.print("Ingrese el nombre del Cliente: ");
                        String nombre = sc.nextLine();

                        System.out.println("Seleccione ubicación:");
                        System.out.println("1. VIP ($30.000)");
                        System.out.println("2. Platea Baja ($15.000)");
                        System.out.println("3. Platea Alta ($18.000)");
                        System.out.println("4. Palco ($13.000)");
                        int opt = sc.nextInt(); 
                        sc.nextLine();

                        String zona = obtenerZona(opt);
                        if (zona.equals("")) {
                            System.out.println("Opción inválida.");
                            break;
                        }

                        System.out.println("¿Es estudiante? (1. Sí / 2. No)");
                        String tipo = "Sin descuento";
                        if (sc.nextInt() == 1) {
                            tipo = "Estudiante";
                        } else {
                            System.out.println("¿Es persona de la tercera edad? (1. Sí / 2. No)");
                            if (sc.nextInt() == 1) tipo = "Adulto Mayor";
                        }
                        sc.nextLine();

                        double base = Utilidades.obtenerPrecioBase(zona);
                        double total = Utilidades.aplicarDescuento(tipo, base);
                        reservas.add(new Reserva(nombre, zona, base, tipo, total));
                        System.out.println("Reserva registrada exitosamente.");
                        break;

                    case 2:
                        System.out.println("Seleccionaste la opción 2: Venta de Entradas");
                        if (reservas.isEmpty()) {
                            System.out.println("No hay reservas.");
                        } else {
                            mostrarReservas(reservas);
                            System.out.print("Ingrese el número de reserva a comprar (0 para salir): ");
                            int sel = sc.nextInt(); sc.nextLine();
                            if (sel == 0) break;
                            if (sel > 0 && sel <= reservas.size()) {
                                Reserva r = reservas.remove(sel - 1);
                                ventas.add(Venta.desdeReserva(r));
                                System.out.println("Compra realizada exitosamente.");
                            } else {
                                System.out.println("Selección inválida.");
                            }
                        }
                        break;

                    case 3:
                        System.out.println("Seleccionaste la opción 3: Revisar y Editar Entradas");
                        if (ventas.isEmpty()) {
                            System.out.println("No hay entradas compradas.");
                        } else {
                            for (Venta v : ventas) v.mostrarVenta();
                            System.out.print("¿Desea editar una entrada? (1. Sí / 2. No): ");
                            if (sc.nextInt() == 1) {
                                System.out.print("Ingrese el ID de la entrada: ");
                                int id = sc.nextInt(); sc.nextLine();
                                int index = -1;
                                for (int i = 0; i < ventas.size(); i++) {
                                    if (ventas.get(i).id == id) {
                                        index = i;
                                        break;
                                    }
                                }
                                if (index != -1) {
                                    editarVenta(ventas.get(index), sc);
                                    System.out.println("Entrada actualizada correctamente:");
                                    ventas.get(index).mostrarVenta();
                                } else {
                                    System.out.println("ID no encontrado.");
                                }
                            }
                        }
                        break;

                    case 4:
                        System.out.println("Seleccionaste la opción 4: Generar Boleta");
                        if (ventas.isEmpty()) {
                            System.out.println("No hay entradas para generar boleta.");
                        } else {
                            Boleta b = new Boleta(new ArrayList<>(ventas));
                            boletas.add(b);
                            b.mostrarBoleta();
                            ventas.clear();
                        }
                        break;

                    case 5:
                        System.out.println("Seleccionaste la opción 5: Calcular Ingresos Totales Diarios");
                        double totalIngresos = 0;
                        for (Boleta b : boletas) totalIngresos += b.total;
                        System.out.println("Ingresos totales: $" + (int) totalIngresos);
                        break;

                    case 6:
                        System.out.println("Seleccionaste la opción 6, Salir.");
                        System.out.println("Gracias por su compra, nos vemos pronto!");
                        continuar = false;
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida.");
                sc.nextLine();
            }
        }

        sc.close();
    }

    public static String obtenerZona(int opcion) {
        return switch (opcion) {
            case 1 -> "VIP";
            case 2 -> "Platea Baja";
            case 3 -> "Platea Alta";
            case 4 -> "Palco";
            default -> "";
        };
    }

    public static String obtenerTipoDescuento(int opcion) {
        return switch (opcion) {
            case 1 -> "Estudiante";
            case 2 -> "Adulto Mayor";
            default -> "Sin descuento";
        };
    }

    public static void mostrarReservas(ArrayList<Reserva> reservas) {
        for (int i = 0; i < reservas.size(); i++) {
            Reserva r = reservas.get(i);
            System.out.println((i + 1) + ". Cliente: " + r.nombreCliente +
                    " | Zona: " + r.ubicacion + " | Precio Final: $" + r.precioFinal);
        }
    }

    public static void editarVenta(Venta v, Scanner sc) {
        System.out.print("Nuevo nombre (Enter para mantener): ");
        String nuevo = sc.nextLine();
        if (!nuevo.trim().isEmpty()) v.nombreCliente = nuevo;

        System.out.println("Seleccione nueva ubicación:");
        System.out.println("1. VIP ($30.000)");
        System.out.println("2. Platea Baja ($15.000)");
        System.out.println("3. Platea Alta ($18.000)");
        System.out.println("4. Palco ($13.000)");
        int nuevaUbic = sc.nextInt(); sc.nextLine();
        v.ubicacion = obtenerZona(nuevaUbic);

        System.out.println("Seleccione nuevo tipo de descuento:");
        System.out.println("1. Estudiante (10%)");
        System.out.println("2. Adulto Mayor (15%)");
        System.out.println("3. Sin Descuento");
        int tipoD = sc.nextInt(); sc.nextLine();
        v.tipoDescuento = obtenerTipoDescuento(tipoD);

        double precio = Utilidades.aplicarDescuento(v.tipoDescuento, Utilidades.obtenerPrecioBase(v.ubicacion));
        v.precioFinal = precio;
    }
}

class Precios {
    static final int VIP = 30000;
    static final int PLATEA_BAJA = 15000;
    static final int PLATEA_ALTA = 18000;
    static final int PALCO = 13000;
}

class Utilidades {
    public static double aplicarDescuento(String tipoDescuento, double base) {
        return switch (tipoDescuento) {
            case "Estudiante" -> base * 0.9;
            case "Adulto Mayor" -> base * 0.85;
            default -> base;
        };
    }

    public static int obtenerDescuentoPorcentaje(String tipoDescuento) {
        return switch (tipoDescuento) {
            case "Estudiante" -> 10;
            case "Adulto Mayor" -> 15;
            default -> 0;
        };
    }

    public static int obtenerPrecioBase(String ubicacion) {
        return switch (ubicacion) {
            case "VIP" -> Precios.VIP;
            case "Platea Baja" -> Precios.PLATEA_BAJA;
            case "Platea Alta" -> Precios.PLATEA_ALTA;
            case "Palco" -> Precios.PALCO;
            default -> 0;
        };
    }
}