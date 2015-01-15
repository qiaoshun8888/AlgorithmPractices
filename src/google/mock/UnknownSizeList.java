package google.mock;

public class UnknownSizeList {

	static class MyList {
		int size;

		public MyList(int size) {
			this.size = size;
		}

		public Object getObj(int index) {
			return index < 0 || index >= size ? null : new Object();
		}
	}

	public int getLength(MyList list) {
		if (list == null || list.getObj(0) == null) return 0;
		int start = 1, end = -1;
		while (true) {
			if (list.getObj(start) != null) start *= 2;
			else {
				end = start;
				start /= 2;
				break;
			}
		}
		int length = binarySearch(list, start, end) + 1;
		return length;
	}

	private int binarySearch(MyList list, int start, int end) {
		if (start <= end) {
			int mid = start + (end - start) / 2;
			if (list.getObj(mid) != null && list.getObj(mid + 1) == null) return mid;
			else if (list.getObj(mid) != null) return binarySearch(list, mid + 1, end);
			else return binarySearch(list, start, mid - 1);
		}
		return -1;
	}

	public static void main(String[] args) {
		MyList list = new MyList(178263721);
		UnknownSizeList o = new UnknownSizeList();
		System.out.println(o.getLength(list));
	}
}
