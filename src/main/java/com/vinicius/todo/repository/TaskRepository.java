package com.vinicius.todo.repository;

import com.vinicius.todo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // define que é um repositorio
public interface TaskRepository extends JpaRepository<Task, Long> {
    // O spring usa essa interface para criar todos os métodos que devem ser usados para se realcionar com a database
}
