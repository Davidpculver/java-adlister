import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "viewColorServlet", urlPatterns = "/viewcolor")
public class viewColorServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newcolor = req.getQueryString();
        System.out.println(newcolor);
        String colorchoice = req.getParameter("colorchoice");
        req.setAttribute("colorchoice", colorchoice);
        req.getRequestDispatcher("/viewColor.jsp").forward(req, resp);
    }
}
