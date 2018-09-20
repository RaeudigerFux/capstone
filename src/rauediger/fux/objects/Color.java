package rauediger.fux.objects;

public class Color {

	private float red;
	private float green;
	private float blue;
	private float alpha;

	public Color(float red, float green, float blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.alpha = 255;
	}

	public Color(float red, float green, float blue, float alpha) {
		this(red, green, blue);
		this.alpha = alpha;
	}

	public Color() {
		this(255, 255, 255);
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

	public void setRed(float red) {
		this.red = red;
	}

	public void setGreen(float green) {
		this.green = green;
	}

	public void setBlue(float blue) {
		this.blue = blue;
	}

	public void setAlpha(float alpha) {
		this.alpha = alpha;
	}
}
