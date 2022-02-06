package pert.catalin.lab2.ex4;

import java.util.Scanner;
import java.util.Vector;

public class ex4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Introducwti numarul de elemente al vectorului");
        int N = in.nextInt();
        int i;
        Vector A = new Vector(N);
        System.out.println("Introducwti elementele vectorului");
        for(i=0;i<=N-1;i++){
            int x = in.nextInt();
            A.add(i,x);
        }
        int max;
        max = (int) A.get(0);
        for(i=1;i<=N-1;i++){
            if((int) A.get(i) > (int) A.get(i-1)){
                max= (int) A.get(i);
            }
        }
        System.out.println("Numarul maxim din vector este "+max);
    }
}
