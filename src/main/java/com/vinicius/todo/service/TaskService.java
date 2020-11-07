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

    public Task getById(Long id) {
        Optional<Task> op = this.taskRepository.findById(id);
        if (op.isPresent()) {
            return op.get();
        }
        return null;
    }

    public Task save(Task task) {
        return this.taskRepository.save(task);
    }

    public void delete(Long id) {
        Task task = this.taskRepository.getOne(id);
        this.taskRepository.delete(task);
    }

    public Task uptade(Task task) throws Exception { // Não existe um metodo específico para dar update

        // task passada como parâmetro é a tarefa a ser atualizada, tendo o mesmo id da tarefa antiga

        Optional<Task> op = this.taskRepository.findById(task.getId()); // op -> procura o id da tarefa existente no bd (antiga)
        if (op.isPresent()) { // se for achado
            Task tUpdate = op.get(); // tUpdate = conteúdo da tarefa antiga tarefa antiga
            tUpdate.setTitle(task.getTitle()); // muda o titulo para o novo
            tUpdate.setDescription(task.getDescription()); // muda a descrição para o novo
            return this.taskRepository.save(tUpdate); // salva a tarefa atualizada
        } else {
            throw new Exception("Registro nao encontrado");
        }
    }

}