package com.cursospring.cursospring.controller;

import com.cursospring.cursospring.dto.MessageResponseDTO;
import com.cursospring.cursospring.entity.Book;
import com.cursospring.cursospring.repository.BookRepository;
import com.cursospring.cursospring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //API Rest
@RequestMapping("/api/v1/books") //endereço da aplicação
public class BookController {
    private BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody Book book){
        return bookService.create(book);
    }
}
