package rauediger.fux.controller;

import rauediger.fux.models.Moveable;
import rauediger.fux.models.PaddleModel;
import rauediger.fux.starter.Game;
import rauediger.fux.starter.Game.EVENTS;

public class PaddleController extends AbstractController {

	@Override
	public void handleEvent(Enum<EVENTS> event) {
		if (event == EVENTS.MOVE_LEFT || event == EVENTS.MOVE_RIGHT) {
			int direction = event == EVENTS.MOVE_LEFT ? Moveable.LEFT : Moveable.RIGHT;
			PaddleModel paddle = (PaddleModel) gameObject.getModel(); // not try/catch, getting model from its own gameObject
			paddle.moveHorizontal(paddle.getPosition(), paddle.getSpeed(), direction, 0, Game.WIDTH, paddle.getDimension());
			paddle.setDirectionH(direction);
		}
	}

}
