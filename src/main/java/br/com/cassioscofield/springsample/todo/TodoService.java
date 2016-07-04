package br.com.cassioscofield.springsample.todo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TodoService {

	private List<Todo> todos = new ArrayList<Todo>();
	
	public TodoService() {

		todos.add(new Todo("1", "Pegar avião", 1));
		todos.add(new Todo("2", "Pegar taxi"));
		todos.add(new Todo("3", "Entrar na recepção"));
		todos.add(new Todo("4", "Realizar entrevista"));
		
	}
	
	public List<Todo> find() {
		
		
		return todos;
		
	}

	public Todo findById(String id) {
		
		for (Todo todo : todos) {
			if (todo.getId().equals(id)) {
				return todo;
			}
		}
		
		return null;
	}

	public Todo save(Todo newTodo) {
		
		if (newTodo.getId() == null) {
			// create
			todos.add(newTodo);
			newTodo.setId(String.valueOf(todos.size()));
		} else {
			// update
			Todo oldTodo = findById(newTodo.getId());
			oldTodo.setDescription(newTodo.getDescription());
			oldTodo.setPriority(newTodo.getPriority());
		}
		
		return newTodo;
		
	}
	
	public void removeById(String id) {
		
		todos.remove(findById(id));
		
	}
	
}
