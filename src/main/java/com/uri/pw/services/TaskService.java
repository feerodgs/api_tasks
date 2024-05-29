package com.uri.pw.services;

import com.uri.pw.entities.Task;
import com.uri.pw.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public List<Task> findAll() {
        return repository.findAll();
    }

    public Task findTask(Long id) {
        return repository.findById(id).stream().findFirst().get();
    }

    public Task create(Task task) {
        return repository.save(task);
    }

    public Task update(Long id, Task task) {
        Task currentTask = findTask(id);
        currentTask.setDescription(task.getDescription());
        currentTask.setCreationDate(task.getCreationDate());
        currentTask.setLimitDate(task.getLimitDate());
        currentTask.setFinished(true);
        return repository.save(currentTask);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}