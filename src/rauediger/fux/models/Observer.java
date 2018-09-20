package rauediger.fux.models;

import rauediger.fux.objects.Observable;

public abstract class Observer {

	protected Observer(Observable subject) {
		if (null != subject) {
			subject.attachObserver(this);
		}
	}

	public abstract void update(Object object);

}
