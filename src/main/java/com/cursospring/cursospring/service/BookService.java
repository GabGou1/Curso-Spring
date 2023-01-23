package com.cursospring.cursospring.service;

import com.cursospring.cursospring.dto.BookDTO;
import com.cursospring.cursospring.dto.MessageResponseDTO;
import com.cursospring.cursospring.entity.Book;
import com.cursospring.cursospring.mapper.BookMapper;
import com.cursospring.cursospring.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private BookRepository bookRepository;
    private final BookMapper bookMapper = BookMapper.INSTANCE;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public MessageResponseDTO create(BookDTO bookDTO){
        Book bookToSave = bookMapper.toModel(bookDTO);
        Book savedBook = bookRepository.save(bookToSave);
        return MessageResponseDTO.builder().message("Book created with ID " + savedBook.getId()).build();
    }
}