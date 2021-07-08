import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("isAdmin") != null){
//            CREATED WEB-INF folder to hide the jsp files - so they cannot be accessed from the url address. Can leave out Index.jsp so user can still see the home page
            response.sendRedirect("/WEB-INF/secret-admin-page.jsp");
            return;
        }

        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean isAdmin = username.equals("admin") && password.equals("password");

        HttpSession session = request.getSession();

        if (isAdmin) {
            session.setAttribute("isAdmin", true);
            response.sendRedirect("/secret-admin-page");
        } else {
            response.sendRedirect("/login");
        }










//        Sessions resides in the server. If we close the browser, the session continues until the server is stopped. The cookies live in the browser, holds user preferences and histories

////        Below just a demo of different methods
////        set session object to a variable based on the httpsession class (when user logs on)
//        HttpSession session = request.getSession();
//
//        String darkMode = request.getParameter("color");
//
////        set the dark theme attribute on session so it gets remembered every time log on
//        session.setAttribute("darkMode", darkMode);
//
////        on a different servlet (profile page)
////        getAttribute method, our return is always a generic object type
////        therefore need to explicitly cast the object to the correct type
//        session.getAttribute("darkMode");
//        String darkSelected = (String) session.getAttribute("darkMode");
//
//        session.removeAttribute("darkMode");
//
////        destroy session: mainly used to log out of a session
//        session.invalidate();

    }
}
