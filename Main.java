import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Interval implements Comparable<Interval> {
    int a;
    int b;

    public Interval(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Interval other) {
        return Integer.compare(this.a, other.a);
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer la entrada
        int N = scanner.nextInt();
        List<Interval> intervalos = new ArrayList<>();

        // Leer cada intervalo y almacenarlo en la lista
        for (int i = 0; i < N; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            intervalos.add(new Interval(a, b));
        }

        // Ordenar los intervalos por 'a'
        Collections.sort(intervalos);
        scanner.close();

        // Inicializar los límites de los fridges
        int T1 = 0, T2 = 0;
        int minA = intervalos.get(0).getA();
        int maxB = intervalos.get(0).getB();
        boolean split = false;
        boolean found = true;

        // Iterar a través de los intervalos para definir los límites de los fridges
        for (int i = 1; i < intervalos.size(); i++) {
            Interval intervalo = intervalos.get(i);

            // Verificar si el intervalo actual se solapa con el rango del primer grupo
            if (intervalo.getA() <= maxB && found) {
                // Extender el rango del primer grupo
                minA = Math.max(minA, intervalo.getA());
                maxB = Math.min(maxB, intervalo.getB());
            } else {
                // No hay solapamiento: fijamos el límite superior del primer grupo y el límite inferior del segundo grupo
                maxB = Math.max(maxB, intervalo.getA());
                found = false;
//                T1 = minA;              // Límite izquierdo del primer grupo
//                T2 = intervalo.getA();  // Límite izquierdo del segundo grupo
                split = true;
//                break;
            }
        }

            T1 = minA;
            T2 = maxB;


        // Imprimir el resultado esperado
        System.out.printf("%d %d%n", T1, T2);
    }
}
