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

    // Método para comparar intervalos según el valor de 'a'
    @Override
    public int compareTo(Interval other) {
        return Integer.compare(this.a, other.a);
    }

    @Override
    public String toString() {
        return "(" + a + ", " + b + ")";
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }
}
class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Paso 1: Leer la entrada
        int N = scanner.nextInt();

        List<Interval> intervalos = new ArrayList<>();

        // Leer cada intervalo y almacenarlo en la lista
        for (int i = 0; i < N; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            intervalos.add(new Interval(a, b));
        }

        // Paso 2: Ordenar los intervalos por 'a'
        Collections.sort(intervalos);

        System.out.println("Intervalos ordenados:");
        for (Interval intervalo : intervalos) {
            System.out.println(intervalo);
        }

        scanner.close();

        int minA = intervalos.get(0).getA();
        int maxB = intervalos.get(0).getB();
        Interval aux;
        int flag = 0;
        // Iteramos a través de los intervalos para ajustar el rango del intervalo auxiliar
        for (int i=0; i < intervalos.size();i++){
            if(maxB - intervalos.get(i).getA() >= 0){
                minA = Math.max(minA, intervalos.get(i).getA());
                maxB = Math.min(maxB, intervalos.get(i).getB());
            }
            else {
                int T1 = minA;
                int J = i;
                ++flag;
                break;

            }

        }
        if(flag != 0){
            int T1 = minA, T2 = minA;
        }
        else{

        }

