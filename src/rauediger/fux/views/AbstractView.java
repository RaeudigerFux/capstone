package rauediger.fux.views;

import processing.core.PApplet;
import rauediger.fux.models.AbstractModel;

public abstract class AbstractView {

	PApplet game;
	
	protected AbstractView(PApplet game) {
		this.game = game;
	}
	
	public abstract void draw(AbstractModel model);

}
