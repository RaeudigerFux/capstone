package rauediger.fux.views;

import processing.core.PApplet;
import rauediger.fux.models.AbstractModel;
import rauediger.fux.models.StarFieldModel;
import rauediger.fux.objects.Color;

public class StarFieldView extends AbstractView {

	public StarFieldView(PApplet game) {
		super(game);
	}

	@Override
	public void draw(AbstractModel model) {
		try {
			StarFieldModel stars = (StarFieldModel) model;
			Color c = stars.getColor();
			game.fill(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha());
			stars.getStars().forEach(s -> game.ellipse(s.x, s.y, stars.getDimension().width, stars.getDimension().height));
		} catch (ClassCastException e) {
			System.out.println(this.getClass().getName() + "--" + e.getMessage());
		}		
	}

}
