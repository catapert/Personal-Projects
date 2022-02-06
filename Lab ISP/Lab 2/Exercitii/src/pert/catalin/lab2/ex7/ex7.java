package pert.catalin.lab2.ex7;

import java.util.Scanner;

public class ex7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int inf,sup;
        System.out.println("Alegeti cel mai mic numar posibil");
        inf=in.nextInt();
        System.out.println("Alegeti cel mai mare numar posibil");
        sup=in.nextInt();
        int random_nr =(int)(Math.random()*(sup-inf+1)+inf);
        System.out.println("Alegeti un numar intre "+inf+" si "+sup+" posibil");
        int vieti=3,nr,gasit=0;
        while(gasit==0 && vieti>0){
            nr=in.nextInt();
            if(nr==random_nr){
                System.out.println("Felicitari ai gasit numarul corect!");
                gasit=1;
            }
            if(nr>random_nr) {
                System.out.println("Numarul ales este prea mare.");
                vieti--;
            }
            if(nr<random_nr){
                System.out.println("Numarul ales este prea mic.");
                vieti--;
            }
        }
        if(vieti==0)
            System.out.println("GAME OVER!");
    }
}
