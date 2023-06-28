package com.practice.interrface;

public class MyClass2 {
	static final int client_id = MyInterface.CLIENT_ID;
	String client_name = MyInterface.CLIENT_NAME;

	@Override
	public String toString() {
		return "MyClass2 [client_id=" + client_id + ", client_name=" + client_name + "]";
	}

}
