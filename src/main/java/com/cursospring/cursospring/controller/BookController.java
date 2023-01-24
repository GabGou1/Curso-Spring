package com.cursospring.cursospring.controller;

import com.cursospring.cursospring.dto.BookDTO;
import com.cursospring.cursospring.dto.MessageResponseDTO;
import com.cursospring.cursospring.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController //API Rest
@RequestMapping("/api/v1/books") //endereço da aplicação
public class BookController {
    private BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody @Valid BookDTO bookDTO){
        return bookService.create(bookDTO);
    }

    @GetMapping("/{id}")
    public BookDTO findById(@PathVariable Long id){
        return bookService.findById(id);
    }
}
