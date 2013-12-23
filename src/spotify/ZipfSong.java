package spotify;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.*;

public class ZipfSong {

	int rank_num;
	Scanner in;
	List<Item> item_list;

	static class Item {
		long play;
		double q_v, f_v; // q_v: quality, f_v: value that Zipf's Law predicted.
		String name;

		public Item(long play, String name) {
			this.play = play;
			this.name = name;
		}

		public Item(String str) {
			this.play = Integer.parseInt(str.split(" ")[0]);
			this.name = str.split(" ")[1];
		}
	}

	public ZipfSong(int rank_num, List<Item> item_list) {
		this.rank_num = rank_num;
		this.item_list = item_list;
	}

	public ZipfSong(String file_url) {
		item_list = new ArrayList<Item>();
		try {
			boolean first_line = false;
			in = new Scanner(new File(file_url));
			while (in.hasNext()) {
				String line = in.nextLine();
				if (!first_line) {
					first_line = true;
					// total_num = Integer.parseInt(line.split(" ")[0]);
					rank_num = Integer.parseInt(line.split(" ")[1]);
				} else {
					item_list.add(new Item(line));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Item> getOutput() {
		applyZipfLaw();
		return item_list.subList(0, rank_num);
	}

	private void applyZipfLaw() {
		if (item_list.size() != 0) {
			long n = item_list.get(0).play;
			for (int i = 0; i < item_list.size(); i++) {
				Item item = item_list.get(i);
				item.f_v = (double) n / ((i + 1) * n);
				item.q_v = item.play / item.f_v;
			}
		}
		sortList();
	}

	private void sortList() {
		Collections.sort(item_list, new Comparator<Item>() {
			public int compare(Item i1, Item i2) {
				return i2.q_v > i1.q_v ? 1 : (i2.q_v == i1.q_v ? 0 : -1);
			}
		});
	}

	public static void main(String[] args) {
		/*
		 * String file_url = null; if (args.length != 0) {
		 * System.out.println("args[0]: " + args[0]); file_url = args[0]; } else
		 * { file_url = "./src/spotify/test_data2.txt"; } ZipfSong zs = new
		 * ZipfSong(file_url); for (Item item : zs.getOutput()) {
		 * System.out.println(item.name); }
		 */
		
		/*
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					System.in));
			String line = reader.readLine();
			int total_num = Integer.parseInt(line.split(" ")[0]);
			int rank_num = Integer.parseInt(line.split(" ")[1]);
			List<Item> list = new ArrayList<Item>();
			for (int i = 0; i < total_num; i++) {
				line = reader.readLine();
				list.add(new Item(line));
			}
			ZipfSong zs = new ZipfSong(rank_num, list);
			for (Item item : zs.getOutput()) {
				System.out.println(item.name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		int m = 5, n = 2;
		System.out.println(m > n >> 1);
	}
}
