package br.com.cassioscofield.springsample.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ResponseBody
@RequestMapping("/todo")
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@RequestMapping(value="list", method = RequestMethod.GET)
	public ModelAndView list(@RequestParam(value="id", required = false) String id) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("todo/list");
		
		mv.addObject("todos", todoService.find());
		
		if (id != null) {
			mv.addObject("todo", todoService.findById(id));
		} else {
			mv.addObject("todo", new Todo());
		}
		
		return mv;
	}
	
	@RequestMapping(value="save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute Todo todo) {
		
		todoService.save(todo);
		
		return list(null);
		
	}
	
	@RequestMapping(value="remove", method = RequestMethod.GET)
	public ModelAndView remove(@ModelAttribute Todo todo) {
		
		todoService.removeById(todo.getId());
		
		return list(null);
		
	}
	
}
