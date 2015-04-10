package pl.embe.todo.config;

/**
 * Created by Michal_Bucki on 03/03/2015.
 */

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import pl.embe.todo.model.TodoDAO;
import pl.embe.todo.service.TodoService;
import pl.embe.todo.service.TodoServiceImpl;


@Configuration
@EnableWebMvc
public class TestContext {

    @Bean
    public TodoDAO todoDAO() {
        return Mockito.mock(TodoDAO.class);
    }

    @Bean
    public TodoService todoService() {
        return Mockito.mock(TodoService.class);
    }
}