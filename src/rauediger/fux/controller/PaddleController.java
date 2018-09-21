package rauediger.fux.controller;

import rauediger.fux.models.Moveable;
import rauediger.fux.models.PaddleModel;
import rauediger.fux.starter.Game;
import rauediger.fux.starter.Game.EVENTS;

public class PaddleController extends AbstractController {

	@Override
	public void handleEvent(Enum<EVENTS> event) {
		if (event == EVENTS.moveLeft || event == EVENTS.moveRight) {
			int direction = event == EVENTS.moveLeft ? Moveable.LEFT : Moveable.RIGHT;
			PaddleModel paddle = (PaddleModel) gameObject.getModel(); // not try/catch, getting model from its own gameObject
			paddle.moveHorizontal(paddle.getPosition(), paddle.getSpeed(), direction, 0, Game.WIDTH, paddle.getDimension());
			paddle.setDirectionH(direction);
		}
	}

}
