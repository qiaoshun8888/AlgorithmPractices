package crackingTheCodingInterview.chapter8;

import java.util.ArrayList;

public class FileSystem {

}

abstract class Entry {
	protected Directory parent;
	protected long created;
	protected long last_modified;
	protected long last_accessed;
	protected String name;
	
	public Entry(String n, Directory p) {
		name = n;
		parent = p;
		created = System.currentTimeMillis();
		last_modified = System.currentTimeMillis();
		last_accessed = System.currentTimeMillis();
	}
	
	public boolean delete() {
		if (parent == null) return false;
		return parent.deleteEntry(this);
	}
	
	public abstract int size();
	
	public String getFullPath() {
		if (parent == null) return name;
		return parent.getFullPath() + "/" + name;
	}
	
	public long getCreatedTime() {
		return created;
	}
	
	public long getLastModifiedTime() {
		return last_modified;
	}
	
	public long getLastAccessTime() {
		return last_accessed;
	}
	
	public void changeName(String n) {
		name = n;
	}
	
	public String getName() {
		return name;
	}
}

class File extends Entry {
	
	private String content;
	private int size;

	public File(String n, Directory p, int size) {
		super(n, p);
		this.size = size;
	}

	@Override
	public int size() {
		return size;
	}
	
	public String getContents() {
		return content;
	}
	
	public void setContents(String c) {
		content = c;
	}
}

class Directory extends Entry {

	private ArrayList<Entry> contents;
	
	public Directory(String n, Directory p) {
		super(n, p);
		contents = new ArrayList<Entry>();
	}

	@Override
	public int size() {
		int size = 0;
		for (Entry e : contents) {
			size += e.size();
		}
		return size;
	}
	
	public boolean deleteEntry(Entry entry) {
		return contents.remove(entry);
	}
	
	public void addEntry(Entry entry) {
		contents.add(entry);
	}
	
	protected ArrayList<Entry> getContents() {
		return contents;
	}
}