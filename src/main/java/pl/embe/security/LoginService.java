package pl.embe.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.embe.security.model.User;
import pl.embe.security.model.UserDAO;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Michal_Bucki on 10/03/2015.
 */
@Service
public class LoginService implements UserDetailsService
{
    @Autowired
    private UserDAO userDAO;

    public LoginService( )
    {

    }

    public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException
    {
        User user = userDAO.findOne(userDAO.createQuery().field("username").equal(username));

        if( user == null )
            throw new UsernameNotFoundException( "Oops!" );

        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));

        return new org.springframework.security.core.userdetails.User( user.getUsername(), user.getMD5Password(), authorities );
    }
}
