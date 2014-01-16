package crackingTheCodingInterview.chapter8;

import java.util.LinkedList;

public class MHashTable<K, V> {

	static class Cell<K, V> {
		private K key;
		private V value;
		public Cell(K k, V v) {
			key = k;
			value = v;
		}
		
		public boolean isEquals(Cell<K, V> cell) {
			return key.equals(cell.key);
		}
		
		public boolean isEquals(K key) {
			return key.equals(key);
		}
		
		public K getKey() {
			return key;
		}
		
		public V getValue() {
			return value;
		}
	}
	
	private final int MAX_SIZE = 100;
	LinkedList<Cell<K, V>> [] items;
	
	@SuppressWarnings("unchecked")
	public MHashTable() {
		items = ((LinkedList<Cell<K, V>>[])new LinkedList[MAX_SIZE]);
	}
	
	public void put(K key, V value) {
		int x = hashCodeOfKey(key);
		if (items[x] == null) {
			items[x] = new LinkedList<Cell<K, V>>();
		}
		
		LinkedList<Cell<K, V>> collide = items[x];
		
		// Looking for the item with the same key and replace it if found.
		for (Cell<K, V> cell : collide) {
			if (cell.isEquals(key)) {
				collide.remove(cell);
				break;
			}
		}
		
		collide.add(new Cell<K, V>(key, value));
	}
	
	public V get(K key) {
		int x = hashCodeOfKey(key);
		if (items[x] == null) return null;
		for (Cell<K, V> cell : items[x]) {
			if (cell.isEquals(key)) return cell.getValue();
		}
		return null;
	}
	
	/* Really really stupid hash function */
	public int hashCodeOfKey(K key) {
		return key.toString().length() % items.length;
	}
}
