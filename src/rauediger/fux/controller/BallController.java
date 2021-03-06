package rauediger.fux.controller;

import java.awt.Rectangle;

import rauediger.fux.models.BallModel;
import rauediger.fux.starter.Game;
import rauediger.fux.starter.Game.EVENTS;

public class BallController extends AbstractController {

	@Override
	public void handleEvent(Enum<EVENTS> event) {
		BallModel ball = (BallModel) gameObject.getModel(); // not try/catch, getting model from its own gameObject

		if (event == EVENTS.AUTOMOVE) {
			ball.move(ball.getPosition(), ball.getSpeed(), ball.getDirectionH(), ball.getDirectionV(), ball.getDimension(),
					new Rectangle(0, 0, Game.WIDTH, Game.HEIGHT));
			gameObject.notifyAllOberservers(EVENTS.INCREASE_SCORE);
		}
		if (event == EVENTS.TOGGLE_DIRECTION_VERT) {
			ball.toggleDirectionV();
			gameObject.notifyAllOberservers(EVENTS.INCREASE_SPEED);
		}
	}

}
