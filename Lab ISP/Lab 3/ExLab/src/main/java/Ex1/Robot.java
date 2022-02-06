package Ex1;

public class Robot {
    public int x;
    public Robot(){
        x=1;
    }
    public int AddK(int k){
        if(k>=0)
            x=x+k;
        return x;
    }
    public String toString(int x){
        return String.valueOf(x);
    }
    public int getX() {
        return x;
    }

}
