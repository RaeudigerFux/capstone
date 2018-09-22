package rauediger.fux.models;

import java.awt.Dimension;
import java.awt.Rectangle;

import rauediger.fux.objects.Color;
import rauediger.fux.objects.Observable;

public class PaddleModel extends AbstractModel implements Moveable, Collidible {

	private Dimension dimension;
	private int speed;
	private int directionH;

	public PaddleModel(Observable gameobject, int posX, int posY, Dimension dimension) {
		super(gameobject, posX, posY);
		this.dimension = dimension;
		speed = 5;
		directionH = Moveable.STOP;
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

	public void setDirectionH(int directionH) {
		this.directionH = directionH;
	}

	@Override
	public void update(Object object) {
		// TODO nothing to do yet
	}

	@Override
	public Rectangle getHitbox() {
		return new Rectangle(position.x, position.y, dimension.width, dimension.height);
	}

}
