package pl.embe.todo;

import org.junit.Test;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.mapping.MappedClass;
import org.mongodb.morphia.mapping.Mapper;
import pl.embe.todo.model.MorphiaFactory;
import pl.embe.todo.model.Todo;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Michal_Bucki on 02/03/2015.
 */
public class MorphiaFactoryTest {

    @Test
    public void doesCreateMorphia(){
        MorphiaFactory factory = new MorphiaFactory();
        Morphia morphia = factory.getMorphia();
        assertNotNull(morphia);
    }

    @Test
    public void doesMapTodoClass(){
        MorphiaFactory factory = new MorphiaFactory();
        Morphia morphia = factory.getMorphia();
        Mapper mapper = morphia.getMapper();
        Collection<MappedClass> mappedClasses =  mapper.getMappedClasses();
        Iterator<MappedClass> iter = mappedClasses.iterator();
        Set<Class> classes =new HashSet<Class>();
        while(iter.hasNext()) {
            classes.add(iter.next().getClazz());
        }
        assertTrue(classes.contains(Todo.class));
    }
}
