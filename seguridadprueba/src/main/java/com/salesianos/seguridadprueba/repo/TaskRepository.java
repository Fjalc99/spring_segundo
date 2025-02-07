package com.salesianos.seguridadprueba.repo;

import com.salesianos.seguridadprueba.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
