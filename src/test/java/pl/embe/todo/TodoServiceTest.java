package pl.embe.todo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.embe.todo.config.TestContext;
import pl.embe.todo.model.Todo;
import pl.embe.todo.service.TodoService;

import javax.annotation.Resource;
import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Michal_Bucki on 02/03/2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContext.class})
@WebAppConfiguration
public class TodoServiceTest {

    private MockMvc mockMvc;
    @Autowired
    private TodoService todoService;

    @Resource
    private WebApplicationContext webApplicationContext;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(todoService);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void isTodoServiceAutowired(){
        assertNotNull(todoService);
    }



    @Test
    public void find_Todos_byGetShouldReturnTwoEntries() throws Exception {
        Todo todo1 = new Todo();
        todo1.setName("tmp1");
        todo1.setDone(false);
        Todo todo2 = new Todo();
        todo2.setName("tmp2");
        todo2.setDone(true);
        when(todoService.getTodoList()).thenReturn(Arrays.asList(todo1, todo2));
        mockMvc.perform(get("/getTodoList"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("tmp1")))
                .andExpect(jsonPath("$[0].done", is(false)))
                .andExpect(jsonPath("$[1].name", is("tmp2")))
                .andExpect(jsonPath("$[1].done", is(true)));
    }

    @Test
    public void find_Todos_byPostShouldReturn404() throws Exception {
        mockMvc.perform(post("/getTodoList"))
                .andExpect(status().is4xxClientError());
    }

}
