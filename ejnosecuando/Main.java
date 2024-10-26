package ejnosecuando;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el valor de N
        int N = scanner.nextInt();

        // Leer el conjunto A
        int X = scanner.nextInt();
        Set<Integer> A = new HashSet<>();
        for (int i = 0; i < X; i++) {
            int element = scanner.nextInt();
            A.add(element);
        }

        // Leer el conjunto B
        int Y = scanner.nextInt();
        Set<Integer> B = new HashSet<>();
        for (int i = 0; i < Y; i++) {
            int element = scanner.nextInt();
            B.add(element);
        }
    }
}