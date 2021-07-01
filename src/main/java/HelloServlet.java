import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Moved everything except index.jsp into WEB-INF folder so that cannot access from address bar in browser. Changed requestdispatcher to correct address.

@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//        gets whatever is passed into the name parameter in the query string.
        String name = req.getParameter("name");
//        able to setAttribute, then use that in jsp. the first "name" is what is sent to jsp, second name is the value, what outputs... pass in the first "name" (or value) into jsp for it to work.
        req.setAttribute("name", name);
        req.getRequestDispatcher("/WEB-INF/hello.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        req.setAttribute("name", name);
        req.getRequestDispatcher("/WEB-INF/hello.jsp").forward(req, resp);
    }
}
