import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Ejemplo2 {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            JSONArray productos = new JSONArray();
            int opcion = -1;

            do {
                try {
                    System.out.println("\n===== GESTIÓN DE PRODUCTOS (JSON) =====");
                    System.out.println("1. Agregar producto");
                    System.out.println("2. Mostrar productos");
                    System.out.println("3. Buscar producto");
                    System.out.println("4. Eliminar producto");
                    System.out.println("5. Mostrar JSON completo");
                    System.out.println("6. Salir");
                    System.out.print("Opción: ");

                    opcion = sc.nextInt();
                    sc.nextLine();

                    switch (opcion) {

                        case 1:

                            JSONObject producto = new JSONObject();

                            System.out.print("Nombre: ");
                            String nombre = sc.nextLine();

                            double precio = 0;
                            boolean precioValido = false;

                            while (!precioValido) {
                                try {
                                    System.out.print("Precio: ");
                                    precio = sc.nextDouble();
                                    sc.nextLine();

                                    if (precio >= 0) {
                                        precioValido = true;
                                    } else {
                                        System.out.println("ERROR: El precio no puede ser negativo.");
                                    }    
                                    
                                } catch (InputMismatchException e) {
                                    System.out.println("ERROR: Ingrese un número válido.");
                                    sc.nextLine();
                                }
                            }

                            JSONArray categorias = new JSONArray();

                            System.out.print("Ingrese categorías (separadas por coma): ");
                            String[] catsInput = sc.nextLine().split(",");

                            for (String cat : catsInput) {
                                categorias.add(cat.trim());
                            }

                            producto.put("nombre", nombre);
                            producto.put("precio", precio);
                            producto.put("categorias", categorias);

                            productos.add(producto);

                            System.out.println("Producto agregado exitosamente.");
                            break;

                        case 2:

                            System.out.println("\n--- Lista de productos ---");

                            if (productos.isEmpty()) {
                                System.out.println("No hay productos cargados.");
                            } else {

                                for (Object obj : productos) {

                                    JSONObject prod = (JSONObject) obj;

                                    System.out.println("Nombre: " + prod.get("nombre"));
                                    System.out.println("Precio: $" + prod.get("precio"));

                                    System.out.println("Categorías:");

                                    JSONArray cats =
                                            (JSONArray) prod.get("categorias");

                                    for (Object c : cats) {
                                        System.out.println("- " + c);
                                    }

                                    System.out.println("----------------------");
                                }
                            }

                            break;

                        case 3:

                            System.out.print("Ingrese nombre a buscar: ");
                            String buscar = sc.nextLine();

                            boolean encontrado = false;

                            for (Object obj : productos) {

                                JSONObject prod = (JSONObject) obj;

                                if (prod.get("nombre").toString()
                                        .equalsIgnoreCase(buscar)) {

                                    System.out.println("Producto encontrado:");
                                    System.out.println(prod.toJSONString());

                                    encontrado = true;
                                }
                            }

                            if (!encontrado) {
                                System.out.println("No se encontró el producto.");
                            }

                            break;

                        case 4:

                            System.out.print("Ingrese nombre a eliminar: ");
                            String eliminar = sc.nextLine();

                            boolean eliminado = false;

                            for (int i = 0; i < productos.size(); i++) {

                                JSONObject prod =
                                        (JSONObject) productos.get(i);

                                if (prod.get("nombre").toString()
                                        .equalsIgnoreCase(eliminar)) {

                                    productos.remove(i);

                                    eliminado = true;

                                    System.out.println("Producto eliminado.");
                                    break;
                                }
                            }

                            if (!eliminado) {
                                System.out.println("No se encontró el producto.");
                            }

                            break;

                        case 5:

                            System.out.println("\nJSON estructurado:");
                            System.out.println(productos.toJSONString());
                            break;

                        case 6:

                            System.out.println("Saliendo...");
                            break;

                        default:

                            System.out.println("Opción inválida.");
                    }

                } catch (InputMismatchException e) {

                    System.out.println("ERROR: Debe ingresar un número válido.");
                    sc.nextLine();
                    opcion = -1;
                }

            } while (opcion != 6);
        }
    }
}