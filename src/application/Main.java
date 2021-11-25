package application;
	
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public class Main extends Application {
	
	public GameScene theScene;
	@Override
	public void start(Stage primaryStage) throws Exception{
		
		primaryStage.setTitle("ULTRA SNOW PANDA VS ZOMBIES AND HIGH ZOMBIE FLAPPY BIRDS 2 DEFINITIVE EDITION");
		Group root = new Group();
		Pane pane = new Pane(root);
		GameScene theScene = new GameScene(pane, 800, 400,true);
		
		pane.getChildren().add(theScene.getBackground1().getImageView());
		pane.getChildren().add(theScene.getBackground2().getImageView());
		pane.getChildren().add(theScene.getHero().getImageView());
		pane.getChildren().add(theScene.getFoe(1).getImageView());
		pane.getChildren().add(theScene.getFoe(2).getImageView());
		
		pane.getChildren().add(theScene.getGameOverPane().getImageView());
		
		
		theScene.setFill(Color.BLACK);
		primaryStage.setScene(theScene);
		primaryStage.show();
		
	
		 }
	
	public static void main(String[] args) {
		launch(args);
	}
}

