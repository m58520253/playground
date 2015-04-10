package pl.embe.config;

/**
 * Created by Michal_Bucki on 10/03/2015.
 */
import net.minidev.json.JSONObject;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class AjaxAwareAuthenticationEntryPoint
        extends LoginUrlAuthenticationEntryPoint {

    public AjaxAwareAuthenticationEntryPoint(String loginUrl) {
        super(loginUrl);
    }

    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException)
            throws IOException, ServletException {

        boolean isRestCall = request.getRequestURI().startsWith("/rest/");

        if (isRestCall) {
            sendAuthenticationError(response);
        } else {
            super.commence(request, response, authException);
        }
    }

    private void sendAuthenticationError(HttpServletResponse response) throws IOException {
        response.setContentType("text/x-json;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        JSONObject json = new JSONObject();
        json.put("Error code", 401);
        json.put("Message", "Please log in");
        json.writeJSONString(response.getWriter());
        response.sendError(401,json.toJSONString());
    }

}