package Ex5;

public class Flower{
    int petal;
    static int count=0;
    public Flower(int p){
        petal=p;
        System.out.println("New flower has been created!");
        count++;
    }

    public static void main(String[] args) {
        Flower f1 = new Flower(4);
        Flower f2 = new Flower(6);
        System.out.println("Number of constructed objects: " +f2.count);
    }
}