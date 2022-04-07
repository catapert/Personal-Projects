package pert.catalin.lab2.ex6;

import java.util.Scanner;

public class ex6_nerecursiv {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Introduceti numarul dorit");
        int N = in.nextInt();
        int fact=1 ,i;
        if(N>1){
            for(i=1; i<=N; i++)
                fact=fact*i;
        }
        if(N==1 || N==0){
            fact=1;
        }
        System.out.println(N+ "!= " +fact);


    }
}
