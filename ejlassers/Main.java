package ejlassers;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // S = size parking lot
        int S = scanner.nextInt();

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
            if(directionValue == 1){
                LinearFunction linearFunction = new LinearFunction((double) S/steps, 0);
                A.add(linearFunction);
            }else {
                LinearFunction linearFunction = new LinearFunction((double) steps/S, 0);
                A.add(linearFunction);
            }
        }


        Set<LinearFunction> B = new HashSet<>();
        for (int i=0; i < M ; i++) {
            String direction = scanner.next();
            int steps = scanner.nextInt();
            letterChanger changer = letterChanger.valueOf(direction);  // Convierte la dirección a enum
            int directionValue = changer.getValue();                   // Obtén el valor del enum

            if(directionValue == 1){
                LinearFunction linearFunction = new LinearFunction((double) -S/(S-steps), (double) (S * S) /(S-steps));
                B.add(linearFunction);
            }else {
                LinearFunction linearFunction = new LinearFunction((double) (-steps) /S, steps);
                B.add(linearFunction);
            }
            // Crear la función lineal con la pendiente basada en steps y directionValue
        }





        scanner.close();
    }
}
