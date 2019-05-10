package persistencia.imp;

import dominio.Producto;
import persistencia.def.ProductoDAO;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProductoDAOImp implements ProductoDAO {

    private final String archivoProductos;

    public ProductoDAOImp() {
        this.archivoProductos = "productos.txt";
    }



    @Override
    public List<Producto> leerProductos() {
        List<Producto> productos = new ArrayList<>();
        NumberFormat formatoNumero = NumberFormat.getInstance(Locale.FRANCE);
        Number numero;
        String lineaConDatos;

        try (var archivo = Files.newBufferedReader(Paths.get(archivoProductos))) {
            while (archivo.readLine() != null) {
                // Codigo
                archivo.readLine();
                lineaConDatos = archivo.readLine().trim();
                numero = formatoNumero.parse(lineaConDatos);
                int codigo = numero.intValue();

                // nombre
                archivo.readLine();
                lineaConDatos = archivo.readLine().trim();
                String nombre = lineaConDatos;

                // nombre
                archivo.readLine();
                lineaConDatos = archivo.readLine().trim();
                String descripcion = lineaConDatos;

                // Precio
                archivo.readLine();
                lineaConDatos = archivo.readLine().trim();
                numero = formatoNumero.parse(lineaConDatos);
                double precio = numero.doubleValue();

            }
        }catch (Exception e) {
            System.err.println("Error de formato en " + archivoProductos);
            System.exit(1);
//        } catch (IOException e) {
//            System.err.println("Error de lectura en " + archivoProductos);
//            System.exit(1);
        }

        return productos;
    }

    @Override
    public boolean actualizarProductos(List<Producto> productos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
