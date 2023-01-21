package com.cursospring.cursospring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data //Getters e Setters
@Builder //Classe para construção de objetos
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Gera uma ID nova no banco de dados para cada valor
    private Long id;
    @Column(nullable = false, unique = true)//Verifica se o campo do nome está vazio ou diferente
    private String name;
    @Column(nullable = false)//Verifica se o valor está vazio
    private Integer age;
}