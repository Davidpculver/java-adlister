import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "correctServlet", urlPatterns = "/correct")
public class correctServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String result = "You Won!";
////        resp.sendRedirect("/viewResult.jsp");
//        req.getRequestDispatcher("/viewResult.jsp").forward(req, resp);
        resp.getWriter().println("<h1>You won!</h1>");
    }
}
