//definimos los atributos para la clase devolucion apartado
public class DevolucionApartado { 
    String fechaDevolucion;
    boolean estatusDevolucion;
    double montoDevuelto;
    //referencia al apartado que se va a devolver
    RegistroApartado referenciaApartado; 

    //constructor para inicializar atributos
    public DevolucionApartado(String fechaDevolucion, RegistroApartado referenciaApartado) { 
        this.fechaDevolucion = fechaDevolucion; 
        this.referenciaApartado = referenciaApartado;
        this.estatusDevolucion = false; 
    }
    //getters
    //retornamos la fecha de devolucion
    public String getFechaDevolucion() { 
        return fechaDevolucion; 
    }
    //retornamos el estatus de devolucion
    public boolean isEstatusDevolucion() { 
        return estatusDevolucion;
    }
    //retornamos el monto devuelto
    public double getMontoDevuelto() {
        return montoDevuelto;
    }

    //metodo para procesar la devolucion
    public void procesarDevolucion() {
        if (estatusDevolucion) {
            System.out.println("La devolución ya fue procesada previamente."); 
            return; 
        }

        //verificamos que el apartado de referencia no sea nulo y este activo
        if (referenciaApartado != null && referenciaApartado.isActivo()) {
            montoDevuelto = calcularMontoDevolucion(); 
            estatusDevolucion = true;
            referenciaApartado.getAuto().setDisponible(true);
            referenciaApartado.cancelarApartado(); 
            System.out.println("Devolución procesada el:" + fechaDevolucion);
            System.out.println("Monto devuelto: $" + montoDevuelto); 
        } else {
            System.out.println("No hay apartado, no hay devolucion.");
        }
    }

    //metodo para calcular monto y cancelar apartado
    public double calcularMontoDevolucion() {
        return referenciaApartado.getMontoAnticipo(); //calculamos el monto
    }

}
