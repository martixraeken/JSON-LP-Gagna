import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.util.Scanner;

public class Ejemplo2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        JSONArray productos = new JSONArray();

        int opcion;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Buscar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Mostrar JSON completo");
            System.out.println("6. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    JSONObject producto = new JSONObject();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();
                    sc.nextLine();

                    producto.put("nombre", nombre);
                    producto.put("precio", precio);

                    productos.add(producto);

                    System.out.println("Producto agregado.");
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

                        if (prod.get("nombre").toString().equalsIgnoreCase(buscar)) {
                            System.out.println("Producto encontrado:");
                            System.out.println("Nombre: " + prod.get("nombre"));
                            System.out.println("Precio: $" + prod.get("precio"));
                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese nombre a eliminar: ");
                    String eliminar = sc.nextLine();
                    boolean eliminado = false;

                    for (int i = 0; i < productos.size(); i++) {
                        JSONObject prod = (JSONObject) productos.get(i);

                        if (prod.get("nombre").toString().equalsIgnoreCase(eliminar)) {
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
                    System.out.println("\nJSON completo:");
                    System.out.println(productos.toJSONString());
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 6);

        sc.close();
    }
}