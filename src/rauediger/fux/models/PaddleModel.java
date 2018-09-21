package rauediger.fux.models;

import java.awt.Dimension;

import rauediger.fux.objects.Color;
import rauediger.fux.objects.Observable;

public class PaddleModel extends AbstractModel implements Moveable {

	private Dimension dimension;
	private int speed;
	private int directionH;

	public PaddleModel(Observable gameobject, int posX, int posY, Dimension dimension) {
		super(gameobject, posX, posY);
		this.dimension = dimension;
		this.speed = 5;
		this.directionH = 0;
	}

	public PaddleModel(Observable gameobject, int posX, int posY, Dimension dimension, Color color) {
		this(gameobject, posX, posY, dimension);
		setColor(color);
	}

	public Dimension getDimension() {
		return dimension;
	}

	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDirectionH() {
		return directionH;
	}

	@Override
	public void update(Object object) {
		// TODO nothing to do yet
	}

}
