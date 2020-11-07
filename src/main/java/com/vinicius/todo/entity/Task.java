package com.vinicius.todo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity // define que a classe mapeia uma tabela do banco de dados
@Table(name = "tasks") // define o nome da tabela mapeada
@Getter
@Setter // cria os getters e setters automaticamente
public class Task {
    @Id // define o identificador (a tarefa, no caso)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // define que esse id é gerado automaticamente e é sequencial
    private Long id;
    private String title;
    private String description;

}
