package crackingTheCodingInterview.chapter11;

import java.util.*;

/**
 * CircusTower.java
 * 
 * Description: A circus is designing a tower routine consisting of people
 * standing atop one another's shoulders. For practical and aesthetic reasons,
 * each person must be both shorter and lighter than the person below him or
 * her. Given the heights and weights of each person in the circus, write a
 * method to compute the largest possible number of people in such a tower.
 * 
 * EXAMPEL:
 * 
 * Input (ht, wt): (65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
 * 
 * Output: The longest tower is length 6 and includes from top to bottom: (56,
 * 90) (60,95) (65,100) (68,110) (70,150) (75,190)
 * 
 * @author John Qiao <qiaoshun8888@gmail.com> Date: Jan 29, 2014
 */

public class CircusTower {

	static class P {
		int h, w;

		public P(int h, int w) {
			this.h = h;
			this.w = w;
		}

		@Override
		public String toString() {
			return "P(" + h + ", " + w + ")";
		}
	}

	public static int count(List<P> array) {
		List<P> hList = new ArrayList<P>(array);
		Collections.sort(hList, new Comparator<P>() {
			@Override
			public int compare(P o1, P o2) {
				return o1.h > o2.h ? 1 : (o1.h < o2.h ? -1 : 0);
			}
		});
		List<P> wList = new ArrayList<P>(array);
		Collections.sort(wList, new Comparator<P>() {
			@Override
			public int compare(P o1, P o2) {
				return o1.w > o2.w ? 1 : (o1.w < o2.w ? -1 : 0);
			}
		});

		int size = hList.size();
		boolean[] bHList = new boolean[size];
		boolean[] bWList = new boolean[size];

		int h1 = 0, w1 = 0, h2 = 0, w2 = 0;

		for (int i = 0; i < size; i++) {
			P p1 = hList.get(i);
			P p2 = wList.get(i);
			if (p1.h > h1 && p1.w > w1) {
				bHList[i] = true;
				h1 = p1.h;
				w1 = p1.w;
			}
			if (p2.h > h2 && p2.w > w2) {
				bWList[i] = true;
				h2 = p2.h;
				w2 = p2.w;
			}
		}

		int bHNum = 0, bWNum = 0;

		for (boolean b : bHList) {
			if (b)
				bHNum++;
		}

		for (boolean b : bWList) {
			if (b)
				bWNum++;
		}

		// System.out.printf("bHNum: %d\t");

		return Math.max(bHNum, bWNum);
	}

	public static void main(String[] args) {
		List<P> list = new ArrayList<P>();
		// 1,1 2,2 2,4 3,3, 3,5 ,4,7, 7,8
		/*
		 * list.add(new P(1,1)); list.add(new P(2,2)); list.add(new P(2,4));
		 * list.add(new P(3,3)); list.add(new P(3,5)); list.add(new P(4,7));
		 * list.add(new P(7,8));
		 */

		/*
		 * list.add(new P(65, 100)); list.add(new P(70, 150)); list.add(new
		 * P(56, 90)); list.add(new P(75, 190)); list.add(new P(60, 95));
		 * list.add(new P(68, 110));
		 */

		/**/
		list.add(new P(12, 12));
		list.add(new P(11, 8));
		list.add(new P(10, 9));
		list.add(new P(9, 10));
		list.add(new P(8, 11));
		list.add(new P(7, 7));

		System.out.println(count(list));
	}
}
