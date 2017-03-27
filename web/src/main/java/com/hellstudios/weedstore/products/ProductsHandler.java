package com.hellstudios.weedstore.products;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author strel
 */
@WebServlet(name = "ProductsHandler")
public class ProductsHandler extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/com/hellstudios/weedstore/products/ProductsRenderer.jsp");
        dispatcher.forward(request, response);
    }
}
