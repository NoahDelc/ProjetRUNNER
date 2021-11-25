package application;

//import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class staticThing {
	//** VARIABLES **//
	private double x;
	private double y;
	private ImageView imageView;
	
	
	//** CONSTRUCTEUR **//
	public staticThing(double x, double y, String fileName ) {
		Image thingSpriteSheet = new Image("/Images/"+fileName+".png");
		this.imageView = new ImageView(thingSpriteSheet);
		this.imageView.setX(x);
		this.imageView.setY(y);
		
		this.x = x;
		this.y = y;
		
		
		
	}







	//GETTERS//
	public ImageView getImageView() {return imageView;}
	
	public double getX() {return x;}
	public double getY() {return y;}
	
	//SETTERS//
	public void setX(double x) {this.x = x;}
	public void setY(double y) {this.y = y;}

}
