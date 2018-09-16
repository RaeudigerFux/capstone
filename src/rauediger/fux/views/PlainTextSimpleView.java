package rauediger.fux.views;

import processing.core.*;
import rauediger.fux.models.AbstractModel;
import rauediger.fux.models.PlainTextModel;

public class PlainTextSimpleView extends AbstractView {

	public PlainTextSimpleView(PApplet game) {
		super(game);
	}

	@Override
	public void draw(AbstractModel abstractModel) {
		try {
			PlainTextModel model = (PlainTextModel) abstractModel;
			game.textAlign(PConstants.CENTER);
			game.fill(model.getRed(), model.getGreen(), model.getBlue(), model.getAlpha());
			game.text(model.getText(), model.getPosition().x, model.getPosition().y);					
		} catch (ClassCastException e) {
			System.out.println(this.getClass().getName() + "--" + e.getMessage());
		}
	}

}
