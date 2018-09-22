package rauediger.fux.starter;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import processing.core.*;
import rauediger.fux.controller.BallController;
import rauediger.fux.controller.PaddleController;
import rauediger.fux.controller.PlainTextController;
import rauediger.fux.models.BallModel;
import rauediger.fux.models.Moveable;
import rauediger.fux.models.PaddleModel;
import rauediger.fux.models.PlainTextModel;
import rauediger.fux.objects.Color;
import rauediger.fux.objects.GameObject;
import rauediger.fux.views.BallView;
import rauediger.fux.views.PaddleView;
import rauediger.fux.views.PlainTextSimpleView;

public class Game extends PApplet {

	public static final int WIDTH = 1024;
	public static final int HEIGHT = 800;

	public enum EVENTS {
		moveLeft, moveRight, automove, updateScore, toggleDirectionV
	};

	private PFont font;
	private List<GameObject> sceneGame = new ArrayList<>();
	private List<GameObject> sceneStart = new ArrayList<>();
	private List<GameObject> sceneGameOver = new ArrayList<>();

	private GameObject paddle;
	private GameObject ball;
	private boolean isGameRunning = false;

	public Game() {

		// construct the objects for start scene
		GameObject gameTitleText = new GameObject(
				new PlainTextModel(null, WIDTH / 2, HEIGHT / 2 - 300, "Squash", new Color(200, 0, 0)),
				new PlainTextController(), new PlainTextSimpleView(this));

		GameObject keysTextA = new GameObject(
				new PlainTextModel(null, WIDTH / 2, HEIGHT / 2 - 200, "a - move left", new Color(0, 0, 200)),
				new PlainTextController(), new PlainTextSimpleView(this));

		GameObject keysTextB = new GameObject(
				new PlainTextModel(null, WIDTH / 2, HEIGHT / 2 - 100, "d - move right", new Color(0, 0, 200)),
				new PlainTextController(), new PlainTextSimpleView(this));

		GameObject startText = new GameObject(
				new PlainTextModel(null, WIDTH / 2, HEIGHT / 2, "hit space to start", new Color(0, 0, 200)),
				new PlainTextController(), new PlainTextSimpleView(this));

		sceneStart.add(gameTitleText);
		sceneStart.add(keysTextA);
		sceneStart.add(keysTextB);
		sceneStart.add(startText);

		// construct the objects for game scene; paddle and ball are main gameObejcts
		paddle = new GameObject(
				new PaddleModel(null, (WIDTH / 2) - 50, HEIGHT - 25, new Dimension(100, 25), new Color(200, 0, 0)),
				new PaddleController(), new PaddleView(this));

		ball = new GameObject(new BallModel(null, WIDTH / 2, HEIGHT / 2, new Dimension(15, 15), new Color(0, 200, 150)),
				new BallController(), new BallView(this));

		GameObject scoreText = new GameObject(new PlainTextModel(ball, WIDTH / 2, HEIGHT / 2, "0", new Color(0, 0, 200)),
				new PlainTextController(), new PlainTextSimpleView(this));

		sceneGame.add(scoreText);
		sceneGame.add(paddle);
		sceneGame.add(ball);

		// construct the objects for game over scene
		GameObject gameOverText = new GameObject(
				new PlainTextModel(null, WIDTH / 2, HEIGHT / 2 - 200, "GAME OVER", new Color(200, 0, 0)), new PlainTextController(),
				new PlainTextSimpleView(this));
		
		GameObject gameOverScoreText = new GameObject(
				new PlainTextModel(null, WIDTH / 2, HEIGHT / 2 - 100, "your score is", new Color(0, 0, 200)), new PlainTextController(),
				new PlainTextSimpleView(this));

		sceneGameOver.add(gameOverText);
		sceneGameOver.add(gameOverScoreText);
		sceneGameOver.add(scoreText);		

	}

	public void settings() {
		size(WIDTH, HEIGHT);
	}

	public void setup() {
		// https://fontlibrary.org/de/font/some-time-later (open source)
		setFont("ressources/sometimelater.otf", 64);
		background(0);
		frameRate(30);
	}

	public void draw() {
		// clear screen
		fill(0);
		rect(0, 0, WIDTH, HEIGHT);

		// handle user commands
		if (keyPressed) {
			handleKeyboardEvent(key);
		}

		// move the ball
		if (isGameRunning && ((BallModel) ball.getModel()).isAlive()) {
			ball.getController().handleEvent(EVENTS.automove);
		}

		// draw the active scene
		if (!isGameRunning) {
			sceneStart.forEach(o -> o.getViews().forEach(v -> v.draw(o.getModel())));
		} else if (!((BallModel) ball.getModel()).isAlive()) {
			sceneGameOver.forEach(o -> o.getViews().forEach(v -> v.draw(o.getModel())));
		} else if (isGameRunning) {
			sceneGame.forEach(o -> o.getViews().forEach(v -> v.draw(o.getModel())));
		}

		// simplest collision check
		checkCollision();
	}

	private void handleKeyboardEvent(int key) {
		switch (key) {
		case 'a':
			paddle.getController().handleEvent(EVENTS.moveLeft);
			break;
		case 'd':
			paddle.getController().handleEvent(EVENTS.moveRight);
			break;
		case 32:
			isGameRunning = true;
			break;
		default:
			((PaddleModel) paddle.getModel()).setDirectionH(Moveable.STOP);
			break;
		}
	}

	private void checkCollision() {
		// check if ball intersects with the paddle
		Rectangle hitboxBall = ((BallModel) ball.getModel()).getHitbox();
		Rectangle hitboxPaddle = ((PaddleModel) paddle.getModel()).getHitbox();
		if (hitboxBall.intersects(hitboxPaddle)) {
			ball.getController().handleEvent(EVENTS.toggleDirectionV);
			((BallModel) ball.getModel()).setDirectionH(((PaddleModel) paddle.getModel()).getDirectionH());
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
