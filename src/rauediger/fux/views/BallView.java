package rauediger.fux.views;

import processing.core.PApplet;
import rauediger.fux.models.AbstractModel;
import rauediger.fux.models.BallModel;
import rauediger.fux.objects.Color;

public class BallView extends AbstractView{

	public BallView(PApplet game) {
		super(game);
	}

	@Override
	public void draw(AbstractModel model) {
		try {
			BallModel ball = (BallModel) model;
			Color c = ball.getColor();
			game.fill(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha());
			game.ellipse(ball.getPosition().x, ball.getPosition().y, ball.getDimension().width, ball.getDimension().height);		
		} catch (ClassCastException e) {
			System.out.println(this.getClass().getName() + "--" + e.getMessage());
		}			
	}

}
