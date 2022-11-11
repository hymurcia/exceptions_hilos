package exceptions_hilos;

import javax.swing.JOptionPane;

/**
 *
 * @author Yessid Murcia
 */
public class Exceptions_hilos {

    public static void main(String[] args) {
//llamado al procemiento opciones de menu
        opMenu();
    }

//Opciones Menu
    public static void opMenu() {
        //Try catch donde lee los numeros enteros y verifica que no tenga letras.
        try {
//llamado a la funcion menu
            menu(Integer.parseInt(JOptionPane.showInputDialog("Seleccione la opción:\n1.Laboratorio de Excepciones.\n2. Demo de Hilos.\n3. Prueba de Excepciones.\n4. Salir")));
        } catch (NumberFormatException ed) {
//mensaje de la excepcion
            System.out.println("Intente otra vez. Usted ingreso algo diferente a un numero. " + ed.getMessage());
        }
    }

//llamado de procedimientos y funciones del menu
    public static void menu(int a) {
        switch (a) {
            case 1: {
//Try catch donde lee los numeros enteros y verifica que no tenga letras.
                try {
//llamado a la funcion del laboratorio de excepciones
                    labExceptions(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Numerador:")), Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Denominador:")));
                } catch (NumberFormatException ex) {
//mensaje de la excepcion
                    System.out.println("Intente otra vez. Usted ingreso algo diferente a un numero. " + ex.getMessage());
                }
            }
            break;
            case 2: {
                hilos();
                break;
            }
            case 3:
                formatoNumero();
                desborde();
                aritmetico();
                break;
            case 4:
                JOptionPane.showMessageDialog(null,"Adios...");
                System.out.println("Profe coloqueme 5.0 en esta entrega...");
                break;
            default:
                opMenu();
        }

    }

//laboratorio de excepciones
    public static void labExceptions(int a, int b) {
        try {
            //Try catch para verificar si divide por 0.
            try {
                System.out.println("Numerador: " + a + "\nDenominador: " + b + "\nResultado: " + (a / b) + "\n");

            } catch (ArithmeticException e) {
                System.out.println("\nError de division por 0: " + e.getMessage());
            }
            if ((a / b) < 10) {
                throw new Exception("\nEl resultado es menor a 10");
            }
        } catch (Exception es) {
            System.out.println("Excepcion!\nResultado < 10" + es.getMessage());
        }
    }

//Demo Hilos
    public static void hilos() {
        Hilos t1, t2, t3;

// Creación de los threads con parámetro tiempo aleatorio
        t1 = new Hilos("Hilo 1", (int) (Math.random() * 2000));

        t2 = new Hilos("Hilo 2", (int) (Math.random() * 2000));

        t3 = new Hilos("Hilo 3", (int) (Math.random() * 2000));

// Arrancamos los threads con el método start
        t1.start();

        t2.start();

        t3.start();

    }

//Prueba de excepciones
    //excepciones tratadas
    public static void formatoNumero() {

        int numero;
        String cadena = "  1";
        try {
            numero = Integer.parseInt(cadena);
        } catch (NumberFormatException ex) {
            System.out.println("No es un número, es una cadena de texto." + ex.getMessage());

        }
    }

    public static void desborde() {

        int v[] = new int[3];
        try {
            for (int i = 0; i < 5; i++) {
                v[i] = i;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("el tipo de índice erróneo, de datos en un arreglo." + ex.getMessage());

        }
    }

    public static void aritmetico() {

        int numero = 5, resultado;
        try {
            resultado = numero / 0;
            System.out.println(resultado);
        } catch (ArithmeticException ex) {
            System.out.println("Errores Matemáticos, como división por cero." + ex.getMessage());
        }

    }
}
