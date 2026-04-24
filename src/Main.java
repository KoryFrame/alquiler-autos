import java.time.LocalDate; //para obtener fecha al momento de la devolución
import java.util.Scanner; //leer entradas de datos

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        SistemaRenta renta =  new SistemaRenta(); //creamos un objeto paraa manejar el sistema del menu
        
    int opcion;

    do { 
        System.out.println("\n--- Sistema de Alquiler de Autos ---");
        System.out.println("1. Agregar cliente: ");
        System.out.println("2. Agregar auto: ");
        System.out.println("3. Registrar apartado:");
        System.out.println("4. Procesar devolucion: ");
        System.out.println("5. Mostrar apartados: ");
        System.out.println("6. Buscar cliente: ");
        System.out.println("7. Buscar auto: ");
        System.out.println("8. Salir: ");

        //leemos la opcion del usuario y validamos el formato
        opcion = Validaciones.leerEntero(read, "Seleccione una opción: "); 

        switch (opcion) {
            case 1:
                System.out.println("\n--- Agregar Cliente ---");
                String nombre =  Validaciones.leerSoloLetras(read, "Ingrese el nombre del cliente: "); 
                String telefono = Validaciones.leerTelefono(read, "Ingrese el teléfono del cliente: "); 
                String correo = Validaciones.leerCorreo(read, "Ingrese el correo del cliente: "); 
                String licencia = Validaciones.leerNumeroLicencia(read, "Ingrese el numero de licencia: "); 
                if (renta.existeCliente(nombre, telefono, correo, licencia)) {
                    System.out.println("Ya existe un cliente con esa información.");
                } else {
                    Cliente nuevo = new Cliente(nombre, telefono, correo, licencia); 
                    renta.agregarCliente(nuevo);
     
                    System.out.println("Cliente agregado correctamente.");
                }
                break; 
            case 2:
                System.out.println("\n--- Agregar auto ---");
                String color = Validaciones.leerSoloLetras(read, "Ingrese el color del auto: ");
                String modelo = Validaciones.leerSoloLetras(read, "Ingrese el modelo del auto: ");        
                String marca = Validaciones.leerSoloLetras(read,"Ingrese la marca del auto: "); 
                int anio = Validaciones.leerEntero(read, "Ingrese el año del auto: "); 
                double precioFijo = Validaciones.leerDouble(read, "Ingrese el precio fijo del auto: "); 

                RegistroAutos nuevoAuto = new RegistroAutos(0, color, modelo, marca, anio, precioFijo); 
                renta.agregarAuto(nuevoAuto);

                System.out.println("Auto agregado correctamente.");
                break;
            case 3:
                System.out.println("\n--- Registrar apartado ---");
                //leemos el numero de licencia y validamos que tenga el formato correcto(ej.AB123456)
                String numLicencia = Validaciones.leerNumeroLicencia(read, "Ingrese el numero de licencia del cliente: "); 
                Cliente cliente = renta.buscarCliente(numLicencia);

                //si el cliente no se enuentra en el sistema
                if (cliente == null) { 
                    System.out.println("Cliente no encontrado, por favor registre al cliente antes de crear un apartado.");
                } else { //sino
                    String marcaBusqueda = Validaciones.leerSoloLetras(read, "Ingrese la marca del auto: "); 
                    var autosEncontrados = renta.buscarAutosPorMarca(marcaBusqueda); 
                    if (autosEncontrados.isEmpty()) { 
                        System.out.println("no hay autos de esa marca."); 
                    } else { 
                      

                        for (RegistroAutos a : autosEncontrados) { 
                            a.mostrarInfoCarro(); 
                        }

                        int idAuto = Validaciones.leerEntero(read, "Seleccione el ID del auto: ");
                        RegistroAutos auto = renta.buscarAuto(idAuto);

                        //si el auto existe en el sistema
                        if (auto != null){ 
                            double anticipo = Validaciones.leerDouble(read, "Ingrese el anticipo para el apartado: ");
                            int dia = Validaciones.leerEntero(read, "Ingrese los dias del apartado: "); 

                            RegistroApartado apartado = renta.crearApartado(cliente, auto, anticipo, dia);
                            if (apartado != null) {
                                System.out.println("Apartado creado correctamente.");
                            } 
                        //si el auto no existe en el sistema
                        } else {
                            System.out.println("Auto no encontrado."); 
                        }
                    
                }
            }
                break; 
            case 4:
                System.out.println("\n--- Procesar devolución ---");
                //primero mostramos los apartados, para elegir uno
                renta.mostrarApartados(); 

                //Restamos 1 al número ingresado para ajustar el índice,
                int indice = Validaciones.leerEntero(read, "Ingrese el numero del apartado: ") -1; 
                RegistroApartado apartadoSeleccionado = renta.obtenerApartado(indice);
               
                if (apartadoSeleccionado != null) { 
                    //obtemos la fecha actual
                    String fecha = LocalDate.now().toString();
               
                    renta.procesarDevolucion(apartadoSeleccionado, fecha); 
                //si el apartado seleccionado no es válido
                } else { 
                    System.out.println("El número ingresado no corresponde a ningún apartado."); 
                }
                break;
            case 5: 
                renta.mostrarApartados(); 
                break; 
            case 6:
                System.out.println("\n--- Buscar cliente ---");
                System.out.println("1. Buscar cliente por licencia: "); 
                System.out.println("2. Buscar cliente por nombre: "); 

                int opcionBusqueda = Validaciones.leerEntero(read, "Seleccione una opción:"); 
                 if (opcionBusqueda == 1) { 
                     String licenciaBuscada = Validaciones.leerNumeroLicencia(read, "Ingrese el numero de licencia del cliente:");
                     Cliente c = renta.buscarCliente(licenciaBuscada); 
                     //si el cliente existe
                     if (c != null) { 
                        c.mostrarInfoCliente();
                    //si el cliente no existe
                     } else { 
                        System.out.println("Cliente no encontrado.");
                     } 
                    //si la opcion es igual a 2
                    } else if (opcionBusqueda == 2) { 
                        String nombreBuscado = Validaciones.leerSoloLetras(read, "Ingrese el nombre del cliente:");
                        var resultados = renta.buscarClientePorNombre(nombreBuscado); 
                        //si no se encuentra clientes con ese nombre
                        if (resultados.isEmpty()) { 
                            System.out.println("No se encontraron clientes."); 
                        // si se encuentran clientes
                        } else {
                            for (Cliente c : resultados) {
                                c.mostrarInfoCliente(); 
                            }
                        }
                    }
                    break;
                case 7:
                    System.out.println("\n--- Buscar auto ---");
                    System.out.println("1. Buscar auto por ID: ");
                    System.out.println("2. Buscar auto por marca: ");

                    int opcionAuto = Validaciones.leerEntero(read, "Ingresa una opción: ");
                    // si la opcion es igual a 1
                     if (opcionAuto == 1) { 
                        int idBuscado = Validaciones.leerEntero(read, "Ingrese el ID del auto: ");
                        RegistroAutos auto = renta.buscarAuto(idBuscado); 
                    
                        //si el auto existe en el sistema
                        if (auto != null) {
                            auto.mostrarInfoCarro();
                        //si el auto no existe
                        } else { 
                            System.out.println("Auto no encontrado.");
                        }
                         
                    //si la opcion es igual a 2
                     } else if (opcionAuto == 2) { 
                         String marcaBuscada = Validaciones.leerSoloLetras(read,"Ingrese la marca del auto: ");
                         var autos = renta.buscarAutosPorMarca(marcaBuscada);

                         //si no se encuentra autos de esa marca
                         if (autos.isEmpty()) { 
                            System.out.println("No hay autos de esa marca.");

                        //si se encuentra autos de esa marca
                         } else {
                            for (RegistroAutos a : autos) { 
                                a.mostrarInfoCarro();
                            }
                         }
                     }
                     break;
                     
                 
            case 8:
                System.out.println("Saliendo del sistema, te veo pronto!."); 
                break; 

        } 


        }  while (opcion != 8);  
        read.close();
     }  
    }
    
