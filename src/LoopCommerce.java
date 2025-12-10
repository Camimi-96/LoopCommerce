import java.util.Scanner;

public class LoopCommerce {
    public static void main(String[] args) {

        // Scanner para leer desde consola
        Scanner scanner = new Scanner(System.in);

        // 1) Productos en un arreglo de Strings (requisito)
        String[] productos = {
                "1) Asesoría legal básica",
                "2) Soporte TI remoto",
                "3) Revisión de finanzas personales",
                "4) Sesión de bienestar integral"
        };

        // Arreglo paralelo de precios (mismo índice que productos)
        int[] precios = {35000, 25000, 30000, 28000};

        // Acumulador del subtotal del carrito
        int subtotal = 0;

        int opcion; // opción del menú

        // Menú principal con do-while (requisito)
        do {
            System.out.println("==================================");
            System.out.println("      LoopCommerce - Consola      ");
            System.out.println("==================================");
            System.out.println("1) Ver productos disponibles");
            System.out.println("2) Agregar productos al carrito");
            System.out.println("3) Ver subtotal actual");
            System.out.println("4) Realizar checkout");
            System.out.println("5) Salir");
            System.out.print("Elige una opción: ");

            // leer opción del menú
            opcion = scanner.nextInt();
            System.out.println(); // línea en blanco para separar

            if (opcion == 1) {
                // 1) Ver productos disponibles -> foreach (requisito)
                System.out.println("Productos disponibles:");
                int index = 0;
                for (String producto : productos) {
                    System.out.println(producto + " - $" + precios[index] + " CLP");
                    index++;
                }
                System.out.println();

            } else if (opcion == 2) {
                // 2) Agregar productos al carrito -> while (requisito)
                int seleccionProducto = -1;

                System.out.println("Ingresa el número del producto que quieres agregar.");
                System.out.println("Ingresa 0 para volver al menú.");
                System.out.println();

                while (seleccionProducto != 0) {
                    System.out.print("Producto (1-" + productos.length + ", 0 para terminar): ");
                    seleccionProducto = scanner.nextInt();

                    if (seleccionProducto == 0) {
                        System.out.println("Volviendo al menú principal...\n");
                    } else if (seleccionProducto < 0 || seleccionProducto > productos.length) {
                        System.out.println("❌ Opción de producto no válida. Intenta nuevamente.");
                    } else {
                        int indice = seleccionProducto - 1;
                        subtotal += precios[indice]; // acumulador
                        System.out.println("✅ Agregado al carrito: " + productos[indice]);
                        System.out.println("Subtotal actual: $" + subtotal + " CLP\n");
                    }
                }

            } else if (opcion == 3) {
                // 3) Ver subtotal actual
                System.out.println("🧾 Subtotal actual del carrito: $" + subtotal + " CLP\n");

            } else if (opcion == 4) {
                // 4) Checkout -> for (requisito)

                if (subtotal == 0) {
                    System.out.println("Tu carrito está vacío. Agrega productos antes de hacer checkout.\n");
                } else {
                    System.out.println("Iniciando proceso de checkout...");
                    System.out.println("Monto total a pagar: $" + subtotal + " CLP\n");

                    // 4 pasos fijos usando for
                    for (int paso = 1; paso <= 4; paso++) {
                        if (paso == 1) {
                            System.out.println("Paso 1/4: Validando stock...");
                        } else if (paso == 2) {
                            System.out.println("Paso 2/4: Confirmando datos del cliente...");
                        } else if (paso == 3) {
                            System.out.println("Paso 3/4: Procesando pago...");
                        } else {
                            System.out.println("Paso 4/4: Generando información de envío...");
                        }
                    }

                    System.out.println("\n✅ ¡Compra realizada con éxito!");
                    System.out.println("Gracias por usar LoopCommerce.\n");

                    // Reiniciar subtotal después de la compra
                    subtotal = 0;
                }

            } else if (opcion == 5) {
                // 5) Salir
                System.out.println("Saliendo del sistema. ¡Hasta luego! 👋");

            } else {
                // Mínimo un if/else (ya lo estamos usando)
                System.out.println("❌ Opción no válida. Intenta nuevamente.\n");
            }

        } while (opcion != 5); // do-while para mantener el menú activo

        scanner.close();
    }
}
