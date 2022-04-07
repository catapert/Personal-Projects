import java.lang.Math;
import java.util.Scanner;

public class primeNubers {
    public static boolean verifprim(int n) {

        if (n < 2) {
            return false;
        } else if (n == 2) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        } else {
            for (int i = 3; i <= Math.sqrt(n); i = i + 2) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;

        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Introduceti prima limita a intervalului");
        int x = in.nextInt();
        System.out.println("Introduceti a doua limita a intervalului");
        int y = in.nextInt();
        int k = 0, aux;
        if (x > y) {
            aux = x;
            x = y;
            y = aux;
        }
        for (int i = x; i <= y; i++) {
            if (verifprim(i)) {
                System.out.print(i + " ");
                k++;
            }

        }
        if(k==1){
            System.out.println("Este " + k + " numar prim");
        } else {
            if (k > 1) {
                System.out.println("Sunt " + k + " numere prime");
            } else {
                System.out.println("Nu sunt numere prime");
            }
        }
    }
}