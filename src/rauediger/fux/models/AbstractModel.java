package rauediger.fux.models;

import java.awt.Point;

import rauediger.fux.objects.Observable;

public abstract class AbstractModel extends Observer {
	private Point position;

	protected AbstractModel(Observable gameobject, int x, int y) {
		super(gameobject);
		this.setPosition(new Point(x, y));
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}
	
}
