package chapter8;

import java.util.ArrayList;

public class OnlineBookReaderSystem {
	private enum SearchType {
		Title, Author;
	}
	private OnlineBookReaderSystem _instance;
	
	private OnlineBookReaderSystem() {}
	
	public OnlineBookReaderSystem getInstance() {
		if (_instance == null) {
			_instance = new OnlineBookReaderSystem();
		}
		return _instance;
	}
	
	public ArrayList<Book> search(String str, SearchType st) {
		// return a book
		return null; 
	}
}

class User {
	String name;
	
	Book last_raed;
	int last_read_page;
}

class Book {
	String title;
	String author;
	
	private ArrayList<Page> pages;
	
	int pages_num;
	
	public Book() {
		
	}
}

class Page {
	String content;
}
