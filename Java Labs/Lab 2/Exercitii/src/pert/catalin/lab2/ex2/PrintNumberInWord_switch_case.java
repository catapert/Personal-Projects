package pert.catalin.lab2.ex2;
import java.util.Scanner;

public class PrintNumberInWord_switch_case {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Alegeti un numar de la 1 la 9");
        int x = in.nextInt();
        String rezultat;

        switch (x){
            case 1: rezultat = "ONE";
                break;
            case 2: rezultat = "TWO";
                break;
            case 3: rezultat = "THREE";
                break;
            case 4: rezultat = "FOUR";
                break;
            case 5: rezultat = "FIVE";
                break;
            case 6: rezultat = "SIX";
                break;
            case 7: rezultat = "SEVEN";
                break;
            case 8: rezultat = "EIGHT";
                break;
            case 9: rezultat = "NINE";
                break;
            default: rezultat = "Numarul invalid";
                break;
        }
        System.out.println(rezultat);
    }
}
