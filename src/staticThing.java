import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class staticThing {
    private ImageView im;
    private double X;
    private double Y;
    private double index1;
    private double index2;
    private int offset;
    private int lenght = 5;

    private double C;


    public staticThing(double X, double Y, String fileName){

        this.X = X;
        this.Y = Y;
        //this.im = I;

        Image staticImage = new Image(fileName);
        im = new ImageView(staticImage);

        im.setX(X);
        im.setY(Y);
    }


    public ImageView getIm() {
        return im;
    }

    public void setX(double x) {
        X = x;
    }

    public void setY(double y) {
        Y = y;
    }

    public void setIm(ImageView im) {
        this.im = im;
    }

    public void update(long time, int offset, Camera camera){

        this.im.setViewport(new Rectangle2D(0,0,800,400));

        C=(this.X-(index2*lenght));
        if (C<=(-800)){
            this.X=0;
            index2 = (-800/(lenght));

        }
        this.im.setX(C);
        int B=0;
        this.im.setY(B);

        index2++;

    }



}
