package com.practice.observerPattern.observer;

import com.practice.observerPattern.observable.StockObservable;

public class EmailAlterObserverImpl implements NotificationAlertObserver {
	String emailId;
	StockObservable stockObservable;
	public EmailAlterObserverImpl(String emailId, StockObservable stockObservable) {
		// TODO Auto-generated constructor stub
		this.emailId = emailId;
		this.stockObservable = stockObservable;
	}
	@Override
	public void update() {
		sendEmail(emailId, "product is in stock. Hurry up!");
	}
   private void sendEmail(String emailId, String msg) {
	   System.out.println("mail sent to "+emailId);
   }
}
