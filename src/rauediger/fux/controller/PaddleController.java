package rauediger.fux.controller;

import rauediger.fux.objects.GameObject;
import rauediger.fux.starter.Game.EVENTS;

public class PaddleController extends AbstractController {

	@Override
	public void handleEvent(GameObject gameObject, Enum<EVENTS> event) {
		System.out.println("handleEvent() " + this.getClass().getName() + " - " + event.toString());
		if (event == EVENTS.updateScore) {
			gameObject.notifyAllOberservers();
		}
	}

}
