package com.salesianos.seguridadprueba.service;

import com.salesianos.seguridadprueba.model.Task;
import com.salesianos.seguridadprueba.repo.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;


    public List<Task> obtnerTodosTask(){
       return taskRepository.findAll();
    }


    public Optional<Task> obtenerTaskPorId(Long id){
        return taskRepository.findById(id);
    }

    public Task guardarTask(Task task){
        return taskRepository.save(task);
    }

}
