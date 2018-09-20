package rauediger.fux.models;

import java.awt.Dimension;

import rauediger.fux.objects.Color;
import rauediger.fux.objects.Observable;

public class PaddleModel extends AbstractModel {

	private Dimension dimension;

	public PaddleModel(Observable gameobject, int posX, int posY, Dimension dimension) {
		super(gameobject, posX, posY);
		this.dimension = dimension;
	}

	public PaddleModel(Observable gameobject, int posX, int posY, Dimension dimension, Color color) {
		this(gameobject, posX, posY, dimension);
		setColor(color);
	}

	public Dimension getDimension() {
		return dimension;
	}

	@Override
	public void update(Object object) {
		// TODO nothing to do yet		
	}

}
