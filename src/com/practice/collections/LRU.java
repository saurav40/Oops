package com.practice.collections;

import java.util.HashMap;
import java.util.Map;

public class LRU<K, V> {
	// Capacity of
	private final int capacity;
	private final Map<K, Node<K, V>> cache;
	private final Node head;
	private final Node tail;

	public LRU(int capacity) {
		this.capacity = capacity;
		cache = new HashMap<>();
		head = new Node(null, null);
		tail = new Node(null, null);
		head.next = tail;
		tail.prev = head;
	}

	public void put(K key, V value) {
		Node node = cache.get(key);
		if (node != null) {
			remove(node);
		}
		node = new Node(key, value);
		add(node);
		cache.put(key, node);
		if (cache.size() > capacity) {
			remove(tail.prev);
		}
	}

	public V get(K key) {
		Node node = cache.get(key);
		if (node != null) {
			remove(node);
			add(node);
			return (V) node.value;
		}
		return null;
	}

	private void add(Node node) {
		node.prev = head;
		node.next = head.next;
		head.next.prev = node;
		head.next = node;
	}

	private void remove(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
		cache.remove(node.key);
	}

}
