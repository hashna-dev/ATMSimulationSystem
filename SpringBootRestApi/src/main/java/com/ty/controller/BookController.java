package com.ty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.service.BookService;

@RestController
public class BookController {

	@GetMapping("/books")
	public Book getBook() {
		Book book = new Book();
		book.setId(11);
		book.setName("MYLVE");
		book.setAuthor("VENKY");
		return book;

	}

	@Autowired
	private BookService service = new BookService();

	@GetMapping("/book")
	public List<Book> getAllBooks() {
		return service.getAllBook();

	}

	@PostMapping("/book")
	public Book addBook(@RequestBody Book book) {
		Book book2 = service.addBook(book);
		return book2;

	}

	@DeleteMapping("/book/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		service.deleteBook(id);
		return "Book deleted successfully.";
	}

	@PutMapping("/book/{id}")
	public Book updateBook(@RequestBody Book book, @PathVariable("id") int id) {
		Book res = service.UpdateBook(book, id);
		return res;
	}

}