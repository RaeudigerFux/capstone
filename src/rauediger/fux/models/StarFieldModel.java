package rauediger.fux.models;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import rauediger.fux.objects.Observable;
import rauediger.fux.starter.Game;

public class StarFieldModel extends AbstractModel {

	private List<Point> stars = new ArrayList<>();
	private Dimension dimension;
	private int speed;

	public StarFieldModel(Observable gameobject, int posX, int posY) {
		super(gameobject, posX, posY);
		// set some random 2D positions for the stars
		Random rand = new Random();
		for (int i = 0; i <= 200; i++) {
			stars.add(new Point(rand.nextInt(Game.WIDTH), rand.nextInt(Game.HEIGHT)));
		}
		dimension = new Dimension(2, 2);
		speed = 2;
	}

	@Override
	public void update(Object object) {
		// nothing to do yet
	}

	public List<Point> getStars() {
		return stars;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void scroll() {
		stars.forEach(star -> {
			int newX = star.x + speed * Moveable.LEFT;
			if (newX > 0) {
				star.move(newX, star.y);
			} else {
				star.move(Game.WIDTH, star.y);
			}
			;
		});
	}

}
