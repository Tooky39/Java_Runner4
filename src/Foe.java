import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Foe extends AnimatedThing{
    private ImageView Anime;
    private int num;
    private double start;

    public Foe(double v, double x, double y) {
        super(v, x, y);

        start = x;
        Image spriteSheet = new Image("Foe3.png");
        Anime = new ImageView(spriteSheet);
        Anime.setViewport(new Rectangle2D(0, 0, 130,170));//Rectangle2D.Double (double X, double Y, double W, double H)
        Anime.setX(x);
        Anime.setY(y);
    }

    public void update(double time,Camera cam) {
        System.out.println("xfoe ="+this.x);
        this.x=start-cam.getX()%(start+400);
        System.out.println("xfoe2 ="+x);
        this.y=200;

        this.Anime.setX(x);
        this.Anime.setY(y);

        if (this.x<-200){
            this.num++;
        }


    }

    public ImageView getAnime() {
        return Anime;
    }

    public int getNum() {
        return num;
    }
}


