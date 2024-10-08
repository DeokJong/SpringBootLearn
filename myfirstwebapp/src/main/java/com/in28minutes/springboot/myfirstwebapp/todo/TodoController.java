package com.in28minutes.springboot.myfirstwebapp.todo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TodoController {

  private TodoService todoService;
  
  public TodoController(TodoService todoService) {
    super();
    this.todoService = todoService;
  }

  @RequestMapping(value="list-todos")
  public String requestMethodName(ModelMap model) {
      List<Todo> todos = todoService.findByUsername("in28minutes");
      model.addAttribute("todos", todos);

      return "listTodos";
  }
  
}