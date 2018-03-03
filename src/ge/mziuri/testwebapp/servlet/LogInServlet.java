package ge.mziuri.testwebapp.servlet;

import ge.mziuri.testwebapp.dao.UserDao;
import ge.mziuri.testwebapp.dao.UserDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogInServlet extends HttpServlet {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("failedAuth", "false");
        resp.sendRedirect("index.jsp");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("usernameField");
        String password = req.getParameter("passwordField");
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            req.setAttribute("failedAuth", "true");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            return;
        }
        boolean result = userDao.logIn(username, password);
        if (result) {
            resp.sendRedirect("/home.html");
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            session.setMaxInactiveInterval(1000);
        } else {
            req.setAttribute("failedAuth", "true");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
