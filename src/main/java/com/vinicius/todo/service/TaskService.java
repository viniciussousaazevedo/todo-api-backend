package com.vinicius.todo.service;


import com.vinicius.todo.entity.Task;
import com.vinicius.todo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // define o service
public class TaskService {
    private TaskRepository taskRepository; // é a interface que contém os métodos a serem implementados

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository; // aqui o spring vai escrever o conteúdo dos métodos da interface TaskRepository
    }

    public List<Task> list() { // método p/ listar todas as atividades
        return this.taskRepository.findAll();
    }
}
