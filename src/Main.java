
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

public class Main extends Application {
        private long t=25;

    @Override

public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Hello world");
        Group root = new Group();

        GameScene theGameScene = new GameScene(root, 600, 400,true);

            //root.getChildren().add(theGameScene.getLeft().getIm());
            //root.getChildren().add(theGameScene.getRight().getIm());
        primaryStage.setScene(theGameScene);

        primaryStage.show();

        }


        public static void main(String[] args) {
        launch(args);
        }
}

