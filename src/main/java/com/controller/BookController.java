package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.BookBean;
import com.dao.BookDao;

@RestController
@CrossOrigin
public class BookController {

	@Autowired
	BookDao bookDao;

	/*
	 * @PostMapping(value = "/addbook") public String addBook(BookBean bookBean) {
	 * 
	 * int status = bookDao.addBook(bookBean); if (status > 0) {
	 * 
	 * return "BOOK addDED"; }
	 * 
	 * return "BOOK NOT ADDED";
	 * 
	 * }
	 */

	@PostMapping(value = "/addbook")
	public ResponseEntity addBook(@RequestBody BookBean bookBean) {
		//harshil	
		int status = bookDao.addBook(bookBean);
		if (status > 0) {

			return new ResponseEntity(HttpStatus.CREATED);
		}

		return new ResponseEntity(HttpStatus.BAD_REQUEST);

	}

	@GetMapping(value = "/viewbook")
	public List<BookBean> bookList() {

		List<BookBean> list = bookDao.bookList();

		return list;
	}

	@GetMapping(value = "/viewbook/{id}")
	public BookBean getBookById(@PathVariable int id) {

		return bookDao.getBookById(id);

	}
}
