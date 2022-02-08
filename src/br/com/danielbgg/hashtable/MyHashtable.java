package br.com.danielbgg.hashtable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyHashtable {

	private class MyData {
		private String key;
		private Object value;

		public MyData(String key, Object value) {
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return key;
		}

		public Object getValue() {
			return value;
		}
		
		public String toString() {
			return key + ": " + value;
		}

	}

	private int size;
	public List<MyData>[] data;

	public MyHashtable(int size) {
		this.size = size;
		this.data = new List[size];
	}

	private int hash(String key) {
		int hash = 0;
		for (int i = 0; i < key.length(); i++) {
			hash = (hash + key.charAt(i) * i) % size;
		}
		return hash;
	}

	public void set(String key, Object value) {
		List<MyData> listOfValues = data[hash(key)];		
		if (listOfValues == null) {
			listOfValues = new ArrayList<MyData>();
			listOfValues.add(new MyData(key, value));
			data[hash(key)] = listOfValues;
		} else {
			// collision!
			listOfValues.add(new MyData(key, value));
		}
	}

	public Object get(String key) {
		List<MyData> values = data[hash(key)];
		if (values != null) {
			for (int i = 0; i < values.size(); i++) {
				MyData data = (MyData) values.get(i);
				if (data.getKey().equals(key)) {
					return data.getValue();
				}
			}
		}
		return null;
	}
	
	public List<String> keys() {
		List<String> keys = new ArrayList<String>();
		for (int i = 0; i < data.length; i++) {
			List<MyData> listOfValues = data[i];
			if (listOfValues != null) {
				for (int j = 0; j < listOfValues.size(); j++) {
					keys.add(listOfValues.get(j).getKey());
				}
			}
		}
		return keys;
	}
	

	public static void main(String[] args) {
		MyHashtable mine = new MyHashtable(2);
		mine.set("grapes", 100);
		mine.set("grapess", 200);
		mine.set("grape", 300);
		mine.set("grap", 400);
		for (int i = 0; i < mine.data.length; i++) {
			System.out.println("[" + i + "] " + mine.data[i] + " ");
		}
		System.out.println();
		System.out.println(mine.get("grapes"));
		System.out.println(mine.get("grapess"));
		System.out.println(mine.get("grape"));
		System.out.println(mine.get("grap"));
		System.out.println(mine.get("xx"));
		
		List<String> keys = mine.keys();
		for (Iterator<String> iterator = keys.iterator(); iterator.hasNext();) {
			System.out.println("Key: " + iterator.next());
		}
	}

}
