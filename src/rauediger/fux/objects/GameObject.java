package rauediger.fux.objects;

import java.util.ArrayList;
import java.util.List;

import rauediger.fux.controller.AbstractController;
import rauediger.fux.models.AbstractModel;
import rauediger.fux.models.BallModel;
import rauediger.fux.models.Observer;
import rauediger.fux.starter.Game.EVENTS;
import rauediger.fux.views.AbstractView;

public class GameObject implements Observable {

	private AbstractModel model;
	private List<AbstractView> views = new ArrayList<AbstractView>();
	private AbstractController controller;
	private List<Observer> observers = new ArrayList<Observer>();

	public GameObject(AbstractModel model, AbstractController controller, AbstractView view) {
		this.model = model;
		this.controller = controller;
		this.controller.setGameObject(this);
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
	public void notifyAllOberservers(Enum<EVENTS> event) {
		if (model instanceof BallModel) {
			for (Observer observer : observers) {
				if (event == EVENTS.INCREASE_SCORE) {
					observer.update(String.valueOf(((BallModel) model).getTravelledDistance()));
				}
				if (event == EVENTS.INCREASE_SPEED) {
					observer.update(1);
				}
			}
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
