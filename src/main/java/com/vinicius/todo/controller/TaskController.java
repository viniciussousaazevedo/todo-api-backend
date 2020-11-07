package com.vinicius.todo.controller;

import com.vinicius.todo.entity.Task;
import com.vinicius.todo.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("tasks") // Direciona a URL que tenha "/tasks" p/ essa classe
@RestController // Identifica que é um controller REST
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping // se o verbo for get, ele cai nesse metodo
    public List<Task> list() {
        return this.taskService.list();
    }
}
