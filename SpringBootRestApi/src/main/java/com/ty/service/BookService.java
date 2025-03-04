package com.ty.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ty.controller.Book;

@Component
public class BookService {

	public static List<Book> list = new ArrayList<Book>();

	static {
		list.add(new Book(1, "INDULEKHA", "OCHANDUMENON"));
		list.add(new Book(2, "MY LOVE", "KK"));
		list.add(new Book(3, "LADOO", "ON"));

	}

	public Book addBook(Book b) {
		list.add(b);
		return b;
	}

	
	
	public List<Book> getAllBook() {
     for (Book book : list) {
		}
		return list;
	}

	public void deleteBook(int id) {
		for (Book book : list) {
			if (book.getId() == id) {
				list.remove(book);
			}
		}

	}

	public Book UpdateBook(Book book, int id) {
		for (Book book2 : list) {
			if (book2.getId() == id) {
				list.add(book);
				return book;

			}

		}
		return book;

	}



	
}