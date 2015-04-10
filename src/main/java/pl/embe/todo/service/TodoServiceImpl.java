package pl.embe.todo.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;
import org.mongodb.morphia.query.UpdateOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import pl.embe.todo.model.Todo;
import pl.embe.todo.model.TodoDAO;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

/**
 * Created by Michal_Bucki on 02/03/2015.
 */
@RestController
@Scope(WebApplicationContext.SCOPE_SESSION)
public class TodoServiceImpl implements TodoService{

    private static final Log LOG = LogFactory.getLog(TodoServiceImpl.class);

    @Autowired
    private TodoDAO todoDAO;

    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    @ResponseBody
    public List<Todo> getTodoList() {
        String name = getUserName();
        QueryResults<Todo> todos =todoDAO.find(todoDAO.createQuery().field("username").equal(name));
        List<Todo> result =  todos.asList();
        return result;
    }

    @RequestMapping(value = "/todos", method = RequestMethod.POST)
    public void addTodo(@RequestBody Todo todo) {
        String name = getUserName();
        todo.setUsername(name);
        todoDAO.save(todo);
    }

    @RequestMapping(value = "/todos", method = RequestMethod.PUT)
    public void setTodoStatus( @RequestBody Todo todo) {
        String name = getUserName();
        Query<Todo> updateQuery = todoDAO.createQuery().field("_id").equal(todo.getId()).field("username").equal(name);
        UpdateOperations<Todo> updateOperations = todoDAO.createUpdateOperations().set("done", todo.isDone());
        todoDAO.update(updateQuery, updateOperations);
    }

    private String getUserName(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    @PostConstruct
    public void initIt() throws Exception {
        System.out.println("TodoServiceImpl POST CONSTRUCT");
    }

    @PreDestroy
    public void cleanUp() throws Exception {
        System.out.println("TodoServiceImpl PRE DESTROY");
    }


}
