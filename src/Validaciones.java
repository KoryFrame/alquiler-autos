import java.util.Scanner; //importamos el scanner para que se lea en el Main

public class Validaciones {
    // leer solo enteros
    // estatico y variable del Scanner para ingresar el mensaje
    public static int leerEntero(Scanner read, String mensaje) {
        while (true) {
            // imprimos el mensaje puesto en Main
            System.out.print(mensaje);
            String input = read.nextLine();

            // verificamos los errores
            try {
                // retornamos un entero
                return Integer.parseInt(input);

            // si hay error entonces se hace una excepcion
            } catch (NumberFormatException e) {
                System.out.println("Solo se permiten números.");
            }
        }

    }

    // leer solo letras
    // estatico t variable del Scanner para ingresar el mensaje
    public static String leerSoloLetras(Scanner read, String mensaje) {
        while (true) {
            // imprimos el mensaje puesto en Main
            System.out.print(mensaje);
            String input = read.nextLine();
            // verificamos este rango de letras y que contenga solo letras
            if (input.matches("[a-zA-Z ]+")) {
                // retornamos ese input
                return input;
            } else {
                // sino se cumple entonces mensaje de error
                System.out.println("Solo se permiten letras.");
            }
        }
    }

    // leer numeros de licencia
    // estatico para solo leer licencia, con mensaje y la variable con la que se lee
    public static String leerNumeroLicencia(Scanner read, String mensaje) {
        while (true) {
            // imprirmos el mensaje
            System.out.print(mensaje);
            String input = read.nextLine();
            // verificamos este formato de licencia
            if (input.matches("[A-Z]{2}[0-9]{6}")) {
                return input;
            } else {
                // si falla, mensaje de error y un ejemplo
                System.out.println("Formato inválido. Ejemplo váido: AB123456");
            }
        }
    }

    // leer solo correos
    // estatico para formato de correo, variable y mensaje
    public static String leerCorreo(Scanner read, String mensaje) {
        // definimos el atributo de coreo
        String correo;
        // definimos el patron
        String patron = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        while (true) {
            // mostramos mensaje
            System.out.print(mensaje);
            // leemos input y eliminamos espacios en el correo
            correo = read.nextLine().trim();
            // verificamos si se cumple el patron
            if (correo.matches(patron)) {
                // sisi retornamos el correo
                return correo;
            } else {
                // sino entonces formato invladi con un ejemplo
                System.out.println("Correo inválido. Formato: ejemplo@dominio.com");
            }
        }
    }

    // leemos telefono del cliente
    // estatico para formato de telefono, variable y mensaje
    public static String leerTelefono(Scanner read, String mensaje) {
        while (true) {
            // mostramos el mensaje
            System.out.print(mensaje);
            String input = read.nextLine();
            // verificamos si el formato se cumple
            if (input.matches("\\d{10}")) {
                // sisi retornamos el input ingresado
                return input;
            } else {
                // sino entonces mensaje de error con ejemplo
                System.out.println("Ingrese un número de teléfono válido(10 dígitos).");
            }
        }
    }

    // leemos numero decimales
    // estatico para verificar cantidades decimales, variable y mensaje
    public static double leerDouble(Scanner read, String mensaje) {
        while (true) {
            // mostramos mensaje
            System.out.print(mensaje);
            String input = read.nextLine();
            // verifiamos si se cumple el formato en el rango
            if (input.matches("\\d+(\\.\\d{2})?")) {
                // reornamos un decimal
                return Double.parseDouble(input);
            } else {
                // sino mensaje de error y un mensaje
                System.out.println("Ingrese un número válido (ej. 13 o 13.50)");
            }
        }
    }
}
