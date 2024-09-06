package com.in28minutes.springboot.myfirstwebapp.todo;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

import java.util.function.Predicate;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
  private static List<Todo> todos = new ArrayList<>();

  static {
    todos.add(new Todo(1, "in28minutes", "Learn Spring Boot", LocalDate.now(), false));
    todos.add(new Todo(2, "in28minutes", "Learn React", LocalDate.now().plusDays(2), false));
    todos.add(new Todo(3, "in28minutes", "Learn AWS", LocalDate.now().plusYears(2), false));
  }

  public List<Todo> findByUsername(String username) {
    return todos;
  }

  public void addTodo(String username, String description, LocalDate targetDate, boolean isDone) {
    todos.add(new Todo(todos.size() + 1, username, description, targetDate, isDone));
  }

  public void deleteById(int id) {
    Predicate<? super Todo> predicate = todo -> todo.getId() == id;
    todos.removeIf(predicate);
  }
}

