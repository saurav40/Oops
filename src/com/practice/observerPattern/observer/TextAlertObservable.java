package com.practice.observerPattern.observer;

import com.practice.observerPattern.observable.StockObservable;

public class TextAlertObservable implements NotificationAlertObserver{
	String userName;
	StockObservable stockObservable;
	public TextAlertObservable(String userName, StockObservable stockObservable) {
		this.userName = userName;
		this.stockObservable = stockObservable;
	}
	@Override
	public void update() {
		sendMessage(userName, "product is in stock, Hurry up!");
	}
	private void sendMessage(String userName, String msg) {
		System.out.println("msg sent to "+ userName);
	}

}
