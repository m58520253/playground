package pl.embe.todo.service;

import pl.embe.todo.model.Todo;

import java.util.List;

/**
 * Created by Michal_Bucki on 03/03/2015.
 */
public interface TodoService {

    public List<Todo> getTodoList();

    public void setTodoStatus(Todo id);
}
