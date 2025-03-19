package com.practice.observerPattern.observable;

import java.util.ArrayList;
import java.util.List;

import com.practice.observerPattern.observer.NotificationAlertObserver;

public class IphoneObervableImple implements StockObservable {
    List<NotificationAlertObserver> observers = new ArrayList<>();
    public int stockCount = 0;
	@Override
	public void add(NotificationAlertObserver observer) {
		observers.add(observer);
	}

	@Override
	public void delete(NotificationAlertObserver observer) {
		observers.remove(observer);
	}

	@Override
	public void notifySubscribers() {
		for(NotificationAlertObserver observer : observers) {
			observer.update();
		}
	}
	
	public void setStockCount(int stock) {
		if(stockCount == 0) {
			notifySubscribers();
		}
		stockCount = stockCount + stock;
	}
	
	public int getStockCount() {
		return stockCount;
	}

}
