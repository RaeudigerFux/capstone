package rauediger.fux.views;

import processing.core.PApplet;
import rauediger.fux.models.AbstractModel;
import rauediger.fux.models.PaddleModel;
import rauediger.fux.objects.Color;

public class PaddleView extends AbstractView{

	public PaddleView(PApplet game) {
		super(game);
	}

	@Override
	public void draw(AbstractModel model) {
		try {
			PaddleModel paddle = (PaddleModel) model;
			Color c = paddle.getColor();
			game.fill(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha());
			game.rect(paddle.getPosition().x, paddle.getPosition().y, paddle.getDimension().width, paddle.getDimension().height);				
		} catch (ClassCastException e) {
			System.out.println(this.getClass().getName() + "--" + e.getMessage());
		}
		
	}

}
