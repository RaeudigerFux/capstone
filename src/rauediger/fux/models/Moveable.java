package rauediger.fux.models;

import java.awt.Dimension;
import java.awt.Point;

public interface Moveable {

	final static int LEFT = -1;
	final static int RIGHT = 1;
	
	default void moveHorizontal(Point position, int speed, int direction, int edgeLeft, int edgeRight, Dimension dimension) {
		int newX = position.x + speed * direction;
		// move only if gameObject will not scroll out of viewport
		if (newX >= edgeLeft && newX + dimension.getWidth() <= edgeRight) {
			position.move(newX, position.y);
		}
	}

	default void toggleDirectionH(int direction) {
		direction = direction * -1;
	}

}
