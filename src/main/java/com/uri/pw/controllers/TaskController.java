package com.uri.pw.controllers;

import com.uri.pw.entities.Task;
import com.uri.pw.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/tasks")
@RestController
public class TaskController {
    @Autowired
    private TaskService service;

    @GetMapping
    public ResponseEntity<List<Task>> findAll() {
        List<Task> tasks = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(tasks);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Task> findTask(@PathVariable long id) {
        Task task = service.findTask(id);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(task);
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody Task task) {
        Task newTask = service.create(task);
        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(newTask);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Task> update(@PathVariable long id, @RequestBody Task task) {
        Task updatedTask = service.update(id, task);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(updatedTask);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
