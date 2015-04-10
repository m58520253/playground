package pl.embe.security.model;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import pl.embe.todo.model.Todo;

/**
 * Created by Michal_Bucki on 10/03/2015.
 */
public class UserDAO extends BasicDAO<User, String> {
    public UserDAO(Morphia morphia, MongoClient mongo, String databaseName) {
        super(mongo, morphia, databaseName);
    }
}

