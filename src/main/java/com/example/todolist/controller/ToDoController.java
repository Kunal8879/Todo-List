package com.example.todolist.controller;

import com.example.todolist.model.ToDo;
import com.example.todolist.services.ToDoServices;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class ToDoController {

    private final ToDoServices toDoServices;

    public ToDoController(ToDoServices toDoServices) {
        this.toDoServices = toDoServices;
    }

    @GetMapping
    public List<ToDo> getAll() {
        return toDoServices.getAll();
    }

    @GetMapping("/{id}")
    public ToDo getById(@PathVariable Integer id) {
        return toDoServices.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createToDo(@RequestBody ToDo todo) {
        toDoServices.createToDo(todo);
    }

    @PutMapping("/{id}")
    public void updateToDo(@PathVariable Integer id, @RequestBody ToDo todo) {
        toDoServices.updateToDo(id, todo);
    }

    @DeleteMapping("/{id}")
    public void deleteToDo(@PathVariable Integer id) {
        toDoServices.deleteToDo(id);
    }
}
