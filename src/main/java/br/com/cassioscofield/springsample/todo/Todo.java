package br.com.cassioscofield.springsample.todo;

public class Todo {
	
	private String id;
	private String description;
	private int priority = 0;
	
	public Todo() {
		
	}
	
	public Todo(String id, String description, int priority) {
		this.id = id;
		this.description = description;
		this.priority = priority;
	}
	
	public Todo(String id, String description) {
		this.id = id;
		this.description = description;
	}
	
	public Todo(String description, int priority) {
		this.description = description;
		this.priority = priority;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}

}
