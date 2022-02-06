package Ex4;

public class MyPoint {
    public int x;
    public int y;
    public MyPoint(){
        x=1;
        y=1;
    }
    public int GetX(){
        return x;
    }
    public int GetY(){
        return y;
    }
    public void setXY(int X, int Y){
        x=X;
        y=Y;
    }
    public String toString(int X, int Y){
        return "(" + X + "," + Y + ")";
    }
    public double distance(int X, int Y){
        return Math.sqrt(Math.pow((X-x),2)+Math.pow((Y-y),2));
    }
    public double distance(MyPoint exactly){
        return Math.sqrt(Math.pow((exactly.x-x),2)+Math.pow((exactly.y-y),2));
    }
}
