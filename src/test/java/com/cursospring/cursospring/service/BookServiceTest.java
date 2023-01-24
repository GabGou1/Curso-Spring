package com.cursospring.cursospring.service;

import com.cursospring.cursospring.dto.BookDTO;
import com.cursospring.cursospring.entity.Book;
import com.cursospring.cursospring.exception.BookNotFoundException;
import com.cursospring.cursospring.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.cursospring.cursospring.utils.BookUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @Mock
    private BookRepository bookRepository;
    @InjectMocks
    private BookService bookService;

    @Test
    void WhenGivenExistingIdThenReturnThisBook() throws BookNotFoundException {
        Book expectedFoundBook = createFakeBook();
        when(bookRepository.findById(expectedFoundBook.getId())).thenReturn(Optional.of(expectedFoundBook));
        BookDTO bookDTO = bookService.findById(expectedFoundBook.getId());
        assertEquals(expectedFoundBook.getName(), bookDTO.getName());
        assertEquals(expectedFoundBook.getIsbn(), bookDTO.getIsbn());
        assertEquals(expectedFoundBook.getPublisherName(), bookDTO.getPublisherName());
    }
}