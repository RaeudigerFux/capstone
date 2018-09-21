package rauediger.fux.controller;

import rauediger.fux.objects.GameObject;
import rauediger.fux.starter.Game.EVENTS;

public abstract class AbstractController {

	protected GameObject gameObject;
	
	public abstract void handleEvent(Enum<EVENTS> event);
	
	public void setGameObject(GameObject gameObject) {
		this.gameObject = gameObject;
	}	
}
