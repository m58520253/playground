package pl.embe.todo.model;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import pl.embe.todo.model.Todo;

/**
 * Created by Michal_Bucki on 02/03/2015.
 */


public class TodoDAO extends BasicDAO<Todo, String> {
    public TodoDAO(Morphia morphia, MongoClient mongo, String databaseName) {
        super(mongo, morphia, databaseName);
    }
}



