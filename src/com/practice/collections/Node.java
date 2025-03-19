package com.practice.collections;

public class Node<K, V> {
	K key;
	V value;
	Node next;
	Node prev;

	public Node(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

}
