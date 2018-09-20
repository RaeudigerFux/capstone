package rauediger.fux.controller;

import rauediger.fux.objects.GameObject;
import rauediger.fux.starter.Game.EVENTS;

public abstract class AbstractController {

	public abstract void handleEvent(GameObject gameObject, Enum<EVENTS> event); 
	
}
