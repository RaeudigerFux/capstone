package rauediger.fux.models;

import rauediger.fux.objects.Observable;

public class PlainTextModel extends AbstractModel {

	private String text = "undefined!";
	private float red;
	private float green;
	private float blue;
	private float alpha;
	
	public PlainTextModel(Observable gameobject, int x, int y, String text) {
		super(gameobject, x, y);
		this.text = text;
		setColor(255, 255, 255);
		setAlpha(255);
	}
	
	public PlainTextModel(Observable gameobject, int x, int y, String text, float red, float green, float blue, float alpha) {
		this(gameobject, x, y, text);
		setColor(red, green, blue);
		setAlpha(alpha);
	}
	
	public String getText() {
		return this.text;
	}
	
	public void setColor(float red, float green, float blue) {
		// TODO check input
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public void setAlpha(float alpha) {
		// TODO check input
		this.alpha = alpha;
	}

	public float getRed() {
		return red;
	}

	public float getGreen() {
		return green;
	}

	public float getBlue() {
		return blue;
	}

	public float getAlpha() {
		return alpha;
	}
	
}
