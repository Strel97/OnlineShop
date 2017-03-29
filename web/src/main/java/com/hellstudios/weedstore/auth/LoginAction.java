package com.hellstudios.weedstore.auth;


import com.hellstudios.weedstore.Application;
import com.hellstudios.weedstore.api.APIException;
import com.hellstudios.weedstore.api.account.AccountAPI;
import com.hellstudios.weedstore.util.FieldValidation;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author strel
 */
@WebServlet(name = "LoginAction")
public class LoginAction extends HttpServlet {

    /**
     * {@link Logger} instance.
     */
    private static final Logger log = Logger.getLogger(LoginAction.class);

    /**
     * {@link AccountAPI} instance.
     */
    private AccountAPI accountAPI;


    @Override
    public void init() throws ServletException {
        try {
            accountAPI = Application.getInstance().getAPI(AccountAPI.class);
        }
        catch (APIException ex) {
            log.error("Can't initialize account API", ex);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Response object for auth action
        JSONObject res = new JSONObject();

        if (!validateInputData(request)) {
            res.put("error", "Incorrect email or password.");

            response.setContentType("application/json");
            response.getWriter().write(res.toString());

            return;
        }

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();

        // If user has no logged in attribute  in session, try to auth him.
        if (session.getAttribute("loggedIn") == null) {
            try {
                boolean loggedIn = accountAPI.login(email, password);

                if (!loggedIn) {
                    res.put("error", "Incorrect email or password.");

                    response.setContentType("application/json");
                    response.getWriter().write(res.toString());

                    return;
                }

                session.setAttribute("loggedIn", loggedIn);
            } catch (APIException ex) {
                log.warn(String.format("Can't auth user with email %s", email), ex);
            }
        }

        response.sendRedirect("/Products.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    private boolean validateInputData(HttpServletRequest req) {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        return FieldValidation.validateEmail(email) && FieldValidation.validatePassword(password);
    }
}
