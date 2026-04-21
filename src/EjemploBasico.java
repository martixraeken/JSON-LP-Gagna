import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class EjemploBasico {
    public static void main(String[] args) {

        // 1. GENERAR (Serialización)
        JSONObject producto = new JSONObject();
        producto.put("nombre", "Notebook");
        producto.put("precio", 350000);
        producto.put("disponible", true);

        JSONArray caracteristicas = new JSONArray();
        caracteristicas.add("8GB RAM");
        caracteristicas.add("256GB SSD");
        caracteristicas.add("Intel i5");

        producto.put("caracteristicas", caracteristicas);

        // 2. GUARDAR en un archivo .json
        try (FileWriter archivo = new FileWriter("producto.json")) {
            archivo.write(producto.toJSONString()); // Escribimos el JSON en el archivo
            archivo.flush();
            System.out.println("Archivo 'producto.json' generado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }

        // 3. LEER Y PARSEAR
        JSONParser parser = new JSONParser();

        try {
            // Leemos el archivo y lo transformamos (parsing) en un objeto utilizable
            Object obj = parser.parse(new FileReader("producto.json"));
            JSONObject jsonParseado = (JSONObject) obj;

            System.out.println("\n--- Datos recuperados del archivo ---");
            
            // 4. USAR los datos parseados
            String nombre = (String) jsonParseado.get("nombre");
            long precio = (long) jsonParseado.get("precio");
            JSONArray lista = (JSONArray) jsonParseado.get("caracteristicas");

            System.out.println("Producto recuperado: " + nombre);
            System.out.println("Precio: $" + precio);
            System.out.println("Características:");
            for (Object c : lista) {
                System.out.println("- " + c);
            }

        } catch (Exception e) {
            System.out.println("Error al leer o parsear el archivo: " + e.getMessage());
        }
    }
}