package application;

import javafx.geometry.Rectangle2D;

public class Hero extends animateThing {
	
	//** VARIABLES **//
	
	
	
	//** CONSTRUCTEUR **//
	public Hero() {
		super(20, GameScene.getFloorLevel(), "pandaRoll2");
		//this.imageView.setViewport(new Rectangle2D(0,0,75,100));
		
	}

	//GETTERS//


	
	
	//SETTERS//
	


	
	//** METHODES **//
	
	
	public void update() {
        index = getIndex();
        if (index == 5) {
              setIndex(0);
        } else {
                setIndex(index + 1);
            }
        	
        if((this.jumpOk==false) & (this.fallOk==false)&(this.barrelRoll==false)) {
            	getImageView().setViewport(new Rectangle2D(index * 100 + 2, 2, 98, 110));
            }
        if((this.jumpOk==true)&(this.barrelRoll==false)) {
            		getImageView().setViewport(new Rectangle2D(2, 117, 98, 110));
            	}
            
        if((this.fallOk==true)&(this.barrelRoll==false)) {
        		getImageView().setViewport(new Rectangle2D(102, 117, 98, 110));
        	}
        if((this.barrelRoll==true)) {
        	getImageView().setViewport(new Rectangle2D(index*100+2, 230, 98, 110 ));
        }
	}
	
	
		
	
	

}
	
	
