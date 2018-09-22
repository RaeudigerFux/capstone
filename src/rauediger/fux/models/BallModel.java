package rauediger.fux.models;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import rauediger.fux.objects.Color;
import rauediger.fux.objects.Observable;

public class BallModel extends AbstractModel implements Moveable, Collidible {

	private Dimension dimension;
	private int speed;
	private int directionH;
	private int directionV;
	private int travelledDistance;
	private boolean isAlive;

	public BallModel(Observable gameobject, int posX, int posY, Dimension dimension) {
		super(gameobject, posX, posY);
		this.dimension = dimension;
		directionH = Moveable.STOP;
		directionV = Moveable.DOWN; // start with falling down
		speed = 3;
		isAlive = true;
	}

	public BallModel(Observable gameobject, int posX, int posY, Dimension dimension, Color color) {
		this(gameobject, posX, posY, dimension);
		setColor(color);
	}

	public Dimension getDimension() {
		return dimension;
	}

	public int getSpeed() {
		return speed;
	}

	public int getDirectionH() {
		return directionH;
	}

	public void setDirectionH(int directionH) {
		this.directionH = directionH;
	}

	public int getDirectionV() {
		return directionV;
	}

	public int getTravelledDistance() {
		return travelledDistance;
	}

	public boolean isAlive() {
		return isAlive;
	}

	@Override
	public void update(Object object) {
		// TODO nothing to do yet
	}

	@Override
	public Rectangle getHitbox() {
		return new Rectangle(position.x, position.y, dimension.width, dimension.height);
	}

	@Override
	public void moveHorizontal(Point position, int speed, int direction, int edgeLeft, int edgeRight,
			Dimension objectDimension) {
		int newX = position.x + speed * direction;
		// move only if gameObject will not scroll out of viewport
		if (newX >= edgeLeft && newX + objectDimension.getWidth() <= edgeRight) {
			position.move(newX, position.y);
			travelledDistance += speed;
		} else {
			toggleDirectionH();
			increaseSpeed();
		}
	}

	@Override
	public void moveVertical(Point position, int speed, int direction, int top, int bottom) {
		int newY = position.y + speed * direction;
		if (newY > bottom) {
			isAlive = false;
		} else if (newY >= top) {
			position.move(position.x, newY); // moving out of viewport is allowed
			travelledDistance += speed;
		} else {
			toggleDirectionV();
			increaseSpeed();
		}
	}

	public void toggleDirectionH() {
		directionH = directionH * -1;
	}

	public void toggleDirectionV() {
		directionV = directionV * -1;
	}

	private void increaseSpeed() {
		++speed;
	}

}
