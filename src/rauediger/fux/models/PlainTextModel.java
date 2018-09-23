package rauediger.fux.models;

import rauediger.fux.objects.Color;
import rauediger.fux.objects.Observable;

public class PlainTextModel extends AbstractModel {

	private String text = "undefined!";

	public PlainTextModel(Observable gameobject, int x, int y, String text) {
		super(gameobject, x, y);
		this.text = text;
	}

	public PlainTextModel(Observable gameobject, int x, int y, String text, Color color) {
		this(gameobject, x, y, text);
		setColor(color);
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void update(Object object) {
		if (object instanceof String) {
			this.text = (String) object;
		}
	}
}
