//importamos el uso de listas
import java.util.ArrayList; 

public class SistemaRenta { 
    // inicializamos las listas o ArrayLists
    private ArrayList<Cliente> clientes = new ArrayList<>(); 
    private ArrayList<RegistroAutos> autos = new ArrayList<>(); 
    private ArrayList<RegistroApartado> apartados = new ArrayList<>(); 

    // añadir ciente
    // añadimos al cliente con su metodo de la clase
    public void agregarCliente(Cliente cliente) { 
        clientes.add(cliente);
    }

    // añadir auto
    public void agregarAuto(RegistroAutos auto) {
        autos.add(auto);
    }
    //verifica si ya existe el cliente
    public boolean existeCliente (String nomCompleto, String numTelefono, String correoElect, String numLicencia) {
        for (Cliente c : clientes) {
            if (c.getNomCompleto().equals(nomCompleto) || c.getNumTelefono().equals(numTelefono) || c.getCorreoElect().equals(correoElect) || c.getNumLicencia().equals(numLicencia)) {
                return true;
            }
        }
        return false;
    }
    // añadir apartado
    public RegistroApartado crearApartado(Cliente cliente, RegistroAutos auto, double anticipo, int diasApartado) { // creamos el apartado
        if (!auto.isDisponible()) {
            System.out.println("El auto no está disponible para apartar.");
            return null;
        }
        auto.setDisponible(false);
        RegistroApartado nuevoApartado = new RegistroApartado(cliente, auto, anticipo, diasApartado);
        apartados.add(nuevoApartado); 
        return nuevoApartado;
    }

    // busqueda del cliente por licencia
    public Cliente buscarCliente(String numLicencia) { 
        for (Cliente c : clientes) { 
            if (c.getNumLicencia().equals(numLicencia)) { 
                return c; 
            }
        }
        // No se encontró el cliente
        return null; 

    }

    // buscar cliente por nombre
    public ArrayList<Cliente> buscarClientePorNombre(String nomCompleto) { 
        ArrayList<Cliente> resultados = new ArrayList<>(); 

        for (Cliente c : clientes) {
            if (c.getNomCompleto().equalsIgnoreCase(nomCompleto)) { 
                // añadimos el cliente a ese resultados
                resultados.add(c);
            }
        }
        // retornamos lo clientes encontrados con ese nombre
        return resultados; 
    }

    // busqueda por id
    public RegistroAutos buscarAuto(int id) { 
        for (RegistroAutos a : autos) { 
            // si el objeto es igual al ID
            if (a.getId() == id) { 
                // retornamos el objeto o el auto en este caso
                return a; 
            }
        }
        // No se encontró el auto
        return null; 
    }

    // busqueda auto por marca
    public ArrayList<RegistroAutos> buscarAutosPorMarca(String marca) { 
        ArrayList<RegistroAutos> resultados = new ArrayList<>(); 

        // creamos una instancia de la lista
        for (RegistroAutos a : autos) { 
            if (a.getMarca().equalsIgnoreCase(marca)) { 
                // añadimos la marca a resultados
                resultados.add(a);
            }
        }
        // retornamos ese resultado de la marca
        return resultados; 
    }

    // obtener apartado por indice
    public RegistroApartado obtenerApartado(int indice) {
        // verificamos que el indice este dentro del rango de la lista
        if (indice >= 0 && indice < apartados.size()) {
            // retornamos el apartado en esa posición
            return apartados.get(indice); 
        }
        // el indice esta fuera del rango
        return null; 

    }

    // mostrar los apartados
    public void mostrarApartados() {
        // verificamos si la lista esta vacía
        if (apartados.isEmpty()) {
            System.out.println("No hay apartado registrados.");
        } else {
            // recorremos toda la lista de apartados
            for (int i = 0; i < apartados.size(); i++) {
                // obtenemos cada apartado
                RegistroApartado a = apartados.get(i);

                // solo mostramos los apartados que estan activos
                if (a.isActivo()) {
                    // msotramos la info del apartado
                    a.mostrarInfoApartado();
                }
            }
        }
    }

    // procesar la devolución
    public void procesarDevolucion(RegistroApartado apartado, String fechaDevolucion) {
        // verificamos que el apartado no sea nulo
        if (apartado != null) {
            // creamos un objeto de devolucióncon la fecha y el apartado
            DevolucionApartado devolucion = new DevolucionApartado(fechaDevolucion, apartado);
            // procesamos la devolucion
            devolucion.procesarDevolucion();
        } else {
            System.out.println("Apartado no válido.");
        }
    }
}
