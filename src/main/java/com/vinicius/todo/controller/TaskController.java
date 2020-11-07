package com.vinicius.todo.controller;

import com.vinicius.todo.entity.Task;
import com.vinicius.todo.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("tasks") // Direciona a URL que tenha "/tasks" p/ essa classe
@RestController // Identifica que é um controller REST
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping // se o verbo for get em "/tasks", ele cai nesse metodo
    public List<Task> list() {
        return this.taskService.list();
    }

    @GetMapping("/{id}")
    public Task getOne(Long id) {
        return this.taskService.getById(id);
    }

    @PostMapping
    public Task save(@RequestBody Task task) { //@ -> essa informação vem no body da request
        return this.taskService.save(task);
    }

    @DeleteMapping
    public void delete(@RequestBody Task task) {
        this.taskService.delete(task.getId());
    }

    @PutMapping
    public Task update(@RequestBody Task task) throws Exception {
        return this.taskService.uptade(task);
    }
}
