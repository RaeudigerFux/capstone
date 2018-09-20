package rauediger.fux.objects;

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
import rauediger.fux.controller.AbstractController;
import rauediger.fux.models.AbstractModel;
import rauediger.fux.models.Observer;
import rauediger.fux.views.AbstractView;

public class GameObject implements Observable {

	private AbstractModel model;
	private List<AbstractView> views = new ArrayList<AbstractView>();
	private AbstractController controller;
	private PApplet game;
	private List<Observer> observers = new ArrayList<Observer>();
	
	public GameObject(PApplet game, AbstractModel model, AbstractController controller, AbstractView view) {
		this.game = game;
		this.model = model;
		this.controller = controller;
		views.add(view);
	}
	
	public AbstractModel getModel() {
		return model;
	}

	public AbstractController getController() {
		return controller;
	}
	
	public void addView(AbstractView view) {
		views.add(view);
	}

	public void removeView(AbstractView view) {
		views.remove(view);
	}
	
	public List<AbstractView> getViews() {
		return views;
	}

	@Override
	public void notifyAllOberservers() {
		for (Observer observer : observers) {
			observer.update(model.getPosition().x + "");
		}
	}

	@Override
	public void attachObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void detachObserver(Observer observer) {
		observers.remove(observer);		
	}

}
