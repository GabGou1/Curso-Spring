package com.cursospring.cursospring.repository;

import com.cursospring.cursospring.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
