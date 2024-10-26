package ejlassers;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // S = size parking lot
        int S = scanner.nextInt();

        // Number of beams sent by A
        int N = scanner.nextInt();
        // Number of beams sent by B
        int M = scanner.nextInt();

        List<LinearFunction> A = new ArrayList<>();
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

        for (int i=0; i < M ; i++) {
            String direction = scanner.next();
            int steps = scanner.nextInt();
            letterChanger changer = letterChanger.valueOf(direction);  // Convierte la dirección a enum
            int directionValue = changer.getValue();                   // Obtén el valor del enum

            if(directionValue == 1){
                LinearFunction linearFunction = new LinearFunction((double) -S/(S-steps), (double) (S * S) /(S-steps));
                A.add(linearFunction);
            }else {
                LinearFunction linearFunction = new LinearFunction((double) (-steps) /S, steps);
                A.add(linearFunction);
            }
            // Crear la función lineal con la pendiente basada en steps y directionValue
        }


//        IntersectionCounter intersections = new IntersectionCounter(A,S);

        int count = countInternalIntersections(A,S) + N + M;

        System.out.printf("%d", count );

        scanner.close();
    }

    public static int countInternalIntersections(List<LinearFunction> functions, double S) {
        int intersectionCount = 0;

        // Iterar sobre todas las combinaciones de pares de funciones
        for (int i = 0; i < functions.size(); i++) {
            for (int j = i + 1; j < functions.size(); j++) {
                LinearFunction f1 = functions.get(i);
                LinearFunction f2 = functions.get(j);

                // Calcular la intersección entre f1 y f2
                Double xIntersection = calculateIntersectionX(f1, f2);

                if (xIntersection != null) {
                    // Calcular el valor de y en el punto de intersección
                    double yIntersection = f1.calculate(xIntersection);

                    // Verificar si la intersección está estrictamente dentro del cuadrado (no en los bordes)
                    if (xIntersection > 0 && xIntersection < S && yIntersection > 0 && yIntersection < S) {
                        intersectionCount++;
                    }
                }
            }
        }

        return intersectionCount;
    }

    // Método para calcular la coordenada x de la intersección entre dos funciones lineales
    private static Double calculateIntersectionX(LinearFunction f1, LinearFunction f2) {
        double m1 = f1.getM();
        double b1 = f1.getB();
        double m2 = f2.getM();
        double b2 = f2.getB();

        // Si las pendientes son iguales, no hay intersección (son paralelas)
        if (m1 == m2) {
            return null;
        }

        // Calcular x de la intersección
        return (b2 - b1) / (m1 - m2);
    }
}
