package application;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class animateThing {
	
	//** VARIABLES **//
	protected double x;
	protected double y;
	public ImageView imageView;
	int state;
	private static int framerate;
	protected int index;
	private static int indexMax;
	private static int windowSize;
	private static int frameOffset;
	
	protected boolean jumpOk;
	protected boolean fallOk;
	protected boolean rollOk=true;
	protected boolean barrelRoll=false;
	protected boolean bounceOk=false;
	
	public int jumpIndex=0;
	public int fallIndex;
	public int rollIndex;
	public int bounceIndex;
	
	
	//** CONSTRUCTEUR **//
	/*public animateThing(double x, double y, String fileName ) {
		Image thingSpriteSheet = new Image("/Images/"+fileName+".png");
		this.imageView = new ImageView(thingSpriteSheet);
		this.imageView.setX(x);
		this.imageView.setY(y);
		this.setIndex(0);
		
		this.x = x;
		this.y = y;
		
		
		
	}*/
	
	public animateThing(double x,double y,String fileName){
        this.index = 0;
        Image thingSpriteSheet = new Image("/Images/"+fileName+".png");
		this.imageView = new ImageView(thingSpriteSheet);
		this.imageView.setX(x);
		this.imageView.setY(y);
  
        this.imageView.setViewport(new Rectangle2D(0,0,75,100));
        this.x=x;
        this.y=y;
    }
	







	//GETTERS//
	public ImageView getImageView() {return imageView;}
	
	public double getX() {return x;}
	public double getY() {return y;}
	
	public int getIndex() {return index;}
	
	
	public boolean isJumpOk() {return jumpOk;}
	public boolean isFallOk() {return fallOk;}
	
	public boolean isRollOk() {return rollOk;}
	public boolean isBarrelRoll() {return barrelRoll;}
	public boolean isBounceOk() {return bounceOk;}
	
	
	//SETTERS//
	public void setX(double x) {this.x = x;}
	public void setY(double y) {this.y = y;}
 
	public void setIndex(int index) {this.index = index;}
	
	public void setJumpOk(boolean jumpOk) {this.jumpOk = jumpOk;}
	public void setFallOk(boolean fallOk) {this.fallOk = fallOk;}
	
	public void setRollOk(boolean rollOk) {this.rollOk = rollOk;}
	public void setBarrelRoll(boolean barrelRoll) {this.barrelRoll = barrelRoll;}
	public void setBounceOk(boolean bounceOk) {this.bounceOk = bounceOk;}

	
	//** METHODES **//
	
    
    public void jump(int sens) {
		if(sens==0) {
			if (this.jumpIndex <= 40) {
				this.imageView.setY(getY()-8+(jumpIndex*0.2));
				this.setY(getY()-8+(jumpIndex*0.2));
				jumpIndex=jumpIndex+1;
			}
			
			if (this.jumpIndex == 40) {
				jumpIndex = 0;
				this.jumpOk= false;
				this.fallOk = true;
			}
		}
		else {
			if (this.jumpIndex <= 50) {
				this.imageView.setY(getY()+10-(jumpIndex*0.15));
				this.setY(getY()+10-(jumpIndex*0.15));
				jumpIndex=jumpIndex+1;
			}
			
			if (this.jumpIndex == 50) {
				jumpIndex = 0;
				this.jumpOk= false;
				this.fallOk = true;
			}
		}
    	
		
        
    }
    
public void fall() {
		
		if (this.getY() < GameScene.getFloorLevel()) {
			fallIndex=fallIndex+1;
			this.imageView.setY(getY()+(fallIndex*0.2));
			this.setY(getY()+(fallIndex*0.2));
			fallIndex=fallIndex+1;
		}
		
		if (this.getY() >= GameScene.getFloorLevel()) {
			this.setY(GameScene.getFloorLevel());
			this.fallIndex=0;
			this.fallOk= false;
			this.rollOk= true;
			this.barrelRoll=false;
		}
	}

public void roll() {
	if (this.rollIndex <= 25) {
		rollIndex=rollIndex+1;
	}
	
	if (this.rollIndex == 25) {
		rollIndex = 0;
		this.rollOk= false;
		this.barrelRoll=false;
	
	
	}
	
}
	
	public void bounce() {
		if (this.bounceIndex <= 30) {
			this.imageView.setY(getY()-6+(bounceIndex*0.2));
			this.setY(getY()-6+(bounceIndex*0.2));
			bounceIndex=bounceIndex+1;
		}
		if (this.bounceIndex == 2) {
			this.rollOk = true;
			GameScene.Score=GameScene.Score+1;
		}
		
		
		if (this.bounceIndex == 30) {
			bounceIndex = 0;
			this.bounceOk= false;
			this.fallOk = true;
			this.rollOk = true;
			GameScene.Score=GameScene.Score+1;
		}

}

}





















	
	
	
	
	




