package rauediger.fux.controller;

public class PlainTextController extends AbstractController {

	public PlainTextController() {
	}

	@Override
	public void handleEvent() {
		System.out.println("handleEvent()" + this.getClass().getName());
	}

}
