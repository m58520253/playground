package pl.embe.todo.model;

import org.mongodb.morphia.Morphia;

/**
 * Created by Michal_Bucki on 02/03/2015.
 */
public class MorphiaFactory {

    public Morphia getMorphia(){
        Morphia morphia = new Morphia();
        morphia.map(Todo.class);
        return morphia;
    }

}
