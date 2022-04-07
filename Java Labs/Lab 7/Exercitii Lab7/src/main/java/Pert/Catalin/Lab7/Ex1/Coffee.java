package Pert.Catalin.Lab7.Ex1;

public class Coffee{
    private int temp;
    private int conc;
    private static int countCoffees;

    Coffee(int t,int c){
        temp = t;
        conc = c;
        countCoffees++;
    }

    public static int getCountCoffees() {
        return countCoffees;
    }

    int getTemp(){return temp;}
    int getConc(){return conc;}
    public String toString(){return "[Coffee temperature="+temp+":concentration="+conc+"]";}
}//.class