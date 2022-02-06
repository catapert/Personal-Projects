package pert.catalin.lab2.ex5;

import java.util.Scanner;
import java.util.Vector;

public class ex5 {
    static void bubbleSort(Vector arr) {
        int n;
        n = arr.size();
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if ((int)arr.get(j - 1) > (int)arr.get(j)) {
                    //swap elements
                    temp = (int) arr.get(j - 1);
                    arr.set(j-1,arr.get(j));
                    arr.set(j,temp);
                }

            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Vector A = new Vector(10);
        System.out.println("Introduceti elementele vectorului:");
        for(int i=0;i<=9;i++){
            int x = in.nextInt();
            A.add(i,x);
        }
        int i;
        System.out.println("Vector inainte de sortare");
        for(i=0; i <=9; i++){
            System.out.print(A.get(i) + " ");
        }
        System.out.println("");
        bubbleSort(A);
        System.out.println("Vector dupa sortare");
        for(i=0; i <=9; i++){
            System.out.print(A.get(i) + " ");
        }

    }
}
