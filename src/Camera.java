import javafx.geometry.Rectangle2D;
import java.lang.Math;

import static java.lang.Math.cos;
import static java.lang.Math.exp;

public class Camera {
    private double x;
    private double ax;
    private double vx;
    private int y;
    private int index=1;
    private double lenght=0.1;
    private double offset =200;
    private Hero hero;



    public Camera (int x, int y, Hero hero ){
        this.hero=hero;
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "x : "+x+", y : "+y;
    }

    public void update(double time){
/*
        this.ax= 1*(hero.getX()-this.x)-1.2*(10);
        System.out.println("ax ="+ax);
        this.vx+=ax*time;
        this.x+=vx*time;

 */



        //SANS RESSORT
       x=hero.getAnime().getX()-50;
        hero.getAnime().setX(hero.getAnime().getX()-this.x+100);
    }




    public double getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getOffset() {
        return offset;
    }

    public double getVx() {
        return vx;
    }
}
