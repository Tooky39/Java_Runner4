import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Hero extends AnimatedThing{
    private ImageView Anime;
    private double offset=12;
    private double size=80;
    private double index=0;
    private double index2=0;
    private int lenght =10;
    private double gravity=330;


    public Hero (double x, double y,double Mood){
        super(x, y, Mood);

        Image spriteSheet = new Image("heros.png");
        Anime = new ImageView(spriteSheet);
        Anime.setViewport(new Rectangle2D(20, 0, 75, 100));//Rectangle2D.Double (double X, double Y, double W, double H)
        Anime.setX(x);
        Anime.setY(y);

        LongValue clong = new LongValue(System.nanoTime());

        AnimationTimer tm = new AnimationTimer() {

            public void handle(long time) {
                double now = (time-clong.V)/200000000.0;
                System.out.println(now);
                if(now>0.5) {
                    clong.V = time;
                    if(Hero.super.getMood()==0) {
                        Anime.setViewport(new Rectangle2D(offset + (size * index), 0, 75, 100));
                        index++;
                        if (index == 5) {
                            index = 0;
                        }
                    }
                    if(Hero.super.getMood()==1) {
                        Anime.setViewport(new Rectangle2D(offset + (size * index2), 165,75,100));
                        //index++;
                        //if (index == 5) {
                          //  index = 0;
                        //}
                    }
                }
            }
    };
        tm.start();}

    public ImageView getAnime(){
        return Anime;
    }

    public void update(double time) {
        this.vx = 200;
        this.x+=vx*time;
        this.y=240;
        this.vy = -400;

        this.Anime.setX(x);
        System.out.println("x ="+x);
        this.Anime.setY(y);
    }
//JUMP
    public void jump(double time){
        this.x+=vx*time;

        this.ay=10;
        this.vy+=(gravity)*time;
        this.y+=vy*time;
        System.out.println("y2 ="+y);

        this.Anime.setX(x);
        System.out.println("x2 ="+x);
        this.Anime.setY(y);

        if(vy>0){
            index2=1;
        }
        if(y>=240){
            Hero.super.setMood(0);
            index2=0;
        }

    }


    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    public double getVx() {
        return vx;
    }

}

