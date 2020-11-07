package com.vinicius.todo.service;


import com.vinicius.todo.entity.Task;
import com.vinicius.todo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // define o service
public class TaskService {
    private TaskRepository taskRepository; // é a interface que contém os métodos a serem implementados

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository; // aqui o spring vai escrever o conteúdo dos métodos da interface TaskRepository
    }

    public List<Task> list() { // método p/ listar todas as atividades
        return this.taskRepository.findAll();
    }

    public Task save(Task task) {
        return this.taskRepository.save(task);
    }

    public void delete(Task task) {
        this.taskRepository.delete(task);
    }

    public Task uptade(Task task) throws Exception {

        Optional<Task> op = this.taskRepository.findById(task.getId());
        if (op.isPresent()) {
            Task tUpdate = op.get();
            tUpdate.setTitle(task.getTitle());
            tUpdate.setDescription(task.getDescription());
            return this.taskRepository.save(tUpdate);
        } else {
            throw new Exception("Registro nao encontrado");
        }
    }
}