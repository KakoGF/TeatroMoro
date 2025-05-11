/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebasemana9;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Joaquín Gómez Flores
 */
public class PruebaSemana9 {
    static class Venta {
        static int contadorID = 150;
        int id;
        String nombreCliente;
        String ubicacion;
        double precioFinal;
        String tipoDescuento;
        int asiento;

        public Venta(String nombreCliente, String ubicacion, double precioFinal, String tipoDescuento, int asiento) {
            this.id = contadorID++;
            this.nombreCliente = nombreCliente;
            this.ubicacion = ubicacion;
            this.precioFinal = precioFinal;
            this.tipoDescuento = tipoDescuento;
            this.asiento = asiento;
        }

        public void mostrarVenta() {
            System.out.println("ID: " + id + " | Cliente: " + nombreCliente + " | Ubicación: " + ubicacion + " | Asiento: " + (asiento + 1) + " | Precio Final: $" + precioFinal + " | Descuento: " + tipoDescuento);
        }

        public void mostrarDetalle() {
            System.out.println("ID: " + id);
            System.out.println("Cliente: " + nombreCliente);
            System.out.println("Ubicación: " + ubicacion + " | Asiento: " + (asiento + 1));
            int valorBase = Utilidades.obtenerPrecioBase(ubicacion);
            System.out.println("Valor Base: $" + valorBase);
            int desc = Utilidades.obtenerDescuentoPorcentaje(tipoDescuento);
            System.out.println("Descuento Aplicado: " + desc + "%");
            System.out.println("Valor Final: $" + (int) precioFinal);
            System.out.println("-------------------------------------------");
        }
    }

    static class Boleta {
        static int idBoleta = 1000;
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

    static char[] asientosVIP = {'D','D','D','D','D','D'};
    static char[] asientosPlateaBaja = {'D','D','D','D','D','D'};
    static char[] asientosPlateaAlta = {'D','D','D','D','D','D'};
    static char[] asientosPalco = {'D','D','D','D','D','D'};
    static char[] asientosGaleria = {'D','D','D','D','D','D'};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Venta> ventas = new LinkedList<>();
        ArrayList<Boleta> boletas = new ArrayList<>();

        System.out.println("*******************************************");
        System.out.println("               Teatro Moro");
        System.out.println("*******************************************");
        System.out.println("Bienvenido al sistema de compra de entradas");
        System.out.println("*******************************************");
      
        boolean continuar = true;
        while (continuar) {
            System.out.println("\nSeleccione qué deseas hacer el día de hoy: ");
            System.out.println("1. Venta de Entradas");
            System.out.println("2. Revisar y Editar Entradas");
            System.out.println("3. Generar Boleta");
            System.out.println("4. Salir\n");

            try {
                int menuNum = sc.nextInt();
                sc.nextLine();
                //BreakPoint, Hice pruebas en el menu con letras y me tira la excepcion y comienza de nuevo el proceso, lo mismo ocurre con numeros decimales
                switch (menuNum) {
                    case 1 -> {
                        System.out.println("Seleccionaste la opción 1: Venta de Entradas");
                        System.out.print("Ingrese el nombre del Cliente: ");
                        String nombre = sc.nextLine();

                        System.out.print("Ingrese la edad del Cliente: ");
                        int edad = sc.nextInt();
                        sc.nextLine();
                        if (edad <= 0 || edad > 100) {
                            System.out.println("Edad inválida.");
                            break;
                        }

                        System.out.println("Seleccione ubicación:");
                        System.out.println("1. VIP ($30.000)");
                        System.out.println("2. Platea Baja ($15.000)");
                        System.out.println("3. Platea Alta ($18.000)");
                        System.out.println("4. Palco ($13.000)");
                        System.out.println("5. Galería ($10.000)");
                        int opt = sc.nextInt();
                        sc.nextLine();

                        String zona = obtenerZona(opt);
                        if (zona.equals("")) {
                            System.out.println("Opción inválida.");
                            break;
                        }

                        char[] asientos = obtenerAsientosZona(zona);
                        System.out.println("Asientos disponibles en " + zona + ":");
                        for (int i = 0; i < asientos.length; i++) {
                            System.out.print(asientos[i] + " ");
                            if (i == 2) System.out.println();
                        }
                        System.out.println();

                        System.out.print("Seleccione número de asiento (1 a 6): ");
                        int asientoElegido = sc.nextInt() - 1;
                        sc.nextLine();

                        if (asientoElegido < 0 || asientoElegido >= 6 || asientos[asientoElegido] == 'C') {
                            System.out.println("Asiento no disponible o fuera de rango.");
                            break;
                        }

                        asientos[asientoElegido] = 'C';

                        System.out.println("Seleccione tipo de descuento:");
                        System.out.println("1. Niños (10%)");
                        System.out.println("2. Mujeres (20%)");
                        System.out.println("3. Estudiantes (15%)");
                        System.out.println("4. Personas de Tercera Edad (25%)");
                        System.out.println("5. Sin Descuento");
                        int tipoDescuento = sc.nextInt();
                        sc.nextLine();

                        String tipo = obtenerTipoDescuento(tipoDescuento);

                        double base = Utilidades.obtenerPrecioBase(zona);
                        double total = Utilidades.aplicarDescuento(tipo, base);
                        ventas.add(new Venta(nombre, zona, total, tipo, asientoElegido));
                        System.out.println("Compra registrada exitosamente.");
                    }
                    case 2 -> {
                        System.out.println("Seleccionaste la opción 2: Revisar y Editar Entradas");
                        if (ventas.isEmpty()) {
                            System.out.println("No hay entradas compradas.");
                        } else {
                            for (Venta v : ventas) v.mostrarVenta();
                            System.out.print("¿Desea editar una entrada? (1. Sí / 2. No): ");
                            int opEditar = sc.nextInt();
                            sc.nextLine();

                            if (opEditar == 1) {
                                System.out.print("Ingrese el ID de la entrada: ");
                                int id = sc.nextInt();
                                sc.nextLine();
                                Venta ventaAEditar = null;
                                for (Venta v : ventas) {
                                    if (v.id == id) {
                                        ventaAEditar = v;
                                        break;
                                    }
                                }
                                if (ventaAEditar != null) {
                                   
                                    obtenerAsientosZona(ventaAEditar.ubicacion)[ventaAEditar.asiento] = 'D';

                                    System.out.print("Nuevo nombre (Enter para mantener): ");
                                    String nuevo = sc.nextLine();
                                    if (!nuevo.trim().isEmpty()) ventaAEditar.nombreCliente = nuevo;

                                    System.out.println("Seleccione nueva ubicación:");
                                    System.out.println("1. VIP ($30.000)");
                                    System.out.println("2. Platea Baja ($15.000)");
                                    System.out.println("3. Platea Alta ($18.000)");
                                    System.out.println("4. Palco ($13.000)");
                                    System.out.println("5. Galería ($10.000)");
                                    int nuevaUbic = sc.nextInt();
                                    sc.nextLine();
                                    String nuevaZona = obtenerZona(nuevaUbic);

                                    char[] nuevosAsientos = obtenerAsientosZona(nuevaZona);
                                    System.out.println("Asientos disponibles en " + nuevaZona + ":");
                                    for (int i = 0; i < nuevosAsientos.length; i++) {
                                        System.out.print(nuevosAsientos[i] + " ");
                                        if (i == 2) System.out.println();
                                    }
                                    System.out.println();

                                    System.out.print("Seleccione número de asiento (1 a 6): ");
                                    int nuevoAsiento = sc.nextInt() - 1;
                                    sc.nextLine();

                                    if (nuevoAsiento < 0 || nuevoAsiento >= 6 || nuevosAsientos[nuevoAsiento] == 'C') {
                                        System.out.println("Asiento no disponible o fuera de rango.");
                                        break;
                                    }

                                    nuevosAsientos[nuevoAsiento] = 'C';
                                    ventaAEditar.ubicacion = nuevaZona;
                                    ventaAEditar.asiento = nuevoAsiento;

                                    System.out.println("Seleccione nuevo tipo de descuento:");
                                    System.out.println("1. Niños (10%)");
                                    System.out.println("2. Mujeres (20%)");
                                    System.out.println("3. Estudiantes (15%)");
                                    System.out.println("4. Tercera Edad (25%)");
                                    System.out.println("5. Sin Descuento");
                                    int tipoD = sc.nextInt();
                                    sc.nextLine();
                                    ventaAEditar.tipoDescuento = obtenerTipoDescuento(tipoD);

                                    double precio = Utilidades.aplicarDescuento(ventaAEditar.tipoDescuento, Utilidades.obtenerPrecioBase(ventaAEditar.ubicacion));
                                    ventaAEditar.precioFinal = precio;

                                    System.out.println("Entrada actualizada correctamente:");
                                    ventaAEditar.mostrarVenta();
                                } else {
                                    System.out.println("ID no encontrado.");
                                }
                            }
                        }
                    }
                    case 3 -> {
                        if (ventas.isEmpty()) {
                            System.out.println("No hay entradas para generar boleta.");
                        } else {
                            Boleta b = new Boleta(new ArrayList<>(ventas));
                            boletas.add(b);
                            b.mostrarBoleta();
                            ventas.clear();
                        }
                    }
                    case 4 -> {
                        System.out.println("Gracias por su compra, nos vemos pronto!");
                        continuar = false;
                    }
                    default -> System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida, por favor comience de nuevo.");
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
            case 5 -> "Galería";
            default -> "";
        };
    }

    public static char[] obtenerAsientosZona(String zona) {
        return switch (zona) {
            case "VIP" -> asientosVIP;
            case "Platea Baja" -> asientosPlateaBaja;
            case "Platea Alta" -> asientosPlateaAlta;
            case "Palco" -> asientosPalco;
            case "Galería" -> asientosGaleria;
            default -> new char[6];
        };
    }

    public static String obtenerTipoDescuento(int opcion) {
        return switch (opcion) {
            case 1 -> "Niños";
            case 2 -> "Mujeres";
            case 3 -> "Estudiantes";
            case 4 -> "Tercera Edad";
            default -> "Sin Descuento";
        };
    }
}

class Precios {
    static final int VIP = 30000;
    static final int PLATEA_BAJA = 15000;
    static final int PLATEA_ALTA = 18000;
    static final int PALCO = 13000;
    static final int GALERIA = 10000;
}

class Utilidades {
    public static double aplicarDescuento(String tipoDescuento, double base) {
        return switch (tipoDescuento) {
            case "Niños" -> base * 0.9;
            case "Mujeres" -> base * 0.8;
            case "Estudiantes" -> base * 0.85;
            case "Tercera Edad" -> base * 0.75;
            default -> base;
        };
    }

    public static int obtenerDescuentoPorcentaje(String tipoDescuento) {
        return switch (tipoDescuento) {
            case "Niños" -> 10;
            case "Mujeres" -> 20;
            case "Estudiantes" -> 15;
            case "Tercera Edad" -> 25;
            default -> 0;
        };
    }

    public static int obtenerPrecioBase(String ubicacion) {
        return switch (ubicacion) {
            case "VIP" -> Precios.VIP;
            case "Platea Baja" -> Precios.PLATEA_BAJA;
            case "Platea Alta" -> Precios.PLATEA_ALTA;
            case "Palco" -> Precios.PALCO;
            case "Galería" -> Precios.GALERIA;
            default -> 0;
        };
    }
}
