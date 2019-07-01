package app.controller;

import app.domain.User;
import app.service.UserDaoImpl;
import app.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService userService = UserService.getInstance();
        response.setContentType("text/html;charset=UTF-8");
        User user = userService.findRichestUser();
        request.setAttribute("richestUser", user);
        request.getRequestDispatcher("/bankAccount.jsp").forward(request, response);
    }
}
