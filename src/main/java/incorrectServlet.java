import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "incorrectServlet", urlPatterns = "/incorrect")
public class incorrectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String result = "You Lose!";
//        req.getRequestDispatcher("/viewResult.jsp").forward(req, resp);

        resp.getWriter().println("<h1>You lose!</h1>");
    }
}
