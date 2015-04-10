package pl.embe.security.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;
import org.springframework.util.DigestUtils;

/**
 * Created by Michal_Bucki on 10/03/2015.
 */
@Entity( value="users", noClassnameStored=true, concern="SAFE" )
public class User
{
    @Id
    private ObjectId id;
    @Indexed(unique=true)
    private String username;
    private String password;
    private String role;

    protected User() {}

    public User( String username, String password, String role )
    {
        this.username = username;
        this.password = DigestUtils.md5DigestAsHex(password.getBytes());
        this.role = role;
    }

    public ObjectId getId() { return id; }
    public String getUsername() { return username; }
    public String getMD5Password() { return password; }
    public String getRole() { return role; }
}