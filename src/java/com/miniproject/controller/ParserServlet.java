package com.miniproject.controller;

import com.miniproject.model.G17Parser;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ParserServlet", urlPatterns = {"/parse"})
public class ParserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Get user input from the form
            String input = request.getParameter("expression");

            // Create a parser and parse the input
            G17Parser parser = new G17Parser(input);
            String result = parser.parse();
            
            request.setAttribute("input", input);
            request.setAttribute("result", result);
                    
            // Forward the request back to index.html (or index.jsp)
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
        }
    }
}