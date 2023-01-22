package com.cursospring.cursospring.repository;

import com.cursospring.cursospring.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
//Gerenciamento de todas as entidades com o banco de dados
public interface BookRepository extends JpaRepository<Book, Long> {
}
