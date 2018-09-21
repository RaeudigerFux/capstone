package rauediger.fux.controller;

import rauediger.fux.models.Moveable;
import rauediger.fux.models.PaddleModel;
import rauediger.fux.starter.Game;
import rauediger.fux.starter.Game.EVENTS;

public class PaddleController extends AbstractController {

	@Override
	public void handleEvent(Enum<EVENTS> event) {
		System.out.println("handleEvent() " + this.getClass().getName() + " - " + event.toString());
		if (event == EVENTS.moveLeft || event == EVENTS.moveRight) {
			int direction = event == EVENTS.moveLeft ? Moveable.LEFT : Moveable.RIGHT;
			PaddleModel m = (PaddleModel) gameObject.getModel();
			m.moveHorizontal(m.getPosition(), m.getSpeed(), direction, 0, Game.WIDTH, m.getDimension());
		}
		
		if (event == EVENTS.updateScore) {
			gameObject.notifyAllOberservers();
		}
	}

}
