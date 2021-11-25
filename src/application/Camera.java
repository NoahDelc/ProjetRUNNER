package application;

import javafx.geometry.Rectangle2D;

public class Camera {
	
	//** VARIABLES **//
	private double posX;
	private double posY;
	
	//** CONSTRUCTEUR **//
	public Camera(double posX,double posY) {
		this.posX = posX;
		this.posY = posY;
	}

	//GETTERS//
	public double getPosX() {return posX;}
	public double getPosY() {return posY;}
	
	//SETTERS//
	public void setPosX(int posX) {this.posX = posX;}
	public void setPosY(int posY) {this.posY = posY;}
	
	
	//** METHODES **//
	
	@Override
	public String toString() {
		return posX +", "+ posY;
		
	}
	
	//** METHODES **//
		public void update(long time) {
			
		}
}

