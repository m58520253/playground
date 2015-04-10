package pl.embe.security;

/**
 * Created by Michal_Bucki on 10/03/2015.
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController
{
    @RequestMapping( value = "/login", method = RequestMethod.GET )
    public String login()
    {
        String page = "login";
        return page;
    }


    @RequestMapping( value = "/loginError", method = RequestMethod.GET )
    public ModelAndView loginError()
    {
        Map<String, String>  model = new HashMap<String, String>();
        model.put("errorMessage", "Authentication failure");
        return  new ModelAndView("login", model);
    }

}