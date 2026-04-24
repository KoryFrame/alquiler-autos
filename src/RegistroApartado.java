public class RegistroApartado {// definos los atributos del apartado
    private static int contadorApartados = 0;
    private int idApartado;
    private Cliente cliente;
    private RegistroAutos auto;
    private double montoAnticipo;
    private int diasApartado;
    private boolean estatusApartado;

    // Constructor
    // inicializamos los atributos
    public RegistroApartado(Cliente cliente, RegistroAutos auto, double anticipo, int diasApartado) { 
        this.cliente = cliente;
        this.auto = auto;
        this.montoAnticipo = anticipo;
        this.diasApartado = diasApartado;
        this.estatusApartado = true; // inicia activo
        contadorApartados++;
        this.idApartado = contadorApartados;                                                                                     
    }

    // Getters

    public int getIdApartado() {
        return idApartado;
    }
    public Cliente getCliente() {
        return cliente; 
    }

    public RegistroAutos getAuto() {
        return auto; 
    }

    public double getMontoAnticipo() {
        return montoAnticipo;
    }

    public int getDiasApartado() {
        return diasApartado; 
    }
    public int getTotalApartados() {
        return contadorApartados;
    }

    public boolean isActivo() {
        return estatusApartado;
    }

    // Setters
    public void setAnticipo(double anticipo) {
        this.montoAnticipo = anticipo; 
    }

    public void setDiasApartado(int diasApartado) {
        this.diasApartado = diasApartado;
    }

    // Métodos funcionales
    public void cancelarApartado() {

        if (estatusApartado == true) {
            // lo igualamos a falso para cancelarlo
            estatusApartado = false; 
            System.out.println("El apartado ha sido cancelado."); 

        } else {
            System.out.println("El apartado ya estaba cancelado o no existe.");
        }
    }

    public void confirmarCompra() {
        // confirmamos la comprar igualanado el estatus del apartado a false.
        estatusApartado = false;
        System.out.println("Compra confirmada.");
    }

    // Mostrar toda la información del apartado
    public void mostrarInfoApartado() {
        System.out.println("\n====== INFORMACIÓN DEL APARTADO" + idApartado + "======");

        System.out.println("\n--- Cliente ---");
        cliente.mostrarInfoCliente();

        System.out.println("\n------Información del Auto------");
        auto.mostrarInfoCarro();

        System.out.println("\n--- Apartado ---");
        System.out.println("Anticipo: $" + montoAnticipo);
        System.out.println("Días de apartado: " + diasApartado);
        System.out.println("Estado: " + (estatusApartado ? "Activo" : "Finalizado"));
        System.out.println("\n=====================================");
    }
}