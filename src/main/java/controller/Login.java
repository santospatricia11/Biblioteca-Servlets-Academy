package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Login  extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();
        if (action.equals("/login")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            System.out.println("Email: " + email + " Password: " + password);
            request.setAttribute("email", email);
            if (email.equals("lucas@mail.com") && password.equals("123")) {
                request.getRequestDispatcher("welcome.jsp").forward(request,response);
            }else{
                request.getRequestDispatcher("loginFail.jsp").forward(request,response);
            }
        }
    }
}
