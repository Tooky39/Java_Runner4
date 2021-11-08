import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;


public class GameScene extends Scene {
    private Camera cam;
    private static staticThing left = new staticThing(0,0, "desert.png");
    private static staticThing right = new staticThing(800,0, "desert.png");
    private Hero Deku;
    private Foe Vilain0= new Foe(0,800 ,200);
    private Foe Vilain1= new Foe(0,800,200);
    private long t=25;
    private long t2=25;
    private int index=0;
    //private Foe[] myArray = new Foe[2];
    private ArrayList<Foe> List;


    public GameScene(Group root, double width, double height, boolean depthBuffer){
        super(root, width, height, depthBuffer);
        Deku = new Hero(50,240,0);
        cam =new Camera(0,0,Deku);
        //myArray[0]=Vilain0;
        //myArray[1]=Vilain1;
        List = new ArrayList<>();
        List.add(Vilain0);
        List.add(Vilain1);



        LongValue clong = new LongValue(System.nanoTime());

        AnimationTimer tm = new AnimationTimer() {
            public void handle(long time) {
                double now = (time-clong.V)/600000000.0;
                System.out.println(now);
                    clong.V = time;

                    if(Deku.getMood()==1){
                        Deku.jump(now);
                    }
                    if(Deku.getMood()==0) {
                        Deku.update(now);
                    }
                    List.get(Vilain0.getNum()).update(now, cam);
                    System.out.println("Xvilain ="+Vilain0.getNum());
                    cam.update(now);
                    update(now);

                    if (Deku.getHitBox().intersects((Vilain0.getHitBox()))){
                        System.out.println(("COLLISION COLLISION COLLISION COLLISION COLLISION!!!"));
                    }
                if (Deku.getHitBox().intersects((Vilain1.getHitBox()))){
                    System.out.println(("COLLISION COLLISION COLLISION COLLISION COLLISION!!!"));
                }


            }

        };
//start the timer
        tm.start();

        this.setOnMouseClicked((click) -> {
            System.out.println("Jump");
            Deku.setMood(1);
        }
        );

      root.getChildren().add(left.getIm());
      root.getChildren().add(right.getIm());
      root.getChildren().add(Deku.getAnime());
      root.getChildren().add(Vilain0.getAnime());
      root.getChildren().add(Vilain1.getAnime());
    }

    public staticThing getLeft() {
        return left;
    }

    public staticThing getRight() {
        return right;
    }


    public void update(double time){
        left.getIm().setViewport(new Rectangle2D(cam.getX()%800, 0,800,400 ));
        right.getIm().setViewport(new Rectangle2D(0, 0,800,400 ));
        right.getIm().setX(800-cam.getX()%800);
    }

    public ArrayList<Foe> getList() {
        return List;
    }
}
