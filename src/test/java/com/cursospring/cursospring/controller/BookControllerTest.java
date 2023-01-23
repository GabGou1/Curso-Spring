package com.cursospring.cursospring.controller;

import com.cursospring.cursospring.dto.BookDTO;
import com.cursospring.cursospring.dto.MessageResponseDTO;
import com.cursospring.cursospring.service.BookService;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import static com.cursospring.cursospring.utils.BookUtils.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {
    private MockMvc mockMvc;
    @Mock
    private BookService bookService;
    @InjectMocks
    private BookController bookController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(bookController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers(((viewName, locale) -> new MappingJackson2JsonView()))
                .build();
    }

    @Test
    void testWhenPOSTisCalledThenABookShouldBeCreated() throws Exception {
        BookDTO fakeBookDTO = createFakeBookDTO();
        MessageResponseDTO expectedMessageResponse = MessageResponseDTO.builder()
                .message("Book created with ID" + fakeBookDTO.getId())
                .build();

        when(bookService.create(fakeBookDTO)).thenReturn(expectedMessageResponse);

        mockMvc.perform(post("/api/v1/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(fakeBookDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", Is.is(expectedMessageResponse.getMessage())));
    }

    @Test
    void testWhenPOSTWithInvalidISBNIsCalledThenBadRequestShouldBeReturned() throws Exception {
        BookDTO fakeBookDTO = createFakeBookDTO();
        fakeBookDTO.setIsbn("Invalid isbn");

        mockMvc.perform(post("/api/v1/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(fakeBookDTO)))
                .andExpect(status().isBadRequest());
    }
}