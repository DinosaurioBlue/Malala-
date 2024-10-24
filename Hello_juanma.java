import java.util.InputMismatchException;
import java.util.Scanner;

public class Hello_juanma {
    public static void main(String[] args) {
        System.out.println("Hello Juanma");
        int j;
        System.out.println("Escribí un número");
        Scanner sc = new Scanner(System.in);
        try {
            j = sc.nextInt();
            System.out.println("El numero es:   " +j + " GRACIAS");
        } catch (InputMismatchException e) {
            System.out.println("Error al leer el número: " + e.getMessage());
        }

        sc.close();
    }
}

