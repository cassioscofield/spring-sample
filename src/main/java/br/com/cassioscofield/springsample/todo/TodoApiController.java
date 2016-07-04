package br.com.cassioscofield.springsample.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/api/todo")
public class TodoApiController {

	@Autowired
	private TodoService todoService;
	
	@RequestMapping(value="", method = RequestMethod.GET)
	private List<Todo> getList() throws Exception {
		
		return todoService.find();
		
	}
	
	@RequestMapping(value="", method = RequestMethod.POST)
	private Todo save(@RequestBody Todo todo) throws Exception {
		
		return todoService.save(todo);
		
	}

	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	private Todo update(@PathVariable String id, @RequestBody Todo todo) throws Exception {
		
		todo.setId(id);
		return todoService.save(todo);
		
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	private void remove(@PathVariable String id) throws Exception {
		
		todoService.removeById(id);
		
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	private Todo getOne(@PathVariable String id) throws Exception {
		
		return todoService.findById(id);
		
	}
	
}
