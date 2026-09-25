import java.util.Scanner;

public class arregloEjercicio {
    // Arreglo bidimensional: 12 meses (filas) x 3 departamentos (columnas)
    private static double[][] ventas = new double[12][3];;
    private static final String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", 
                                    "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    private static final String[] departamentos = {"Ropa", "Deportes", "Juguetería"};
        
    public arregloEjercicio() {
        // Inicializa el arreglo con 12 filas y 3 columnas
  
    }

    // 1. Método para insertar elementos en el arreglo
    public static void insertarVenta(int indiceMes, int indiceDepartamento, double monto) {
        if (indiceMes >= 0 && indiceMes < 12 && indiceDepartamento >= 0 && indiceDepartamento < 3) {
            ventas[indiceMes][indiceDepartamento] = monto;
            System.out.println("Venta de $" + monto + " insertada en " + meses[indiceMes] + 
                               ", departamento de " + departamentos[indiceDepartamento] + ".");
        } else {
            System.out.println("Índices inválidos. Mes debe ser 0-11 y departamento 0-2.");
        }
    }

    // 2. Método para buscar un elemento en particular (por monto exacto)
    public static void buscarVenta(double montoBuscar) {
        boolean encontrado = false;
        System.out.println("Buscando la venta de $" + montoBuscar + "...");
        
        for (int i = 0; i < ventas.length; i++) {
            for (int j = 0; j < ventas[i].length; j++) {
                if (ventas[i][j] == montoBuscar) {
                    System.out.println("-> Venta encontrada en el mes de " + meses[i] + 
                                       ", departamento de " + departamentos[j] + ".");
                    encontrado = true;
                }
            }
        }
        if (!encontrado) {
            System.out.println("-> Venta no encontrada en ningún departamento.");
        }
    }

    // 3. Método para eliminar una venta en particular (restablece a 0.0)
    public static void eliminarVenta(int indiceMes, int indiceDepartamento) {
        if (indiceMes >= 0 && indiceMes < 12 && indiceDepartamento >= 0 && indiceDepartamento < 3) {
            ventas[indiceMes][indiceDepartamento] = 0.0;
            System.out.println("Venta eliminada en " + meses[indiceMes] + 
                               ", departamento de " + departamentos[indiceDepartamento] + " (valor restablecido a 0.0).");
        } else {
            System.out.println("Índices inválidos.");
        }
    }

    // Método auxiliar para imprimir el estado actual del arreglo
    public static void mostrarTablaVentas() {
        System.out.printf("%-12s %-12s %-12s %-12s\n", "Mes", "Ropa", "Deportes", "Juguetería");
        System.out.println("-----------------------------------------------------");
        for (int i = 0; i < 12; i++) {
            System.out.printf("%-12s %-12.2f %-12.2f %-12.2f\n", 
                              meses[i], ventas[i][0], ventas[i][1], ventas[i][2]);
        }
    }

    public static void main(String[] args) {
        int opcion = 0;
        Scanner board = new Scanner(System.in);

        do {

      
            
        System.out.println("\n===== MENU DE VENTAS =====");
        System.out.println("1. Insertar venta");
        System.out.println("2. Buscar venta");
        System.out.println("3. Eliminar venta");
        System.out.println("4. Mostrar tabla de ventas");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
        
        if (board.hasNextInt()) {
            opcion = board.nextInt();


        System.out.println("'");
        switch(opcion) {
            case 1:
                System.out.print("Ingrese el mes (1 para Enero, ..., 12 para Diciembre): ");
                    int mesInsertar = board   .nextInt() - 1; // Restamos 1 para ajustar al índice del arreglo
                    System.out.print("Ingrese el departamento (1 para Ropa, 2 para Deportes, 3 para Juguetería): ");
                    int deptoInsertar = board.nextInt() - 1;
                    System.out.print("Ingrese el monto de la venta: ");
                    double monto = board    .nextDouble();
                    insertarVenta(mesInsertar, deptoInsertar, monto);
            break;

            case 2:
                    System.out.print("Ingrese el monto exacto a buscar: ");
                    double montoBuscar = board.nextDouble();
                    buscarVenta(montoBuscar);
            break;

            case 3: 
                    System.out.print("Ingrese el mes de la venta a eliminar (1-12): ");
                    int mesEliminar = board.nextInt() - 1;
                    System.out.print("Ingrese el departamento de la venta a eliminar (1-3): ");
                    int deptoEliminar = board.nextInt() - 1;
                    eliminarVenta(mesEliminar, deptoEliminar);
            break;

            case 4: 
                System.out.println();
                arregloEjercicio.mostrarTablaVentas();
                break;

            case 5: 
                System.out.println("Saliendo del programa");
                System.exit(0);

                }
            }  
        } while (opcion != 5);
        
        board.close();
    }
}
