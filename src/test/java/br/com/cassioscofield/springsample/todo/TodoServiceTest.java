package br.com.cassioscofield.springsample.todo;

import org.junit.Before;
import org.junit.Test;

import br.com.cassioscofield.springsample.todo.Todo;
import br.com.cassioscofield.springsample.todo.TodoService;

import org.junit.Assert;

public class TodoServiceTest {

	TodoService todoService = new TodoService();
	
	private Todo todo = new Todo(null, "Description", 1);
	
	@Before
	public void init() {
	}
	
	@Test
	public void testFind() {

		int size = todoService.find().size();
		
		Assert.assertEquals(4, size);
		
	}
	
	@Test
	public void testSave() {

		int original = todoService.find().size();

		Todo newTodo = new Todo();
		newTodo.setId(null);
		newTodo.setDescription("Save");
		newTodo.setPriority(1);
		todoService.save(newTodo);
		
		Assert.assertEquals(original + 1, todoService.find().size());
	}
	
	@Test
	public void testFindOne() {

		Todo saved = todoService.save(todo);
		
		Todo retrieved = todoService.findById(saved.getId());
		
		Assert.assertEquals(todo.getId(), retrieved.getId());
		Assert.assertEquals(todo.getDescription(), retrieved.getDescription());
		Assert.assertEquals(todo.getPriority(), retrieved.getPriority());
		
	}
	
	@Test
	public void testDelete() {

		todoService.removeById(todo.getId());
		
		Todo retrieved = todoService.findById("10");
		
		Assert.assertEquals(null, retrieved);
		
	}
	
}
