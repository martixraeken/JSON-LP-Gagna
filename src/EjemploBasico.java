import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class EjemploBasico {
    public static void main(String[] args) {

        // Crear objeto JSON
        JSONObject producto = new JSONObject();

        producto.put("nombre", "Notebook");
        producto.put("precio", 350000);
        producto.put("disponible", true);

        // Crear arreglo JSON
        JSONArray caracteristicas = new JSONArray();
        caracteristicas.add("8GB RAM");
        caracteristicas.add("256GB SSD");
        caracteristicas.add("Intel i5");

        // Agregar array al objeto
        producto.put("caracteristicas", caracteristicas);

        // Mostrar JSON completo
        System.out.println("JSON generado:");
        System.out.println(producto.toJSONString());

        // Acceder a datos específicos
        System.out.println("\nDatos del producto:");
        System.out.println("Nombre: " + producto.get("nombre"));
        System.out.println("Precio: $" + producto.get("precio"));

        // Recorrer el array
        System.out.println("\nCaracterísticas:");
        for (Object c : caracteristicas) {
            System.out.println("- " + c);
        }
    }
}