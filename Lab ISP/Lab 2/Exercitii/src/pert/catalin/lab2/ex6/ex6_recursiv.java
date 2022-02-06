package pert.catalin.lab2.ex6;

import java.util.Scanner;

public class ex6_recursiv {
    static long factorial(int nr){
        if(nr>=1)
            return nr*factorial(nr-1);
        else
            return 1;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Introduceti numarul dorit");
        int N = in.nextInt();
        factorial(N);
        long fact=factorial(N);
        System.out.println(N+ "!= " +fact);
    }
}
