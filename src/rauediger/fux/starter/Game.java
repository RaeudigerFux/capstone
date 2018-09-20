package rauediger.fux.starter;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import processing.core.*;
import rauediger.fux.controller.PaddleController;
import rauediger.fux.controller.PlainTextController;
import rauediger.fux.models.PaddleModel;
import rauediger.fux.models.PlainTextModel;
import rauediger.fux.objects.Color;
import rauediger.fux.objects.GameObject;
import rauediger.fux.objects.Observable;
import rauediger.fux.views.AbstractView;
import rauediger.fux.views.PaddleView;
import rauediger.fux.views.PlainTextSimpleView;

public class Game extends PApplet {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 640;

	private PFont font;
	private List<GameObject> gameObjects = new ArrayList<>();

	public Game() {

		GameObject scoreText = new GameObject(this,
				new PlainTextModel(null, WIDTH / 2, HEIGHT / 2, "Hello openHPI", new Color(0, 0, 200)),
				new PlainTextController(), 
				new PlainTextSimpleView(this));

		GameObject paddle = new GameObject(this,
				new PaddleModel(null, (WIDTH / 2) - 50, HEIGHT - 25, new Dimension(100, 25), new Color(200, 0, 0)),
				new PaddleController(),
				new PaddleView(this));

		gameObjects.add(scoreText);
		gameObjects.add(paddle);

	}

	public void settings() {
		size(WIDTH, HEIGHT);
	}

	public void setup() {
		// https://fontlibrary.org/de/font/some-time-later (open source)
		setFont("ressources/sometimelater.otf", 64);

		background(0);
	}

	public void draw() {
		for (GameObject gameObject : gameObjects) {
			for (AbstractView view : gameObject.getViews()) {
				view.draw(gameObject.getModel());
			}
		}
	}

	/**
	 * Sets the font to use to a given font and size
	 * 
	 * @param name - the name of the font e.g "sometimelater.otf"
	 * @param size - the size of the font e.g. 64
	 */
	private void setFont(String name, float size) {
		try {
			font = createFont(name, size);
			textFont(font);
		} catch (RuntimeException e) {
			// if the given font was not found, fetch the first of installed fonts as
			// fallback
			font = createFont(PFont.list()[0], 24);
			textFont(font);
		}
	}

}
