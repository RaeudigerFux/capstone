package rauediger.fux.controller;

import rauediger.fux.starter.Game.EVENTS;

public class PlainTextController extends AbstractController {

	@Override
	public void handleEvent(Enum<EVENTS> event) {
		System.out.println("handleEvent()" + this.getClass().getName());
	}

}
