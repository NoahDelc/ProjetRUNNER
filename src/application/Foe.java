package application;

import javafx.geometry.Rectangle2D;

public class Foe extends animateThing{
	
	//** VARIABLES **//
	private int zombieJumperIndex=2;
	private boolean zombieJumper=false;
	
	
	//** CONSTRUCTEUR **//
		public Foe(int x, int y, String name) {
			super(x, y, name);
			//this.imageView.setViewport(new Rectangle2D(0,0,75,100));
			
		}
		
		
		public void update() {
	        index = getIndex();
	        if (index == 5) {
	              setIndex(0);
	        } else {
	                setIndex(index + 1);
	            }
	        if(zombieJumper==true) {
	        	getImageView().setViewport(new Rectangle2D(index * 100 + 2, 117, 97, 110));
	        }
	        else {
	        	getImageView().setViewport(new Rectangle2D(index * 100 + 2, 2, 97, 110));	
	        }
	        
	            
		}
		
		public void move(int speed, int distance, int y) {
	    	x = getX();
	        if(x<=-100){
	            getImageView().setX(distance);
	            setX(distance);
	            getImageView().setY(y);
	            setY(y);
	            GameScene.Score=GameScene.Score+1;
	            
	            
	            zombieJumperIndex=zombieJumperIndex+1;
	            if (zombieJumperIndex==5) {
	            	zombieJumperIndex=0;
	            	zombieJumper=true;
	            	
	            }
	            if(zombieJumperIndex==1) {
	            	zombieJumper=false;
	            }
	        }
	        else{
	            getImageView().setX(x-speed);
	            setX(x-speed);
	        }
	    }


		public int getZombieJumperIndex() {return zombieJumperIndex;}


		public void setZombieJumperIndex(int zombieJumperIndex) {this.zombieJumperIndex = zombieJumperIndex;}


		public boolean isZombieJumper() {return zombieJumper;}


		public void setZombieJumper(boolean zombieJumper) {this.zombieJumper = zombieJumper;}

}
