package ejlassers;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // L = size parking lot
        int L = scanner.nextInt();

        // Number of beams sent by A
        int N = scanner.nextInt();
        // Number of beams sent by B
        int M = scanner.nextInt();

        Set<LinearFunction> A = new HashSet<>();
        for (int i=0; i < N ; i++) {
            String direction = scanner.next();
            int steps = scanner.nextInt();
            letterChanger changer = letterChanger.valueOf(direction);  // Convierte la dirección a enum
            int directionValue = changer.getValue();                   // Obtén el valor del enum

            // Crear la función lineal con la pendiente basada en steps y directionValue
            LinearFunction linearFunction = new LinearFunction((double) steps / directionValue, 0);
            A.add(linearFunction);
        }


        Set<LinearFunction> B = new HashSet<>();
        for (int i=0; i < M ; i++) {
            String direction = scanner.next();
            int steps = scanner.nextInt();
            letterChanger changer = letterChanger.valueOf(direction);  // Convierte la dirección a enum
            int directionValue = changer.getValue();                   // Obtén el valor del enum

            // Crear la función lineal con la pendiente basada en steps y directionValue
            LinearFunction linearFunction = new LinearFunction((double) steps / directionValue, 0);
            B.add(linearFunction);
        }



        scanner.close();
    }
}
