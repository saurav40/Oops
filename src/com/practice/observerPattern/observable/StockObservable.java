package com.practice.observerPattern.observable;

import com.practice.observerPattern.observer.NotificationAlertObserver;

public interface StockObservable {
	public void add(NotificationAlertObserver observer);
	public void delete(NotificationAlertObserver observer);
	public void notifySubscribers();
	public void setStockCount(int count);
}
