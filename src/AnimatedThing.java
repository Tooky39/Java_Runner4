import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

abstract public class AnimatedThing {
    protected double x;
    protected double y;
    protected double ax;
    protected double vx;
    protected double ay;
    protected double vy;
    private double duration;
    private double Mood=0;



    public AnimatedThing(double v, double x, double y){
        this.x = x;
        this.y = y;

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setMood(double mood) {
        Mood = mood;
    }

    public double getMood() {
        return Mood;
    }

    public Rectangle2D getHitBox(){
        return new Rectangle2D(this.x,this.y,75, 100);
    }
}
