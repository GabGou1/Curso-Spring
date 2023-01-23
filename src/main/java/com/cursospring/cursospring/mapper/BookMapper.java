package com.cursospring.cursospring.mapper;

import com.cursospring.cursospring.dto.BookDTO;
import com.cursospring.cursospring.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
    Book toModel(BookDTO bookDTO);
    BookDTO toDTO(Book book);
}