package ejlassers;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

Class

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // L = size parking lot
        int L = scanner.nextInt();

        // Number of beams sent by A
        int N = scanner.nextInt();
        // Number of beams sent by B
        int M = scanner.nextInt();

        Set<> A = new HashSet();
        for (int i=0; i < N ; i++) {
            String direction = scanner.next();
            int steps = scanner.nextInt();

            A.add();
        }
        for (int i=0; i < M ; i++) {
            String direction = scanner.next();
            int steps = scanner.nextInt();

        }
        System.out.println("Direction: " + direction + ", Steps: " + steps);


        scanner.close();
    }
}
