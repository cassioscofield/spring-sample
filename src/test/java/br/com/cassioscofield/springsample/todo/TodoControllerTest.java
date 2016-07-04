package br.com.cassioscofield.springsample.todo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.web.servlet.ModelAndView;

import br.com.cassioscofield.springsample.todo.Todo;
import br.com.cassioscofield.springsample.todo.TodoController;
import br.com.cassioscofield.springsample.todo.TodoService;
import mockit.Injectable;
import mockit.Mock;
import mockit.MockUp;
import mockit.Tested;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
@SuppressWarnings("unchecked")
public class TodoControllerTest {

	@Tested
	private TodoController controller;
	
	@Injectable
	private TodoService service;
	
	private List<Todo> originalList;
	
	@Before
	public void init() {

		originalList = new ArrayList<Todo>();
		originalList.add(new Todo("1", "Description", 2));
		
		new MockUp<TodoService>() {
			
			@Mock
			List<Todo> find() {
				return originalList;
			}
			
			@Mock
			Todo save(Todo t) {
				
				if (t.getId() == null) {
					originalList.add(t);
				} else {
					originalList.remove(0);
					originalList.add(t);
				}
				
				return t;
			}

			@Mock
			void removeById(String id) {
				originalList.remove(0);
			}
			
		};
		
	}
	
	@Test
	public void listTest() {
		
		ModelAndView mv = controller.list(null);
		assertEquals("todo/list", mv.getViewName());
		
		List<Todo> list = (List<Todo>) mv.getModel().get("todos");
		assertEquals(originalList.size(), list.size());
		
	}
	
	@Test
	public void saveTest() {
		
		ModelAndView mv = controller.save(new Todo("Test", 2));
		assertEquals("todo/list", mv.getViewName());
		
		List<Todo> list = (List<Todo>) mv.getModel().get("todos");
		assertEquals(2, list.size());
		
	}
	
	@Test
	public void editTest() {
		
		ModelAndView mv = controller.save(new Todo("1", "Test", 2));
		assertEquals("todo/list", mv.getViewName());
		
		List<Todo> list = (List<Todo>) mv.getModel().get("todos");
		assertEquals(1, list.size());
		assertEquals("Test", list.get(0).getDescription());
		
	}
	
	@Test
	public void removeTest() {
		
		ModelAndView mv = controller.remove(new Todo("1", "Test", 2));
		assertEquals("todo/list", mv.getViewName());
		
		List<Todo> list = (List<Todo>) mv.getModel().get("todos");
		assertEquals(0, list.size());
		
	}
	
}
