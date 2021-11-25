package application;

import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;

public class GameScene extends Scene {
	//** VARIABLES **//

		private static staticThing background1;
		private static staticThing background2;
		private static staticThing gameOverPane;
		
		public static int Score=0;
		public Text text;
		
		private Hero hero;
		private static int floorLevel = 210;

		private Foe foe1;
		private Foe foe2;
		private boolean timestop=false;
		
		
		
		
	//** CONSTRUCTEUR **//
		public GameScene(Parent parent, double width, double height, boolean depthBuffer) {
			super(parent, width, height, depthBuffer);
			
			this.setBackground1(new staticThing(0,0,"neige"));
			this.setBackground2(new staticThing(800,0,"neige"));
			this.setGameOverPane(new staticThing(1000,600,"TNUL"));
		
			
			this.getBackground1().getImageView().setViewport(new Rectangle2D(0,0,this.getBackground1().getImageView().getFitHeight(),this.getBackground1().getImageView().getFitWidth()));
			this.getBackground2().getImageView().setViewport(new Rectangle2D(0,0,this.getBackground1().getImageView().getFitHeight(),this.getBackground1().getImageView().getFitWidth()));
			
			this.getGameOverPane().getImageView().setViewport(new Rectangle2D(0,0,0,0));
			
			this.hero= new Hero();
			this.foe1 = new Foe(1000, GameScene.floorLevel, "zombieJump");
			this.foe2 = new Foe(3800, GameScene.floorLevel-150, "highFlappyFall" );
			
			this.text = new Text(0,0, "Score : " + Score);
			
			
			//Animation
	        AnimationTimer timer = new AnimationTimer() {
	            private long lastUpdate = 0;
	            @Override
	            public void handle(long time) {
	            	if(timestop==false) {
	            		GameScene.update();
	            	}
	                if ((hero.isJumpOk() == true)&(timestop==false)) {
                    	hero.jump(0);
                    }
	                if ((hero.isJumpOk() == false)&(hero.isBounceOk()==false)&(hero.getY()<floorLevel)) {
                    	hero.setFallOk(true);
                    }
	                if ((hero.isBarrelRoll() == true)&(timestop==false)) {
                    	hero.roll();
                    }
	                if((hero.isBarrelRoll()==true)&(checkCollision()==true)&(timestop==false)) {
	                	hero.setFallOk(false);
	                	hero.fallIndex=0;
	                	hero.setBounceOk(true);
	                	hero.rollIndex=0;
	                }
	                if(hero.isBounceOk()==true) {
	                	hero.bounce();
	                	if (checkCollision()==true) {
	                		hero.bounceIndex=0;
	                	}
	                }
	                if ((hero.isFallOk() == true)&(timestop==false)) {
                    	hero.fall();
                    }
	                
	                if ((foe1.isJumpOk() == true)&(timestop==false)) {
                    	foe1.jump(0);
                    }
	                if ((foe1.isJumpOk() == false)&(foe1.getY()<floorLevel)) {
                    	foe1.setFallOk(true);
                    }
	                if ((foe1.isFallOk() == true)&(timestop==false)) {
                    	foe1.fall();
                    }
	                
	                if ((foe2.isJumpOk() == true)&(timestop==false)) {
                    	foe2.jump(1);
                    }
	                
	                if (time - lastUpdate >= 80_000_000) {
	                    if(timestop==false) {
	                    
	                    foe1.update();
	                    foe1.move(30,850,GameScene.floorLevel);
	                    foe2.update();
	                    foe2.move(52,1800,GameScene.floorLevel-150);
	                    
	                    if((foe1.getX()>=200)&(foe1.getX()<=220)&(foe1.isZombieJumper()==true)) {foe1.setJumpOk(true);}
	                    if((foe2.getX()>=270)&(foe2.getX()<=300)&(foe2.isZombieJumper()==true)) {foe2.setJumpOk(true);}
	                    
	                    hero.update();
	                    }
	            
	                    lastUpdate = time;
	                    //System.out.println("Collision : "+checkCollision());
	                    //System.out.println("TimeStop : "+timestop);
	                    //System.out.println("FallOk : "+hero.isFallOk());
	                    //System.out.println("JumpOk : "+hero.isJumpOk());
	                    //System.out.println("rollOk : "+hero.isRollOk());
	                    //System.out.println("Roll : "+hero.isBarrelRoll());
	                    //System.out.println("JumpOk : "+foe1.isJumpOk());
	                    
	                    
	                }
	                if ((checkCollision()==true)&(hero.isBarrelRoll()==false)) {
	                	timestop= true;
	                	System.out.println("GameOver");
	                	gameOver();
	                	this.stop();
	                	
	                }
	                 
	            }
	        };
	        timer.start();
	        
	        this.setOnKeyTyped( (event)->{
	        	//if (event.getCode()== KeyCode.ENTER ) {
	        		System.out.println("Jump");
	        		if (hero.getY()==floorLevel) {
	        			hero.setJumpOk(true);
	        			}
	        		if ((hero.getY()<floorLevel)&(hero.isRollOk()==true)) {
	        			hero.setBarrelRoll(true);
	        			hero.setRollOk(false);
	        			}
	        		//}
	        	});
	        
	   /*     this.setOnKeyReleased( (event)->{
	        	System.out.println("Jump");
	        	if (hero.getY()==245) {
	        		hero.jumpOk=false;
	        	}
	        	
	        	});*/


					
			
		} 
		
			
		//GETTERS//
		public staticThing getBackground1() {return background1;}
		public staticThing getBackground2() {return background2;}
		
		public Hero getHero() {return hero;}
		public Foe getFoe(int n) {
			if (n==1) {return foe1;}
			if (n==2) {return foe2;}
			else {return foe1;}
		}
		
		public static int getFloorLevel() {return floorLevel;}
		
		public staticThing getGameOverPane() {return gameOverPane;}
		
		public boolean isTimestop() {return timestop;}
		
		//SETTERS//
		public void setBackground1(staticThing background1) {this.background1 = background1;}
		public void setBackground2(staticThing background2) {this.background2 = background2;}
	

		public static void setFloorLevel(int floorLevel) {GameScene.floorLevel = floorLevel;}
		
		public void setGameOverPane(staticThing gameOverPane) {GameScene.gameOverPane = gameOverPane;}
		public void setTimestop(boolean timestop) {this.timestop = timestop;}
		
		
		//** METHODES **//		
		private static void update() {
	        double x1 = background1.getX();
	        double x2=background2.getX();
	        if(x2<=0){
	            background2.getImageView().setX(799);
	            background2.setX(799);
	            background1.getImageView().setX(0);
	            background1.setX(0);
	        }
	        else {
	            background1.getImageView().setX(x1 - 4);
	            background1.setX(x1-4);
	            background2.getImageView().setX(x2 - 4);
	            background2.setX(x2-4);
	        }
		}
		
		
		public void gameOver() {
			 gameOverPane.getImageView().setX(100);
			 gameOverPane.getImageView().setY(100);
	         //gameOverPane.setX(200);
			 System.out.println("Score : "+ Score);
	    	}
	    
	      public boolean checkCollision() {
	    	 
	    	  if ((hero.getX()+95 >foe1.getX()) & (hero.getX()<foe1.getX()+60) & (hero.getY()+90 > foe1.getY()) & (hero.getY()<foe1.getY()+90)) {
	    		  return true;
	    	  }
	    	  else {if ((hero.getX()+60 >foe2.getX()) & (hero.getX()<foe2.getX()+75) & (hero.getY()+95 > foe2.getY()) & (hero.getY()<foe2.getY()+60)) {
	    		  return true;
	    	  }
	    		  else  {return false;}
	    	  }
	    		
	    		
	    	}
}
	       

	



