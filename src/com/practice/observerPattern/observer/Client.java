package com.practice.observerPattern.observer;

import com.practice.observerPattern.observable.IphoneObervableImple;
import com.practice.observerPattern.observable.StockObservable;

public class Client {
	public static void main(String[] args) {
      // Subject or observable
	 StockObservable iphoneStockObservable = new IphoneObervableImple();
	 
	 // Observers/ subscripbers
	 NotificationAlertObserver observer1 = new EmailAlterObserverImpl("xyz@email.com", iphoneStockObservable);
	 NotificationAlertObserver observer2 = new EmailAlterObserverImpl("xyz12@email.com", iphoneStockObservable);
	 NotificationAlertObserver observer3 = new TextAlertObservable("xyz234", iphoneStockObservable);
	 
	 iphoneStockObservable.add(observer1);
	 iphoneStockObservable.add(observer2);
	 iphoneStockObservable.add(observer3);
	 
	 // State change of observable
	 iphoneStockObservable.setStockCount(10);
	 
	}
}
