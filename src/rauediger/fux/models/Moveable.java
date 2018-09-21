package rauediger.fux.models;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

public interface Moveable {

	final static int LEFT = -1;
	final static int RIGHT = 1;
	final static int UP = -1;
	final static int DOWN = 1;
	final static int STOP = 0;
	
	default void moveHorizontal(Point position, int speed, int direction, int edgeLeft, int edgeRight, Dimension objectDimension) {
		int newX = position.x + speed * direction;
		// move only if gameObject will not scroll out of viewport
		if (newX >= edgeLeft && newX + objectDimension.getWidth() <= edgeRight) {
			position.move(newX, position.y);
		}
	}

	default void moveVertical(Point position, int speed, int direction, int top, int bottom) {
		int newY = position.y + speed * direction;
		position.move(position.x, newY); // moving out of viewport is allowed
	}
	
	default void move(Point position, int speed, int directionH, int directionV, Dimension objectDimension, Rectangle viewport) {
		this.moveHorizontal(position, speed, directionH, viewport.x, (viewport.x + viewport.width), objectDimension);
		this.moveVertical(position, speed, directionV, viewport.y, (viewport.y + viewport.height));
	}

}
