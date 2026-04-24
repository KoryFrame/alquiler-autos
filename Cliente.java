

//definimos atributos para el cliente
public class Cliente {
    private static int contadorClientes = 0;
    private int idCliente;
    private String nomCompleto;
    private String numTelefono;
    private String correoElect;
    private String numLicencia;
   

    //constructor para inicializar los atributos del cliente
    public Cliente(String nomCompleto, String numTelefono, String correoElect, String numLicencia) {
        this.nomCompleto = nomCompleto;
        this.numTelefono = numTelefono;
        this.correoElect = correoElect;
        this.numLicencia = numLicencia;
        contadorClientes++;
        this.idCliente = contadorClientes;
    }

    //Getters
    public int getIdCliente() {
        return idCliente;
    }
   
    public String getNomCompleto() {
        return nomCompleto; 
    }
    public String getNumTelefono() {
        return numTelefono; 
    }
    public String getCorreoElect() {
        return correoElect; 
    }
    public String getNumLicencia() {
        return numLicencia; 
    }
    public static int getTotalClientes () {
        return contadorClientes;
    }
    //Setters
    public void setNomCompleto(String nomCompleto){
        this.nomCompleto = nomCompleto; 
    }
    public void setCorreoElect(String correoElect) {
        this.correoElect = correoElect; 
    }
    //establecemos el numero de telefono del cliente
    public void setNumTelefono(String numTelefono) { 
        this.numTelefono = numTelefono; 
    }
    public void setNumLiencia(String numLicencia) { 
        this.numLicencia = numLicencia; 
    }


    //informacion del cliente
    public void mostrarInfoCliente() { 
        System.out.println("\n=== Información del cliente " + idCliente + "===");
        System.out.println("Nombre: " + nomCompleto);
        System.out.println("Telefono: " + numTelefono);
        System.out.println("Correo: " + correoElect);
        System.out.println("Licencia: " + numLicencia);
        System.out.println("\n=====================================");
    }
}
