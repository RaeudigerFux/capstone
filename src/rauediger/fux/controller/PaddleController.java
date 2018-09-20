package rauediger.fux.controller;

public class PaddleController extends AbstractController {

	@Override
	public void handleEvent() {
		System.out.println("handleEvent()" + this.getClass().getName());		
	}

}
