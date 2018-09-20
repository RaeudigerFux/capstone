package rauediger.fux.models;

import java.awt.Point;

import rauediger.fux.objects.Color;
import rauediger.fux.objects.Observable;

public abstract class AbstractModel extends Observer {
	private Point position;
	private Color color;

	protected AbstractModel(Observable gameobject, int posX, int posY) {
		super(gameobject);
		this.setPosition(new Point(posX, posY));
		this.color = new Color();
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
