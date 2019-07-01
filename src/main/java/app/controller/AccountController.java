package app.controller;

import app.domain.Account;
import app.service.AccountDaoImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AccountController extends HttpServlet {
    private AccountDaoImpl accountService = AccountDaoImpl.getInstance();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        List<Account> accounts = null;
        accounts = accountService.getAllAccounts();
        if (accounts != null) {
            int sum = accounts.stream().mapToInt(Account::getAccount).sum();
            request.setAttribute("sum", sum);
        }
        request.getRequestDispatcher("/bankAccount.jsp").forward(request, response);
    }
}
