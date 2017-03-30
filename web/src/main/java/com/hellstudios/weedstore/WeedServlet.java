package com.hellstudios.weedstore;

import com.hellstudios.weedstore.core.util.StringUtils;

import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "WeedServlet")
public class WeedServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        boolean loggedIn = !StringUtils.isEmpty((String) session.getAttribute("loggedIn")) && (boolean) session.getAttribute("loggedIn");
        String jspPath = loggedIn ? "/com/hellstudios/weedstore/index.jsp" : "/com/hellstudios/weedstore/login.jsp";

        response.setContentType("text/html");
        RequestDispatcher dispatcher = request.getRequestDispatcher(jspPath);
        dispatcher.forward(request, response);
    }
}
