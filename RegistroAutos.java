public class RegistroAutos {
    private static int contadorAutos = 0; //para registrar el total de autos
    private int id;
    private String color;
    private String modelo;
    private String marca;
    private int anio;
    private double precioFijo;
    private boolean disponible = true;

    // inicializamos los atributos
    public RegistroAutos(int id, String color, String modelo, String marca, int anio, double precioFijo) { 
                                                                                                           
        this.color = color;
        this.modelo = modelo;
        this.marca = marca;
        this.anio = anio;
        this.precioFijo = precioFijo;
        contadorAutos++;
        this.id = id; 
        
    }
    //getters
    public int getId() {
        return id;
    }
    public String getColor() {
        return color;
    }
    public String getModelo() {
        return modelo;
    }
    public String getMarca() {
        return marca;
    }
    public int getAnio() {
        return anio;
    }
    public double getPrecioFijo() {
        return precioFijo;
    }
    public int getContadorAutos() {
        return contadorAutos;
    }
    public int getTotalAutos () {
        return contadorAutos;
    }
    public boolean isDisponible () {
        return disponible;
    }

    //setters
    public void setColor(String color) {
        this.color = color;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }
    public void setPrecioFijo(double precioFijo) {
        this.precioFijo = precioFijo;
    }
    public void setDisponible(boolean d) {
        disponible = d;
    }


    // funcionalidades del auto
    public void encender() {
        System.out.println("El auto esá encendido.");
    }

    public void apagar() {
        System.out.println("El auto está apagado.");
    }

    public void acelerar() {
        System.out.println("El auto esta acelerando.");
    }

    public void frenar() {
        System.out.println("El auto esta frenando.");
    }

    // metodos para mostrar informacion
    public void mostrarInfoCarro() { 
        System.out.println("\n=== Información del auto " + id + " ===");
        System.out.println("ID: " + id);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Año: " + anio);
        System.out.println("Color: " + color);
        System.out.println("Precio Fijo: " + precioFijo);
        System.out.println("\n=====================================");
    }

}
