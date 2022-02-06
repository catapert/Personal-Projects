package pert.catalin.lab2.ex1;
import java.util.Scanner;

public class ex1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("x=");
        int x = in.nextInt();
        System.out.println("y=");
        int y = in.nextInt();

        System.out.println("x="+x+" y="+y);
        if (x>y){
            System.out.println("Numarul maxim este x="+x);
        } else if (y>x) {
            System.out.println("Numarul maxim este y=" +y );
        } else{
            System.out.println("Numerele sunt egale");
        }
    }
}
