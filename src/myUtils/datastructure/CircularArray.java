package myUtils.datastructure;

import java.util.Iterator;

/**
 * CircularArray.java
 * 
 * Description: A Circular Array class that supports an array-like
 * data structure which can be efficiently rotated. 
 * 
 * The class uses a generic type, and supports iteration via the standard 
 * for (Obj o : circuLarArray) notation.
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 28, 2014
 */

public class CircularArray<T> implements Iterable<T>{

	private T [] items;
	private int head;
	
	@SuppressWarnings("unchecked")
	public CircularArray(int size) {
		items = (T[])new Object[size];
	}
	
	private int convert(int index) {
		if (index < 0) {
			index %= items.length;
			index += items.length;
		}
		return (head + index) % items.length;
	}
	
	public void rotate(int shiftRight) {
		head = convert(shiftRight);
	}
	
	public T get(int i) {
		return items[convert(i)];
	}
	
	public void set(int i, T item) {
		items[convert(i)] = item;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (T t: items) {
			sb.append(t + ", ");
		}
		String s = sb.toString();
		return s.substring(0, s.length() - 2) + "}";
	}

	@Override
	public Iterator<T> iterator() {
		return new CircularArrayIterator<T>(this); 
	}
	
	private class CircularArrayIterator<TI> implements Iterator<TI> {
		// Iterate from the rotated head not the actual start of the array
		private int _current = -1;
		private TI[] _items;
		
		public CircularArrayIterator(CircularArray<TI> o) {
			this._items = o.items;
		}
		
		@Override
		public boolean hasNext() {
			return _current < items.length - 1;
		}
		
		@Override
		public TI next() {
			_current++;
			TI item = (TI)_items[convert(_current)];
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("...");
		}
	}
}
