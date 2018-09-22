package rauediger.fux.controller;

import rauediger.fux.models.StarFieldModel;
import rauediger.fux.starter.Game.EVENTS;

public class StarFieldController extends AbstractController {

	@Override
	public void handleEvent(Enum<EVENTS> event) {
		// not try/catch, getting model from its own gameObject
		StarFieldModel stars = (StarFieldModel) gameObject.getModel();

		if (event == EVENTS.AUTOMOVE) {
			stars.scroll();
		}
	}

}
