import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ShowAdminPageServlet", urlPatterns = "/secret-admin-page")
public class ShowAdminPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
//have to cast to boolean to compare since it returns an object. Have to cast to type comparing to
        if ((Boolean) session.getAttribute("isAdmin") == false) {
            resp.sendRedirect("/login");
            return;
        }


        req.getRequestDispatcher("/WEB-INF/secret-admin-page.jsp").forward(req, resp);
    }
}
