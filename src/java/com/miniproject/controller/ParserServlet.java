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

            // Display the result
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Parser Result</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Parser Result</h1>");
            out.println("<p>Input: " + input + "</p>");
            out.println("<p>Result: " + result + "</p>");
            out.println("<a href='index.html'>Try another expression</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}