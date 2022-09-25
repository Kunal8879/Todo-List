package com.example.todolist.services;

import com.example.todolist.model.ToDo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ToDoServices {

    private final List<ToDo> todos = new ArrayList<>(
            Arrays.asList(
                    new ToDo(1, "Demo Name 1", "Demo Summary 1", "Demo Description 1"),
                    new ToDo(2, "Demo Name 2", "Demo Summary 2", "Demo Description 2"),
                    new ToDo(3, "Demo Name 3", "Demo Summary 3", "Demo Description 3")
            )
    );

    public List<ToDo> getAll() {
        return todos;
    }

    public ToDo getById(Integer id) {
        return todos.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
    }

    public void createToDo(ToDo todo) {
        todos.add(todo);
    }

    public void updateToDo(Integer id, ToDo todo) {
        for (int i = 1; i <= todos.size(); i++) {
            ToDo t = todos.get(i);
            if (t.getId().equals(id)) {
                todos.set(i, todo);
                return;
            }
        }
    }

    public void deleteToDo(Integer id) {
        todos.removeIf(t -> t.getId().equals(id));
    }
}
